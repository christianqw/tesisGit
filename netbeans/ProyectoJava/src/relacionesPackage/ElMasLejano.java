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
public class ElMasLejano extends Evaluador{
    
   @Override
    public Elemento_m evaluar(HashMap<String, Elemento_m> dom, ArrayList<Elemento_m> e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCantidadParametros() { return 1; }

    
    @Override
    public String toString() {
        return "Funtion Elmascercano"; //To change body of generated methods, choose Tools | Templates.
    }

    private Elemento_m buscar(ArrayList<Elemento_m> instancia, Elemento_m elem) {
        return null;
    }

    
 }        
        
 