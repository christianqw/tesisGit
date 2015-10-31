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
public class AtributoJSON implements JSONStreamAware{
    
    private final String _name;
    private final JSONArray _listOfOptions;

    
    public AtributoJSON( String name, ArrayList<String> opciones){
        this._name = name;
        this._listOfOptions = cargarLista(opciones);
    }

    public String toJSONString(){
        JSONObject obj = new JSONObject();
        obj.put("Atributo", this._name);
        obj.put("Opciones", this._listOfOptions);
        return obj.toString();
    }
    
    @Override
    public void writeJSONString(Writer writer) throws IOException {
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("Atributo", this._name);
        obj.put("Opciones", this._listOfOptions);
        JSONValue.writeJSONString(obj, writer);
    }
    
    
    /* la conversion la realizo de forma manual por el momento
    no encontre que el casteo de las listas se pueda realizar por medio
    de una funcion ya definida de la clase
    */
    private JSONArray cargarLista(ArrayList<String> opciones){
        JSONArray list = new JSONArray();  
        for (int i = 0; i < opciones.size(); i++) {
            list.add(opciones.get(i));
        }
        return list;
    }
}
    
    