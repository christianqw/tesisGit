/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package relacionesPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modeladoPackge.Elemento_m;

/**
 *
 * @author Chris
 */
public class ElMasCercano extends Evaluador{
    
    @Override
    public Elemento_m evaluar(HashMap<String, Elemento_m> dom, ArrayList<Elemento_m> parametros) {
      /*Recorremos todos los elementos del dominio, buscando el que se encuentra mas proximo al 
        elemento pasado por parametro, si el elemento es unico, se retorna a si mismo*/ 
        if (dom.size() == 1){
            return parametros.get(0);
        }else {
            return buscar(dom, parametros.get(0));
        }
    }
    
    @Override
    public int getCantidadParametros() { return 1; }
    
    @Override
    public String toString() {
        return "Funtion Elmascercano"; //To change body of generated methods, choose Tools | Templates.
    }

    private Elemento_m buscar(HashMap<String, Elemento_m> dom, Elemento_m elem) {
        double distanciaMenor = 0; 
        double dTemporal;
        Elemento_m encontrado = null;
        for (Map.Entry<String, Elemento_m> entrySet : dom.entrySet()) {
            // busca el otro que no sea si mismo que tenga distancia menor
            if (!entrySet.getKey().equals(elem.getNombre())){
                dTemporal = Math.sqrt( Math.pow(elem.getValue("Top")- entrySet.getValue().getValue("Top"),2)
                                        + Math.pow(elem.getValue("Left")- entrySet.getValue().getValue("Left"),2));
                if ((distanciaMenor > dTemporal) || (distanciaMenor == 0)){
                    distanciaMenor = dTemporal;
                    encontrado = entrySet.getValue();
                } 
            }
        }
        System.out.println("Encontrado : " + encontrado);
        return encontrado; 
    }

    
}

