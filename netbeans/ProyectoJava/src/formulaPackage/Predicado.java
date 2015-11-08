 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaPackage;

import java.util.ArrayList;
import java.util.HashMap;
import modeladoPackge.Elemento_m;
import modeladoPackge.Modelo;
import modeladoPackge.Error_m;

/**
 *
 * @author Chris
 */
public class Predicado implements Formula{
    
    private final String _id;
    private ArrayList<Termino> _terminos;

    public Predicado(String id) {
        this._id = id;
    }

    public Predicado(String id, ArrayList<Termino> terminos) {
        this._id = id;
        this._terminos = terminos;
    }
    
    public void agregarTermino(Termino t){
        this._terminos.add(t);
    };

    @Override
    public boolean verificar(Modelo m, HashMap<String, String> instancia, Error_m e) {
        ArrayList<Elemento_m> consulta = new ArrayList<>();
        
        //Verificamos que exista un predicado con ese identificador.
        if (m.containsPredicado(this._id)){
           //En este momento es posible realizar la verificacion de error de cantidad de paramentros.
            if (!m.aridadPredicadoCorrecta(this._id, this._terminos.size())){
                e.setError(modeladoPackge.Error_m.tipoError.ARIDAD, "Cantidad de paramentros incorrecta dentro de " + this._id);
                return false;
            }else{ //primero busca las distintas variables intervinientes (pueden ser resultados de funciones)
                    int cont = 0;
                    while (cont < this._terminos.size() && e.isWithoutError()){
                        consulta.add(this._terminos.get(cont).evaluar(m, instancia, e));
                        cont++;
                    }
                    //realizamos la verificacion y la evaluacion del predicado dentro del modelo en cuestion
                    if (e.isWithoutError())
                        return m.verificarPredicado(this._id, consulta, e);
                    else {
                        return false; 
                    }
            } 
        } else {
            e.setError(modeladoPackge.Error_m.tipoError.NOEXISTEP, "No Existe la funcion "+ this._id);
            return false;
        }
    }

    @Override
    public String toString() {
        return "Predicado{" + "id=" + this._id + ", terminos=" + this._terminos + '}';
    }
   
}
