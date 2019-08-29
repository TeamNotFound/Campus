package controller.prenotazione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.CorsoDao;
import dao.implementations.FacoltaDao;
import dao.implementations.PrenotazioneDao;
import dao.implementations.StudenteDao;
import dao.interfaces.CorsoInterface;
import dao.interfaces.FacoltaInterface;
import dao.interfaces.PrenotazioneInterface;
import dao.interfaces.StudenteInterface;
import model.Account;
import model.Facolta;
import model.Prenotazione;
import model.Studente;

/**
 * Servlet implementation class PrenotazioneVisualizza
 */
@WebServlet("/PrenotazioneVisualizza")
public class PrenotazioneVisualizza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioneVisualizza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudenteInterface daos = new StudenteDao ();
	
		
		Account s =(Account) request.getSession().getAttribute("account");

		Studente st = daos.getByIdWithPrenotazioni(s.getUtente().getId());
		
		System.out.println(st);
		
		request.setAttribute("prenotazioni", st.getPrenotazioni() );
		request.getRequestDispatcher("/prenotazioni.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
