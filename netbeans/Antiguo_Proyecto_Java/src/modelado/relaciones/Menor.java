/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelado.relaciones;

/**
 *
 * @author Chris
 */
public class Menor extends Simple{
    
   public Menor(int value1, int value2) {
        super(value1, value2);
    }

    @Override
    public boolean verificar() {
         return (_value1.compareTo(_value2)>0);
    }

    @Override
    public String toString() {
        return "Menor{" + "_value1=" + _value1 + ", _value2=" + _value2 + '}';
    }
    
}
