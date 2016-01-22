package testserverfalso;


import com.sun.jndi.url.rmi.rmiURLContext;
import generadoresPackge.Estructura;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.parser.ParseException;
import serverPackages.RequestWrapper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chris
 */
public class Test_Estructura {
     
    public static void main(String[] args) throws ClassNotFoundException, ParseException, FileNotFoundException {
     
        
    //
        
    //generamos la estructura:     
        String data = getString();
        Estructura e = new Estructura(data);
        System.out.println("Estructura Cargada: ");
        System.out.println(e);
        
        
    //emulamos el POST - mensaje mandado por la Web
        RequestWrapper rw = TestGenerateRequestWrapper.getFalsoPost();
        
        System.out.println(" XXXX --- *falso* RequestWApper --- XXXX ");
        System.out.println(rw);
        System.out.println(" XXXX ----------------------------- XXXX ");
        
    //ejecutamos verificador : 
        rw.ejecutar(e);
    }
    
    private static String getString () {
        String s;
        s = "{\"Predicado\":[\n" +
            "{\"NombrePred\":\"Despierto\",\n" +
            "  \"CantParam\":1,\n" +
            "  \"Componentes\" :[{\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"att2\", \"ParametroD\":0, \"AtributoD\":\"_constante\"}\n" +
            "				  ]},\n" +
            "{\"NombrePred\":\"Dormido\",\n" +
            "  \"CantParam\":1,\n" +
            "  \"Componentes\" :[{\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"att2\", \"ParametroD\":1, \"AtributoD\":\"_constante\"}\n" +
            "				  ]},\n" +
            "{\"NombrePred\":\"EsChancho\",\n" +
            "  \"CantParam\":1,\n" +
            "  \"Componentes\" :[{\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"tipo\", \"ParametroD\":0, \"AtributoD\":\"_constante\"}\n" +
            "				  ]},\n" +
            "{\"NombrePred\":\"EsGallina\",\n" +
            "  \"CantParam\":1,\n" +
            "  \"Componentes\" :[{\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"tipo\", \"ParametroD\":1, \"AtributoD\":\"_constante\"}\n" +
            "				  ]},\n" +
            "{\"NombrePred\":\"EsPato\",\n" +
            "  \"CantParam\":1,\n" +
            "  \"Componentes\" :[{\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"tipo\", \"ParametroD\":2, \"AtributoD\":\"_constante\"}\n" +
            "				  ]},\n" +
            "{\"NombrePred\":\"EsVaca\",\n" +
            "  \"CantParam\":1,\n" +
            "  \"Componentes\" :[{\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"tipo\", \"ParametroD\":3, \"AtributoD\":\"_constante\"}\n" +
            "				  ]},\n" +
            "{\"NombrePred\":\"MismoLugar\",\n" +
            "  \"CantParam\":2,\n" +
            "  \"Componentes\" :[{\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"zona\", \"ParametroD\":1, \"AtributoD\":\"zona\"}\n" +
            "				  ]}\n" +
            "			],\n" +
            "			\n" +
            "\"Funcion\":[{\"Rename\":\"ELMASLEJANO\",\"Class\":\"ElMasLejano\"},\n" +
            "		   {\"Rename\":\"CERCA\",\"Class\":\"ElMasCercano\"}\n" +
            "		],\n" +
            "\n" +
            "\"Elemento\":[{\"Dominio\":\"animal\",\n" +
            "			\"ListAtributos\":[{\"Atributo\":\"tipo\",\"Opciones\":[\"tipo1\",\"tipo2\",\"tipo3\", \"tipo4\"]},\n" +
            "							{\"Atributo\":\"att1\",\"Opciones\":[\"chico\",\"mediano\",\"grande\"]},\n" +
            "							{\"Atributo\":\"att2\",\"Opciones\":[\"despierto\",\"dormido\"]},\n" +
            "							{\"Atributo\":\"zona\",\"Opciones\":[\"bosque\",\"cielo\",\"corral\"]}]\n" +
            "			}]\n" +
            "}"; 
        return s;
    }
}
