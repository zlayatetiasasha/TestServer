/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import test.panels.Answer;
import test.panels.LogTeacher;
import test.panels.Teacher;
import test.panels.Test;

/**
 *
 * @author Asus
 */
public interface TeacherDAO {
    // add student
    public Teacher checkTeacher(String login, String password) throws SQLException;
    // add teacher
    public BigInteger addTeacher(Teacher teacher) throws SQLException;  
    // update teacher
    public void updateTeacher(Teacher teacher) throws SQLException;
    // get teacher by id
    public Teacher getTeacherById(BigInteger id) throws SQLException;    
    // get all teachers
    public List<Teacher> getAllTeachers() throws SQLException;        
    // delete teacher
    public void deleteTeacher(Teacher teacher) throws SQLException;
    // get all tests
    public List<Test> getAllTests(BigInteger id) throws SQLException;
    //get teacher by login
    public Teacher getTeacherByLogin(String login) throws SQLException;
    //adding new LogTeacher for Teacher
    public void addLogTeacher(LogTeacher log);
}
