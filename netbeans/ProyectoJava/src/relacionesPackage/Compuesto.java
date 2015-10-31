/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package relacionesPackage;

/**
 *
 * @author Chris
 */
public abstract class Compuesto extends Verificador{

    protected Verificador _vI, _vD;

    public Compuesto(Verificador _vI, Verificador _vD) {
        this._vI = _vI;
        this._vD = _vD;
    }

}
