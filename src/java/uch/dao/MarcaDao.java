
package uch.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uch.model.MarcaBean;

public class MarcaDao {
    public List<MarcaBean> listar() throws SQLException {
        Connection cn = null;
        List<MarcaBean> lista = new ArrayList<MarcaBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_AUTO_CONSULTA()}";
            CallableStatement cstm = cn.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                MarcaBean t = new MarcaBean();
                t.setID_MARCA(rs.getString("ID_MARCA"));
                t.setNOMBRE(rs.getString("NOMBRE"));
                t.setNACIONALIDAD(rs.getString("NACIONALIDAD"));
                t.setESTADO(rs.getString("ESTADO"));
                lista.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
    
    public List<MarcaBean> listarddl() throws SQLException {
        Connection cn = null;
        List<MarcaBean> lista = new ArrayList<MarcaBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_MARCA_CONSULTA_LISTA()}";
            CallableStatement cstm = cn.prepareCall(sql);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                MarcaBean t = new MarcaBean();
                t.setID_MARCA(rs.getString("ID_MARCA"));
                t.setNOMBRE(rs.getString("NOMBRE"));
                lista.add(t);
            }
            cstm.close();
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
    
    public List<MarcaBean> listar(int numeroPagina, int filasPorPagina) throws SQLException {
        Connection cn = null;
        List<MarcaBean> lista = new ArrayList<MarcaBean>();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_ALMACEN_PAGINACION(?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setInt(1, numeroPagina);
            cstm.setInt(2, filasPorPagina);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                MarcaBean t = new MarcaBean();
                t.setID_MARCA(rs.getString("ID_MARCA"));
                t.setNOMBRE(rs.getString("NOMBRE"));
                t.setNACIONALIDAD(rs.getString("NACIONALIDAD"));
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
            String sql = "{call USP_GENERARCODIGOAUTO()}";
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

    public boolean Insertar(MarcaBean marca) throws SQLException {
        Connection cn = null;        
        boolean rpta = false;
        try {            
            cn = ConexionBD.getConnection();
            String sql = "{call USP_INSERTAR_AUTO(?,?,?,?,?,?,?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1, marca.getID_MARCA());
            cstm.setString(2, marca.getNOMBRE());
            cstm.setString(3, marca.getNACIONALIDAD());
            cstm.setString(4, marca.getESTADO());
            cstm.setString(5, marca.getFECHA_REGISTRO());
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
    
    public MarcaBean buscar(int Id) throws Exception {
        Connection cn = null;
        MarcaBean auto = new MarcaBean();
        try {
            cn = ConexionBD.getConnection();
            String sql = "{call USP_AUTO_BUSCAR(?)}";
            CallableStatement cstm = cn.prepareCall(sql);
             cstm.setInt(1, Id);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {                
                auto.setID_MARCA(rs.getString("ID_MARCA"));
                auto.setNOMBRE(rs.getString("NOMBRE"));
                auto.setNACIONALIDAD(rs.getString("NACIONALIDAD"));
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
        
    public boolean Actualizar(MarcaBean auto) throws SQLException {
        Connection cn = null;        
        boolean rpta = false;
        try {            
            cn = ConexionBD.getConnection();
            String sql = "{call Auto(?,?,?,?,?,?)}";
            CallableStatement cstm = cn.prepareCall(sql);
            cstm.setString(1,auto.getID_MARCA());
            cstm.setString(2, auto.getNOMBRE());
            cstm.setString(3, auto.getNACIONALIDAD());
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
