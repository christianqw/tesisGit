/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

import JSONSimple.JSONAdmin;
import modelado.Modelo;

/**
 *
 * @author Chris
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        
        //Cargamos el archivo de configuracion
        JSONAdmin ArchJson = new JSONAdmin("ExampleConfigJSONFile.json");
        
        Modelo mod = new Modelo(ArchJson.ReadJSONElemento(), ArchJson.ReadJSONPredicado(),ArchJson.ReadJSONFunciones());
        
        System.out.println(mod.toString());
    }
    
}
