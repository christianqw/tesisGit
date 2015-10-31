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
public class Or extends Compuesto{

    public Or(Verificador _vI, Verificador _vD) {
        super(_vI, _vD);
    }

    @Override
    public String toString() {
        return "Or{" + "_eI" + _vI + "_eD" + _vD +'}';
    }

    @Override
    public boolean verificar(ArrayList<Elemento> list) {
        return (this._vI.verificar(list) & this._vI.verificar(list));
    }
}
