
package uch.model;

import java.io.Serializable;


public class PaisBean implements Serializable{
    
    public String ID_PAIS;
    public String ISO;
    public String NOMBRE;
    public String ESTADO;
    public String FECHA_REGISTRO;
    public String USUARIO_REGISTRO;
    
    public PaisBean(){
       
    }

    public String getID_PAIS() {
        return ID_PAIS;
    }

    public void setID_PAIS(String ID_PAIS) {
        this.ID_PAIS = ID_PAIS;
    }

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(String FECHA_REGISTRO) {
        this.FECHA_REGISTRO = FECHA_REGISTRO;
    }

    public String getUSUARIO_REGISTRO() {
        return USUARIO_REGISTRO;
    }

    public void setUSUARIO_REGISTRO(String USUARIO_REGISTRO) {
        this.USUARIO_REGISTRO = USUARIO_REGISTRO;
    }
    
    
}
