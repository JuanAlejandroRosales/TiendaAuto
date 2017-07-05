package uch.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import uch.model.AutoBean;

public class AutoDao {
    
    public List<AutoBean> listar() throws SQLException {
        Connection cn = null;
        List<AutoBean> lista = new ArrayList<AutoBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_AUTOMOVIL_CONSULTA()}";
            CallableStatement cstm = cn.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                AutoBean t = new AutoBean();
                t.setCodigo(rs.getString("ID_AUTOMOVIL"));
                t.setMarca(rs.getString("ID_MARCA"));
                t.setModelo(rs.getString("MODELO"));
                t.setColor(rs.getString("COLOR"));
                t.setPrecio(rs.getDouble("PRECIO"));
                t.setStock(rs.getInt("STOCK"));
                t.setEstado(rs.getString("ESTADO"));
                lista.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
    
    public List<AutoBean> listar(int numeroPagina, int filasPorPagina) throws SQLException {
        Connection cn = null;
        List<AutoBean> lista = new ArrayList<AutoBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_PAGINACION_AUTOMOVIL(?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setInt(1, numeroPagina);
            cstm.setInt(2, filasPorPagina);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                AutoBean t = new AutoBean();
                t.setCodigo(rs.getString("ID_AUTOMOVIL"));
                t.setMarca(rs.getString("ID_MARCA"));
                t.setModelo(rs.getString("MODELO"));
                t.setColor(rs.getString("COLOR"));
                t.setPrecio(rs.getDouble("PRECIO"));
                t.setStock(rs.getInt("STOCK"));
                t.setEstado(rs.getString("ESTADO"));
                lista.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
    
    public List<AutoBean> listar(int CantidadReg) throws SQLException {
        Connection cn = null;
        List<AutoBean> lista = new ArrayList<AutoBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_FILTRARCANTREG_AUTOMOVIL(?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setInt(1, CantidadReg);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                AutoBean t = new AutoBean();
                t.setCodigo(rs.getString("ID_AUTOMOVIL"));
                t.setMarca(rs.getString("ID_MARCA"));
                t.setModelo(rs.getString("MODELO"));
                t.setColor(rs.getString("COLOR"));
                t.setPrecio(rs.getDouble("PRECIO"));
                t.setStock(rs.getInt("STOCK"));
                t.setEstado(rs.getString("ESTADO"));
                lista.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
   
    
   
    public String generarcodigo() throws SQLException {
        Connection cn = null;
        String codigo = null;
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_GENERARCODIGOAUTOMOVIL()}";
            CallableStatement cstm = cn.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();
            if (rs.next()) {
                codigo = rs.getString("CODIGO");
            }
            rs.close();
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return codigo;
    }

    public int getCantPaginas(int filasPorPagina) throws Exception {
        int totalPaginas = 0;
        double valor;
        Connection cn = null;
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_TOTAL_REGISTROS_AUTOMOVIL()}";
            CallableStatement cstm = cn.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();

            if (rs.next()) {
                valor = rs.getInt("CANTREG");
                valor = Math.ceil(valor / filasPorPagina);
                totalPaginas = (int) valor;
            } else {
                totalPaginas = 1;
            }
            rs.close();
            cstm.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (SQLException e1) {
            }
        }
        return totalPaginas;
    }

    public boolean Insertar(AutoBean auto) throws SQLException {
        Connection cn = null;        
        boolean rpta = false;
        try {            
            cn = ConexionBD.getConnection();
            String sql = "{call USP_INSERTAR_AUTOMOVIL(?,?,?,?,?,?,?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1, auto.getCodigo());
            cstm.setString(2, auto.getMarca());
            cstm.setString(3, auto.getModelo());
            cstm.setString(4, auto.getColor());
            cstm.setDouble(5, auto.getPrecio());
            cstm.setInt(6, auto.getStock());
            cstm.setString(7, auto.getEstado());
            cstm.setString(8, auto.getFecha_registro());
            rpta = cstm.executeUpdate() == 1 ? true : false;
            cstm.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
    
    public AutoBean buscar(String Id) throws Exception {
        Connection cn = null;
        AutoBean auto = new AutoBean();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_BUSCAR_AUTOMOVIL(?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1, Id);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {                
                auto.setCodigo(rs.getString("ID_AUTOMOVIL"));
                auto.setMarca(rs.getString("ID_MARCA"));
                auto.setModelo(rs.getString("MODELO"));                
                auto.setColor(rs.getString("COLOR"));
                auto.setPrecio(rs.getInt("PRECIO"));
                auto.setStock(rs.getInt("STOCK"));
                auto.setEstado(rs.getString("ESTADO"));
                auto.setFecha_registro(rs.getString("FECHA_REGISTRO"));
            }
            cstm.close();
        } catch (SQLException e1) {
            throw e1;
        } finally {
            try {
                cn.close();
            } catch (SQLException e2) {
            }
        }
        return auto;
    }
        
    public boolean Actualizar(AutoBean auto) throws SQLException {
        Connection cn = null;        
        boolean rpta = false;
        try {            
            cn = ConexionBD.getConnection();
            String sql = "{call USP_UPDATE_AUTOMOVIL(?,?,?,?,?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1,auto.getCodigo());
            cstm.setString(2,auto.getMarca());
            cstm.setString(3,auto.getModelo());
            cstm.setString(4,auto.getColor());
            cstm.setDouble(5,auto.getPrecio());
            cstm.setInt(6,auto.getStock());
            rpta = cstm.executeUpdate() == 1 ? true : false;
            cstm.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
    
    public boolean Eliminar(AutoBean auto) throws SQLException {
        Connection cn = null;        
        boolean rpta = false;
        try {            
            cn = ConexionBD.getConnection();
            String sql = "{call USP_DELETE_AUTOMOVIL(?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1,auto.getCodigo());
            rpta = cstm.executeUpdate() == 1 ? true : false;
            cstm.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return rpta;
    }
    
}
