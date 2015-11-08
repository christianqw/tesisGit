/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package formulaPackage;

import java.util.ArrayList;
import java.util.HashMap;
import modeladoPackge.*;

/**
 *
 * @author Chris
 */
public class Funcion extends Termino{
    
    private final String _id;
    private ArrayList<Termino> _terminos;

    /**
     *
     * @param id
     */
    public Funcion(String id) {
        this._id = id;
    }

    public Funcion(String id, ArrayList<Termino> terminos) {
        this._id = id;
        this._terminos = terminos;
    }

    public void AgregarTermino(Termino t){
        this._terminos.add(t);
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public Elemento_m evaluar(Modelo m, HashMap<String, String> instancia, Error_m e) {
       ArrayList<Elemento_m> parametros = new ArrayList();
       
       Elemento_m res;
       if (!m.aridadFuncionCorrecta(this._id, this._terminos.size())){
                e.setError(modeladoPackge.Error_m.tipoError.ARIDAD, "Cantidad de paramentros incorrecta dentro de " + this._id);
                return null;
            } else {
            /* definicion de los parametros de la función 
            Se realiza una busqueda de los diferenetes parametros 
            para poder hacer la correspondiente evaluacion */
            int cont = 0;
            while (cont < this._terminos.size() && e.isSinError()){
                 parametros.add(this._terminos.get(cont).evaluar(m, instancia, e));
                 cont++;
            };
     
            if (e.getTipoError() == modeladoPackge.Error_m.tipoError.SINERROR){
                res = m.evaluarFuncion(this._id, parametros, e);
                if (e.getTipoError() != modeladoPackge.Error_m.tipoError.SINERROR){
                    res = null; 
                    /*"evaluarFuncion"1 retorna ' ' pero para una mayor 
                    consistencia se le asigna el resultado de error de 
                    forma explicita.*/
                }
            } else res = null;
        }
    
       return res;
    }

    @Override
    public String toString() {
        return "Funcion{" + "id=" + this._id + ", terminos=" + this._terminos + '}';
    }

}
