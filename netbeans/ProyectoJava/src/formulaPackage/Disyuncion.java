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
public class Disyuncion implements Formula{

    private final Formula der, izq;

    public Disyuncion(Formula der, Formula izq) {
        this.der = der;
        this.izq = izq;
    }
    
    @Override
    public boolean verificar(Modelo m, HashMap<String, String> instancia, Error_m e) {
        boolean rIzq = izq.verificar(m, instancia, e);
        if (e.isHasError())
            return false;
        boolean rDer = der.verificar(m, instancia, e);
        if (e.isHasError())
            return false;
        return (rIzq || rDer);
    }

    @Override
    public String toString() {
        return "Disyuncion{" + "der=" + der + ", izq=" + izq + '}';
    }
    
}
