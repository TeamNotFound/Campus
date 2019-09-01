package controller.prenotazione;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
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
import model.Corso;
import model.Esame;
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
		StudenteDao studenteDao = new StudenteDao();
		
		Account account =(Account) request.getSession().getAttribute("account");
		Studente studente = (Studente) account.getUtente();
		studente = studenteDao.getByIdWithPrenotazioniEsami(studente.getId());
		
		Facolta f = fDao.getByIdWithCorsi(studente.getFacolta().getId());
		
		List<Corso> corsiDaRimuovere = getCorsiDaRimuovere(studente);
		
		for(Corso corso : corsiDaRimuovere) {
			f.getCorsi().remove(corso);
		}
		
		request.setAttribute("facolta", f);
		
		request.getRequestDispatcher("/views/prenotazione/prenotazioniForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrenotazioneDao dao = new PrenotazioneDao();
		DataAppelloDao daoa = new DataAppelloDao();
		
		Prenotazione p = new Prenotazione();
		Date d = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		p.setDataAppello(daoa.getById(Integer.parseInt(request.getParameter("data_appello_id"))));
		p.setDataPrenotazione(d);

		Account a =(Account) request.getSession().getAttribute("account");
		p.setStudente((Studente) a.getUtente());
		
		dao.inserimento(p);
		
		response.sendRedirect("PrenotazioniEffettuate");
	}

	private List<Corso> getCorsiDaRimuovere(Studente studente){
		List<Corso> corsiDaRimuovere = new ArrayList<Corso>();
		
		for(Esame esame : studente.getEsami()) {
			corsiDaRimuovere.add(esame.getCorso());
		}
		
		for(Prenotazione prenotazione : studente.getPrenotazioni()) {
			corsiDaRimuovere.add(prenotazione.getDataAppello().getCorso());
		}
		
		return corsiDaRimuovere;
	}
}
