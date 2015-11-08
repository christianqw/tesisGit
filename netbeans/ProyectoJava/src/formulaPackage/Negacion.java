/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaPackage;

import java.util.HashMap;
import modeladoPackge.Modelo;
import modeladoPackge.Error_m;

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
    public boolean verificar(Modelo m, HashMap<String, String> instancia, Error_m  e) {
        return (! this._elem.verificar(m, instancia, e));
    }

    @Override
    public String toString() {
        return "Negacion{" + "elem=" + this._elem + '}';
    }
    
}
