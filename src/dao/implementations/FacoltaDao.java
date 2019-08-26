package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.FacoltaInterface;
import model.Facolta;
import util.HibernateUtil;

public class FacoltaDao implements FacoltaInterface{

	
	// Metodo di inserimento per la facoltà, in hibernate tutti i metodi di inserimento 
	// saranno analoghi a questo
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
	
	// Metodo che restituisce tutti i record di facoltà dal database
	// Dato che il Fetch-type tra facoltà e corsi è configurato a "LAZY"
	// con la query quì sotto non verranno recuperati i corsi (più efficiente)
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Facolta> getAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Facolta> facolta;
		
		try{
			session.beginTransaction();
			
			facolta = (ArrayList<Facolta>) session
					.createQuery("from Facolta")
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
	
	// Metodo che restituisce tutti i record di facoltà dal database.
	// Con questa query, anche se il fetch-type è di tipo LAZY
	// caricheremo comunque i corsi con le facoltà (meno efficiente ma a volta necessario)
	
	@SuppressWarnings("unchecked")
	@Override
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
	
	// Metodo che restituisce un singolo record di facoltà dal database
	// Dato che il Fetch-type tra facoltà e corsi è configurato a "LAZY"
	// con la query quì sotto non verranno recuperati i corsi (più efficiente)
	
	@Override
	public Facolta getById(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Facolta facolta;
		
		try{
			session.beginTransaction();
						
			facolta = (Facolta) session.get(Facolta.class, id);
						
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
	
	// Metodo che restituisce un singolo record di facoltà dal database.
	// Con "Hibernate.initialize()", anche se il fetch-type è di tipo LAZY
	// caricheremo comunque i corsi con le facoltà (meno efficiente ma a volta necessario)
	
	@Override
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
	
	@Override
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
	
	// Metodo di update per la facoltà, in hibernate tutti i metodi di update 
	// saranno analoghi a questo

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

	// Metodo di remove per la facoltà, in hibernate tutti i metodi di remove 
	// saranno analoghi a questo

	@Override
	public void remove(Facolta f) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try{
			session.beginTransaction();

			session.delete(f);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally{
			session.close();
		}			
	}

	
	
}
