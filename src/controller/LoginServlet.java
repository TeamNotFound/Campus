package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.implementations.AccountDao;
import model.Account;
import model.Professore;
import model.Studente;
import util.BCryptUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDao dao = new AccountDao();
		Account a = dao.getByUsername(request.getParameter("username"));
		
		if(a != null && 
				BCryptUtil.checkPs2(request.getParameter("password"), a.getPassword())){
			
			System.out.println("Login successfull");
			
			HttpSession session = request.getSession(true);
			
			session.setAttribute("account", a);
			
			if(a.getUtente() instanceof Studente){
				session.setAttribute("studente", true);
				session.setAttribute("rettore", false);
				
			} else if (a.getUtente() instanceof Professore) {
				session.setAttribute("studente", false);
				
				Professore p = (Professore) a.getUtente();
				System.out.println(p.isRettore());
				
				if(p.isRettore()) {
					session.setAttribute("rettore", true);
				} else {
					session.setAttribute("rettore", false);

				}
			}
		}
		response.sendRedirect("Login");
	}

}
