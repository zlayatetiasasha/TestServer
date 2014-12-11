/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import test.dao.StudentDAO;
import test.panels.LogStudent;
import test.panels.QuestionType;
import test.panels.Student;
import test.util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class StudentDAOImpl implements StudentDAO {
    
    public Student addStudent(Student stud) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(stud);
                session.getTransaction().commit();
                return stud;
            } catch (Exception e) {
                System.out.println("Error - addStudent");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return null;
      }

      public void updateStudent(Student stud) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(stud);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - updateStudent");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public Student getStudentById(BigInteger id) throws SQLException {
            Session session = null;
            Student stud = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                stud = (Student) session.load(Student.class, id);
            } catch (Exception e) {
                System.out.println("Error - getStudentById");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return stud;
      }

      public List<Student> getAllStudents() throws SQLException {
            Session session = null;
            List<Student> studs = new ArrayList<Student>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                studs = session.createCriteria(Student.class).list();
            } catch (Exception e) {
                System.out.println("Error - getAllStudents");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return studs;
      }

      public void deleteStudent(Student stud) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(stud);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - deleteStudent");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }  
      
      public Long checkStudent(String login, String password) throws SQLException {
            Session session = null;
            Query query = null;
            List result = null;
            Long id = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                query = session.createSQLQuery("select s_id from LogStudent where login=:l and password=:p")
                        .addEntity(LogStudent.class).setParameter("l", login).setParameter("p", password);
                result = query.list();
                if (!result.isEmpty())
                    id = (Long)result.get(0);
            } catch (Exception e) {
                System.out.println("Error - checkStudent");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return id;
      }
}
