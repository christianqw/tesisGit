/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeladoPackge;

/**
 *
 * @author Chris
 */
public class Error_m {
       
    public enum tipoError {
        SINERROR, CUANTIFICACION, VARLIBRE, NOEXISTEP,
        NOEXISTEF, ARIDAD, SINTAXIS, LEXICO, DOMVACIO
    }
 
    private tipoError _tipo_de_error;
    private String _identificador;

    public Error_m() {//Cuando se genera una nueva variable error se inicializa como sin Error_m
        this._tipo_de_error = modeladoPackge.Error_m.tipoError.SINERROR;
        this._identificador = "";
    }

    public tipoError getTipoError() {//permite retornar el tipo de error que fue identificado
        return this._tipo_de_error;
    }

    public String getId() {//permite devolver el identificador con el que se distigue el erorr particular
        return this._identificador;
    }

    public void setError(tipoError estado, String id) {//permite modificar el tipo de error detectado.
        this._tipo_de_error = estado;
        this._identificador = id;
    }

    public void setIdentificador (String identificador) {
        this._identificador = identificador;
    }
    
    public boolean isSinError(){
        return this._tipo_de_error.equals(modeladoPackge.Error_m.tipoError.SINERROR);
    }
    
    @Override
    public String toString() {
        return "Estado de la var Error{" + _tipo_de_error+ ", \n"
                + "                        Mensaje de error = " + _identificador + '}';
    }
}
