package serverPackages;

public class Sentencia {

    private String id;
    private String nombre;
    private String valor;
    private String estado;
    private String mensaje;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "\n Sentencia{" + "id=" + id + ", nombre=" + nombre + ", valor=" + valor + ", estado=" + estado + ", mensaje=" + mensaje + "} \n";
    }

    
}
