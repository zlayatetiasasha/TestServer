/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import test.dao.TeacherDAO;
import test.panels.LogTeacher;
import test.panels.Teacher;
import test.panels.Test;
import test.util.HibernateUtil;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import test.panels.Answer;
import test.panels.Question;

/**
 *
 * @author Asus
 */
public class TeacherDAOImpl implements TeacherDAO {

    public BigInteger addTeacher(Teacher teach) throws SQLException {
        Session session = null;
        BigInteger t = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            System.out.println("Adding teacher beginTransaction()=");
            t = (BigInteger) session.save(teach);

            System.out.println("Adding teacher id=" + t);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error - addTeacher");
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return t;
    }

    public void updateTeacher(Teacher teach) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(teach);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error - updateTeacher");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Teacher getTeacherById(BigInteger id) throws SQLException {
        Session session = null;
        Teacher teach = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            teach = (Teacher) session.load(Teacher.class, id);
            Hibernate.initialize(teach);
        } catch (Exception e) {
            System.out.println("Error - getTeacherById");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return teach;
    }

    public List<Teacher> getAllTeachers() throws SQLException {
        Session session = null;
        List<Teacher> teachs = new ArrayList<Teacher>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            teachs = session.createCriteria(Teacher.class).list();
        } catch (Exception e) {
            System.out.println("Error - getAllTeachers");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return teachs;
    }

    public void deleteTeacher(Teacher teach) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(teach);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error - deleteTeacher");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    //static Session session=HibernateUtil.getSessionFactory().openSession(); 
    public List<Test> getAllTests(BigInteger tid) throws SQLException {
        Session session = null;
        Query query = null;
        List result = null;
        List<Test> tests = new ArrayList<Test>();
        try {
            System.out.println("TeacherDAOImpl in getAllTests");

            session = HibernateUtil.getSessionFactory().openSession();
            Criteria cats = session.createCriteria(Test.class)
                    .add(Restrictions.eq("teacher.id", tid))
                    .setFetchMode("questions", FetchMode.JOIN);
            if (cats != null) {

                List<Test> l = cats.list();
                tests = l;
                System.out.println("tests.size()"+tests.size());
                Hibernate.initialize(tests);

            }

            if (!tests.isEmpty() && tests.size() > 0) {
                tests.get(0).getTeacher().setTests(tests);
                System.out.println("tests.get(0).getTeacher()"+tests.get(0).getTeacher());
            }

            /*     SQLQuery q = session.createSQLQuery("select * from test where teacher_id=:id ");
             query = q.addEntity(test.panels.Test.class);
             query.setParameter("id", tid);*/
            // .addEntity(Test.class).setParameter("id", tid);
            // result = query.list();

            /*   if (result != null && !result.isEmpty()) {

             for (Iterator iterator = result.iterator(); iterator.hasNext();) {
             Hibernate.initialize(iterator.next());

             }
             for (Iterator iterator = result.iterator(); iterator.hasNext();) {
             Test test = (Test) (iterator.next());
             tests.add(test);
             Hibernate.initialize(test);
             Hibernate.initialize(test.getQuestions().size());
                    
                    
             }
             */
        } catch (Exception e) {
            System.out.println("Error - getAllTests");
            System.out.println("-----------ERROR!_____ in getAllTests");
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();

            }
        }
        return tests;
    }

    //returns null when there are no such pair login/password
    public Teacher checkTeacher(String login, String password) throws SQLException {
        Session session = null;
        Query query = null;
        List result = null;
        LogTeacher log_teacher = null;
        BigInteger id = null;
        Teacher teacher = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            SQLQuery q = session.createSQLQuery("select * from logteacher where login=:l and password=:p");

            query = q.addEntity(test.panels.LogTeacher.class);
            query.setParameter("l", login);
            query.setParameter("p", password);

            System.out.println(login + " " + password);
            System.out.println("query=" + query);

            if (query != null) {
                result = query.list();
            }

            if (result != null && !result.isEmpty()) {
                log_teacher = (LogTeacher) result.get(0);
                id = log_teacher.getId();
                teacher = log_teacher.getTeacher();
            }

            System.out.println("teacher found= " + id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error - checkTeacher");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return teacher;
    }

    //returns null when there are no such teacher with login
    public Teacher getTeacherByLogin(String login) throws SQLException {
        Session session = null;
        Query query = null;
        List result = null;
        LogTeacher log_teacher = null;
        BigInteger id = null;
        Teacher teacher = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            SQLQuery q = session.createSQLQuery("select * from logteacher where login=:l");

            query = q.addEntity(test.panels.LogTeacher.class);
            query.setParameter("l", login);

            System.out.println("query=" + query);

            if (query != null) {
                result = query.list();
            }

            if (result != null) {
                log_teacher = (LogTeacher) result.get(0);
                Hibernate.initialize(log_teacher);
                id = log_teacher.getId();
                teacher = log_teacher.getTeacher();
            }

            System.out.println("teacher found= " + id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error - checkTeacher");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return teacher;
    }

    public void addLogTeacher(LogTeacher log) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(log);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error - addTeacherLog");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
