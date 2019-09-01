package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.interfaces.CattedraInterface;
import model.Cattedra;
import util.HibernateUtil;

public class CattedraDao implements CattedraInterface {

	@Override
	public void inserimento(Cattedra pc) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			session.save(pc);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore inserimento CattedraDao");
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}

	@Override
	public Cattedra getById(int id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Cattedra pc;
		
		try {
			session.beginTransaction();
			
			pc = (Cattedra) session.get(Cattedra.class, id);
			
			session.getTransaction().commit();
			
			return pc;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erorre getById in ProfessoriCorsiDao");
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Cattedra> getAll() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		ArrayList<Cattedra> pc;
		try {
			session.beginTransaction();
			
			pc = (ArrayList<Cattedra>) session.createQuery("form Cattedra").list();
			
			session.getTransaction().commit();
			
			return pc;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore getAll in ProfessoriCorsiDao");
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}
	

	

	@Override
	public void update(Cattedra pc) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			session.update(pc);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore update in CattedraDao");
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void remove(Cattedra pc) {
Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			session.delete(pc);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore update in ProfessoriCorsiDao");
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		
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
