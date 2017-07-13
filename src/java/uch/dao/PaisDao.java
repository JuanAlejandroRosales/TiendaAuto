package uch.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uch.model.AutoBean;
import uch.model.ClienteBean;
import uch.model.UbigeoBean;
import uch.model.PaisBean;

public class PaisDao {

    public List<PaisBean> listarPaisDll() throws SQLException {
        Connection cn = null;
        List<PaisBean> lista = new ArrayList<PaisBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{CALL USP_PAIS_CONSULTA_LISTA()}";
            CallableStatement cstm = cn.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                PaisBean t = new PaisBean();
                t.setID_PAIS(rs.getString("ID_PAIS"));
                t.setNOMBRE(rs.getString("NOMBRE"));
                lista.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
    
    public List<UbigeoBean> listarProv(String ID_DEPARTAMENTO) throws SQLException {
        Connection cn = null;
        List<UbigeoBean> lista = new ArrayList<UbigeoBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_PROVINCIA_CONSULTA_LISTA(?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1, ID_DEPARTAMENTO);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                UbigeoBean t = new UbigeoBean();
                t.setID_UBIGEO(rs.getString("ID_UBIGEO"));
                t.setPROVINCIA(rs.getString("PROVINCIA"));
                lista.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public List<UbigeoBean> listarDist(String ID_DEPARTAMENTO, String ID_PROVINCIA) throws SQLException {
        Connection cn = null;
        List<UbigeoBean> lista = new ArrayList<UbigeoBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_DISTRITO_CONSULTA_LISTA(?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1, ID_DEPARTAMENTO);
            cstm.setString(2, ID_PROVINCIA);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                UbigeoBean t = new UbigeoBean();
                t.setID_UBIGEO(rs.getString("ID_UBIGEO"));
                t.setDISTRITO(rs.getString("DISTRITO"));
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
   
    
   
    public String generarcodigo() throws SQLException {
        Connection cn = null;
        String codigo = null;
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_GENERARCODIGOCLIENTE()}";
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

    public boolean Insertar(ClienteBean CLIENTE) throws SQLException {
        Connection cn = null;        
        boolean rpta = false;
        try {            
            cn = ConexionBD.getConnection();
            String sql = "{call USP_INSERTAR_CLIENTE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1, CLIENTE.getID_CLIENTE());
            cstm.setString(2, CLIENTE.getPRI_NOMBRE());
            cstm.setString(3, CLIENTE.getSEG_NOMBRE());
            cstm.setString(4, CLIENTE.getPRI_APELLIDO());
            cstm.setString(5, CLIENTE.getSEG_APELLIDO());
            cstm.setString(6, CLIENTE.getRAZON_SOCIAL());
            cstm.setString(7, CLIENTE.getNOMBRE_COMERCIAL());
            cstm.setString(8, CLIENTE.getTIPO_DOCUMENTO());
            cstm.setString(9, CLIENTE.getNUMERO_DOCUMENTO());
            cstm.setString(10, CLIENTE.getNUMERO_RUC());
            cstm.setString(11, CLIENTE.getFECHA_NACIMIENTO());
            cstm.setString(12, CLIENTE.getTIPO_CLIENTE());
            cstm.setString(13, CLIENTE.getCLASE_CLIENTE());
            cstm.setString(14, CLIENTE.getID_UBIGEO());
            cstm.setString(15, CLIENTE.getDIRECCION());
            cstm.setString(16, CLIENTE.getID_PAIS());
            cstm.setString(17, CLIENTE.getTELEFONO_FIJO());
            cstm.setString(18, CLIENTE.getCELULAR());
            cstm.setString(19, CLIENTE.getEMAIL());
            cstm.setString(20, CLIENTE.getSEXO());
            cstm.setString(21, CLIENTE.getESTADO());
            cstm.setString(22, CLIENTE.getFECHA_REGISTRO());
            cstm.setString(23, CLIENTE.getUSUARIO_REGISTRO());
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
