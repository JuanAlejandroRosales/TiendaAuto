package uch.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    public ConexionBD() {

    }

    public static Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            String url = "jdbc:sqlserver://DESKTOP-KVSVG71;"+
                        "database=BD_VENTAS;"+
                        "user=sa;"+
                        "password=123456;";
            //creating connection to SQL SERVER database using JDBC
            cn = DriverManager.getConnection(url);
            System.out.println("Connection...OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
    public static void main(String[] args) {
        
        System.out.println(ConexionBD.getConnection());
        
    }
}
