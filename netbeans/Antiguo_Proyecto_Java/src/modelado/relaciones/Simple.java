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
public abstract class Simple extends Verificador{
    
    protected final Integer _value1, _value2;
   
    public Simple(int value1, int value2) {
        this._value1 = value1;
        this._value2 = value2;
    }
    
}
