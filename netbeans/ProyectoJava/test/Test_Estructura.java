
import generadoresPackge.Estructura;
import org.json.simple.parser.ParseException;

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
     
    public static void main(String[] args) throws ClassNotFoundException, ParseException {
     
        String data = getString();
        Estructura e = new Estructura(data);
        System.out.println("Estructura Cargada: ");
        System.out.println(e);
        
    }
    
    private static String getString () {
        String s;
        s = "{\"Predicado\":[\n" +
"{\"NombrePred\":\"Patito\",\n" +
"  \"CantParam\":2,\n" +
"  \"Componentes\" :[{\"Clase\":\"IGUAL\", \"ParametroI\":1, \"AtributoI\":\"Col\", \"ParametroD\":2, \"AtributoD\":\"_constante\"},\n" +
"				  {\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"Fil\", \"ParametroD\":1,  \"AtributoD\":\"Fil\"},\n" +
"				  {\"Clase\":\"OR\"}\n" +
"				  ]},\n" +
"{\"NombrePred\":\"EstaEntre\",\n" +
"  \"CantParam\":3,\n" +
"  \"Componentes\" :[{\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"Fil\", \"ParametroD\":1, \"AtributoD\":\"Fil\"},\n" +
"				  {\"Clase\":\"IGUAL\", \"ParametroI\":1, \"AtributoI\":\"Fil\", \"ParametroD\":2, \"AtributoD\":\"Fil\"},\n" +
"				  {\"Clase\":\"AND\"},\n" +
"				  {\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"Col\", \"ParametroD\":1, \"AtributoD\":\"Col\"},\n" +
"				  {\"Clase\":\"IGUAL\", \"ParametroI\":1, \"AtributoI\":\"Col\", \"ParametroD\":2, \"AtributoD\":\"Col\"},\n" +
"				  {\"Clase\":\"AND\"},\n" +
"				  {\"Clase\":\"AND\"}\n" +
"				  ]},\n" +
"{\"NombrePred\":\"Escirculo\",\n" +
"  \"CantParam\":1,\n" +
"  \"Componentes\" :[{\"Clase\":\"IGUAL\", \"ParametroI\":0, \"AtributoI\":\"Tipo\", \"ParametroD\":0, \"AtributoD\":\"_constante\"}\n" +
"				  ]}\n" +
"			],\n" +
"			\n" +
"\"Funcion\":[{\"Rename\":\"ELMASLEJANO\",\"Class\":\"ElMasLejano\"},\n" +
"		   {\"Rename\":\"CERCA\",\"Class\":\"ElMasCercano\"}\n" +
"		],\n" +
"\n" +
"\"Elemento\":[{\"Dominio\":\"Figura\",\n" +
"			\"ListAtributos\":[{\"Atributo\":\"Tipo\",\"Opciones\":[\"circulo\",\"piramide\",\"hexaedro\"]},\n" +
"							{\"Atributo\":\"Tamaño\",\"Opciones\":[\"chico\",\"mediano\",\"grande\"]},\n" +
"							{\"Atributo\":\"Fil\",\"Opciones\":[\"1\",\"2\",\"3\"]},\n" +
"							{\"Atributo\":\"Col\",\"Opciones\":[\"1\",\"2\",\"3\",\"4\"]}]\n" +
"			}]\n" +
"}"; 
        return s;
    }
}
