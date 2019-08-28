package controller.corsiFacolta;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.CorsoDao;
import dao.implementations.FacoltaDao;
import dao.implementations.ProfessoriCorsiDao;
import dao.interfaces.CorsoInterface;
import dao.interfaces.FacoltaInterface;
import dao.interfaces.ProfessoriCorsiInterface;
import model.Facolta;
import model.ProfessoriCorsi;

/**
 * Servlet implementation class FacoltaVisualizzaServlet
 */
@WebServlet("/Facolta/*")
public class FacoltaVisualizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacoltaVisualizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	// Carico dal database la facolta con id uguale alla pathInfo (Per dubbi vedere i commenti in CorsoDeleteServlet 
    // o FacoltaDeleteServlet.
    // La carico con i suoi corsi annessi così da poterli visualizzare 
    // Carico inoltre tutti i corsi così da popolare la form che associera i corsi alla Facolta
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaInterface dao = new FacoltaDao();
		CorsoInterface cDao = new CorsoDao();
		
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		
		Facolta f = dao.getByIdWithCorsiAndCattedre(id);
		
		HashMap<Integer, ProfessoriCorsi> profCorsi = new HashMap<Integer, ProfessoriCorsi>();
		for(ProfessoriCorsi pc : f.getCattedre()) {
			profCorsi.put(pc.getCorso().getId(), pc);
		}
		
		request.setAttribute("cattedre", profCorsi);
		request.setAttribute("facolta", f);
		request.setAttribute("corsi", cDao.getAll());
		
		request.getRequestDispatcher("/facolta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
