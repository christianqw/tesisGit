/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeladoPackge;

import java.util.Map;

/**
 *
 * @author Chris
 */
public class Elemento_m {
    
    private final String _nombre;
    private final Map<String, Integer> _atributos ;
    

    public Elemento_m(Map<String, Integer> _atributos, String _nombre) {
        this._atributos = _atributos;
        this._nombre = _nombre;
    }
    
    
    public Integer getValue (String atributo){
        return this._atributos.get(atributo);
    }
    
    public String getNombre (){
        return this._nombre;
    }

    @Override
    public String toString() {
        return "Elemento{" + "nombre:" + _nombre + ", _atributos=" + _atributos + '}';
    }
    
    
    
}
