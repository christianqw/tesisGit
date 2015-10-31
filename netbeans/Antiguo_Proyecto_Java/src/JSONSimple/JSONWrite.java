package JSONSimple;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;  
import org.json.simple.JSONObject;  
/**
 *
 * @author Chris
 */
 

public class JSONWrite {  
    
    /*
    Mediante la presente clase se desarrolla un generador de archivos de configuracion, que por el momento
    intenta definir los ditintos atributos y sus opciones de los elementos del modelo.
    Para mejor legibilidad se Inplementas los archivos de configuracion de forma que 
    se mantenga el orden en el que se definen los componentes.
    */
  
    private static Map GenerarlElemento(){
        Map ElementObj = new  LinkedHashMap();  
        //permite que conserve el orden de los elementos agregados. 

        ElementObj.put("Dominio", "Figura");  

        JSONArray listOfAtributos = new JSONArray(); 

        ArrayList<String> opciones = new ArrayList<String> ();
        opciones.add("circulo");  
        opciones.add("piramide");  
        opciones.add("hexaedro");  
        listOfAtributos.add(new AtributoJSON("Tipo", opciones));  

        opciones = new ArrayList<String> ();
        opciones.add("chico");  
        opciones.add("mediano");  
        opciones.add("grande"); 
        listOfAtributos.add(new AtributoJSON("Tamaño", opciones));  

        opciones = new ArrayList<String> ();
        opciones.add("1");  
        opciones.add("2");  
        opciones.add("3");

        listOfAtributos.add(new AtributoJSON("Fil", opciones)); 
        
        opciones.add("4");       
        listOfAtributos.add(new AtributoJSON("Col", opciones)); 

        ElementObj.put("ListAtributos", listOfAtributos); 

        JSONArray users = new JSONArray();
        users.add(new AtributoJSON("Tipo", opciones));
        users.add(new AtributoJSON("Fil", opciones));
        users.add(new AtributoJSON("Col", opciones));

        return ElementObj;
    }
    
     private static JSONArray GenerarFunciones(){
        JSONArray listOfFunciones = new JSONArray(); 
        
        JSONObject fun = new JSONObject();
        fun.put("Class", "ElMasLejano");
        fun.put("Rename", "ELMASLEJANO");
        listOfFunciones.add(fun);//mismo nombre
    
        fun = new JSONObject();
        fun.put("Class", "ElMasCercano");
        fun.put("Rename", "CERCA");
        listOfFunciones.add(fun);//renombrada
        
        fun = new JSONObject();
        fun.put("Class", "ElMasArriva");
        fun.put("Rename", "NULL");
        listOfFunciones.add(fun);//ignorada.
        
        return listOfFunciones;
    }
     
   private static JSONArray GenerarPredicados(){
        
        JSONArray listOfPredicados = new JSONArray();
        
        //Las claves son los nombres de las clases que lo componen
        ArrayList<String> claves = new ArrayList<String> ();
        claves.add("IGUAL");  claves.add("IGUAL");  claves.add("OR");  
                
        ArrayList<Integer> parametros  = new ArrayList<Integer> ();
        parametros.add(1); parametros.add(-1); parametros.add(0); parametros.add(1);

        ArrayList<String> atributos = new ArrayList<String> ();
        atributos.add("Col"); atributos.add("3"); atributos.add("Fil"); atributos.add("Fil");
        
        listOfPredicados.add(new PredicadoJSON("Patito", 2, claves, parametros, atributos));
         
        claves = new ArrayList<String> ();
        claves.add("IGUAL");  claves.add("IGUAL"); claves.add("MENOR"); claves.add("MENOR");  claves.add("AND");  
                
        parametros  = new ArrayList<Integer> (); //Los parametros comienzan en 0 (cero)
        parametros.add(0); parametros.add(1); parametros.add(1); parametros.add(2);
        parametros.add(0); parametros.add(1); parametros.add(1); parametros.add(2);

        atributos = new ArrayList<String> ();
        atributos.add("Fil"); atributos.add("Fil"); atributos.add("Fil"); atributos.add("Fil");
        atributos.add("Col"); atributos.add("Col"); atributos.add("Col"); atributos.add("Col"); 
        
        listOfPredicados.add(new PredicadoJSON("EstaEntre", 3, claves, parametros, atributos));  
        
        claves = new ArrayList<String> ();
        claves.add("IGUAL");   
                
        parametros  = new ArrayList<Integer> ();
        parametros.add(0); parametros.add(-1);

        atributos = new ArrayList<String> ();
        atributos.add("Tipo"); atributos.add("circulo"); 
        
        listOfPredicados.add(new PredicadoJSON("Escirculo", 1, claves, parametros, atributos)); 
        
        return  listOfPredicados;
    }
    
    public static void main(String[] args) {  
        
        JSONObject ConfigJSON = new  JSONObject();  
        
        ConfigJSON.put("Elemento", GenerarlElemento());
        ConfigJSON.put("Funcion", GenerarFunciones());
        ConfigJSON.put("Predicado", GenerarPredicados());
        
        try {  
              
            // Writing to a file  
            File file=new File("ExampleConfigJSONFile.json");  
            file.createNewFile();  
            try (FileWriter fileWriter = new FileWriter(file)) {
                StringWriter out = new StringWriter();
                JSONValue.writeJSONString(ConfigJSON, out);
                String jsonText = out.toString();
                
                System.out.println("Escribiendo el JSON object en el Archivo");
                System.out.println("-----------------------");
                System.out.println(jsonText);
                
                fileWriter.write( jsonText);
                fileWriter.flush();
            }  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
    }  
} 
