/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionesPackage;

import generadoresPackge.Estructura;
import java.util.ArrayList;
import modeladoPackge.Elemento_m;

/**
 *
 * @author Chris
 */
public abstract class Verificador {

    private Integer cantParametros;

    public abstract boolean verificar(ArrayList<Elemento_m> e);
        
    public void setCantidadParamentros(Integer valor) {
        this.cantParametros = valor;
    }

    public int getCantParametros() {
        return cantParametros;
    }

    public boolean isArityCorrect(int size) {
        return (getCantParametros() == size);
    }

}
