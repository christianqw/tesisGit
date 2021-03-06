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
public abstract class Simple extends Verificador{
    
    protected Integer _paramI, _paramD;
    protected Integer _valI, _valD;
    protected String _attI, _attD;

    public Simple(Integer paramI, Integer paramD, String attI, String attD) {
        this._paramI = paramI;
        this._paramD = paramD;
        this._attI = attI;
        this._attD = attD;            
    }

    protected Integer getIzquierda(ArrayList<Elemento_m> listE ){
        if (isConstante(_attI)){
            return this._paramI;
        } else {
            return listE.get(this._paramI).getValue(_attI);
        }
    }
    
    protected Integer getDerecha(ArrayList<Elemento_m> listE ){
        if (isConstante(_attD)){
            return this._paramD;
        } else {
            return listE.get(this._paramD).getValue(_attD);
        }
    }    
    
    protected boolean isConstante(String s){
        return s.equals("_constante");
    }
    
    @Override
    public String toString() {
        return "_paramI=" + _paramI + ", _paramD=" + _paramD + ", _attI=" + _attI + ", _attD=" + _attD ;
    }
    
    
}
