package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.interfaces.CRUDInterface;
import dao.interfaces.CrudGenerico;
import model.Account;
import model.Esame;
import util.HibernateUtil;

public class EsameDao extends CrudGenerico<Esame, Integer> implements CRUDInterface<Esame , Integer>{
	
	public EsameDao () {
		this.classeT=Esame.class;
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
	
	
}
