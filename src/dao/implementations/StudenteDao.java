package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.CRUDInterface;
import dao.interfaces.CrudGenerico;
import model.Account;
import model.Studente;
import util.HibernateUtil;

public class StudenteDao extends CrudGenerico<Studente, Integer> implements CRUDInterface<Studente , Integer>{
 
	public StudenteDao () {
		this.classeT=Studente.class;
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

	
}