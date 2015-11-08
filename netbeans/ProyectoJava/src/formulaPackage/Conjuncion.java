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
public class Conjuncion implements Formula{

    private final Formula _der, _izq;

    public Conjuncion(Formula der, Formula izq) {
        this._der = der;
        this._izq = izq;
    }
    
    /*Realizar la verificacion de una conjuncion
    La variale instancia es modificada unicamente cuando se realiza la
    verificacion de un cunatificador */
    @Override
    public boolean verificar(Modelo m, HashMap<String, String> instancia, Error_m e) {
        boolean rIzq = this._izq.verificar(m, instancia, e);
        if (e.getTipoError()!= modeladoPackge.Error_m.tipoError.SINERROR)
            return false;
        boolean rDer = this._der.verificar(m, instancia, e);
        if (modeladoPackge.Error_m.tipoError.SINERROR!= e.getTipoError())
            return false;
        return (rIzq && rDer); /*Return P ^ Q*/
    }

    @Override
    public String toString() {
        return "Conjuncion{" + "der=" + this._der + ", izq=" + this._izq + '}';
    }
    
}