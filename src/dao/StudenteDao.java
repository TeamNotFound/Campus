package dao;

import java.util.ArrayList;

import org.hibernate.Session;

import model.Studente;
import util.HibernateUtil;

public class StudenteDao implements CRUDInterface<Studente> {

	public void inserimento(Studente s){
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			System.out.println("User prima salvataggio " + s.getFacolta().getId());
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
}
