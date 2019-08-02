package controller;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDao;
import dao.CorsoDao;
import dao.PrenotazioneDao;
import model.Account;
import model.Corso;
import model.PrenoPK;
import model.Prenotazione;
import model.Studente;

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
		
		Account a = dao.getByUsername(username);
		Set<Corso> corsi = a.getStudente().getFacolta().getCorsi();
		
		request.setAttribute("studente", a.getStudente());
		request.setAttribute("corsi", corsi);
		
		request.getRequestDispatcher("prenotazioniForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrenotazioneDao dao = new PrenotazioneDao();
		CorsoDao cDao = new CorsoDao();
		AccountDao aDao = new AccountDao();
		
		Prenotazione p = new Prenotazione();
		PrenoPK pk = new PrenoPK();
		
		Corso c = cDao.getById(Integer.parseInt(request.getParameter("corso")));
		Studente s = aDao.getByUsername((String)request.getSession().getAttribute("username")).getStudente();
		
		p.setCorso(c);
		p.setStudente(s);
		
		p.setDataPrenotazione(Date.from(Instant.now()));
		
		dao.inserimento(p);
		
		response.sendRedirect("Prenotazione");
	}

}
