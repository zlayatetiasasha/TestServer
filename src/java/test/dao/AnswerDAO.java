/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import java.sql.SQLException;
import java.util.List;
import test.panels.Answer;
/**
 *
 * @author Asus
 */
public interface AnswerDAO {
    // add answer
    public void addAnswer(Answer answer) throws SQLException;  
    // update answer
    public void updateAnswer(Answer answer) throws SQLException;
    // get answer by id
    public Answer getAnswerById(Long id) throws SQLException;    
    // get all answers
    public List<Answer> getAllAnswers() throws SQLException;        
    // delete answer
    public void deleteAnswer(Answer answer) throws SQLException;
}
