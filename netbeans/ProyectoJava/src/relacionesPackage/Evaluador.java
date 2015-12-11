/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionesPackage;

import java.util.ArrayList;
import java.util.HashMap;
import modeladoPackge.Elemento_m;

/**
 *
 * @author Chris
 */
public abstract class Evaluador {
    
    private int cantParametros;

    public Evaluador() {}
    
    @Override
    public abstract String toString();

    public abstract Elemento_m evaluar(HashMap<String, Elemento_m> dom, ArrayList<Elemento_m> e);

    public int getCantidadParametros(){
        return this.cantParametros;
    }
    
    public void setCantidadParametros(int valor){
        this.cantParametros = valor;
    }

    public boolean isArityCorrect(int size) {
        return (getCantidadParametros() == size);
    }
    
}
