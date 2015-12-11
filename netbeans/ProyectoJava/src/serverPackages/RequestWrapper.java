package serverPackages;

import ALexicoyASintacticoPackage.AnalizadorSintactico;
import formulaPackage.Formula;
import generadoresPackge.Estructura;
import java.util.HashMap;
import java.util.List;
import modeladoPackge.*;

public class RequestWrapper {
    /*
    La estructura contiene 2 Listas que son uno a uno con los Json que manda la web
    para poder cominucar la informacion a travez del POST
    */

    List<ElementoPost> elements;
    List<Sentencia> sentens;

    /*
    Genera el Modelo correspondiente a la informacion mandada desde la web, el mismo
    posee los diferentes componentes que requiere:
    Elementos como mapas, predicados y funciones.
    */
    public Modelo generarNuevoModelo( Estructura estructura ){
        HashMap<String, Elemento_m> list_map_elementos = new HashMap<>();

        this.elements.stream().forEach((ElementoPost element) -> {
            list_map_elementos.put(element.getNombre(), element.getElemToMap(estructura));
        });

        return new Modelo(list_map_elementos, estructura);
    }

    public void ejecutar(Estructura estructura){
        Modelo m = generarNuevoModelo(estructura);
        
        System.out.println("Modelo Actual: ");
        System.out.println(m);
        
        Formula f;
        Error_m e;
        boolean result = false;
        for (int i = 0; i < sentens.size(); i++) {
            System.out.println("Analizamos todas las Formulas ... y ejecutamos AL y AS ");
            f = AnalizadorSintactico.EjecutarAnalizador(sentens.get(i).getValor()); 
            e = AnalizadorSintactico.getError();
            if (e.isWithoutError()){
                e = new Error_m();
                result = f.verificar(m, new HashMap<String, String>(), e);
            }
            System.out.println("[[[[[[[[[[  -----  ]]]]]]]]]]");
            System.out.println(" Formula : " + f.toString() +" \n resultado: " + result + "\n error : " + e.toString());
            System.out.println("[[[[[[[[[[  -----  ]]]]]]]]]]");
        }
    }
    
    
    public List<ElementoPost> getElements() {
                    return elements;
    }

    public void setElements(List<ElementoPost> elements) {
                    this.elements = elements;
    }

    public List<Sentencia> getSentens() {
                    return sentens;
    }

    public void setSentens(List<Sentencia> sentens) {
                    this.sentens = sentens;
    }

    @Override
    public String toString() {
        return "RequestWrapper{" + "elements=" + elements + ", sentens=" + sentens + '}';
    }
    
    
    
}
