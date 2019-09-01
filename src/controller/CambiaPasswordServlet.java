package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.AccountDao;
import dao.interfaces.AccountInterface;
import model.Account;
import util.BCryptUtil;

/**
 * Servlet implementation class CambiaPasswordServlet
 */
@WebServlet("/CambiaPassword")
public class CambiaPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiaPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/cambiaPassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountInterface accountDao = new AccountDao();
		
		Account account = (Account) request.getSession().getAttribute("account");
		
		System.out.println("Old password: "+request.getParameter("oldPassword"));
		System.out.println("New password: "+request.getParameter("newPassword"));
		System.out.println("Old hash: "+account.getPassword());

		
		if(BCryptUtil.checkPs2(request.getParameter("oldPassword"), account.getPassword())) {
			account.setPassword(BCryptUtil.hashPsw(request.getParameter("newPassword")));
			
			System.out.println("New hash: "+account.getPassword());
			
			accountDao.update(account);
			response.sendRedirect("Home");
		} else {
			doGet(request, response);
		}
	}

}
