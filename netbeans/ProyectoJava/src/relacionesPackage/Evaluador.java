/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionesPackage;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import modeladoPackge.Elemento_m;
import org.json.simple.JSONObject;

/**
 *
 * @author Chris
 */
public abstract class Evaluador {
    
    private int cantParametros;

    public Evaluador() {}
    
    @Override
    public abstract String toString();

    public abstract Elemento_m evaluar();

    public int getCantidadParametros(){
        return this.cantParametros;
    }
    
    public void setCantidadParametros(int valor){
        this.cantParametros = valor;
    }
    
}
