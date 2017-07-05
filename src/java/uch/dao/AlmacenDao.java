package uch.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uch.model.AlmacenBean;

public class AlmacenDao {

    public List<AlmacenBean> listar() throws SQLException {
        Connection cn = null;
        List<AlmacenBean> lista = new ArrayList<AlmacenBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_ALMACEN_CONSULTA()}";
            CallableStatement cstm = cn.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                AlmacenBean t = new AlmacenBean();
                t.setIdentificador(rs.getInt("idAlmacen"));
                t.setCodigo(rs.getString("codigo"));
                t.setDescripcion(rs.getString("nombre"));
                lista.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public List<AlmacenBean> listar(int numeroPagina, int filasPorPagina) throws SQLException {
        Connection cn = null;
        List<AlmacenBean> lista = new ArrayList<AlmacenBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_ALMACEN_PAGINACION(?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setInt(1, numeroPagina);
            cstm.setInt(2, filasPorPagina);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                AlmacenBean t = new AlmacenBean();
                t.setIdentificador(rs.getInt("idAlmacen"));
                t.setCodigo(rs.getString("codigo"));
                t.setDescripcion(rs.getString("nombre"));
                lista.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public int getCantPaginas(int filasPorPagina) throws Exception {
        int totalPaginas = 0;
        double valor;
        Connection cn = null;
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_ALMACEN_TOTAL_REGISTROS()}";
            CallableStatement cstm = cn.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();

            if (rs.next()) {
                valor = rs.getInt("cantReg");
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

    public boolean Insertar(AlmacenBean almacen) throws SQLException {
        Connection cn = null;        
        boolean rpta = false;
        try {            
            cn = ConexionBD.getConnection();
            String sql = "{call USP_ALMACEN_GRABAR(?,?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setInt(1,0);
            cstm.setString(2, almacen.getDescripcion());
            cstm.setString(3, almacen.getCodigo());
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
    
    public AlmacenBean buscar(int Id) throws Exception {
        Connection cn = null;
        AlmacenBean almacen = new AlmacenBean();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_ALMACEN_BUSCAR(?)}";
            CallableStatement cstm = cn.prepareCall(sql);
             cstm.setInt(1, Id);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {                
                almacen.setIdentificador(rs.getInt("idAlmacen"));
                almacen.setCodigo(rs.getString("codigo"));
                almacen.setDescripcion(rs.getString("nombre"));                
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
        return almacen;
    }
        
    public boolean Actualizar(AlmacenBean almacen) throws SQLException {
        Connection cn = null;        
        boolean rpta = false;
        try {            
            cn = ConexionBD.getConnection();
            String sql = "{call USP_ALMACEN_GRABAR(?,?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setInt(1,almacen.getIdentificador());
            cstm.setString(2, almacen.getDescripcion());
            cstm.setString(3, almacen.getCodigo());
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
