/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.atm;

import java.util.List;
import model.classes.Account;
import model.classes.Card;
import model.classes.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tune
 */
public class AtmActions {
    
    public int getCustomerIDfromCardID(int cardId) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
	Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Card where id = :id ");
            query.setParameter("id", cardId);
            
            List<Card> list = query.list();
            Card card = list.get(0);
            
            System.out.print(card.getCustomerId());
            
            return list.get(0).getCustomerId();
            
	} catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
	} finally {
            session.close();
            return -1;
	}
       
    }
    
    
    public double getAmountfromCustomerID(int cusId) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
	Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Account where customerId = :customerId ");
            query.setParameter("customerId", cusId);
            
            List<Account> list = query.list();
            Account account = list.get(0);
            
            System.out.print(account.getCustomerId());
            
            return list.get(0).getAmount();
            
	} catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
	} finally {
            session.close();
            return 0;
	}
       
    }
    
}
