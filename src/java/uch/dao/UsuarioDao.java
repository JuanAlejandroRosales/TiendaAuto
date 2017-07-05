package uch.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uch.model.UsuarioBean;

public class UsuarioDao {
    
    public String login(String USUARIO, String PASSWORD) throws SQLException {
        Connection cn = null;
        String userval = null;
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_LOGIN_USUARIO(?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1, USUARIO);
            cstm.setString(2, PASSWORD);
            ResultSet rs = cstm.executeQuery();
            if(rs.next()) {
                userval="validado";
            }else{
                userval="novalidado";
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return userval;
    }
}
