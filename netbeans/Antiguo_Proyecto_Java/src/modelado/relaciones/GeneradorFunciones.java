/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelado.relaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelado.Elemento;
import modelado.data.EstructuraPredicado;


/**
 *
 * @author Chris
 */
public class GeneradorFunciones {
    
    private HashMap<String, Evaluador> _funciones; 
    
    public void cargarFunciones(HashMap<String, String> func) throws ClassNotFoundException{
        /*Genera los objetos de las funciones que son definidas en el archivo
     de configuracion, de esta forma se permite redefinir los nombres de las funciones
        y ademas eliminar si alguna no forma parte de los componentes.*/
        
        this._funciones = new HashMap<>();
              
        for (Map.Entry<String, String> e: func.entrySet()) {
            if (!e.getValue().equals(null)){
                String nameClass = "modelado.relaciones."+e.getKey();
                Evaluador f;
                try {
                    //generamos la entrada en la tabla con el renombre de la funcion y el evaluador
                    f = (Evaluador) Class.forName(nameClass).newInstance();
                    this._funciones.put(e.getValue(), f);
                } catch (InstantiationException ex) {
                    Logger.getLogger(GeneradorFunciones.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GeneradorFunciones.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
    }
    
    public GeneradorFunciones( HashMap<String, String> func) throws ClassNotFoundException{
        //Cargamos las funciones que la configuracion determina.
        cargarFunciones(func);
    }
    
    public Evaluador getFuncion(String Id, ArrayList<Elemento> parametros, ArrayList<Elemento> dom){
       //las verificaciones de Existencia y de cantidad de paramentros se realizan previo a invocar esta funcion
        Evaluador fun = this._funciones.get(Id);
        fun.setParametros(parametros);
        fun.setInstanciaDominio(dom);
        return fun;
    }
    
    public boolean cantidadParametrosCorrectos(String id, int parametros) {
        return (this._funciones.get(id).getCantidadParametros() == parametros);
    }

    public boolean existeId(String id) {
        return this._funciones.containsKey(id);
    }

    @Override
    public String toString() {
        return "GeneradorFunciones{" + "_funciones=" + _funciones + '}';
    }
    
}
