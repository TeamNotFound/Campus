package controller.professore;

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
 * Servlet implementation class PromuoviProfessoreServlet
 */
@WebServlet("/Professore/Promuovi/*")
public class PromuoviProfessoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PromuoviProfessoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfessoreDao pd = new ProfessoreDao();
		
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		
		Account a = (Account) request.getSession().getAttribute("account");
		Professore rettore = (Professore)a.getUtente();
		Professore profDaProm = pd.getById(id);
		
		//cambiamo i ruoli: il rettore diventa un prof e il prof precedentemente selezionato diventa rettore
		rettore.setRettore(false);
		pd.update(rettore);
		profDaProm.setRettore(true);
		pd.update(profDaProm);
		
		//rimandiamo al login per verificare i cambiamenti
		request.getRequestDispatcher("/Logout").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
