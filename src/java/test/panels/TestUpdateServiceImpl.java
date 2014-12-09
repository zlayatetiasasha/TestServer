/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.panels;

import com.caucho.hessian.server.HessianServlet;
import java.util.Iterator;
import java.util.List;
import test.dao.Factory;

/**
 *
 * @author Asus
 */
public class TestUpdateServiceImpl extends HessianServlet implements TestUpdateService
{
    
    public boolean update(Test test) {
        boolean temp = false;
        try {
                Factory.getInstance().getTestDAO().updateTest(test);
                temp = true;
            }
        catch (Exception ex) {ex.printStackTrace();}
        
        return temp;
    }
}