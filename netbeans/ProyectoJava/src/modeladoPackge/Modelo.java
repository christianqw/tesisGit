/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeladoPackge;

import generadoresPackge.Estructura;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


/**
 *
 * @author Chris
 */
public class Modelo {
    
    private final Estructura _estructura;
    private final HashMap<String, Elemento_m> _dom;

    public Modelo(HashMap<String, Elemento_m> list_map_elementos, Estructura estructura) {
        this._dom = list_map_elementos;
        this._estructura = estructura;
    }

    public boolean dominioContiene(String name_elem) {
        return this._dom.containsKey(name_elem);
    }

    public Elemento_m getElemento(String name_elem) {
        return this._dom.get(name_elem);
    }

    public Elemento_m evaluarFuncion(String _id, ArrayList<Elemento_m> parametros, Error_m e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean aridadFuncionCorrecta(String _id, int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Set<String> getListaNombresElementos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean aridadPredicadoCorrecta(String _id, int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verificarPredicado(String _id, ArrayList<Elemento_m> consulta, Error_m e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean containsFuncion(String id){
        return this._estructura.containsFuncion(id);
    }
    
    public boolean containsPredicado(String id){
        return this._estructura.containsPredicado(id);
    }
    
}
