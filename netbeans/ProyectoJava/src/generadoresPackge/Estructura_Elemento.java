/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadoresPackge;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Chris
 */
public class Estructura_Elemento {


    private final Map<String, Map <String, Integer>> _def_elemento;
    
    public Estructura_Elemento(JSONObject eElem) {
        JSONArray arrAtributos = (JSONArray) eElem.get("ListAtributos"); 
        
        this._def_elemento = new HashMap<>();
        
        arrAtributos.stream().forEach((att) -> {
            cargaAtributo((JSONObject) att);
        });
    }

    private void cargaAtributo(JSONObject atributo) {
        JSONArray arrOpciones = (JSONArray) atributo.get("Opciones");
        Map <String, Integer> mapInterno  = new HashMap<>(); 
        
        for (int i = 0; i < arrOpciones.size(); i++) {
            mapInterno.put((String) arrOpciones.get(i), i);            
        }
        
        this._def_elemento.put((String) atributo.get("Atributo"), mapInterno);
    }
    
    public Integer getCodigoValue (String att, String op){
        return this._def_elemento.get(att).get(op);
    }
    
    public boolean atributoValido (String att){
        return this._def_elemento.containsKey(att);
    }
    
    public boolean opcionValida(String att, String op){
        if (!atributoValido(att)){
            return false;
        } 
        else {
            return this._def_elemento.get(att).containsKey(op);
        }
             
    }

    @Override
    public String toString() {
        return "Estructura_Elemento{" + "_def_elemento=" + _def_elemento + '}';
    }
    
    
    
}
