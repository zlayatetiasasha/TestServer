/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.panels;

import com.caucho.hessian.server.HessianServlet;
import java.math.BigInteger;
import test.dao.Factory;

/**
 *
 * @author hp
 */
public class TestStudentServiceImpl extends HessianServlet implements TestStudentService{
    
    public Student addStudent(Student student){
     Student st = null;
        try {
            st = Factory.getInstance().getStudentDAO().addStudent(student);
            
        }
        catch (Exception ex) {ex.printStackTrace();}
        
        return st;
    }
    
    public Student getStudentByID(BigInteger id){
    Student st = null;
        try {
            st = Factory.getInstance().getStudentDAO().getStudentById(id);    
        }
        catch (Exception ex) {ex.printStackTrace();}
        
        return st;
    }
    
}
