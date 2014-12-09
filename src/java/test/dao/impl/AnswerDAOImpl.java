/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import test.dao.AnswerDAO;
import test.dao.TestDAO;
import test.panels.Answer;
import test.panels.Test;
import test.util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class AnswerDAOImpl implements AnswerDAO {
    
    public void addAnswer(Answer answer) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(answer);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - addAnswer");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public void updateAnswer(Answer answer) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(answer);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - updateAnswer");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public Answer getAnswerById(Long id) throws SQLException {
            Session session = null;
            Answer answer = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                answer = (Answer) session.load(Answer.class, id);
            } catch (Exception e) {
                System.out.println("Error - getAnswerById");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return answer;
      }

      public List<Answer> getAllAnswers() throws SQLException {
            Session session = null;
            List<Answer> answers = new ArrayList<Answer>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                answers = session.createCriteria(Answer.class).list();
            } catch (Exception e) {
                System.out.println("Error - getAllAnswers");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return answers;
      }

      public void deleteAnswer(Answer answer) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(answer);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - deleteAnswer");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }  
}
