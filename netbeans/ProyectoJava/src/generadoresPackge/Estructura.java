/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadoresPackge;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import relacionesPackage.Evaluador;
import relacionesPackage.Verificador;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Chris
 */
public class Estructura {
    Map<String, Estructura_Elemento> _def_elementos;
    Map<String, Verificador> _predicados;
    Map<String, Evaluador> _funciones;
    
    //Id utilizado dentro del Archivo | Nombre de la clase
    private Map<String, String> _clases; 

    public Estructura(String dataJson) throws ParseException {
        cargarClases();
        
        JSONParser p = new JSONParser(); 
        JSONObject objJson = (JSONObject) p.parse(dataJson);
        
        cargaMapPredicados((JSONArray) objJson.get("Predicado"));
        cargaMapFunciones((JSONArray) objJson.get("Funcion"));
        cargaMapDefElementos((JSONArray) objJson.get("Elemento"));

    }
    
    public Verificador getPredicado (String s){
        return this._predicados.get(s);
    }

    public Evaluador getFuncion (String s){
        return this._funciones.get(s);
    }
    
    public Estructura_Elemento getEstructuraElemento(String s){
       return this._def_elementos.get(s);
    }
    
    private void cargaMapPredicados(JSONArray arrPred) {
        this._predicados = new HashMap<>();
        arrPred.stream().forEach((Object p) -> {
            try {
                cargaPredicado((JSONObject) p);
            } catch (ClassNotFoundException ex) {
                System.out.println("Error dentro de Cargar Predicados");
                Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    private void cargaMapFunciones(JSONArray arrFun) {
        this._funciones = new HashMap<>();
        arrFun.stream().forEach((Object f) -> {
            cargaFuncion((JSONObject) f);
        });
    }

    private void cargaMapDefElementos(JSONArray arrElem) {
        this._def_elementos = new HashMap<> ();
        arrElem.stream().forEach((arrElem1) -> {
            CargaEstructuraElem((JSONObject) arrElem1);
        });
    }

    private void cargaPredicado(JSONObject p) throws ClassNotFoundException {
        this._predicados.put((String) p.get("NombrePred"),generaVerificador(p));
    }

    private void cargaFuncion(JSONObject f) {
        this._funciones.put((String) f.get("Rename"), generaEvaluador(f));
    }

    private void CargaEstructuraElem(JSONObject eElem) {
        this._def_elementos.put((String) eElem.get("Dominio"), new Estructura_Elemento(eElem));
    }

    @Override
    public String toString() {
        return "Estructura{ \n" + "_def_elementos=" + _def_elementos + ", \n _predicados=" + _predicados + ",\n _funciones=" + _funciones + '}';
    }

    private Evaluador generaEvaluador(JSONObject f){
        Evaluador fun = null;
        String nameClass = "relacionesPackage." + (String) f.get("Class");
        System.out.println(nameClass);
        try {
            fun = (Evaluador) Class.forName(nameClass).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fun;
}

    private Verificador generaVerificador(JSONObject p) throws ClassNotFoundException {
        ArrayList<Verificador> parciales = new ArrayList();
        
        JSONArray componentes = (JSONArray) p.get("Componentes");
        JSONObject iterado;
        String s_iterando;
        Verificador v_actual; 
        Integer c_parametros;
        
        c_parametros = ((Long)p.get("CantParam")).intValue();
        
        System.out.println("Estado del : Mapa _Clases");
        System.out.println(this._clases);

        System.out.println("---- Generacion de Predicado ----");
        
        for (Object componente : componentes) {
            iterado = (JSONObject) componente;
            System.out.println("Json: \n" + iterado);
            s_iterando = (String) iterado.get("Clase");
            System.out.println("Clase: " + s_iterando);
            if (esSimple(s_iterando)){
                try {
                    Integer auxA, auxB;
                    String auxC, auxD;
                    auxA = ((Long)iterado.get("ParametroI")).intValue(); auxB = ((Long) iterado.get("ParametroD")).intValue();
                    auxC = (String)iterado.get("AtributoI"); auxD = (String)iterado.get("AtributoD");
                    System.out.println("parametros: " + auxA + auxC + auxB+ auxD);
                    
                    v_actual = (Verificador) Class.forName(this._clases.get(s_iterando)).getConstructor(Integer.class, Integer.class, String.class, String.class).newInstance(auxA, auxB, auxC, auxD);
                    
                    System.out.println("resutaldooooo:  "+ v_actual.toString());
                    //Verificador v = (Verificador) Class.forName(this._clases.get(s_iterando)).getConstructor(Integer.TYPE, Integer.TYPE, String.class, String.class ).newInstance(auxA, auxB, auxC, auxD);                    
                    
                    parciales.add(v_actual);
                } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    System.out.println("Error al Contruir Verificador Simple");
                    Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else
                if(esCompuesto(s_iterando)){
                    try {
                        System.out.println("ENTRANDO AL COMPUESTO");
                        v_actual = (Verificador) Class.forName(this._clases.get(s_iterando)).getConstructor(Verificador.class, Verificador.class).newInstance(parciales.remove(parciales.size()-1), parciales.remove(parciales.size()-1));
                        System.out.println("sALIDA: " + v_actual.toString());
                        //v_actual = (Verificador) Class.forName((String) this._clases.get(s_iterando)).getConstructor( Verificador.class, Verificador.class ).newInstance(parciales.remove(parciales.size()-1), parciales.remove(parciales.size()-1));
                        parciales.add(v_actual);
                        System.out.println("Arreglo: " + parciales.toString());
                    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                        System.out.println("Error al Contruir Verificador Compuesto");
                        Logger.getLogger(Estructura.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("Error - Clase de Componente Predicado Inexistente ");
                }
        }
        
        if (parciales.size()>1) {
            System.out.println("Error, Quedo mas de un Predicado Parcial en la lista al momento de generarlos");
        }
        (parciales.get(0)).setCantidadParamentros(c_parametros);
        return parciales.get(0);
        
    }
    
    private boolean esSimple(String clave) {
        return (clave.equals("IGUAL")||clave.equals("MENOR")||clave.equals("MAYOR"));
    } 
    private boolean esCompuesto(String clave) {
        return (clave.equals("AND")||clave.equals("OR"));
    }
    
    private void cargarClases(){
        this._clases = new HashMap<>();
        //Agregamos los objetos predicados de contruccion
        this._clases.put("IGUAL", "relacionesPackage.Igual");
        this._clases.put("OR", "relacionesPackage.Or");
        this._clases.put("AND", "relacionesPackage.And");
        this._clases.put("MENOR", "relacionesPackage.Menor");
        this._clases.put("MAYOR", "relacionesPackage.Mayor");
    }
    
    
    
}
