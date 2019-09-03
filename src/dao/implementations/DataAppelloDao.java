package dao.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.CRUDInterface;
import dao.interfaces.CrudGenerico;
import model.Account;
import model.DataAppello;
import util.HibernateUtil;

public class DataAppelloDao extends CrudGenerico<DataAppello, Integer> implements CRUDInterface<DataAppello , Integer>{

	public DataAppelloDao () {
		this.classeT=DataAppello.class;
	}
	@SuppressWarnings("unchecked")

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
