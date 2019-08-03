package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.interfaces.StudenteInterface;
import model.Utente;
import util.HibernateUtil;

public class StudenteDao implements StudenteInterface {

	public void inserimento(Utente s){
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
	public Utente getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Utente studente;
		
		try{
			session.beginTransaction();

			studente = (Utente) session.get(Utente.class, id);

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
	public ArrayList<Utente> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Utente> studenti;
		
		try{
			session.beginTransaction();

			studenti = (ArrayList<Utente>) session.createQuery("from Studente").list();
			
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
	public void update(Utente s) {
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
	public void remove(Utente element) {
		
	}
}
