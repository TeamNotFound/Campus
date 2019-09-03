package controller.corsiFacolta;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.CorsoDao;
import dao.implementations.FacoltaDao;
import dao.interfaces.CrudGenerico;
import model.Corso;
import model.Facolta;

/**
 * Servlet implementation class CorsiFacoltaDeleteServlet
 */
@WebServlet("/CorsiFacoltaDelete")
public class CorsiFacoltaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorsiFacoltaDeleteServlet() {
        super();
    
    }

	// Elimino l'associazione corso-facolta tramite il metodo update (In modo analogo alla sua creazione)
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudGenerico fDao = new FacoltaDao();
		CrudGenerico cDao = new CorsoDao();

		Facolta f = ((FacoltaDao) fDao).getByIdWithCorsi(Integer.parseInt(request.getParameter("facolta")));
		Corso c = ((CorsoDao) cDao).getByIdWithFacolta(Integer.parseInt(request.getParameter("corso")));
					
		f.removeCorso(c);
		c.removeFacolta(f);
		
		fDao.update(f);
		
		response.sendRedirect("Facolta/"+f.getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
