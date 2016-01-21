package server;

public class Sentencia {

    private String _id;
    private String _nombre;
    private String _valor;
    private String _estado;
    private String _mensaje;

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String nombre) {
        this._nombre = nombre;
    }

    public String getValor() {
        return _valor;
    }

    public void setValor(String valor) {
        this._valor = valor;
    }

    public String getEstado() {
        return _estado;
    }

    public void setEstado(String estado) {
        this._estado = estado;
    }

    public String getMensaje() {
        return _mensaje;
    }

    public void setMensaje(String mensaje) {
        this._mensaje = mensaje;
    }

    public String toString(){
      return ("nombre -> " + this.getNombre());
    }

}
