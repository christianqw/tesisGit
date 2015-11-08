/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaPackage;

import modeladoPackge.Elemento_m;
import java.util.HashMap;
import modeladoPackge.Error_m;
import modeladoPackge.Modelo;

/**
 *
 * @author Chris
 */
public abstract class Termino {
    
    public abstract Elemento_m evaluar(Modelo m, HashMap<String, String> a, Error_m e);

    @Override
    public abstract String toString();
    
}
