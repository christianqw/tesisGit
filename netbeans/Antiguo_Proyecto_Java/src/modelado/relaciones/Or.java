/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelado.relaciones;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Chris
 */
public class Or extends Compuesto{

    public Or() {//inicializamos el vector
        super();
    }   

    @Override
    public String toString() {
        return "Or{" + "_elementos=" + _elementos + '}';
    }
    
    @Override
    public boolean verificar() {
        boolean parcial = false;
        Iterator<Verificador> it = _elementos.iterator();
        while (!parcial && it.hasNext()){
            parcial = parcial || it.next().verificar();
        }
        return parcial;
    }
    
    
    
}
