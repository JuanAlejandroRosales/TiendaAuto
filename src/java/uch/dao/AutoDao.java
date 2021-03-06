package uch.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uch.model.AutoBean;
import uch.model.ClienteBean;

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
                t.setID_AUTOMOVIL(rs.getString("ID_AUTOMOVIL"));
                t.setID_MARCA(rs.getString("ID_MARCA"));
                t.setMODELO(rs.getString("MODELO"));
                t.setCOLOR(rs.getString("COLOR"));
                t.setPRECIO(rs.getDouble("PRECIO"));
                t.setSTOCK(rs.getInt("STOCK"));
                t.setESTADO(rs.getString("ESTADO"));
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
                t.setID_AUTOMOVIL(rs.getString("ID_AUTOMOVIL"));
                t.setID_MARCA(rs.getString("ID_MARCA"));
                t.setMODELO(rs.getString("MODELO"));
                t.setCOLOR(rs.getString("COLOR"));
                t.setPRECIO(rs.getDouble("PRECIO"));
                t.setSTOCK(rs.getInt("STOCK"));
                t.setESTADO(rs.getString("ESTADO"));
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
                t.setID_AUTOMOVIL(rs.getString("ID_AUTOMOVIL"));
                t.setID_MARCA(rs.getString("ID_MARCA"));
                t.setMODELO(rs.getString("MODELO"));
                t.setCOLOR(rs.getString("COLOR"));
                t.setPRECIO(rs.getDouble("PRECIO"));
                t.setSTOCK(rs.getInt("STOCK"));
                t.setESTADO(rs.getString("ESTADO"));
                lista.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
   
    public List<AutoBean> listarModelos(String ID_MARCA, String MODELO) throws SQLException {
        Connection cn = null;
        List<AutoBean> listaM = new ArrayList<AutoBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{CALL USP_FILTRAR_AUTOMOVIL(?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1, ID_MARCA);
            cstm.setString(2, MODELO);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                AutoBean t = new AutoBean();
                t.setID_AUTOMOVIL(rs.getString("ID_AUTOMOVIL"));
                t.setID_MARCA(rs.getString("ID_MARCA"));
                t.setMODELO(rs.getString("MODELO"));
                t.setCOLOR(rs.getString("COLOR"));
                t.setPRECIO(rs.getDouble("PRECIO"));
                listaM.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return listaM;
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
            String sql = "{call USP_INSERTAR_AUTOMOVIL(?,?,?,?,?,?,?,?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1, auto.getID_AUTOMOVIL());
            cstm.setString(2, auto.getID_MARCA());
            cstm.setString(3, auto.getMODELO());
            cstm.setString(4, auto.getCOLOR());
            cstm.setDouble(5, auto.getPRECIO());
            cstm.setInt(6, auto.getSTOCK());
            cstm.setString(7, auto.getESTADO());
            cstm.setString(8, auto.getFECHA_REGISTRO());
            cstm.setString(9, auto.getUSUARIO_REGISTRO());
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
                auto.setID_AUTOMOVIL(rs.getString("ID_AUTOMOVIL"));
                auto.setID_MARCA(rs.getString("ID_MARCA"));
                auto.setMODELO(rs.getString("MODELO"));                
                auto.setCOLOR(rs.getString("COLOR"));
                auto.setPRECIO(rs.getInt("PRECIO"));
                auto.setSTOCK(rs.getInt("STOCK"));
                auto.setESTADO(rs.getString("ESTADO"));
                auto.setFECHA_REGISTRO(rs.getString("FECHA_REGISTRO"));
                auto.setUSUARIO_REGISTRO(rs.getString("USUARIO_REGISTRO"));
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
            cstm.setString(1,auto.getID_AUTOMOVIL());
            cstm.setString(2,auto.getID_MARCA());
            cstm.setString(3,auto.getMODELO());
            cstm.setString(4,auto.getCOLOR());
            cstm.setDouble(5,auto.getPRECIO());
            cstm.setInt(6,auto.getSTOCK());
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
            cstm.setString(1,auto.getID_AUTOMOVIL());
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
