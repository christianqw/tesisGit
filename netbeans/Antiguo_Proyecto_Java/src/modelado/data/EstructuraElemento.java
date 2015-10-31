/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelado.data;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Chris
 */
public class EstructuraElemento {
    
    private HashMap<String, Opciones>_listAtributos;
    private String _dom;

    // ----  Definicion del elemento  ----
    public EstructuraElemento(){
        this._listAtributos = new HashMap<String, Opciones> ();
    }
    
    public void AddAtributo(String name, ArrayList<String> op){
        this._listAtributos.put(name, new Opciones(op));
    }

    public String getDominio() {
        return _dom;
    }

    public void setDominio(String dominio) {
        this._dom = dominio;
    }

    
    // ----  Uso del elemento  ----
    
    //Retorna la clave nuemrica de una opcion de un determinado atributo
    public int getValue(String atributo, String opcion) {
        return this._listAtributos.get(atributo).getValue(opcion);
    }
    //Retorna la opcion de una calve de un determinado atributo
    public String getNameValue(String atributo, int opcion){
        return this._listAtributos.get(atributo).getNameValue(opcion);
    }
    
    //Retorna si es valida una opcion
    @SuppressWarnings("empty-statement")
    public boolean esNombreValido(String atributo, String opcion){
        try {
            return this._listAtributos.get(atributo).contains(opcion);
        } catch (Exception e) {
            System.out.println("Error : "+ e.toString());
            return false;
        }
            

    }
    //Reorna si es valido una clave
    public boolean esValido(String atributo, int opcion){
        return this._listAtributos.get(atributo).contains(opcion);
    }
    
    public boolean esAtributoValido (String atributo){
        return this._listAtributos.containsKey(atributo);
    }
    
    //Retorna la Lista de Atributos
    public ArrayList<String> getAtributos(){
        return new ArrayList<String>(this._listAtributos.keySet());
    }

    @Override
    public String toString() {
        return "EstructuraElemento{" + "_listAtributos=" + _listAtributos + ", _dom=" + _dom + '}';
    }
    
    
}
