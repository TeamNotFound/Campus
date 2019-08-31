package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.interfaces.EsameInterface;
import model.Esame;
import util.HibernateUtil;

public class EsameDao implements EsameInterface{
	public void inserimento(Esame e){
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.save(e);

			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		} finally{
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Esame> getByIdStudente(int idStudente){
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Esame> esami = new ArrayList<Esame>();
		
		try{
			session.beginTransaction();
						
			esami = (ArrayList<Esame>) session.createQuery("from Esame where studente_id= :idStudente").setParameter("idStudente", idStudente).list();
						
			session.getTransaction().commit();

			return esami;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	@Override
	public Esame getById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Esame esame;
		
		try{
			session.beginTransaction();
						
			esame = (Esame) session.get(Esame.class, id);
						
			session.getTransaction().commit();

			return esame;
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
	public ArrayList<Esame> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Esame> esami;
		
		try{
			session.beginTransaction();

			esami = (ArrayList<Esame>) session.createQuery("from Esame").list();
			
			session.getTransaction().commit();

			return esami;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			return null;
		} finally {
			session.close();
		}
	}
	@Override
	public void update(Esame e) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.update(e);

			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}		
	}

	@Override
	public void remove(Esame e) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.delete(e);

			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}		
	}
}
