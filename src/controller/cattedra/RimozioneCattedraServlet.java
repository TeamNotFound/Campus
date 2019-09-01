package controller.cattedra;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.CattedraDao;
import model.Cattedra;

/**
 * Servlet implementation class RimozioneCattedraServlet
 */
@WebServlet("/RimozioneCattedra/*")
public class RimozioneCattedraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimozioneCattedraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CattedraDao pcd = new CattedraDao();
		Cattedra cattedra = new Cattedra();
		
		
		//prendo i dati passati per path e li splitto in tre diversi id
		String[] id = request.getPathInfo().substring(1).split("-");
		int id_corso = Integer.parseInt(id[0]);
		int id_professore = Integer.parseInt(id[1]);
		int id_facolta = Integer.parseInt(id[2]);
	
		//setting degli attributi che voglio visualizzare nel db
		cattedra = pcd.getByComposedId(id_corso, id_professore, id_facolta);
		request.setAttribute("cattedra", cattedra);
		
		request.getRequestDispatcher("/views/cattedra/rimozioneCattedra.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CattedraDao pcd = new CattedraDao();
		Cattedra cattedra = new Cattedra();
	
		cattedra = pcd.getByComposedId(Integer.parseInt(request.getParameter("corsoId")), Integer.parseInt(request.getParameter("profId")), Integer.parseInt(request.getParameter("facoltaId")));
	
		pcd.remove(cattedra);
		
		response.sendRedirect("/Campus/Facolta/"+request.getParameter("facoltaId"));
	}

}
