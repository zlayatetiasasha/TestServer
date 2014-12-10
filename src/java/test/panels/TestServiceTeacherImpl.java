/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.panels;

import com.caucho.hessian.server.HessianServlet;
import java.math.BigInteger;
import java.util.List;
import test.dao.Factory;

/**
 *
 * @author Asus
 */
public class TestServiceTeacherImpl extends HessianServlet implements TestServiceTeacher {
    
    public Test[] getTeacherTests(BigInteger teacher_id) {
        List<Test> temp = null;
        Test[] tests = null;
        try {
            temp = Factory.getInstance().getTeacherDAO().getAllTests(teacher_id);
            if(temp != null && !temp.isEmpty()) 
                tests = temp.toArray(new Test[temp.size()]);
        }
        catch (Exception ex) {ex.printStackTrace();}
        
        return tests;
    }  
    
     public Teacher getTeacherById(BigInteger teacher_id) {
     Teacher teacher = null;
        try {
            teacher = Factory.getInstance().getTeacherDAO().getTeacherById(teacher_id);
            
        }
        catch (Exception ex) {ex.printStackTrace();}
        
        return teacher;
     }
     
     public Teacher getTeacherByLogin(String login) {
     Teacher teacher = null;
        try {
            teacher = Factory.getInstance().getTeacherDAO().getTeacherByLogin(login);
            
        }
        catch (Exception ex) {ex.printStackTrace();}
        
        return teacher;
     }
    
    
}
