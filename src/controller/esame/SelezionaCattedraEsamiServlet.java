package controller.esame;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.ProfessoreDao;
import model.Account;
import model.Professore;

/**
 * Servlet implementation class SelezionaCattedraEsamiServlet
 */
@WebServlet("/Esami/Cattedre")
public class SelezionaCattedraEsamiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelezionaCattedraEsamiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfessoreDao daoProf = new ProfessoreDao();
		
		Account a=(Account)request.getSession().getAttribute("account");
		Professore p = (Professore) a.getUtente();
		
		p = daoProf.getByIdWithCorsi(p.getId());
		
		request.setAttribute("cattedre", p.getProfessoriCorsi());
		
		request.getRequestDispatcher("/views/esame/selezioneCattedreEsami.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
