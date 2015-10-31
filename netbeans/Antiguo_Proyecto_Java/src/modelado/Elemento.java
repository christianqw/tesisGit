/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import modelado.data.EstructuraElemento;

/**
 *
 * @author Chris
 */
public class Elemento {
    
    private HashMap<String, Integer> _atributos;
    EstructuraElemento _estructura;
    private int _posx, _posy;
    private String _name;

    public Elemento(EstructuraElemento estructura, int posx, int posy, String name) {
        this._estructura = estructura;
        this._atributos = new HashMap<>();
        this._posx = posx;
        this._posy = posy;
        this._name = name;
        inicElem();
    }
    
    public boolean setAtributoStringValue(String atributo, String valor) {
        if (this._estructura.esNombreValido(atributo, valor)){
            this._atributos.put(atributo, _estructura.getValue(atributo, valor));
            return true;
        }
        else{
            System.out.println("XXXXXXX Error: valor del atributo invalido ");
            return false;
        } 
    }
    
    public boolean setAtributoNumValue(String atributo, int valor){
        if (this._estructura.esValido(atributo, valor)){
            this._atributos.put(atributo, valor);
            return true;
        }
        else return false;
    }
    
    public void inicElem(){
        ArrayList<String> namesAtributos = this._estructura.getAtributos();
        for (Iterator<String> it = namesAtributos.iterator(); it.hasNext();) {
            String string = it.next();
            this._atributos.put(string, 0);
        }
    }
    
    public void setPosicion(int x, int y) {
        this._posx = x;
        this._posy = y;
    }
    
    public void setNombre(String name){
        this._name= name;
    }

    public String getNombre (){
        return this._name;
    }

    public int getPosx() {
        return this._posx;
    }

    public int getPosy() {
        return this._posy;
    }
    
    public int getvalue(String nameAtributo) {
        return _atributos.get(nameAtributo);
    }
    
    public String getStringvalue(String nameAtributo) {
        return this._estructura.getNameValue(nameAtributo, this._atributos.get(nameAtributo));
    } 

    @Override
    public String toString() {
        return "Elemento{" + "_atributos=" + _atributos + ", _posx=" + _posx + ", _posy=" + _posy + ", _name=" + _name + '}';
    }   
    
}
