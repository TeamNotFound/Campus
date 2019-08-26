package dao.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.PrenotazioneInterface;
import model.Facolta;
import model.Prenotazione;
import util.HibernateUtil;

public class PrenotazioneDao implements PrenotazioneInterface{

	@Override
	public void inserimento(Prenotazione p) {
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

	public Prenotazione getByIdWithStudente1(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Prenotazione prenotazione;
		
		try{
			session.beginTransaction();
						
			prenotazione = (Prenotazione) session.get(Prenotazione.class, id);
			Hibernate.initialize(prenotazione.getStudente());
						
			session.getTransaction().commit();

			return prenotazione;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	@Override
	public ArrayList<Prenotazione> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Prenotazione element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Prenotazione element) {
		// TODO Auto-generated method stub
		
	}
	public Prenotazione getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Prenotazione prenotazione;
		
		try{
			session.beginTransaction();
						
			prenotazione = (Prenotazione) session.get(Prenotazione.class, id);
						
			session.getTransaction().commit();

			return prenotazione;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

//	public List<Prenotazione> getByStudenteId(int studenteId) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		List<Prenotazione> prenotazioni = null;
//		
//		try{
//			session.beginTransaction();
//						
//			prenotazioni = session.createQuery("from Prenotazione where studente_id = :studente")
//					.setParameter("studente", studenteId)
//					.list();
//						
//			session.getTransaction().commit();
//
//			return prenotazioni;
//		}
//			catch (Exception e) {
//				System.out.println("Error in getAll()");
//				e.printStackTrace();
//				return null;
//			} finally {
//				session.close();
//			}
//		}
//		

}
