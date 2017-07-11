package uch.model;

import java.io.Serializable;

public class UbigeoBean implements Serializable{
    private String ID_UBIGEO;
    private String DEPARTAMENTO;
    private String PROVINCIA;
    private String DISTRITO;
    private String ESTADO;
    private String FECHA_REGISTRO;
    private String USUARIO_REGISTRO;
    
    public UbigeoBean(){
       
    }
    
    public String getID_UBIGEO() {
        return ID_UBIGEO;
    }

    public void setID_UBIGEO(String ID_UBIGEO) {
        this.ID_UBIGEO = ID_UBIGEO;
    }
    
    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }
    
    public String getPROVINCIA() {
        return PROVINCIA;
    }

    public void setPROVINCIA(String PROVINCIA) {
        this.PROVINCIA = PROVINCIA;
    }

    public String getDISTRITO() {
        return DISTRITO;
    }

    public void setDISTRITO(String DISTRITO) {
        this.DISTRITO = DISTRITO;
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
