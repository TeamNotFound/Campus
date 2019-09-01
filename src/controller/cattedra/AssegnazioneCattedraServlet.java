package controller.cattedra;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.CorsoDao;
import dao.implementations.FacoltaDao;
import dao.implementations.ProfessoreDao;
import dao.implementations.CattedraDao;
import model.Cattedra;

/**
 * Servlet implementation class AssegnazioneCattedraServlet
 */
@WebServlet("/AssegnazioneCattedra")
public class AssegnazioneCattedraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssegnazioneCattedraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("account") != null && (boolean) request.getSession().getAttribute("rettore")) {
			
			ProfessoreDao pDao = new ProfessoreDao();
			FacoltaDao fDao = new FacoltaDao();
			CorsoDao cDao = new CorsoDao();
			
			request.setAttribute("professori", pDao.getAll());
			request.setAttribute("facolta", fDao.getAll());
			request.setAttribute("corsi", cDao.getAll());
			
			request.getRequestDispatcher("/views/cattedra/cattedraForm.jsp").forward(request, response);
		} else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("account") != null && (boolean) request.getSession().getAttribute("rettore")) {
			ProfessoreDao pDao = new ProfessoreDao();
			FacoltaDao fDao = new FacoltaDao();
			CorsoDao cDao = new CorsoDao();
			
			CattedraDao pcDao = new CattedraDao();
			
			Cattedra cattedra = new Cattedra();
			
			cattedra.setProfessore(pDao.getById(Integer.parseInt(request.getParameter("prof"))));
			cattedra.setFacolta(fDao.getByIdWithCorsi(Integer.parseInt(request.getParameter("facolta"))));
			cattedra.setCorso(cDao.getById(Integer.parseInt(request.getParameter("corso"))));
			
			System.out.println("Professore: "+cattedra.getProfessore().getId());
			System.out.println("Facolta: "+cattedra.getFacolta().getId());
			System.out.println("Corso: "+cattedra.getCorso().getId());

			
			if(cattedra.getFacolta().getCorsi().contains(cattedra.getCorso())) {
				pcDao.inserimento(cattedra);
			}
			
			response.sendRedirect("AssegnazioneCattedra");
			
		} else {
			response.sendRedirect("Login");
		}
	}

}
