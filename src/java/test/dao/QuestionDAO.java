/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import java.sql.SQLException;
import java.util.List;
import test.panels.Answer;
import test.panels.Question;
import test.panels.QuestionType;
/**
 *
 * @author Asus
 */
public interface QuestionDAO {
    // add question
    public void addQuestion(Question question) throws SQLException;  
    // update question
    public void updateQuestion(Question question) throws SQLException;
    // get question by id
    public Question getQuestionById(Long id) throws SQLException;    
    // get all questions
    public List<Question> getAllQuestions() throws SQLException;        
    // delete question
    public void deleteQuestion(Question question) throws SQLException;
    // get all answers
    public List<Answer> getAllAnswers(Long id) throws SQLException;
    // get question type
    public QuestionType getQuestionType(Long id) throws SQLException;
    // add question type
    public void addQuestionType(QuestionType type) throws SQLException;
}
