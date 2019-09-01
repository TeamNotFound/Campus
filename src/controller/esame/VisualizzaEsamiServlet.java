package controller.esame;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.StudenteDao;
import model.Account;
import model.Studente;

/**
 * Servlet implementation class VisualizzaEsamiServlet
 */
@WebServlet("/Esami/Visualizza")
public class VisualizzaEsamiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaEsamiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudenteDao studenteDao = new StudenteDao();
		
		Account a = (Account) request.getSession().getAttribute("account");
		Studente s = (Studente) a.getUtente();
		s = studenteDao.getByIdWithEsami(s.getId());
		
		request.setAttribute("esami", s.getEsami());
		
		request.getRequestDispatcher("/views/esame/visualizzaEsami.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
