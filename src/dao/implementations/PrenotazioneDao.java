package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.interfaces.PrenotazioneInterface;
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

	@Override
	public Prenotazione getById(int id) {
		// TODO Auto-generated method stub
		return null;
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

}
