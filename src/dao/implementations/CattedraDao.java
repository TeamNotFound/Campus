package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.interfaces.CRUDInterface;
import dao.interfaces.CrudGenerico;
import model.Account;
import model.Cattedra;
import util.HibernateUtil;

public class CattedraDao extends CrudGenerico<Cattedra, Integer> implements CRUDInterface<Cattedra , Integer> {

	public CattedraDao() {
		this.classeT=Cattedra.class;
	}

	


	public Cattedra getByComposedId(int id_corso,int id_professore, int id_facolta) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Cattedra pc;
		
		try {
			session.beginTransaction();
			
			pc = (Cattedra) session.createQuery("from Cattedra pc where pc.corso.id = :corsoId and pc.facolta.id = :facoltaId and pc.professore.id = :profId")
					.setParameter("corsoId", id_corso).setParameter("facoltaId", id_facolta).setParameter("profId", id_professore).list().get(0);
			
			session.getTransaction().commit();
			
			return pc;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erorre getByComposedId in ProfessoriCorsiDao");
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	public Cattedra getByComposedIdWithDate(int id_professore, int id_facolta, int id_corso) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Cattedra pc;
		
		try {
			session.beginTransaction();
			
			pc = (Cattedra) session.createQuery("from Cattedra pc where pc.corso.id = :corsoId and pc.facolta.id = :facoltaId and pc.professore.id = :profId")
					.setParameter("corsoId", id_corso).setParameter("facoltaId", id_facolta).setParameter("profId", id_professore).list().get(0);
			
			
			session.getTransaction().commit();
			
			return pc;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erorre getByComposedId in ProfessoriCorsiDao");
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

}
