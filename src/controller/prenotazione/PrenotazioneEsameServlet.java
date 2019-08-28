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
		DataAppelloDao dad = new DataAppelloDao();
		DataAppello da = new DataAppello();
		
		int id_data_appello = Integer.parseInt(request.getPathInfo().substring(1));
		
		da = dad.getById(id_data_appello);
		request.setAttribute("dataPrenotata", da);
		
		request.getRequestDispatcher("/prenotazioneEsame.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataAppelloDao dad = new DataAppelloDao();
		PrenotazioneDao pd = new PrenotazioneDao();

		Prenotazione p = new Prenotazione();

		Account a =(Account) request.getSession().getAttribute("account");
		p.setStudente((Studente) a.getUtente());
		
		DataAppello da= dad.getById(Integer.parseInt(request.getParameter("dataPrenotaId")));
		p.setDataAppello(da);

		Date d = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		p.setDataPrenotazione(d);
		
		pd.inserimento(p);

		response.sendRedirect(request.getContextPath()+"/PrenotazioneVisualizza");
	}

}
