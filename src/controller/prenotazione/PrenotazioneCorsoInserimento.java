package controller.prenotazione;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.DataAppelloDao;
import dao.interfaces.DataAppelloInterfaces;
import model.Account;
import model.DataAppello;
import model.Studente;

/**
 * Servlet implementation class PrenotazioneCorsoInserimento
 */
@WebServlet("/Prenotazione/Corso/*")
public class PrenotazioneCorsoInserimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioneCorsoInserimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataAppelloInterfaces daDao = new DataAppelloDao();
		
		int idCorso = Integer.parseInt(request.getPathInfo().substring(1));
		
		Account a =(Account) request.getSession().getAttribute("account");
		int idFacolta = ((Studente) a.getUtente()).getFacolta().getId();
		
		List<DataAppello> date = daDao.getByFacoltaAndCorso(idFacolta, idCorso);
		
		request.setAttribute("date", date);
		
		request.getRequestDispatcher("/corsoPrenotazioni.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
