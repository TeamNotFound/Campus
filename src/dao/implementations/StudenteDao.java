package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.StudenteInterface;
import model.Studente;
import util.HibernateUtil;

public class StudenteDao implements StudenteInterface {

	public void inserimento(Studente s){
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.save(s);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			session.close();
		}
	}

	@Override
	public Studente getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Studente studente;
		
		try{
			session.beginTransaction();

			studente = (Studente) session.get(Studente.class, id);

			session.getTransaction().commit();

			return studente;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			return null;
		} finally {
			session.close();
		}
	}
	
	public Studente getByIdWithPrenotazioni(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Studente studente;
		
		try{
			session.beginTransaction();

			studente = (Studente) session.get(Studente.class, id);
			Hibernate.initialize(studente.getPrenotazioni());

			session.getTransaction().commit();

			return studente;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Studente getByIdWithEsami(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Studente studente;
		
		try{
			session.beginTransaction();

			studente = (Studente) session.get(Studente.class, id);
			Hibernate.initialize(studente.getEsami());

			session.getTransaction().commit();

			return studente;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Studente getByIdWithPrenotazioniEsami(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Studente studente;
		
		try{
			session.beginTransaction();

			studente = (Studente) session.get(Studente.class, id);
			Hibernate.initialize(studente.getPrenotazioni());
			Hibernate.initialize(studente.getEsami());
			
			session.getTransaction().commit();

			return studente;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Studente> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Studente> studenti;
		
		try{
			session.beginTransaction();

			studenti = (ArrayList<Studente>) session.createQuery("from Studente").list();
			
			session.getTransaction().commit();

			return studenti;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Studente s) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.update(s);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}		
	}

	@Override
	public void remove(Studente s) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.delete(s);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();	

		}
	}
}