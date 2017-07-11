package uch.model;

import java.io.Serializable;

public class ClienteBean implements Serializable{
    private String ID_CLIENTE;
    private String PRI_NOMBRE;
    private String SEG_NOMBRE;
    private String PRI_APELLIDO;
    private String SEG_APELLIDO;
    private String RAZON_SOCIAL;
    private String NOMBRE_COMERCIAL;
    private String TIPO_DOCUMENTO;
    private String NUMERO_DOCUMENTO;
    private String NUMERO_RUC;
    private String FECHA_NACIMIENTO;
    private String TIPO_CLIENTE;
    private String CLASE_CLIENTE;
    private String ID_UBIGEO;
    private String DIRECCION;
    private String ID_PAIS;
    private String TELEFONO_FIJO;
    private String CELULAR;
    private String EMAIL;
    private String SEXO;
    private String ESTADO;
    private String FECHA_REGISTRO;
    private String USUARIO_REGISTRO;
    
    public ClienteBean(){    
    }

    public String getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(String ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }    
    
    public String getPRI_NOMBRE() {
        return PRI_NOMBRE;
    }

    public void setPRI_NOMBRE(String PRI_NOMBRE) {
        this.PRI_NOMBRE = PRI_NOMBRE;
    }  

    public String getSEG_NOMBRE() {
        return SEG_NOMBRE;
    }

    public void setSEG_NOMBRE(String SEG_NOMBRE) {
        this.SEG_NOMBRE = SEG_NOMBRE;
    }
    
    public String getPRI_APELLIDO() {
        return PRI_APELLIDO;
    }

    public void setPRI_APELLIDO(String PRI_APELLIDO) {
        this.PRI_APELLIDO = PRI_APELLIDO;
    }
    
    public String getSEG_APELLIDO() {
        return SEG_APELLIDO;
    }

    public void setSEG_APELLIDO(String SEG_APELLIDO) {
        this.SEG_APELLIDO = SEG_APELLIDO;
    }

    public String getRAZON_SOCIAL() {
        return RAZON_SOCIAL;
    }

    public void setRAZON_SOCIAL(String RAZON_SOCIAL) {
        this.RAZON_SOCIAL = RAZON_SOCIAL;
    }

    public String getNOMBRE_COMERCIAL() {
        return NOMBRE_COMERCIAL;
    }

    public void setNOMBRE_COMERCIAL(String NOMBRE_COMERCIAL) {
        this.NOMBRE_COMERCIAL = NOMBRE_COMERCIAL;
    }
    
    public String getTIPO_DOCUMENTO() {
        return TIPO_DOCUMENTO;
    }

    public void setTIPO_DOCUMENTO(String TIPO_DOCUMENTO) {
        this.TIPO_DOCUMENTO = TIPO_DOCUMENTO;
    }
    
    public String getNUMERO_DOCUMENTO() {
        return NUMERO_DOCUMENTO;
    }

    public void setNUMERO_DOCUMENTO(String NUMERO_DOCUMENTO) {
        this.NUMERO_DOCUMENTO = NUMERO_DOCUMENTO;
    }
    
    public String getNUMERO_RUC() {
        return NUMERO_RUC;
    }

    public void setNUMERO_RUC(String NUMERO_RUC) {
        this.NUMERO_RUC = NUMERO_RUC;
    }
    
    public String getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public void setFECHA_NACIMIENTO(String FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }
    
    public String getTIPO_CLIENTE() {
        return TIPO_CLIENTE;
    }

    public void setTIPO_CLIENTE(String TIPO_CLIENTE) {
        this.TIPO_CLIENTE = TIPO_CLIENTE;
    }
    
    public String getCLASE_CLIENTE() {
        return CLASE_CLIENTE;
    }

    public void setCLASE_CLIENTE(String CLASE_CLIENTE) {
        this.CLASE_CLIENTE = CLASE_CLIENTE;
    }

    public String getID_UBIGEO() {
        return ID_UBIGEO;
    }

    public void setID_UBIGEO(String ID_UBIGEO) {
        this.ID_UBIGEO = ID_UBIGEO;
    }
    
    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }
    
    public String getID_PAIS() {
        return ID_PAIS;
    }

    public void setID_PAIS(String ID_PAIS) {
        this.ID_PAIS = ID_PAIS;
    }
    
    public String getTELEFONO_FIJO() {
        return TELEFONO_FIJO;
    }

    public void setTELEFONO_FIJO(String TELEFONO_FIJO) {
        this.TELEFONO_FIJO = TELEFONO_FIJO;
    }
    
    public String getCELULAR() {
        return CELULAR;
    }

    public void setCELULAR(String CELULAR) {
        this.CELULAR = CELULAR;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSEXO() {
        return SEXO;
    }

    public void setSEXO(String SEXO) {
        this.SEXO = SEXO;
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
