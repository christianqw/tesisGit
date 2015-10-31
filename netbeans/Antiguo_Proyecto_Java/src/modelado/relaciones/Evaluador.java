/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelado.relaciones;

import java.util.ArrayList;
import modelado.Elemento;

/**
 *
 * @author Chris
 */
public abstract class Evaluador {
    
    private ArrayList<Elemento> _parametros;
    private ArrayList<Elemento> _instanciaDelDominio;
    
    @Override
    public abstract String toString();

    public abstract Elemento evaluar();

    public abstract int getCantidadParametros();

    public void setParametros(ArrayList<Elemento> parametros){
        this._parametros = parametros;
    }

    void setInstanciaDominio(ArrayList<Elemento> dom) {
        this._instanciaDelDominio = dom;
    }

    public ArrayList<Elemento> getParametros() {
        return _parametros;
    }

    public ArrayList<Elemento> getInstanciaDelDominio() {
        return _instanciaDelDominio;
    }

}
