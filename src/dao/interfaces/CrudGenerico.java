package dao.interfaces;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.Session;

import model.Account;
import model.Facolta;
import util.HibernateUtil;

public abstract class CrudGenerico<T,K>{
	protected Class<T> classeT;
	
	public void inserimento(T element) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(element);
		
		session.getTransaction().commit();
		session.close();
	}
	public T getById(K id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		

		try{
			session.beginTransaction();

			T element= (T) session.get(classeT, (Serializable) id);
			
			session.getTransaction().commit();
			
			return element ;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

		
		
	}
	public ArrayList<T> getAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<T> elements;
		
		try{
			session.beginTransaction();
			
			elements = (ArrayList<T>) session.createQuery("from " + classeT.getName()).list();
			
			session.getTransaction().commit();

			return elements;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	
		
	}
	public void update(T element) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.update(element);
		
		session.getTransaction().commit();
		session.close();
		
	}
	public void remove(T element) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.delete(element);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}			
		
	}


}
