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
public class Elemento {
    
    private String _nombre;
    private Map<String, Integer> _atributos ;
    

    public Elemento(Map<String, Integer> _atributos, String _nombre) {
        this._atributos = _atributos;
        this._nombre = _nombre;
    }
    
    
    public Integer getValue (String atributo){
        return this._atributos.get(atributo);
    }

    @Override
    public String toString() {
        return "Elemento{" + "nombre:" + _nombre + ", _atributos=" + _atributos + '}';
    }
    
    
    
}
