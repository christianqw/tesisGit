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
public class Igual extends Simple{

    public Igual(int value1, int value2) {
        super(value1, value2);
    }

    @Override
    public boolean verificar() {
         return _value1.equals(_value2);
    }

    @Override
    public String toString() {
        return "Igual{" + "_value1=" + _value1 + ", _value2=" + _value2 + '}';
    }

}
