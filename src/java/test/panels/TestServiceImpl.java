/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.panels;

/**
 *
 * @author LUDMILA2
 */
import com.caucho.hessian.server.HessianServlet;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import test.dao.Factory;

public class TestServiceImpl extends HessianServlet implements TestService
{
   public boolean addTest(Test t){ 
        boolean temp = false;
            try
            {
                Factory.getInstance().getTestDAO().addTest(t);
                temp = true;
                System.out.println("I've got the test to add");
            }
            catch (Exception ex) {ex.printStackTrace();}
        return temp;
    }
   
   public Test getTestById(BigInteger id){ 
        boolean temp = false;
        Test t=null;
            try
            {
                t = Factory.getInstance().getTestDAO().getTestById(id);
                //temp = t;
                System.out.println("I've got the test to get= "+t.getId()+" "+t.getNumberOfQuestions());
            }
            catch (Exception ex) {ex.printStackTrace();}
        return t;
    }
   
   public boolean addAnswersStudent(AnswersStudent answs){
        boolean temp = false;
            try
            {
                Factory.getInstance().getAnswersStudentDAO().addAnswersStudent(answs);
                temp = true;
                System.out.println("I've got the answs test to add");
            }
            catch (Exception ex) {ex.printStackTrace();}
        return temp;
  
   }
   

}

