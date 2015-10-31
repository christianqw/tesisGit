/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package relacionesPackage;

import java.util.ArrayList;
import modeladoPackge.Elemento;

/**
 *
 * @author Chris
 */
public class Igual extends Simple{

    public Igual(Integer value1, Integer value2, String attI, String attD) {
        super(value1, value2, attI, attD );
    }

    @Override
    public boolean verificar(ArrayList<Elemento> listE) {
        Integer auxI = getIzquierda(listE.get(this._paramI));
        Integer auxD = getDerecha(listE.get(this._paramD));
        if (auxI == null || auxD == null){
            return false;
        } else return auxI.equals(auxD);
    }
    
    @Override
    public String toString() {
        return "Igual{" + super.toString() + '}';
    }

}
