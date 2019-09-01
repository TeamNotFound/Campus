package controller;

import java.io.IOException;
import java.sql.Date;

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
import model.Studente;
import util.BCryptUtil;

/**
 * Servlet implementation class InserimentoStudenteServlet
 */
@WebServlet("/Studente")
public class InserimentoStudenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoStudenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaDao dao = new FacoltaDao();

		request.setAttribute("facolta", dao.getAll());
		
		request.getRequestDispatcher("/views/studenteForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaInterface facDao = new FacoltaDao();
		StudenteInterface stuDao = new StudenteDao();
		
		Studente s = new Studente();
		Account a = new Account();
		
		if(!request.getParameter("nome").equals("")) {
			s.setNome(request.getParameter("nome"));
		}
		
		if(!request.getParameter("cognome").equals("")) {
			s.setCognome(request.getParameter("cognome"));
		}
		
		if(!request.getParameter("nascita-luogo").equals("")) {
			s.setLuogoNascita(request.getParameter("nome"));
		}
		
		if(!request.getParameter("nascita-data").equals("")) {
			s.setDataNascita(Date.valueOf(request.getParameter("nascita-data")));
		}
		
		if(!request.getParameter("sesso").equals("")) {
			if(request.getParameter("sesso").equals("uomo")) {
				s.setUomo(true);
			} else {
				s.setUomo(false);
			}
		}
		
		if(!request.getParameter("fiscale").equals("")) {
			s.setCodiceFiscale(request.getParameter("fiscale"));
		}
		
		if(!request.getParameter("facolta").equals("")) {
			s.setFacolta(facDao.getById(Integer.parseInt(request.getParameter("facolta"))));
		}

		if(!request.getParameter("username").equals("")) {
			a.setUsername(request.getParameter("username"));
		}
		
		if(!request.getParameter("password").equals("")) {
			a.setPassword(BCryptUtil.hashPsw(request.getParameter("password")));
		}
		
		s.setAccount(a);
				
		stuDao.inserimento(s);

		response.sendRedirect("Login");
	}

}
