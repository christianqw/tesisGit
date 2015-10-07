package hello;

public class Musico {

    private String nombre;
    private String instrumento;

    public Musico( String name, String inst) {
        this.nombre = name;
        this.instrumento = inst;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInstrumento() {
        return instrumento;
    }
}
