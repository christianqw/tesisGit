/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelado.data;

import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class EstructuraPredicado {

    private ArrayList<String> _listaClaves, _listaAtributos;
    private ArrayList<Integer> _listaParametros;
    private int _cantidadParametros;
    private String _id;

    public EstructuraPredicado(String id,Integer cantidadParametros, ArrayList<String> listaClaves, ArrayList<Integer> listaParametros, ArrayList<String> listaAtributos) {
        this._listaClaves = listaClaves;
        this._listaAtributos = listaAtributos;
        this._listaParametros = listaParametros;
        this._cantidadParametros = cantidadParametros;
        this._id = id;
    }
    
    public ArrayList<String> getListaClaves() {
        return this._listaClaves;
    }

    public ArrayList<Integer> getListaParam() {
        return this._listaParametros;
    }

    public ArrayList<String> getListaAtributos() {
       return this._listaAtributos;
    }
    
    public int getCantidadParametros(){
        return this._cantidadParametros;
    }

    public String getId() {
        return this._id;
    }

    @Override
    public String toString() {
        return "EstructuraPredicado{" + "_listaClaves=" + _listaClaves + ", _listaAtributos=" + _listaAtributos + ", _listaParametros=" + _listaParametros + ", _cantidadParametros=" + _cantidadParametros + ", _id=" + _id + '}';
    }

    
}
