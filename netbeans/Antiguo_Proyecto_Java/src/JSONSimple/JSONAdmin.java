/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JSONSimple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelado.data.EstructuraElemento;
import modelado.data.EstructuraPredicado;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Chris
 */
public class JSONAdmin {
    
    private JSONArray _FuntionObj;
    private JSONObject _ElementObj;
    private JSONArray _listOfPredicados;
    
    
    public JSONAdmin(String ruta){
        JSONParser parser = new JSONParser();  
        try {  
            //Cargamos el Archivo para ser parseado
            Object obj = parser.parse(new FileReader(ruta));  
            //Se realiza el casteo del mismo
            JSONObject jsonObject = (JSONObject) obj;  
            //obtenemos los 3 objetos Json correspondientes a ser analizados.
            this._FuntionObj = (JSONArray)jsonObject.get("Funcion");
            this._ElementObj = (JSONObject)jsonObject.get("Elemento");
            this._listOfPredicados = (JSONArray)jsonObject.get("Predicado");

        }
        catch (FileNotFoundException e) {
            System.out.println("   FileNotFoundException "); 
            e.printStackTrace(); 
        } catch (IOException ex) {
            Logger.getLogger(JSONAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JSONAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public EstructuraElemento ReadJSONElemento (){

        //obtenemos el Dominio de los elementos definidos (primer atributo)
         String nameOfElement = (String) this._ElementObj.get("Dominio");  

        // Generamos la estructuraElemento a partir  de la lectura del archivo JSON
         EstructuraElemento estructura = new EstructuraElemento();
         estructura.setDominio(nameOfElement);
        //Comnezamos a cargar los distintos atributos
         JSONArray listOfAtributos; //Lista de Atributos definidos
         JSONObject jsonAtributo;
         JSONArray listOfOpciones;  //Lista de opciones de cada atributo

         listOfAtributos = (JSONArray)this._ElementObj.get("ListAtributos"); 
         int indexOpciones, indexAtributo;
         indexAtributo = 0;
         while (indexAtributo < listOfAtributos.size()) {  //Recorremos todos los Atributos
             jsonAtributo = (JSONObject) listOfAtributos.get(indexAtributo);
             //obtenemos el nombre del atributo
             String nameOfAtributo = (String) jsonAtributo.get("Atributo");  
             listOfOpciones = (JSONArray)jsonAtributo.get("Opciones");
             //Generamos una lista con las opciones del atributo
             ArrayList<String> listOpciones = new ArrayList<>();
             indexOpciones = 0;
             while (indexOpciones < listOfOpciones.size()){
                 String Opcion = (String) listOfOpciones.get(indexOpciones); 
                 listOpciones.add(Opcion);
                 indexOpciones++;
             }
             indexAtributo++;
             //Agregamos el atributo y sus opciones a la estructura
             estructura.AddAtributo(nameOfAtributo, listOpciones);
         } 
         return estructura;

    } 
    
    public  HashMap<String, EstructuraPredicado> ReadJSONPredicado (){
         HashMap<String, EstructuraPredicado> predicados  = new HashMap<>();
         EstructuraPredicado pred;
         int index = 0;
         while (index < _listOfPredicados.size()){
             pred = getEstructuraPred((JSONObject)_listOfPredicados.get(index));
             predicados.put(pred.getId(), pred);
             index ++;
         }
        return predicados;
    }
    
    public HashMap<String, String> ReadJSONFunciones(){
        HashMap<String, String> funciones = new HashMap<String, String>();
        JSONObject fun;
        int index = 0;
        while (index < _FuntionObj.size()) {  //Recorremos todos las Funciones
             fun = (JSONObject) _FuntionObj.get(index);
             if (!fun.get("Rename").equals("NULL")){
                 funciones.put((String)fun.get("Class"), (String)fun.get("Rename"));
             }
             index ++;
         } 
        return funciones;
    }
    


    private EstructuraPredicado getEstructuraPred(JSONObject elem) { 
        EstructuraPredicado pred;
        String id = (String)elem.get("NombrePred");
        ArrayList<String> claves =  toArrayList((JSONArray)elem.get("Claves"));
        ArrayList<Integer> parametro = toIntegerList((JSONArray)elem.get("Parametro")); 
        ArrayList<String> atributo = toArrayList((JSONArray)elem.get("Atributo"));
        Long cant = (Long)(elem.get("CantParam"));        
        pred =  new EstructuraPredicado(id, cant.intValue(), claves, parametro, atributo);
        return pred;
    }
    
    private ArrayList toArrayList(JSONArray listJson){
        ArrayList listOut = new ArrayList();
        int index = 0;
        while (index < listJson.size()) { 
            listOut.add(listJson.get(index));
            index ++;
        }
        return listOut;
    }
    
    private ArrayList toIntegerList(JSONArray listJson){
        ArrayList listOut = new ArrayList();
        int index = 0;
        while (index < listJson.size()) { 
            listOut.add(((Long)listJson.get(index)).intValue());
            index ++;
        }
        return listOut;
    }
    
     public void WriteJSONElemento(){
     
     }



}
    