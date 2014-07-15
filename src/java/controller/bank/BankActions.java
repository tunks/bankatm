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

	
	public Long createCustomer(String name, String gender ,Date dateOfBirth, String address, String nationalID,String email,String phone)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long courseId = null;
		try {
			transaction = session.beginTransaction();
			Customer customer = new Customer(name, gender,dateOfBirth,address,nationalID,email, phone);
			//customer.setCourseName(courseName);
			courseId = (Long) session.save(customer);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseId;
		
	}
	
	public List<Customer> listCustomers()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List customers = session.createQuery("from customer").list();
			/*for (Iterator iterator = courses.iterator(); iterator.hasNext();)
			{
				Customer customer = (Customer) iterator.next();
				System.out.println(course.getCourseName());
			}
                        */
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
        
        public Long addCustomerAccount(int customerId, String accountType, double openningAmount)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long courseId = null;
		try {
			transaction = session.beginTransaction();
			Account account = new Account(customerId,accountType,openningAmount);
			//customer.setCourseName(courseName);
			courseId = (Long) session.save(account);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseId;
		
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