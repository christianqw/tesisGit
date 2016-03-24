package demo;

public class Mensaje {

  String m;
  Integer c;

  public Mensaje(){
    m = "Este es un mensaje dentro de la clase";
    c = 0;
  }

  public String getMensaje(){
    c=c+1;
    return m;
  }

}
