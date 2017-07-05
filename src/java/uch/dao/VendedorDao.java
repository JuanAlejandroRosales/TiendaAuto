package uch.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uch.model.VendedorBean;

public class VendedorDao {    
    
    public List<VendedorBean> listar() throws SQLException {
        Connection cn = null;
        
        List<VendedorBean> lista = new ArrayList<VendedorBean>();
        try {
            cn = ConexionBD.getConnection();
            
            String sql = "{call USP_VENDEDOR_LISTAR()}";
            
            CallableStatement cstm = cn.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();
            
            while (rs.next()) {                
                
                VendedorBean t = new VendedorBean();
                t.setId(rs.getInt("idVendedor"));
                t.setCodigo(rs.getString("codigo"));
                t.setNombre(rs.getString("nombre"));
                
                lista.add(t);
                
            }
            
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

}
