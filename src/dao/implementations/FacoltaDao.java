package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.CRUDInterface;
import dao.interfaces.CrudGenerico;
import model.Account;
import model.Facolta;
import util.HibernateUtil;

public class FacoltaDao extends CrudGenerico<Facolta, Integer> implements CRUDInterface<Facolta , Integer>{

	public FacoltaDao () {
		this.classeT=Facolta.class;
	}

	@SuppressWarnings("unchecked")
	
	public ArrayList<Facolta> getAllWithCorsi() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Facolta> facolta;
		
		try{
			session.beginTransaction();
			
			facolta = (ArrayList<Facolta>) session
					.createQuery("select distinct f from Facolta f left join fetch f.corsi corsi")
					.list();
			
			session.getTransaction().commit();

			return facolta;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	public Facolta getByIdWithCorsi(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Facolta facolta;
		
		try{
			session.beginTransaction();
						
			facolta = (Facolta) session.get(Facolta.class, id);
			Hibernate.initialize(facolta.getCorsi());
						
			session.getTransaction().commit();

			return facolta;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	

	public Facolta getByIdWithCorsiAndCattedre(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Facolta facolta;
		
		try{
			session.beginTransaction();
						
			facolta = (Facolta) session.get(Facolta.class, id);
			
			Hibernate.initialize(facolta.getCorsi());
			Hibernate.initialize(facolta.getCattedre());
			
			session.getTransaction().commit();

			return facolta;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	

	public void setClass() {
		// TODO Auto-generated method stub
		
	}

	
	
}
