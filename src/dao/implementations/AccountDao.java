package dao.implementations;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.interfaces.CRUDInterface;
import dao.interfaces.CrudGenerico;
import model.Account;
import util.HibernateUtil;

public class AccountDao extends CrudGenerico<Account, Integer> implements CRUDInterface<Account , Integer> {
	
	public AccountDao () {
		this.classeT=Account.class;
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
	
}
