package server;

public class Mensaje2 {
    String s;
    Integer c;

    public Mensaje2(){
      s = "CLASE CLASE CLASE" ;
      c = 0;
    }

    @Override
    public String toString() {
        this.c = this.c + 1;
        return ("mensaje{ s=" + s + "  c=" + c +" }");
    }
}
