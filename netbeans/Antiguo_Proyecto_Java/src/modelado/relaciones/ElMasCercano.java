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
public class ElMasCercano extends Evaluador{
    
    @Override
    public Elemento evaluar() {
        /*Recorremos todos los elementos del dominio, buscando el que se encuentra mas proximo al 
        elemento pasado por parametro, si el elemento es unico, se retorna a si mismo*/ 
        ArrayList<Elemento> instancia = this.getInstanciaDelDominio();
        Elemento elem = this.getParametros().get(0);
        if (instancia.size() == 1) {
            return elem;
        } else             
            return buscar( instancia, elem); 
    }

    @Override
    public int getCantidadParametros() { return 1; }

    
    @Override
    public String toString() {
        return "Funtion Elmascercano"; //To change body of generated methods, choose Tools | Templates.
    }

    private Elemento buscar(ArrayList<Elemento> instancia, Elemento elem) {        
        double distanciaMenor = 0; 
        double dTemporal;
        Elemento encontrado = null;
        for (int i = 0; i < instancia.size() ; i++) {
            // busca el otro que no sea si mismo que tenga distancia menor
            if (! instancia.get(i).getNombre().equals(elem.getNombre())){
                dTemporal = Math.sqrt( Math.pow(elem.getPosx()- instancia.get(i).getPosx(), 2)
                                        + Math.pow(elem.getPosy()- instancia.get(i).getPosy(), 2));
                if ((distanciaMenor > dTemporal) || (distanciaMenor == 0)){
                    distanciaMenor = dTemporal;
                    encontrado = instancia.get(i);
                } 
            }              
        }
        System.out.println("Encontrado : " + encontrado);
        return encontrado;
    }
    
}

