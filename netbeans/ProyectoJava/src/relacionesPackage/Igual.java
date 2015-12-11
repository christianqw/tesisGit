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
public class Igual extends Simple{

    public Igual(Integer value1, Integer value2, String attI, String attD) {
        super(value1, value2, attI, attD );
    }

    @Override
    public boolean verificar(ArrayList<Elemento_m> listE) {
        Integer auxI;                
        if (isConstante(this._attI)){
            auxI = this._paramI;
        } else {
            auxI = listE.get(this._paramI).getValue(_attI);
        }        
                

        Integer auxD = getDerecha(listE);
        if (auxI == null || auxD == null){
            return false;
        } else return auxI.equals(auxD);
    }
    
    @Override
    public String toString() {
        return "Igual{" + super.toString() + '}';
    }

}
