/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraLogica;

import java.util.HashMap;
import modelado.Modelo;

/**
 *
 * @author Chris
 */
public class Negacion implements Formula{

    private final Formula _elem;

    public Negacion(Formula elem) {
        this._elem = elem;
    }
    
    @Override
    public boolean verificar(Modelo m, HashMap<String, String> instancia, modelado.Error e) {
        return (! this._elem.verificar(m, instancia, e));
    }

    @Override
    public String toString() {
        return "Negacion{" + "elem=" + this._elem + '}';
    }
    
}
