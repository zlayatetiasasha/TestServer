/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.panels;

import com.caucho.hessian.server.HessianServlet;
import java.util.List;
import test.dao.Factory;

/**
 *
 * @author Asus
 */
public class TestServiceTeacherImpl extends HessianServlet implements TestServiceTeacher {
    
    public Test[] getTeacherTests(Long id) {
        List<Test> temp = null;
        Test[] tests = null;
        try {
            temp = Factory.getInstance().getTeacherDAO().getAllTests(id);
            if(temp != null && !temp.isEmpty()) 
                tests = temp.toArray(new Test[temp.size()]);
        }
        catch (Exception ex) {ex.printStackTrace();}
        
        return tests;
    }   
}
