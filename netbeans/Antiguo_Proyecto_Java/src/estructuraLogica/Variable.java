/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraLogica;

import java.util.HashMap;
import modelado.*;

/**
 *
 * @author Chris
 */
public class Variable extends Termino{

    private final String _id;
    
    @Override
    public Elemento evaluar(Modelo m, HashMap<String, String> instancia, modelado.Error e) {
        
        String name_elem = this._id;
        
        /*verifica si la variable existe en la instacia, 
        si la variable ya fue instanciada por algun cuantificador
        */
        if (instancia.containsKey(this._id))
            name_elem = instancia.get(this._id);
        /*verifica en el dominio
        si existe dentro del dominio un elemento con ese nombre,
        puede ocurrir que la variable sea una instancia de la 
        tabla o una constante definida dentro de la formila. 
        */
        if (m.dominioContiene(name_elem))
            return m.getElemento(name_elem);
        else {
            //no existe un elemento con el nombre dentro del dominio. 
            e.setError(modelado.Error.tipoError.VARLIBRE, name_elem);
            return null;
        }
    }

    public Variable(String id) {
        this._id = id;
    }

    @Override
    public String toString() {
        return "Variable{" + "id=" + this._id + '}';
    }    
    
}
