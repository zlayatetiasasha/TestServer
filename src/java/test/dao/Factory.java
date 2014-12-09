/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import test.dao.impl.AnswerDAOImpl;
import test.dao.impl.AnswersStudentDAOImpl;
import test.dao.impl.QuestionDAOImpl;
import test.dao.impl.StatisticsDAOImpl;
import test.dao.impl.StudentDAOImpl;
import test.dao.impl.TeacherDAOImpl;
import test.dao.impl.TestDAOImpl;

/**
 *
 * @author Asus
 */
public class Factory {
      
      private static StudentDAO studentDAO = null;
      private static TeacherDAO teacherDAO = null;
      private static TestDAO testDAO = null;
      private static QuestionDAO questionDAO = null;
      private static AnswerDAO answerDAO = null;
      private static StatisticsDAO statisticsDAO = null;
      private static AnsweredTestDAO answeredTestDAO = null;
      private static AnswersStudentDAO answersStudentDAO = null;
      private static Factory instance = null;

      public static synchronized Factory getInstance(){
            if (instance == null){
              instance = new Factory();
            }
            return instance;
      }

      public StudentDAO getStudentDAO(){
            if (studentDAO == null){
              studentDAO = new StudentDAOImpl();
            }
            return studentDAO;
      }   
      
      public TeacherDAO getTeacherDAO(){
            if (teacherDAO == null){
              teacherDAO = new TeacherDAOImpl();
            }
            return teacherDAO;
      }  
            
      public TestDAO getTestDAO(){
            if (testDAO == null){
              testDAO = new TestDAOImpl();
            }
            return testDAO;
      }  
      
      public QuestionDAO getQuestionDAO(){
            if (questionDAO == null){
              questionDAO = new QuestionDAOImpl();
            }
            return questionDAO;
      }  
      
      public AnswerDAO getAnswerDAO(){
            if (answerDAO == null){
              answerDAO = new AnswerDAOImpl();
            }
            return answerDAO;
      }  
      
      public StatisticsDAO getStatisticsDAO(){
            if (statisticsDAO == null){
              statisticsDAO = new StatisticsDAOImpl();
            }
            return statisticsDAO;
      } 
      
      public AnswersStudentDAO getAnswersStudentDAO(){
            if (answersStudentDAO == null){
              answersStudentDAO = new AnswersStudentDAOImpl();
            }
            return answersStudentDAO;
      }  
}
