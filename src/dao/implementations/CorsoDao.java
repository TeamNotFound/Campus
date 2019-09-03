package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.CRUDInterface;
import dao.interfaces.CrudGenerico;
import model.Account;
import model.Corso;
import util.HibernateUtil;

public class CorsoDao extends CrudGenerico<Corso, Integer> implements CRUDInterface<Corso , Integer>{

	public CorsoDao () {
		this.classeT=Corso.class;
	}
	
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


}
