package controller.esame;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.DataAppelloDao;
import dao.implementations.EsameDao;
import dao.implementations.PrenotazioneDao;
import dao.implementations.StudenteDao;
import model.DataAppello;
import model.Esame;
import model.Prenotazione;
import model.Studente;

/**
 * Servlet implementation class ConvalidaEsamiServlet
 */
@WebServlet("/Esami/Data/*")
public class ConvalidaEsamiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvalidaEsamiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataAppelloDao dataDao = new DataAppelloDao();
		
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		
		DataAppello data = dataDao.getByIdWithPrenotazioni(id);
		
		request.setAttribute("prenotazioni", data.getPrenotazioni());
		request.getRequestDispatcher("/views/esame/convalidaEsami.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Siamo nel do post");
		
		EsameDao esameDao = new EsameDao();
		StudenteDao studenteDao = new StudenteDao();
		DataAppelloDao dataDao = new DataAppelloDao();
		PrenotazioneDao prenotazionDao = new PrenotazioneDao();
		
		int id_data = Integer.parseInt(request.getPathInfo().substring(1));
		DataAppello data = dataDao.getById(id_data);
		
		int id_studente = Integer.parseInt(request.getParameter("studente"));
		Studente studente = studenteDao.getById(id_studente);
		
		Esame esame = new Esame();
		
		esame.setCorso(data.getCorso());
		esame.setFacolta(data.getFacolta());
		esame.setProfessore(data.getProfessore());
		esame.setStudente(studente);
		esame.setVotoEsame(Integer.parseInt(request.getParameter("voto")));
		
		System.out.println(esame);
		esameDao.inserimento(esame);
		
		Prenotazione p = prenotazionDao.getByComposedId(id_studente, id_data);
		System.out.println(p);
		prenotazionDao.remove(p);
		
		response.sendRedirect(request.getRequestURI());
	}

}
