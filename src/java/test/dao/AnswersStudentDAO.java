/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

/**
 *
 * @author hp
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import test.panels.Answer;
import test.panels.AnswersStudent;

/**
 *
 * @author hp
 */
public interface AnswersStudentDAO {
    public void addAnswersStudent(AnswersStudent answ) throws SQLException;
    
    
}
