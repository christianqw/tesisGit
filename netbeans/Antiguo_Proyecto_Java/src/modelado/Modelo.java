/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelado;

import modelado.data.EstructuraElemento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import modelado.data.EstructuraPredicado;
import modelado.relaciones.GeneradorFunciones;
import modelado.relaciones.GeneradorPredicados;

/**
 *
 * @author Chris
 */
public class Modelo {
    
    //Estructur que define los distintos elementos que conforman al Modelo.
    //Los elementos del dominio comparten la misma estructura en comun. 
    private EstructuraElemento _infoElemento;

    //posee un mapa con los diferentes elementos que estan definidos
    //dentro del modelo. NUESTRO DOMINIO
    private HashMap<String, Elemento> _dominio; 
    
    //contructor de predicados que es utilizado para definir los 
    //predicados que el modelo reconoce y sus respectivas caracteristicas.
    //Ademas internamente maneja la info de los distintos predicados a definir. 
    GeneradorPredicados _defPredicados;
    GeneradorFunciones _defFunciones;
    
    //Constructor de la clase, es necesario definir mediante la estructura
    // que atributos poseen los distintos elenemtos que confroman el modelo
    public Modelo(EstructuraElemento estruc, HashMap<String, EstructuraPredicado> predic, HashMap<String, String> func) throws ClassNotFoundException {
        this._infoElemento = estruc; 
        this._dominio = new HashMap<> ();
        this._defFunciones = new GeneradorFunciones(func);
        this._defPredicados = new GeneradorPredicados(predic, estruc);
   }
    
    // -- GENERICO AL MODELO
    public Elemento evaluarFuncion (String id, ArrayList<Elemento> parametros, Error error){
       Elemento Aux;
        if (dominioVacio()){
            error.setError(Error.tipoError.DOMVACIO, "El modelo no posee definido elementos dentro de su Dominio");
            return null;
        }
        if (!existeIdFuncion (id)){
            error.setError(Error.tipoError.NOEXISTEP, "No Existe la funcion "+ id);
            return null;
        } else
            Aux = this._defFunciones.getFuncion(id, parametros, getTodosLosElementos()).evaluar();
            return Aux;
    }
    
    public boolean verificarPredicado (String id, ArrayList<Elemento> parametros, Error error){
        if (dominioVacio()){
            error.setError(Error.tipoError.DOMVACIO, "El modelo no posee definido elementos dentro de su Dominio");
            return false;
        }
        if (!existeIdPredicado (id)){
            error.setError(Error.tipoError.NOEXISTEP, "No Existe el predicado "+ id);
            return false;
        } else
            //Llegando a este punto, este predicado no posee ningun tipo de error
            return _defPredicados.getPredicado(id, parametros).verificar();
    }
    
    // -- MODIFICACION DE ELEMENTOS
    
    public boolean agregarElemento(String name, Elemento elem){
        if (!dominioContiene(name)){
            this._dominio.put(name, elem);
            return true;
        }
        else 
            return false;
    }
    public boolean eliminarElemento(String name){
        if (dominioContiene(name)){
            this._dominio.remove(name);
            return true;
        }
        else return false;
    }
    public boolean setNombreElemento(String name, String newname){
        if (dominioContiene(name)){
            this._dominio.put(newname, this._dominio.remove(name));
            return true;
        }
        else return false;
    }

    public boolean setAtributo (String name, String atributo, String value){
        if (this.dominioContiene(name)){
            if (esAtributoValido(atributo)){
                return this._dominio.get(name).setAtributoStringValue(atributo, value);
            }else {
                System.out.println("XXXXXXXX   nombre atributo invalido");
                return false;
            }
        } else {
            System.out.println("XXXXXXXX  No está el elemento en el dominio");
            return false;
        }
    }
    
    public boolean setPosicion(String name, int x, int y){
        if (this.dominioContiene(name)){
            Elemento aux = this._dominio.get(name);
            aux.setPosicion( x, y);
            return true;
        }
        System.out.println("XXXXXXXX  No existe elemento");
        return false;
    }
    
    private boolean dominioVacio(){
        return this._dominio.isEmpty();
    }
    
    public boolean dominioContiene(String name){
        return this._dominio.containsKey(name);        
    }
    
    public boolean aridadPredicadoCorrecta(String id, int parametros) {
        return _defPredicados.cantidadParametrosCorrectos(id, parametros);
    }

    private boolean existeIdPredicado(String id) {
        return this._defPredicados.existeId(id);
    }
    
    public boolean aridadFuncionCorrecta(String id, int parametros) {
        return this._defFunciones.cantidadParametrosCorrectos(id, parametros);
    }

    private boolean existeIdFuncion(String id) {
        return this._defFunciones.existeId(id);
    }

    public Elemento getElemento(String name_elem) {
        return this._dominio.get(name_elem);
    }

    private ArrayList<Elemento> getTodosLosElementos() {
        return new ArrayList<Elemento> (this._dominio.values());
    }
    
    public Set<String> getListaNombresElementos(){
        return this._dominio.keySet();
    }    

    public EstructuraElemento getEstructuraElemento() {
        return this._infoElemento;
    }

    @Override
    public String toString() {
        return "Modelo{" + "EstructuraElemento =" + _infoElemento + ",\n Dominio Actual =" + _dominio + ",\n  Predicados =" + _defPredicados + ",\n Funciones =" + _defFunciones + '}';
    }
    
    public String domtoString() {
        return this._dominio.toString();
    }

    private boolean esAtributoValido(String atributo) {
        return this._infoElemento.esAtributoValido(atributo);
    }
    
   
}
