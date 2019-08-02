package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CorsoDao;
import dao.FacoltaDao;
import model.Corso;
import model.Facolta;

/**
 * Servlet implementation class CorsiFacoltaInserimentoServlet
 */
@WebServlet("/CorsiFacolta")
public class CorsiFacoltaInserimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorsiFacoltaInserimentoServlet() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaDao fDao = new FacoltaDao();
    	CorsoDao cDao = new CorsoDao();
    	
    	System.out.println("Nomi delle facoltà: ");
    	for(Facolta f:fDao.getAll()){
    		System.out.println(f.getFacolta());
    	}
    	
    	request.setAttribute("facolta", fDao.getAll());
    	request.setAttribute("corsi", cDao.getAll());
    	
    	request.getRequestDispatcher("corsoFacoltaForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaDao fDao = new FacoltaDao();
    	CorsoDao cDao = new CorsoDao();
    	    	
    	Facolta f = fDao.getById(Integer.parseInt(request.getParameter("facolta")));
    	Corso c = cDao.getById(Integer.parseInt(request.getParameter("corso")));
    	
    	f.addCorso(c);
    	c.addFacolta(f);
    	
    	fDao.update(f);
    	
    	response.sendRedirect("CorsiFacolta");
	}

}
