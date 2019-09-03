package controller.corsiFacolta;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.FacoltaDao;
import dao.interfaces.CrudGenerico;
import model.Facolta;

/**
 * Servlet implementation class FacoltaDeleteServlet
 */
@WebServlet("/Facolta/delete/*")
public class FacoltaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacoltaDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Elimino la facolta utilizzando come variabile la "Path Variable", anche nota nei servlet come path info
    // Per usare le path info, nel tag @WebServlet() in cima alla classe bisogna aggiungere un asterisco
    // Così, quando l'indirizzo scritto nell'url sarà /Facolta/delete/2 la path info sarà /2
    // Da notare che l'asterisco può andare solo alla fine dell'indirizzo perchè i servlet son limitati
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudGenerico dao = new FacoltaDao();
				
		int id = Integer.parseInt(request.getPathInfo().substring(1));
		
		Facolta f = (Facolta) dao.getById(id);
					
		dao.remove(f);
		
		response.sendRedirect(request.getContextPath()+"/CorsiFacolta");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
