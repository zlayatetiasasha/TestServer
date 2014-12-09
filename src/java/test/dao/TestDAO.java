/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import test.panels.Question;
import test.panels.Test;

/**
 *
 * @author Asus
 */
public interface TestDAO {
    // add test
    public void addTest(Test test) throws SQLException;  
    // update test
    public void updateTest(Test test) throws SQLException;
    // get test by id
    public Test getTestById(BigInteger id) throws SQLException;    
    // get all tests
    public List<Test> getAllTests() throws SQLException;        
    // delete test
    public void deleteTest(Test test) throws SQLException;
    // get all questions
    public List<Question> getAllQuestions(Long id) throws SQLException;
    // find test
    // public List<Test> findTest(Long id) throws SQLException;
}
