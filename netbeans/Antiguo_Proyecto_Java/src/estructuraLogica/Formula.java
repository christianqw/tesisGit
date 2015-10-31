/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraLogica;

import modelado.Modelo;
import java.util.HashMap;
/**
 *
 * @author Chris
 */
public interface Formula {
    
    public boolean verificar(Modelo m, HashMap<String, String> a, modelado.Error e);
    @Override
    public abstract String toString();
}
