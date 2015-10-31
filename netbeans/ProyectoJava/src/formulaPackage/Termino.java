/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaPackage;

import modeladoPackge.Elemento;
import java.util.HashMap;
import modelado.Error;
import modeladoPackge.Modelo;

/**
 *
 * @author Chris
 */
public abstract class Termino {
    
    public abstract Elemento evaluar(Modelo m, HashMap<String, String> a, modelado.Error e);

    @Override
    public abstract String toString();
    
}
