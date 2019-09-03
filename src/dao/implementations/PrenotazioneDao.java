package dao.implementations;

import java.util.ArrayList;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import dao.interfaces.CRUDInterface;
import dao.interfaces.CrudGenerico;
import model.Account;
import model.Prenotazione;
import util.HibernateUtil;

public class PrenotazioneDao extends CrudGenerico<Prenotazione, Integer> implements CRUDInterface<Prenotazione , Integer>{

	public PrenotazioneDao () {
		this.classeT=Prenotazione.class;
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
	
	public Prenotazione getByComposedId(int id_studente, int id_data) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		Prenotazione p = (Prenotazione) session.createQuery("from Prenotazione where studente_id = :studente "
																+ "and data_appello_id = :data")
								.setParameter("studente", id_studente)
								.setParameter("data", id_data)
								.list().get(0);
		
		session.getTransaction().commit();
		session.close();
		
		return p;
	}


}
