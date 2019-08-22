package dao.implementations;

import java.util.*;

import org.hibernate.Session;

import dao.interfaces.ProfessoreInterface;
import model.Professore;
import model.Utente;
import util.HibernateUtil;

//public class ProfessoreDao implements ProfessoreInterface {
//
//	public void inserimento(Professore p) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//
//		try{
//			session.beginTransaction();
//
//			session.save(p);
//
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		} finally{
//			session.close();
//		}
//	
//
//	}
//
//	@Override
//	public Professore getById(int id) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Utente professore;
//		
//		try{
//			session.beginTransaction();
// 
//			professore = (Utente) session.get(Utente.class, id);
//
//			session.getTransaction().commit();
//
//			return professore;
//		} catch (Exception e) {
//			System.out.println("Error in getAll()");
//			return null;
//		} finally {
//			session.close();
//		}
//	
//
//		return null;
//	}
//
//	@Override
//	public ArrayList<Utente> getAll() {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		ArrayList<Utente> professori;
//		
//		try{
//			session.beginTransaction();
//
//			professori = (ArrayList<Utente>) session.createQuery("from Professore").list();
//			
//			session.getTransaction().commit();
//
//			return professori;
//		} catch (Exception e) {
//			System.out.println("Error in getAll()");
//			return null;
//		} finally {
//			session.close();
//		}
//	
//		return null;
//	}
//
//	@Override
//	public void update(Professore p) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//
//		try{
//			session.beginTransaction();
//
//			session.update(p);
//
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//		} finally{
//			session.close();
//		}		
//	}
//
//	@Override
//	public void remove(Professore element) {
//
//	}
//
//}
