package controller.corsiFacolta;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.CorsoDao;
import dao.implementations.FacoltaDao;
import dao.interfaces.CorsoInterface;
import dao.interfaces.FacoltaInterface;
import model.Facolta;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaInterface dao = new FacoltaDao();
		CorsoInterface cDao = new CorsoDao();
		
		System.out.println(request.getPathInfo());
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		
		Facolta f = dao.getByIdWithCorsi(id);
					
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
