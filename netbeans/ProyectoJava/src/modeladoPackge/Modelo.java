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
    
    //Estructur que define los distintos elementos que conforman al Modelo.
    //Las distintas clases de elementos del dominio 
    //Las Funciones y Los predicados, ya previamente instanciados. 
    private final Estructura _estructura;
    
    private final HashMap<String, Elemento_m> _dom;
    //posee un mapa con los diferentes elementos que estan definidos
    //dentro del modelo. NUESTRO DOMINIO
    
    
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

    public boolean containsPredicado(String id){
        return this._estructura.containsPredicado(id);
    }
    
    public boolean containsFuncion(String id){
        return this._estructura.containsFuncion(id);
    }
    
    public boolean isAridadPredicadoCorrecta(String id, int size) {
        return this._estructura.isPredicateArityCorrect(id, size);
    }
    
    public boolean isAridadFuncionCorrecta(String id, int size) {
        return this._estructura.isFunctionArityCorrect(id, size);
    }

    public boolean verificarPredicado(String id, ArrayList<Elemento_m> parametros, Error_m error) {
          if (dominioVacio()){
            error.setError(Error_m.tipoError.DOMVACIO, "El modelo no posee definido elementos dentro de su Dominio");
            return false;
        }
// ---->   Esto se Verifica antes de invocar al verificador del modelo. 
//        if (!containsPredicado(id)){
//            error.setError(Error_m.tipoError.NOEXISTEP, "No Existe el predicado "+ id);
//            return false;
//        } else
            
        //Llegando a este punto, este predicado no posee ningun tipo de error
        return this._estructura.getPredicado(id).verificar(parametros);    
    }
    
    public Elemento_m evaluarFuncion(String id, ArrayList<Elemento_m> parametros, Error_m error) {
        Elemento_m Aux;
        if (dominioVacio()){
            error.setError(Error_m.tipoError.DOMVACIO, "El modelo no posee definido elementos dentro de su Dominio");
            return null;
        }
        return this._estructura.getFuncion(id).evaluar(_dom, parametros);
    }
    
        public Set<String> getListaNombresElementos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return "Modelo{" + "_estructura=" + _estructura + ", "
                + "\n _dom=" + _dom + '}';
    }

    private boolean dominioVacio() {
        return this._dom.isEmpty();
    }
}
