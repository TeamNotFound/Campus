package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.CorsoInterface;
import model.Corso;
import util.HibernateUtil;

public class CorsoDao implements CorsoInterface {

	@Override
	public void inserimento(Corso c) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.save(c);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}
	}

	@Override
	public Corso getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Corso corso;

		try{
			session.beginTransaction();
			
			corso = (Corso) session.get(Corso.class, id);
			
			session.getTransaction().commit();
			
			return corso;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			return null;
		} finally {
			session.close();
		}
	}
	
	@Override
	public Corso getByIdWithFacolta(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Corso corso;

		try{
			session.beginTransaction();
			
			corso = (Corso) session.get(Corso.class, id);
			Hibernate.initialize(corso.getFacolta());
			
			session.getTransaction().commit();
			
			return corso;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			return null;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Corso> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Corso> corsi;
		
		try{
			session.beginTransaction();
			
			corsi = (ArrayList<Corso>) session
					.createQuery("from Corso")
					.list();
			
			session.getTransaction().commit();
			
			return corsi;
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
	public ArrayList<Corso> getAllWithFacolta() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Corso> corsi;
		
		try{
			session.beginTransaction();
			
			corsi = (ArrayList<Corso>) session
					.createQuery("select distinct c from Corso c left join fetch c.facolta facolta")
					.list();
			
			session.getTransaction().commit();
			
			return corsi;
		} catch (Exception e) {
			
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Corso c) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.update(c);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}		
	}

	@Override
	public void remove(Corso c) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.delete(c);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}
	}

}
