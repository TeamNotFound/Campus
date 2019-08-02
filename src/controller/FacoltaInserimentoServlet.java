package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FacoltaDao;
import model.Facolta;

/**
 * Servlet implementation class FacoltaInserimentoServlet
 */
@WebServlet("/Facolta")
public class FacoltaInserimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacoltaInserimentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaDao dao = new FacoltaDao();
		request.setAttribute("facolta", dao.getAll());
		request.getRequestDispatcher("facoltaForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacoltaDao dao = new FacoltaDao();
		Facolta f = new Facolta();
		f.setFacolta(request.getParameter("facolta"));
		
		dao.inserimento(f);
		
		response.sendRedirect("CorsiFacolta");
	}

}
