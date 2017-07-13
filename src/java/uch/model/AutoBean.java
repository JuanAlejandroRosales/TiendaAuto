package uch.model;
import java.io.Serializable;

public class AutoBean implements Serializable{

    private String ID_AUTOMOVIL;
    private String ID_MARCA;
    private String MODELO;
    private String COLOR;
    private double PRECIO;
    private int STOCK;
    private String ESTADO;
    private String FECHA_REGISTRO;
    private String USUARIO_REGISTRO;
    
    public AutoBean(){    
    }
    
    public String getID_AUTOMOVIL() {
        return ID_AUTOMOVIL;
    }

    public void setID_AUTOMOVIL(String ID_AUTOMOVIL) {
        this.ID_AUTOMOVIL = ID_AUTOMOVIL;
    }

    public String getID_MARCA() {
        return ID_MARCA;
    }

    public void setID_MARCA(String ID_MARCA) {
        this.ID_MARCA = ID_MARCA;
    }

    public String getMODELO() {
        return MODELO;
    }

    public void setMODELO(String MODELO) {
        this.MODELO = MODELO;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }

    public double getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(double PRECIO) {
        this.PRECIO = PRECIO;
    }

    public int getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(int STOCK) {
        this.STOCK = STOCK;
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
