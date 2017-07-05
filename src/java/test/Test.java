package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uch.dao.VendedorDao;
import uch.model.VendedorBean;

public class Test {
    
    public static void main(String[] args) {
        VendedorDao dao =new VendedorDao();
        
        List<VendedorBean> lst = new ArrayList<VendedorBean>();
        
        try {
            
            lst=dao.listar();
            
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
