/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao.impl;

import java.sql.SQLException;
import org.hibernate.Session;
import test.dao.AnswersStudentDAO;
import test.dao.StatisticsDAO;
import test.panels.AnswersStudent;
import test.util.HibernateUtil;

/**
 *
 * @author hp
 */
public class AnswersStudentDAOImpl implements AnswersStudentDAO{
    public void addAnswersStudent(AnswersStudent answ) throws SQLException{
    Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(answ);
                System.out.println(answ.getAnswer().getText()+"------------------HERE------");
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error - addAnswersStudent");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }    
    }
}
