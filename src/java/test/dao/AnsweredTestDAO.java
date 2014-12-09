/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import test.panels.AnsweredTest;

/**
 *
 * @author hp
 */
public interface AnsweredTestDAO {
     public void addAnsweredTest(AnsweredTest answ) throws SQLException; 
     public void getAnsweredTest(BigInteger answ_test_id) throws SQLException; 
     public void getAnsweredTestByTest(BigInteger test_id) throws SQLException; 
}
