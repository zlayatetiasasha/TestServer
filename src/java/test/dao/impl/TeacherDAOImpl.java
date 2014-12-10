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
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import test.dao.TeacherDAO;
import test.panels.LogTeacher;
import test.panels.Teacher;
import test.panels.Test;
import test.util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class TeacherDAOImpl implements TeacherDAO {
    
    public void addTeacher(Teacher teach) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(teach);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - addTeacher");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
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
      
      public List<Test> getAllTests(BigInteger tid) throws SQLException {
            Session session = null;
            Query query = null;
            List result = null;
            List<Test> tests = new ArrayList<Test>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
               SQLQuery q= session.createSQLQuery("select * from test where teacher_id=:id");
               query=q.addEntity(test.panels.Test.class);
               query.setParameter("id", tid);
                       // .addEntity(Test.class).setParameter("id", tid);
                result = query.list();
                
                for(Iterator iterator = result.iterator(); iterator.hasNext();) {
                   Test test = (Test)iterator.next();
                   tests.add(test);
                }
            } catch (Exception e) {
                System.out.println("Error - getAllTests");
                System.out.println("-----------ERROR!_____ in getAllTests");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return tests;
      }
      
      public BigInteger checkTeacher(String login, String password) throws SQLException {
            Session session = null;
            Query query = null;
            List result = null;
            LogTeacher log_teacher=null;
            BigInteger id = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                SQLQuery q=session.createSQLQuery("select * from LogTeacher where login=:l");
              
                query=q.addEntity(test.panels.LogTeacher.class);
                query.setParameter("l", login);
                
                System.out.println(login+ " "+ password);
                System.out.println("query="+query);
               
                if(query!=null){
                result = query.list();
                }
                
                if (result!=null)
                { log_teacher = (LogTeacher)result.get(0);
                  id=log_teacher.getId();
                    }
                    
                     
                
                System.out.println("teacher found= "+id);
            } catch (Exception e) {
               e.printStackTrace();
                System.out.println("Error - checkTeacher");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return id;
      }
}