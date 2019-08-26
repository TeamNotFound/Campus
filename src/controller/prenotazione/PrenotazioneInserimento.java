package controller.prenotazione;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.DataAppelloDao;
import dao.implementations.PrenotazioneDao;
import dao.implementations.StudenteDao;
import model.Prenotazione;

/**
 * Servlet implementation class PrenotazioneInserimento
 */
@WebServlet("/PrenotazioneInserimento")
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
		response.sendRedirect("PrenotazioniEffettuate");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrenotazioneDao dao = new PrenotazioneDao();
		DataAppelloDao daoa = new DataAppelloDao();
		StudenteDao daos= new StudenteDao();
		Prenotazione p = new Prenotazione();
		Date d = new Date(0, 0, 0);
		
		p.setDataAppello(daoa.getById(Integer.parseInt(request.getParameter("data_appello_id"))));
		p.setDataPrenotazione(d);
		p.setStudente(daos.getById(Integer.parseInt(request.getParameter("studente_id"))));
		
		
		dao.inserimento(p);
		
		response.sendRedirect("PrenotazioniEffettuate");
	}

}
