package uch.model;
import java.io.Serializable;
public class AlmacenBean implements Serializable {
    private int identificador;
    private String codigo;
    private String descripcion;    
    
    public AlmacenBean(){    
    }
    
    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}


