
import JSONSimple.JSONAdmin;
import modelado.Elemento;
import modelado.Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chris
 */
public class Test_1 {
    
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        
        /*
        Pruevas en las que se analizan los elementos y su interaccion con el modelo.
        */    


        //Cargamos el archivo de configuracion
        JSONAdmin ArchJson = new JSONAdmin("ExampleConfigJSONFile.json");
        
        Modelo mod = new Modelo(ArchJson.ReadJSONElemento(), ArchJson.ReadJSONPredicado(),ArchJson.ReadJSONFunciones());
        
        System.out.println("Generacion de las estructuras basicas del moedelo");
        System.out.println(mod.toString()); 
        System.out.println( "----------- ");
        Elemento e1 = new Elemento(mod.getEstructuraElemento(), 10, 10, "a");
        
        Elemento e2 = new Elemento(mod.getEstructuraElemento(), 20, 10, "b");
        
        //Error por que el nombre ya existe
        Elemento e3 = new Elemento(mod.getEstructuraElemento(), 10, 20, "a");
                                                    //      0   10  20  30
        mod.agregarElemento(e1.getNombre(), e1);    // 0    -   -   -   -
        mod.agregarElemento(e2.getNombre(), e2);    // 10   -   e1  e2  -
        mod.agregarElemento(e3.getNombre(), e3);    // 20   -   e3  -   -   
                                                    
        
        System.out.println("no agrega el elemento que posee el mismo nombre");
        System.out.println(mod.getListaNombresElementos().toString());
        System.out.println( "----------------------------- ");
       
        e3.setNombre("c");
        //Modificando 
        System.out.println( " Modifica el Elemento ");
        e3.setAtributoStringValue("Tipo", "circulo");
        e2.setAtributoStringValue("Tipo", "piramide");
        mod.agregarElemento(e3.getNombre(), e3);
                                                    //      0   10  20  30
        e3.setPosicion(30, 10);                     // 0    -   -   -   -
        System.out.println( e2.toString());         // 10   -   e1  e2  e3
        System.out.println( e3.toString());         // 20   -   -   -   -
        System.out.println( "  .......  ");         
        
        //Error al intentar modificar un atributo que no existe
        System.out.println( " agrega algo que no existe ");
        e3.setAtributoStringValue("", "");        
        System.out.println( "  ..................  ");
        
        System.out.println( " Modifica utilizando el Modelo: ");
//        System.out.println( "Nombre: ");
//        mod.setNombreElemento("c", "d");
        System.out.println(mod.getListaNombresElementos());
//        System.out.println( "Pos: ");
//        mod.setPosicion("a",0, 10);

        System.out.println(mod.domtoString());
        System.out.println( "Atributos:   ( queda igual que la imagen ) ");
        mod.setAtributo("a", "Tipo", "hexaedro");
        mod.setAtributo("a", "Fil", "2");
        mod.setAtributo("b", "Fil", "2");
        mod.setAtributo("c", "Fil", "2");
        mod.setAtributo("a", "Col", "2");
        mod.setAtributo("b", "Col", "3");
        mod.setAtributo("c", "Col", "4");
        
        System.out.println(mod.domtoString());
 
        System.out.println( " Modifica utilizando el Modelo: ");
        System.out.println( "Nombre: ");
        mod.setNombreElemento("a", "d");
        System.out.println(mod.getListaNombresElementos());
        System.out.println( "Pos: ");
        mod.setPosicion("a",0, 10);
        
        System.out.println( "Atributos: ");
        mod.setAtributo("c", "Fil", "4");
        
    }
    
}