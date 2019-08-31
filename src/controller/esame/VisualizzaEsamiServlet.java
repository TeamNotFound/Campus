package controller.esame;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.EsameDao;
import model.Account;
import model.Esame;
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
		EsameDao ed = new EsameDao();
		
		Account a = (Account) request.getSession().getAttribute("account");
		Studente s = (Studente) a.getUtente();
		ArrayList<Esame> esami = ed.getByIdStudente(s.getId());
		
		request.setAttribute("esami", esami);
		
		request.getRequestDispatcher("/views/esame/visualizzaEsami.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
