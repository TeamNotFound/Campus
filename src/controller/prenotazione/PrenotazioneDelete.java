package controller.prenotazione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.PrenotazioneDao;
import dao.interfaces.CrudGenerico;
import model.Prenotazione;

/**
 * Servlet implementation class PrenotazioneDelete
 */
@WebServlet("/PrenotazioneDelete")
public class PrenotazioneDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioneDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudGenerico daop = new PrenotazioneDao();
		
		
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		
		Prenotazione p = (Prenotazione) daop.getById(id);
					
		daop.remove(p);
		
		response.sendRedirect("InserisciPrenotazione.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
