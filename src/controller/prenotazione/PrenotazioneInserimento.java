package controller.prenotazione;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.DataAppelloDao;
import dao.implementations.FacoltaDao;
import dao.implementations.PrenotazioneDao;
import dao.implementations.StudenteDao;
import dao.interfaces.FacoltaInterface;
import model.Account;
import model.Facolta;
import model.Prenotazione;
import model.Studente;

/**
 * Servlet implementation class PrenotazioneInserimento
 */
@WebServlet("/Prenotazione")
public class PrenotazioneInserimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioneInserimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaInterface fDao = new FacoltaDao();
		
		Account s =(Account) request.getSession().getAttribute("account");
		Facolta f = fDao.getByIdWithCorsi(((Studente) s.getUtente()).getFacolta().getId());
		
		request.setAttribute("facolta", f);
		
		request.getRequestDispatcher("prenotazioniForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrenotazioneDao dao = new PrenotazioneDao();
		DataAppelloDao daoa = new DataAppelloDao();
		StudenteDao daos= new StudenteDao();
		
		Prenotazione p = new Prenotazione();
		Date d = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		p.setDataAppello(daoa.getById(Integer.parseInt(request.getParameter("data_appello_id"))));
		p.setDataPrenotazione(d);

		Account s =(Account) request.getSession().getAttribute("account");

		p.setStudente((Studente) s.getUtente());
		
		dao.inserimento(p);
		
		response.sendRedirect("PrenotazioniEffettuate");
	}

}
