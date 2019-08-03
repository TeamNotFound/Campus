package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.interfaces.RuoloInterface;
import model.Ruolo;
import util.HibernateUtil;

public class RuoloDao implements RuoloInterface {

	@Override
	public void inserimento(Ruolo element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ruolo getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Ruolo ruolo;

		try{
			session.beginTransaction();

			ruolo = (Ruolo) session.get(Ruolo.class, id);
			
			session.getTransaction().commit();
			
			return ruolo;
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
	public ArrayList<Ruolo> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		ArrayList<Ruolo> ruoli;

		try{
			session.beginTransaction();

			ruoli = (ArrayList<Ruolo>) session.createQuery("from Ruolo").list();
			
			session.getTransaction().commit();
			
			return ruoli;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Ruolo element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Ruolo element) {
		// TODO Auto-generated method stub
		
	}

	
}
