package dao.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.DataAppelloInterfaces;
import model.DataAppello;
import util.HibernateUtil;

public class DataAppelloDao implements DataAppelloInterfaces {

	@Override
	public void inserimento(DataAppello dataAppello) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
		
			session.save(dataAppello);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Errore inserimento DataAppelloDao");
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}

	@Override
	public DataAppello getById(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().openSession();
		DataAppello dataAppello;
		
		
		try {
			session.beginTransaction();
			
			dataAppello = (DataAppello) session.get(DataAppello.class, id);
			
			session.getTransaction().commit();
			
			return dataAppello;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore getById in DataAppelloDao");
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<DataAppello> getAll() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		ArrayList<DataAppello> appelli;
		
		try {
			session.beginTransaction();
			
			appelli= (ArrayList<DataAppello>) session.createQuery("from DataAppello").list();
			
			session.getTransaction().commit();
			 
			return appelli;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore getAll in DataAppelloDao");
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public void update(DataAppello dataAppello) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			session.update(dataAppello);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore update in DataAppelloDao");
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}

	@Override
	public void remove(DataAppello dataAppello) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			
			session.delete(dataAppello);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore remove in DataAppelloDao");
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataAppello> getByFacoltaAndCorso(int idFacolta, int idCorso) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		ArrayList<DataAppello> appelli;
		
		try {
			session.beginTransaction();
			
			appelli= (ArrayList<DataAppello>) session
					.createQuery("from DataAppello where facolta_id = :facolta and corso_id = :corso")
					.setParameter("facolta", idFacolta)
					.setParameter("corso", idCorso)
					.list();
			
			session.getTransaction().commit();
			 
			return appelli;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore getAll in DataAppelloDao");
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<DataAppello> getByProfessoreFacoltaAndCorso(int idProfessore, int idFacolta, int idCorso) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		ArrayList<DataAppello> appelli;
		
		try {
			session.beginTransaction();
			
			appelli= (ArrayList<DataAppello>) session
					.createQuery("from DataAppello where professore_id = :professore "
														+ "and facolta_id = :facolta "
														+ "and corso_id = :corso")
					.setParameter("professore", idProfessore)
					.setParameter("facolta", idFacolta)
					.setParameter("corso", idCorso)
					.list();
			
			session.getTransaction().commit();
			 
			return appelli;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errore getAll in DataAppelloDao");
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	public DataAppello getByIdWithPrenotazioni(int id) {
		// TODO Auto-generated method stub
				Session session=HibernateUtil.getSessionFactory().openSession();
				DataAppello dataAppello;
				
				
				try {
					session.beginTransaction();
					
					dataAppello = (DataAppello) session.get(DataAppello.class, id);
					Hibernate.initialize(dataAppello.getPrenotazioni());
					
					session.getTransaction().commit();
					
					return dataAppello;
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Errore getById in DataAppelloDao");
					session.getTransaction().rollback();
				}finally {
					session.close();
				}
				return null;
	}

}
