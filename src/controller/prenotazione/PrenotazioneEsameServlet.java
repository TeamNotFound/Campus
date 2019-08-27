package controller.prenotazione;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.implementations.DataAppelloDao;
import dao.implementations.PrenotazioneDao;
import dao.implementations.StudenteDao;
import model.Account;
import model.DataAppello;
import model.PrenoPK;
import model.Prenotazione;
import model.Studente;

/**
 * Servlet implementation class PrenotazioneEsameServlet
 */
@WebServlet("/Prenotazione/PrenotazioneEsame/*")
public class PrenotazioneEsameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioneEsameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		int id_data_appello = Integer.parseInt(request.getPathInfo().substring(1));
		
		DataAppello da = new DataAppello();
		DataAppelloDao dad = new DataAppelloDao();
		da = dad.getById(id_data_appello);
		request.setAttribute("dataPrenotata", da);
		
		request.getRequestDispatcher("/prenotazioneEsame.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Account a =(Account) request.getSession().getAttribute("account");
		int id_studente = ((Studente)a.getUtente()).getId();
		
		StudenteDao sd = new StudenteDao();
		Studente s = sd.getById(id_studente);
		
		DataAppelloDao dad = new DataAppelloDao();
		DataAppello da= dad.getById(Integer.parseInt(request.getParameter("dataPrenotaId")));
		

		Date d = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		Prenotazione p = new Prenotazione();
		PrenotazioneDao pd = new PrenotazioneDao();
		
		//setting pk che devo inserire nell'oggetto prenotazione
		PrenoPK pk= new PrenoPK();
		pk.setData_appello_id(da.getId());
		pk.setStudente_id(s.getId());
		
		p.setDataAppello(da);
		p.setDataPrenotazione(d);
		p.setStudente(s);
		p.setPk(pk);
		
		pd.inserimento(p);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
