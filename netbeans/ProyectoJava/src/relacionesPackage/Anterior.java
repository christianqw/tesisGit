/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package relacionesPackage;

import java.util.ArrayList;
import modeladoPackge.Elemento_m;

/**
 *
 * @author Chris
 */
public class Menor extends Simple{
    
    public Menor(int value1, int value2, String attI, String attD) {
        super(value1, value2, attI, attD );
    }

    @Override
    public boolean verificar(ArrayList<Elemento_m> listE) {
        Integer auxI = getIzquierda(listE);
        Integer auxD = getDerecha(listE);
        if (auxI == null || auxD == null){
            return false;
        } else return (auxI.compareTo(auxD)>0);
    }
    
    @Override
    public String toString() {
        return "Menor{" + super.toString() + '}';
    }
}
