/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dao;
import java.sql.SQLException;
import java.util.List;
import test.panels.Student;

/**
 *
 * @author Asus
 */
public interface StudentDAO {
    // add student
    public Long checkStudent(String login, String password) throws SQLException;
    // add student
    public void addStudent(Student student) throws SQLException;  
    // update student
    public void updateStudent(Student student) throws SQLException;
    // get student by id
    public Student getStudentById(Long id) throws SQLException;    
    // get all students
    public List<Student> getAllStudents() throws SQLException;        
    // delete student
    public void deleteStudent(Student student) throws SQLException;
}
