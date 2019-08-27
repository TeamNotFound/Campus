package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.ProfessoreDao;
import model.Account;
import model.Professore;
import util.BCryptUtil;

/**
 * Servlet implementation class InserimentoProfessoreServlet
 */
@WebServlet("/InserimentoProfessore")
public class InserimentoProfessoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoProfessoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((boolean) request.getSession().getAttribute("rettore")) {
			request.getRequestDispatcher("profForm.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((boolean) request.getSession().getAttribute("rettore")) {
			
			ProfessoreDao pDao = new ProfessoreDao();
			Professore p = new Professore();
			Account a = new Account();
			
			if(!request.getParameter("nome").equals("")) {
				p.setNome(request.getParameter("nome"));
			}
			
			if(!request.getParameter("cognome").equals("")) {
				p.setCognome(request.getParameter("cognome"));
			}
			
			if(!request.getParameter("nascita-luogo").equals("")) {
				p.setLuogoNascita(request.getParameter("nome"));
			}
			
			if(!request.getParameter("nascita-data").equals("")) {
				p.setDataNascita(Date.valueOf(request.getParameter("nascita-data")));
			}
			
			if(!request.getParameter("sesso").equals("")) {
				if(request.getParameter("sesso").equals("uomo")) {
					p.setUomo(true);
				} else {
					p.setUomo(false);
				}
			}
			
			if(!request.getParameter("fiscale").equals("")) {
				p.setCodiceFiscale(request.getParameter("fiscale"));
			}
			
			if(!request.getParameter("titoli").equals("")) {
				p.setTitoliDiStudio(request.getParameter("titoli"));
			}
			
			if(!request.getParameter("username").equals("")) {
				a.setUsername(request.getParameter("username"));
			}
			
			if(!request.getParameter("password").equals("")) {
				a.setPassword(BCryptUtil.hashPsw(request.getParameter("password")));
			}
			
			p.setAccount(a);
			pDao.inserimento(p);
			
			response.sendRedirect("InserimentoProfessore");
			
		} else {
			response.sendRedirect("Login");
		}
	}

}
