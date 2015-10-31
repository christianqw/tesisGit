/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelado.relaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import modelado.Elemento;
import modelado.data.EstructuraElemento;
import modelado.data.EstructuraPredicado;

/**
 *
 * @author Chris
 */
public class GeneradorPredicados {
    
    //             Id utilizado dentro del Archivo | Nombre de la clase
    private HashMap<String, String> _clases; 
    //                     Id del predicado | Estructura del predicado
    private HashMap<String, EstructuraPredicado> _definidor;
    
    private EstructuraElemento _infoElem;

    
    public void cargarClases(){
        this._clases = new HashMap<>();
        //Agregamos los objetos predicados de contruccion
        this._clases.put("IGUAL", "modelado.relaciones.Igual");
        this._clases.put("OR", "modelado.relaciones.Or");
        this._clases.put("AND", "modelado.relaciones.And");
        this._clases.put("MENOR", "modelado.relaciones.Menor");
        this._clases.put("MAYOR", "modelado.relaciones.Mayor");
    }
    
    public GeneradorPredicados(HashMap<String, EstructuraPredicado> pred, EstructuraElemento estrc) {
        this._definidor = pred;
        this._infoElem = estrc;
        cargarClases();
    }
    
    public Verificador getPredicado(String Id, ArrayList<Elemento> parametros){
        
        //System.out.println("--- Generando pred: " +Id+" ---");

        //mantenemos los evaluadores parciales para generar nuevos evaluadores compuestos.
        ArrayList<Verificador> parciales = new ArrayList();
        //lista que posee las claves de las contruccion de objetos de predicados
        ArrayList<String> lista = _definidor.get(Id).getListaClaves();
        //lista que define el roden en el que son utilizados los lelementos, el orden es creciente.
        ArrayList<Integer> numparametro = _definidor.get(Id).getListaParam();
        //lista donde figuran los atributos que se utilizan.
        ArrayList<String> atributo = _definidor.get(Id).getListaAtributos();
        
        Iterator itNumParam = numparametro.iterator();
        Iterator itAtributo = atributo.iterator();
        //Variables Auxiliares
        String atrib1;
        int valor1; //variables que almacenan temporalmente los valores a comparar.
        int valor2;
        Integer param2;
        for (String clave : lista){
            System.out.println(clave);
            if (esSimple(clave)){ //si es un evaludor simple
                try {
                    //el elemento de la pos"numParam" - Arranca a contar desde cero!!!!!
                    atrib1 = (String)itAtributo.next();
                    valor1 = (parametros.get((Integer)itNumParam.next())).getvalue(atrib1);
                    param2 = (Integer)itNumParam.next();
                    if (param2.equals(-1)){ //si se utiliza un valor especifico
                        valor2 = this._infoElem.getValue(atrib1,(String)itAtributo.next());
                    }else { //se compara con el valor de otro parametro
                        valor2 = (parametros.get(param2)).getvalue((String)itAtributo.next());
                    }
                    System.out.println("vlaor1: " + valor1 +"   Valor2: " + valor2 );
                    //(ClassName) Class.forName([name_of_the_class]).getConstructor([Type]).newInstance([Constructor Argument]);
                    Verificador v = (Verificador) Class.forName(this._clases.get(clave)).getConstructor(Integer.TYPE, Integer.TYPE).newInstance(valor1, valor2);   
                    parciales.add(v);
                }catch (Exception ex) {
                     System.err.println("EXPLOTO LA GENERACION DE CLASES SIMPLE !!!!!!!!!");//Hacer algo
                     System.out.println(ex.getMessage() + "   " + ex.toString());
                     return null;
                }
            } else 
                if (esCompuesto(clave)){ //si es un evaluador compuesto
                    try {
                        Compuesto aux = (Compuesto) Class.forName(_clases.get(clave)).newInstance();
                        aux.setEvaluadores(parciales);                        
                        System.out.println("Parciales: "+parciales.toString()); 
                        parciales = new ArrayList<>(); //quitamos los elementos de la lista de parciales
                        parciales.add(aux);//agregamos el compuesto nuevo generado.
                        System.out.println(aux.toString());
                    } catch (Exception ex) {
                         System.err.println("EXPLOTO LA GENERACION DE CLASES COMPUESTO !!!!!!!!!");//Hacer algo
                         return null;
                    }
                }
                else {
                    System.out.println("ERROR - Clave de Evaluador inexistente");
                    return null;
                }
                
            
        }
        return parciales.get(0); //retornamos el primer elemento. :D
    }
    
    private boolean esSimple(String clave) {
        return (clave.equals("IGUAL")||clave.equals("MENOR")||clave.equals("MAYOR"));
    } 
    private boolean esCompuesto(String clave) {
        return (clave.equals("AND")||clave.equals("OR"));
    } 
    
//    public Verificador getPredicado(String Id, ArrayList<Elemento> parametros){
//        //mantenemos los evaluadores parciales para generar nuevos evaluadores compuestos.
//        ArrayList<Verificador> parciales = new ArrayList();
//        //lista que posee las claves de las contruccion de objetos de predicados
//        ArrayList<String> lista = _definidor.get(Id).getListaClaves();
//        //lista que define el roden en el que son utilizados los lelementos, el orden es creciente.
//        ArrayList<Integer> numparametro = _definidor.get(Id).getListaParam();
//        //lista donde figuran los atributos que se utilizan.
//        ArrayList<String> atributo = _definidor.get(Id).getListaAtributos();
//
//        int Index = 0;
//        /*
//        For (lista de claves)
//            if (es "simple") //Igual
//                hace new del elemento con 2 parametros de la lista
//        else (Es "compuesto") //
//                hace el New del compuesto, 
//                y le agrega los parciales hasta que lo vacie
//                se agrega en la lista de parciales
//        */
//        int valor2;
//        int valor1;
//        for (int pos = 0; pos < lista.size() ; pos++) {
//            //recorremos la lista de claves
//            if(lista.get(pos).equals("IGUAL")){ //Simple (que utiliza parametros)
//            try {
//                
//                valor1 = parametros.get(numparametro.get(Index)).getvalue(atributo.get(Index));
//                Index ++;
//                if (numparametro.get(Index).equals(-1)){ //si es un valor especifico
//                    valor2 =  Integer.parseInt(atributo.get(Index));
//                } else{
//                    valor2 = parametros.get(numparametro.get(Index)).getvalue(atributo.get(Index));
//                    Index ++;
//                }
//                parciales.add((Verificador) Class.forName(_clases.get(lista.get(pos))).newInstance());
//                System.out.println("ESTOYYYYYYYYYYY ACAAAAAAA");
//                System.out.println(parciales.toString());
//                pos++;
//            } catch (Exception ex) {
//                     System.err.println("EXPLOTO LA GENERACION DE CLASES SIMPLE !!!!!!!!!");//Hacer algo
//                     System.out.println(ex.getMessage() + "   " + ex.toString());
//                }
//            }
//            if(lista.get(pos).equals("OR")){ //compuesto (que utiliza parciales)
//                try {
//                    Compuesto aux = (Compuesto) Class.forName(_clases.get(lista.get(pos))).newInstance();
//                    aux.setEvaluadores(parciales);
//                    //Eliminar todos los elementos
//                    
//                    pos++;
//                } catch (Exception ex) {
//                         System.err.println("EXPLOTO LA GENERACION DE CLASES COMPUESTO !!!!!!!!!");//Hacer algo
//                    }
//                }
//            }
//        return parciales.get(0);
//    }

    public boolean cantidadParametrosCorrectos(String id, int parametros) {
        return (this._definidor.get(id).getCantidadParametros() == parametros);
    }

    public boolean existeId(String id) {
        return this._definidor.containsKey(id);
    }

    @Override
    public String toString() {
        return "GeneradorPredicados{" + "Lista de Clases=" + _clases + ", \n EstrucPredicados =" + _definidor + '}';
    }


}
