package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.FacoltaDao;

import dao.implementations.StudenteDao;
import dao.interfaces.FacoltaInterface;
import dao.interfaces.StudenteInterface;
import model.Account;
import model.Facolta;
import model.Studente;
import model.Utente;

/**
 * Servlet implementation class InserimentoStudenteServlet
 */
@WebServlet("/Utente")
public class InserimentoUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaDao dao = new FacoltaDao();
		

		request.setAttribute("facolta", dao.getAll());
		
		request.getRequestDispatcher("userForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaInterface facDao = new FacoltaDao();
		StudenteInterface stuDao = new StudenteDao();
		
		
		Studente s = new Studente();
		s.setNome(request.getParameter("nome"));
		s.setCognome(request.getParameter("cognome"));
		
		Facolta f = facDao.getById(Integer.parseInt(request.getParameter("facolta")));
		s.setFacolta(f);
		
		

		Account a = new Account();
		
		a.setUsername(request.getParameter("username"));
		a.setPassword(request.getParameter("password"));
		
		a.setUtente(s);
				
		stuDao.inserimento(s);

		response.sendRedirect("Utente");
	}

}
