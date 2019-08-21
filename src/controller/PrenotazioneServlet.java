package controller;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.implementations.AccountDao;
import dao.implementations.CorsoDao;
import dao.implementations.FacoltaDao;
import dao.implementations.PrenotazioneDao;
import model.Account;
import model.Corso;
import model.DataAppello;
import model.Prenotazione;
import model.Studente;
import model.Utente;

/**
 * Servlet implementation class PrenotazioneServlet
 */
@WebServlet("/Prenotazione")
public class PrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		if(username == null || username.equals("")){
			response.sendRedirect("Login");
			return;
		}
				
		AccountDao dao = new AccountDao();
		FacoltaDao fDao = new FacoltaDao();
		
		Account a = dao.getByUsername(username);
		if(a.getUtente() instanceof Studente) {
			
		Studente s= (Studente) a.getUtente();
		Set<Corso> corsi = fDao.getById(s.getFacolta().getId()).getCorsi();
		
		request.setAttribute("studente", s);
		request.setAttribute("corsi", corsi);
		
		request.getRequestDispatcher("prenotazioniForm.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrenotazioneDao dao = new PrenotazioneDao();
		CorsoDao cDao = new CorsoDao();
		AccountDao aDao = new AccountDao();
		
		Prenotazione p = new Prenotazione();

		DataAppello da= new DataAppello();// da risolvere 
		Account a= aDao.getByUsername((String) request.getSession().getAttribute("username"));
		Studente s= (Studente) a.getUtente();
		
		p.setDataAppello(da);
		p.setStudente(s);
		
		p.setDataPrenotazione(Date.from(Instant.now()));
		
		dao.inserimento(p);
		
		response.sendRedirect("Prenotazione");
	}

}
