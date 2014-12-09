/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import test.dao.QuestionDAO;
import test.panels.Answer;
import test.panels.Question;
import test.panels.QuestionType;
import test.panels.Student;
import test.util.HibernateUtil;

/**
 *
 * @author Asus
 */
public class QuestionDAOImpl implements QuestionDAO {
    
    public void addQuestion(Question question) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(question);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - addQuestion");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public void updateQuestion(Question question) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(question);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - updateQuestion");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

      public Question getQuestionById(Long id) throws SQLException {
            Session session = null;
            Question question = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                question = (Question) session.load(Question.class, id);
            } catch (Exception e) {
                System.out.println("Error - getQuestionById");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return question;
      }

      public List<Question> getAllQuestions() throws SQLException {
            Session session = null;
            List<Question> questions = new ArrayList<Question>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                questions = session.createCriteria(Question.class).list();
            } catch (Exception e) {
                System.out.println("Error - getAllQuestions");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return questions;
      }

      public void deleteQuestion(Question question) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(question);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - deleteQuestion");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }
      
      public List<Answer> getAllAnswers(Long qid) throws SQLException {
            Session session = null;
            Query query = null;
            List result = null;
            List<Answer> answers = new ArrayList<Answer>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                query = session.createSQLQuery("select * from Answer where question_id=:id")
                        .addEntity(Answer.class).setParameter("id", qid);
                result = query.list();
                
                for(Iterator iterator = result.iterator(); iterator.hasNext();) {
                   Answer answer = (Answer)iterator.next();
                   answers.add(answer);
                }
            } catch (Exception e) {
                System.out.println("Error - getAllAnswers");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return answers;
      }
      
      public QuestionType getQuestionType(Long qid) throws SQLException {
            Session session = null;
            Query query = null;
            List result = null;
            QuestionType qt = new QuestionType();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                query = session.createSQLQuery("select * from QuestionType where q_id=:id")
                        .addEntity(QuestionType.class).setParameter("id", qid);
                result = query.list();
                if (!result.isEmpty())
                    qt = (QuestionType)result.get(0);
            } catch (Exception e) {
                System.out.println("Error - getAllAnswers");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return qt;
      }
      
      public void addQuestionType(QuestionType type) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(type);
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("Error - addQuestionType");
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }
}

