package uch.model;

import java.io.Serializable;

public class MarcaBean implements Serializable{
    
    private String ID_MARCA;
    private String NOMBRE;
    private String NACIONALIDAD;
    private String ESTADO;
    private String FECHA_REGISTRO;
    private String USUARIO_REGISTRO;
    
    public MarcaBean(){    
    }
    
    public String getID_MARCA() {
        return ID_MARCA;
    }

    public void setID_MARCA(String ID_MARCA) {
        this.ID_MARCA = ID_MARCA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getNACIONALIDAD() {
        return NACIONALIDAD;
    }

    public void setNACIONALIDAD(String NACIONALIDAD) {
        this.NACIONALIDAD = NACIONALIDAD;
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
