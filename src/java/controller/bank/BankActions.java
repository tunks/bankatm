/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.bank;

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

public class BankActions {

	
	public static boolean createCustomer(String firstName,String lastName, String address, String email,String phone, String accountType, double  openningAmount)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean save = false;
		try {
			transaction = session.beginTransaction();
			Customer customer = new Customer(firstName,lastName,address,email, phone);
		        int customerId = (Integer) session.save(customer);
			transaction.commit();
                       // if(customerId != null)
                        //{
                            save = addCustomerAccount(customerId,accountType, openningAmount);
                         //}
                                              
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return save;
		
	}
	
	public static List<Customer> listCustomers()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List customers = session.createQuery("from Customer").list();
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
	
	public void deleteCustomer(Long customerId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, customerId);
			session.delete(customer);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
        
        public static boolean addCustomerAccount(int customerId, String accountType, double openningAmount)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		boolean save = false;
		try {
			transaction = session.beginTransaction();
			Account account = new Account(customerId,accountType,openningAmount);
			//customer.setCourseName(courseName);
		        session.save(account);
			transaction.commit();
                        save = true;
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return save;
		
	}
        
        //withdraw
         public Long debitAccount(int accountId,double amount)
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
         
        //deposit into the account
        public Long creditAccount(int accountId,double amount)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long courseId = null;
		try {
			transaction = session.beginTransaction();
                        Account account = (Account) session.get(Account.class, accountId);
			//course.setCourseName(courseName);
                        //if account exists
                        int currentUserId = 1 ;//get the bank user 
                        if(account != null ){                      
			   Deposit deposit = new Deposit(account.getId(), amount,currentUserId);
			   //customer.setCourseName(courseName);
			   session.save(account);
                           account.setAmount(account.getAmount() + deposit.getAmount());
                           //update account after deposit
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