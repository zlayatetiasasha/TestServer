/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import test.dao.TestDAO;
import test.panels.Question;
import test.panels.Test;
import test.util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class TestDAOImpl implements TestDAO {
    
    public void addTest(Test test) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(test);
                System.out.println("test.getNumberOfQuestions()= "+test.getNumberOfQuestions());
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error - addTest");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public void updateTest(Test test) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(test);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - updateTest");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public Test getTestById(BigInteger id) throws SQLException {
            Session session = null;
            Test test = null;
            try {
                System.out.println("NOW_________________________HERE------------------");
                session = HibernateUtil.getSessionFactory().openSession();
                test = (Test) session.load(Test.class, id);
               System.out.println(test.getId()+" --------------NOW_________________________HERE------------------");
            } catch (Exception e) {
                System.out.println("Error - getTestById");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return test;
      }

      public List<Test> getAllTests() throws SQLException {
            Session session = null;
            List<Test> tests = new ArrayList<Test>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                tests = session.createCriteria(Test.class).list();
            } catch (Exception e) {
                System.out.println("Error - getAllTests");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return tests;
      }

      public void deleteTest(Test test) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(test);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - deleteTest");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }  
      
      public List<Question> getAllQuestions(Long tid) throws SQLException {
            Session session = null;
            Query query = null;
            List result = null;
            List<Question> questions = new ArrayList<Question>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                query = session.createSQLQuery("select * from Question where test_id=:id")
                        .addEntity(Question.class).setParameter("id", tid);
                result = query.list();
                
                for(Iterator iterator = result.iterator(); iterator.hasNext();) {
                   Question question = (Question)iterator.next();
                   questions.add(question);
                }
            } catch (Exception e) {
                System.out.println("Error - getAllQuestions");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return questions;
      }
}
