package controller.esame;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.implementations.DataAppelloDao;
import dao.implementations.ProfessoriCorsiDao;
import model.DataAppello;
import model.ProfessoriCorsi;

/**
 * Servlet implementation class SelezionaDataAppelloEsamiServlet
 */
@WebServlet("/Esami/Cattedra/*")
public class SelezionaDataAppelloEsamiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelezionaDataAppelloEsamiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataAppelloDao dataDao = new DataAppelloDao();
		
		String[] ids = request.getPathInfo().substring(1).split("-");
		
		int id_professore = Integer.parseInt(ids[0]);
		int id_facolta = Integer.parseInt(ids[1]);
		int id_corso = Integer.parseInt(ids[2]);
		
		List<DataAppello> date = dataDao.getByProfessoreFacoltaAndCorso(id_professore, id_facolta, id_corso);
		
		request.setAttribute("date", date);
		
		request.getRequestDispatcher("/selezioneDataAppelloEsami.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
