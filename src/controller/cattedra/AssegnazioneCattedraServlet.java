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
import dao.implementations.ProfessoriCorsiDao;
import model.ProfessoriCorsi;

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
			
			ProfessoriCorsiDao pcDao = new ProfessoriCorsiDao();
			
			ProfessoriCorsi pc = new ProfessoriCorsi();
			
			pc.setProfessore(pDao.getById(Integer.parseInt(request.getParameter("prof"))));
			pc.setFacolta(fDao.getByIdWithCorsi(Integer.parseInt(request.getParameter("facolta"))));
			pc.setCorso(cDao.getById(Integer.parseInt(request.getParameter("corso"))));
			
			System.out.println("Professore: "+pc.getProfessore().getId());
			System.out.println("Facolta: "+pc.getFacolta().getId());
			System.out.println("Corso: "+pc.getCorso().getId());

			
			if(pc.getFacolta().getCorsi().contains(pc.getCorso())) {
				pcDao.inserimento(pc);
			}
			
			response.sendRedirect("AssegnazioneCattedra");
			
		} else {
			response.sendRedirect("Login");
		}
	}

}
