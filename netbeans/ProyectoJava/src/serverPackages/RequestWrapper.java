package serverPackages;

import ALexicoyASintacticoPackage.AnalizadorSintactico;
import formulaPackage.Formula;
import generadoresPackge.Estructura;
import java.util.ArrayList;
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
        //List<Elemento_m> list_map_elementos = new ArrayList<>();

        this.elements.stream().forEach((ElementoPost element) -> {
            list_map_elementos.put(element.getNombre(), element.getElemToMap(estructura));
        });

        return new Modelo(list_map_elementos, estructura);
    }

    public void ejecutar(Estructura estructura){
        Modelo m = generarNuevoModelo(estructura);
        Formula f;
        for (int i = 0; i < sentens.size(); i++) {
            System.out.println("Generamos el Objeto Formula ... y ejecutamos AL y AS ");
            f = AnalizadorSintactico.EjecutarAnalizador(sentens.get(i).getValor()); 
            if (AnalizadorSintactico.getError().isWithoutError()){
                f.verificar(m, new HashMap<String, String>(), new Error_m());
            }
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

}
