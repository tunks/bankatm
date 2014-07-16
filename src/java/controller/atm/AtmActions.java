/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.atm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.classes.Account;
import model.classes.Card;
import model.classes.HibernateUtil;
import model.classes.Withdraw;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tune
 */
public class AtmActions {
    
    public static int getCustomerIDfromCardID(int cardId) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
	Transaction transaction = null;
        
        try {
            
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Card where id= :id ");
            query.setParameter("id", cardId);
            
            List<Card> list = query.list();

            return list.get(0).getCustomerId();
            
	} catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
	} finally {
            session.close();
	}
        
        return -1;
    }
    
    
    public static double getAmountfromCustomerID(int cusId) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
	Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Account where customerId = :customerId ");
            query.setParameter("customerId", cusId);
            
            List<Account> list = query.list();
            Account account = list.get(0);
            
            return list.get(0).getAmount();
            
	} catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
	} finally {
            session.close();
            
	}
        
        return -1;
        
    }
    
    public static double getAmountWithdrawFromTransactioin(int cardId, Date today) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
	Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Withdraw where cardId = :cardId and day(date) = day(:date) and month(date) = month(:date) and year(date) = year(:date) and type = 'WITHDRAW' ");
            query.setParameter("cardId", cardId);
            query.setParameter("date", today);
            
            List<Withdraw> list = query.list();
            
            if( list == null ) 
                return 0;
            
            double totalAmount = 0;
            for(int i=0 ; i<list.size() ; i++) { 
                totalAmount += list.get(i).getAmount();
            }
            
            return totalAmount;
            
	} catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
	} finally {
            session.close();
            
	}
        
        return -1;
        
    }
    
    public static Date getTodayDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        
        return date;
    }
    
}
