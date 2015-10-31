
import JSONSimple.JSONAdmin;
import compilacionFormulas.AnalizadorSintactico;
import estructuraLogica.Formula;
import java.util.HashMap;
import java.util.Scanner;
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
public class Test_2 {
    
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        
        /*
        Pruevas del analizador de predicados.
        */    

        System.out.println("Generando estructuras basicas del moedelo");
        //Cargamos el archivo de configuracion
        JSONAdmin ArchJson = new JSONAdmin("ExampleConfigJSONFile.json");
        
        Modelo mod = new Modelo(ArchJson.ReadJSONElemento(), ArchJson.ReadJSONPredicado(),ArchJson.ReadJSONFunciones());

        System.out.println( "----------- ");
        
        System.out.println("Generando instancia del modelo de pruebas");
        Elemento e1 = new Elemento(mod.getEstructuraElemento(), 10, 10, "a");
        
        Elemento e2 = new Elemento(mod.getEstructuraElemento(), 20, 10, "b");
        e2.setAtributoStringValue("Tipo", "piramide");
        
        Elemento e3 = new Elemento(mod.getEstructuraElemento(), 30, 10, "c");
        e3.setAtributoStringValue("Tipo", "circulo");
                                                    //      0   10  20  30
        mod.agregarElemento(e1.getNombre(), e1);    // 0    -   -   -   -
        mod.agregarElemento(e2.getNombre(), e2);    // 10   -   e1  e2  e3
        mod.agregarElemento(e3.getNombre(), e3);    // 20   -   -   -   -   
                                                    
        //modificamos los elementos para tener un estado de trabajo
        mod.setAtributo("a", "Tipo", "hexaedro");
        mod.setAtributo("a", "Fil", "2");
        mod.setAtributo("b", "Fil", "2");
        mod.setAtributo("c", "Fil", "2");
        mod.setAtributo("a", "Col", "2");
        mod.setAtributo("b", "Col", "3");
        mod.setAtributo("c", "Col", "4");

        
        System.out.println("============        =============");
        
        System.out.println("Generando Analisis Sintactio y Semantico");
        
         /*  Ejecutamos el analizador lexico y sintactico
             sobre un archivo de pruebas. 
         */
        
        //Utilizando el main:
        //String[] archivoPrueba = {"test.txt"};
        //AnalizadorSintactico.main(archivoPrueba);
        
        
        Formula f,s = null;
        f = AnalizadorSintactico.EjecutarAnalizador("test.txt");
        System.out.println("Ejecutado!");
        
        System.out.println("Formula generada: ");
        System.out.println(f.toString());
        
        System.out.println("=========   Verificacion: ===========");
        HashMap<String, String> instancia = new HashMap<>();
        modelado.Error error = new modelado.Error();
        System.out.println(f.verificar(mod, instancia , error));
        System.out.println(error.toString());
        
        System.out.println("=========   Evaluación: ===========");
        s = AnalizadorSintactico.EjecutarAnalizador("test2.txt");
        System.out.println("Ejecutado!");        
        HashMap<String, String> instancia2 = new HashMap<>();
        modelado.Error error2 = new modelado.Error();
        System.out.println(s.verificar(mod, instancia2 , error2));
        System.out.println(error2.toString());
        
        
    }
    
}