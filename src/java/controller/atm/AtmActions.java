/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.atm;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.classes.Account;
import model.classes.Customer;
import model.classes.Deposit;
import model.classes.HibernateUtil;
import model.classes.Withdraw;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AtmActions {
	
	public static List<Account> listAccounts(int customerId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List customers = session.createQuery("from Account where card").list();
			transaction.commit();
			return customers;
                        
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	public void updateCustomer(Long customerId, String courseName)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Customer course = (Customer) session.get(Customer.class, customerId);
			//course.setCourseName(courseName);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
        
        //withdraw
         public Long widthdraw(int accountId,double amount)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long courseId = null;
		try {
			transaction = session.beginTransaction();
                        Account account = (Account) session.get(Account.class, accountId);
			//course.setCourseName(courseName);
                        //if account exists
                        if(account != null ){                      
			   Withdraw withdraw = new Withdraw(account.getId(), account.getCustomerId(), amount);
			   //customer.setCourseName(courseName);
			   session.save(account);
                           account.setAmount(account.getAmount() - withdraw.getAmount());
                           //update account after withdraw
			   transaction.commit();
                        }
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseId;
		
	}
         

}