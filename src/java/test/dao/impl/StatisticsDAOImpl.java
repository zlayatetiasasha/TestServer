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
import test.dao.StatisticsDAO;
import test.dao.TestDAO;
import test.panels.Statistics;
import test.panels.Test;
import test.util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class StatisticsDAOImpl implements StatisticsDAO {
    
    public void addStatistics(Statistics stat) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(stat);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - addTest");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public void updateStatistics(Statistics stat) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(stat);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - updateTest");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public Statistics getStatisticsById(Long id) throws SQLException {
            Session session = null;
            Statistics stat = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                stat = (Statistics) session.load(Statistics.class, id);
            } catch (Exception e) {
                System.out.println("Error - getTestById");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return stat;
      }

      public List<Statistics> getAllStatistics() throws SQLException {
            Session session = null;
            List<Statistics> stats = new ArrayList<Statistics>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                stats = session.createCriteria(Statistics.class).list();
            } catch (Exception e) {
                System.out.println("Error - getAllTests");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return stats;
      }

      public void deleteStatistics(Statistics stat) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(stat);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - deleteTest");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }  
}
