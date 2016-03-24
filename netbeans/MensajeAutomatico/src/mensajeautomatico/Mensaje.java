/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensajeautomatico;

/**
 *
 * @author Chris
 */
public class Mensaje {
    String s;
    
    public Mensaje(){
      s = "este es un mensaje generado dentro de la clase" ;
    }

    @Override
    public String toString() {
        return "mensaje{" + "s=" + s + '}';
    }
}
