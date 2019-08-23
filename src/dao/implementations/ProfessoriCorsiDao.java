package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.interfaces.ProfessoriCorsiInterface;
import model.ProfessoriCorsi;
import util.HibernateUtil;

public class ProfessoriCorsiDao implements ProfessoriCorsiInterface {

	@Override
	public void inserimento(ProfessoriCorsi pc) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			session.save(pc);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore inserimento ProfessoriCorsiDao");
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}

	@Override
	public ProfessoriCorsi getById(int id) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		ProfessoriCorsi pc;
		
		try {
			session.beginTransaction();
			
			pc = (ProfessoriCorsi) session.get(ProfessoriCorsi.class,id);
			
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

	@Override
	public ArrayList<ProfessoriCorsi> getAll() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		ArrayList<ProfessoriCorsi> pc;
		try {
			session.beginTransaction();
			
			pc = (ArrayList<ProfessoriCorsi>) session.createQuery("form ProfessoriCorsi").list();
			
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
	public void update(ProfessoriCorsi pc) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			session.update(pc);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore update in ProfessoriCorsiDao");
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void remove(ProfessoriCorsi pc) {
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

}
