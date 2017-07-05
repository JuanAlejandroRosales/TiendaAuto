package uch.model;
import java.io.Serializable;
public class VendedorBean  implements  Serializable{
    private int id;
    private String codigo;
    private String nombre;    
    public VendedorBean(){    
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   
    
    
}
