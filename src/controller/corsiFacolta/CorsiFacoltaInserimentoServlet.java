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

	// Recupero tutte le facolta (con i corsi a loro annessi) e i corsi per mostrare le diverse form
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudGenerico fDao = new FacoltaDao();
    	CrudGenerico cDao = new CorsoDao();
    	
    	request.setAttribute("facolta", fDao.getAll());
    	request.setAttribute("corsi", cDao.getAll());
    	
    	request.getRequestDispatcher("/views/corsiFacolta/corsoFacoltaForm.jsp").forward(request, response);
	}

	// Recupero sia la facolta che il corso tramite id con liste inizializzate (così da poter usare i metodi
	// addCorso e addFacolta). Dopo essersi aggiunti a vicenda ne aggiorno uno (basta appunto aggiornarne uno)
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CrudGenerico fDao = new FacoltaDao();
		CrudGenerico cDao = new CorsoDao();
    	    	
    	Facolta f = ((FacoltaDao) fDao).getByIdWithCorsi(Integer.parseInt(request.getParameter("facolta")));
    	Corso c = ((CorsoDao) cDao).getByIdWithFacolta(Integer.parseInt(request.getParameter("corso")));
    	
    	f.addCorso(c);
    	c.addFacolta(f);
    	
    	fDao.update(f);
    	
    	response.sendRedirect("Facolta/"+f.getId());
	}

}
