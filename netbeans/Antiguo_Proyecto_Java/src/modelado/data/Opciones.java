/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelado.data;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Chris
 */
public class Opciones {
    
    private final ArrayList<String> _opciones;
//    private String _clave;

    public Opciones(ArrayList<String> opciones) {
        this._opciones = opciones;
//        this._clave = clave;
    }
    
    public boolean contains(String name){
         return this._opciones.contains(name);
    }
    
    public boolean contains(int index){
         return (index < this._opciones.size());
    }
    
    public boolean add(String name){
        return this.add(name);
    }
    public boolean isEmpty(){
        return this._opciones.isEmpty();
    }
    public boolean remove (String name){
        return this._opciones.remove(name);
    }
    public int size(){
        return this._opciones.size();
    }
//    
//    public void setClave(String name){
//        this._clave = name; 
//    }

    String getNameValue(int pos) {
        return this._opciones.get(pos);
    }

    int getValue(String name) {
        return this._opciones.indexOf(name);
    }

    @Override
    public String toString() {
        return "Opciones{" + "_opciones=" + _opciones + "}";
    }

}
