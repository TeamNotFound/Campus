package dao;

import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import model.Account;
import util.HibernateUtil;

public class AccountDao implements CRUDInterface<Account> {

	@Override
	public void inserimento(Account a) {
		
	}

	@Override
	public Account getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Account account;

		try{
			session.beginTransaction();

			account = (Account) session.get(Account.class, id);
			
			session.getTransaction().commit();
			
			return account;
		} catch (Exception e) {
			System.out.println("Error in getAll()");
			return null;
		} finally {
			session.close();
		}

	}
	
	public Account getByUsername(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Account account;

		try{
			session.beginTransaction();

			Query qry = session.createQuery("from Account a where a.username = :username");
			qry.setParameter("username", username);
			
			account = (Account) qry.list().get(0);
			
			session.getTransaction().commit();
			
			return account;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in getAll()");
			return null;
		} finally {
			session.close();
		}

	}

	@Override
	public ArrayList<Account> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Account element) {
		// TODO Auto-generated method stub
		
	}

	

}
