package dao.implementations;

import java.util.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.ProfessoreInterface;
import model.Professore;
import model.Utente;
import util.HibernateUtil;

public class ProfessoreDao implements ProfessoreInterface {
	
	public Professore getByIdWithCorsi(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Professore professore;
		
		try{
			session.beginTransaction();
 
			professore = (Professore) session.get(Utente.class, id);

			Hibernate.initialize(professore.getProfessoriCorsi());
			
			session.getTransaction().commit();

			return professore;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			return null;
		} finally {
			session.close();
		}
	}

	public void inserimento(Professore p) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.save(p);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			session.close();
		}
	

	}

	@Override
	public Professore getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Professore professore;
		
		try{
			session.beginTransaction();
 
			professore = (Professore) session.get(Professore.class, id);

			session.getTransaction().commit();

			return professore;
		} catch (Exception e) {
			System.out.println("Error in getById()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	

	}

	@Override
	public ArrayList<Professore> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Professore> professori;
		
		try{
			session.beginTransaction();

			professori = (ArrayList<Professore>) session.createQuery("from Professore").list();
			
			session.getTransaction().commit();

			return professori;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Professore p) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.update(p);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}		
	}

	@Override
	public void remove(Professore p) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.delete(p);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}		
	}
	}


