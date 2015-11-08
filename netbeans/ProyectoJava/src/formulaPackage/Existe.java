/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaPackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import modeladoPackge.Modelo;
import modeladoPackge.Error_m;
/**
 *
 * @author Chris
 */
public class Existe implements Formula{
    
    private final Formula _contenido;
    private final String _varCuantificada;

    public Existe(Formula form, String var) {
        this._contenido = form;
        this._varCuantificada = var;
    }

    @Override
    public boolean verificar(Modelo m, HashMap<String, String> instancia, Error_m e) {
        
        //se verifica que la variable NO exista en el dominio
        if (m.dominioContiene(this._varCuantificada)){
            e.setError(modeladoPackge.Error_m.tipoError.CUANTIFICACION, _varCuantificada);
            return false;
        }    
        
        /*
        Se verifica si la variable ya fue instanciada. 
        Al estar definida dentro de la instancia, la almacenamos en la variable 
        temporal para reasignarla al finalizar la evaluacion. 
        */
        
        String temp = "";
         if (instancia.containsKey(_varCuantificada))
            temp = instancia.get(_varCuantificada);
        
        /*
        Recorre todos los valores del dominio para hacer las evaluaciones.        
        */
        Set<String> listElems = m.getListaNombresElementos();
        Iterator<String> it = listElems.iterator();
        boolean resultado = false;
        /*
        Evaluamos para tods los elementos hasta que:
        no queden elementos, o una evaluacion de verdadero, o encontremos un error
        */        
        while (it.hasNext() && !resultado && e.isWithoutError()){
            String valorIt = it.next();
            instancia.put(_varCuantificada, valorIt); // ---- VER(2) ----
            resultado = this._contenido.verificar(m, instancia, e);
        }
  /* VER(2) 
        El existencian busca hasta encontrar una instancia que vuelve
        verdadera la verificacion de la formula.
        Modifica el valor actual con la nueva intancia de la variable.
        en caso de no existir agrega la instancia. 
  */            
        //Si se encontro algun error cuando se verifico antes
        if (e.isHasError())
            return false;
        
        if (!temp.equals("")){
             instancia.put(_varCuantificada, temp);
        }else{
            instancia.remove(_varCuantificada);
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Existe{" + "elemento=" + _contenido + ", var=" + _varCuantificada + '}';
    }
    
    
}
