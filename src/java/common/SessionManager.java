/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.util.List;
import model.classes.CardSession;
import model.classes.Customer;
import model.classes.HibernateUtil;
import model.classes.UserSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.servlet.http.HttpSession;
/**
 *
 * @author ebrima
 */
public class SessionManager {
    public static  boolean addCardSession(int cardId, int customerId , String ses, long timestamp){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
                boolean save = false;
		try {
                    
                        transaction = session.beginTransaction();
			CardSession cardSession = new CardSession(cardId,customerId,ses,timestamp);
		        session.save(cardSession);
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
    
     public static  boolean addUserSession(int userId, HttpSession httpSession){
        Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
                boolean save = false;
		try {
                        transaction = session.beginTransaction();
			UserSession  userSession = new UserSession(userId,httpSession.getId(),httpSession.getCreationTime());
		        session.save(userSession);
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
}
