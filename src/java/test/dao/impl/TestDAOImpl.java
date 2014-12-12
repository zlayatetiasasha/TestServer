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
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import test.dao.TestDAO;
import test.panels.Question;
import test.panels.Teacher;
import test.panels.Test;
import test.util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class TestDAOImpl implements TestDAO {
//static Session session=HibernateUtil.getSessionFactory().openSession();

    public void addTest(Test test) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(test);
            session.update(test);
            session.getTransaction().commit();
           

            /*Hibernate.initialize(test);
             Teacher teacher = test.getTeacher();
             List<Test>tests= teacher.getTests();
             tests.add(test);
             */
        } catch (Exception e) {

            System.out.println("Error - addTest");
            System.out.println(e.getMessage());

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
        Query query = null;
        List result = null;
        try {
            System.out.println("NOW_________________________HERE------------------");
           session = HibernateUtil.getSessionFactory().openSession();
            SQLQuery q = session.createSQLQuery("select * from test where id=:id");

            if (q != null) {
                query = q.addEntity(test.panels.Test.class);
                query.setParameter("id", id);
                result = query.list();
                System.out.println("result=" + result);
            }
            if (result != null && !result.isEmpty()) {
                test = (Test) result.get(0);
                Hibernate.initialize(test);
            }

        } catch (Exception e) {

            System.out.println("Error - getTestById");
            e.printStackTrace();
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
            Hibernate.initialize(tests);
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
            query = session.createSQLQuery("select * from question where test_id=:id")
                    .addEntity(Question.class).setParameter("id", tid);
            result = query.list();

            for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                Question question = (Question) iterator.next();
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
