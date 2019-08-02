package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.FacoltaInterface;
import model.Facolta;
import util.HibernateUtil;

public class FacoltaDao implements FacoltaInterface{
	
	public void inserimento(Facolta f){
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.save(f);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Facolta> getAll(){
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
	
	@Override
	public Facolta getById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Facolta facolta;
		
		try{
			session.beginTransaction();
						
			facolta = (Facolta) session.get(Facolta.class, id);
			Hibernate.initialize(facolta.getCorsi());
			
			System.out.println(facolta.getCorsi().toArray()[0]);
			
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


	@Override
	public void update(Facolta f) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.update(f);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}		
	}


	@Override
	public void remove(Facolta element) {
		// TODO Auto-generated method stub
		
	}
	
	
}
