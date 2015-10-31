/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JSONSimple;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

/**
 *
 * @author Chris
 */
public class PredicadoJSON implements JSONStreamAware{
    
    private final String _name;
    private final Integer _cantParametros;
    private final JSONArray _listOfClaves;
    private final JSONArray _listOfParametro;
    private final JSONArray _listOfAtributo;

    public PredicadoJSON(String name, Integer cantParametros,  ArrayList<String> Claves,  ArrayList<Integer> Parametros,  ArrayList<String> Atributos) {
        this._name = name;
        this._cantParametros = cantParametros;
        this._listOfClaves = cargarLista(Claves);
        this._listOfParametro = cargarLista(Parametros);
        this._listOfAtributo = cargarLista(Atributos);
    }
    public String toJSONString(){
        JSONObject obj = new JSONObject();
        obj.put("NombrePred", this._name);
        obj.put("CantParam", this._cantParametros);
        obj.put("Claves", this._listOfClaves);
        obj.put("Parametro", this._listOfParametro);
        obj.put("Atributo", this._listOfAtributo);
        return obj.toString();
    }
    
    public void writeJSONString(Writer writer) throws IOException {
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("NombrePred", this._name);
        obj.put("CantParam", this._cantParametros);
        obj.put("Claves", this._listOfClaves);
        obj.put("Parametro", this._listOfParametro);
        obj.put("Atributo", this._listOfAtributo);
        JSONValue.writeJSONString(obj, writer);
    }
    
    /* la conversion la realizo de forma manual por el momento
    no encontre que el casteo de las listas se pueda realizar por medio
    de una funcion ya definida de la clase
    */
    private JSONArray cargarLista(ArrayList elementos){
        JSONArray list = new JSONArray();  
        for (int i = 0; i < elementos.size(); i++) {
            list.add(elementos.get(i));
        }
        return list;
    }
    
    
}
