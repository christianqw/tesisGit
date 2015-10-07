package hello;

public class Banda {

    private String nombre_banda;
    private int integrantes;

    public Banda( String name, int in) {
        this.nombre_banda = name;
        this.integrantes = in;
    }

    public String getNombre() {
        return nombre_banda;
    }

    public int getInte() {
        return integrantes;
    }
}
