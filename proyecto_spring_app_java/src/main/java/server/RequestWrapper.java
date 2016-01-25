package server;

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
	List<Sentencia> listaSentencias;
	List<ElementoPost> listaElementos;

	/*
  Genera el Modelo correspondiente a la informacion mandada desde la web,
	el mismo  posee los diferentes componentes que requiere:
  Elementos como mapas, predicados y funciones.
  */

	public Modelo generarNuevoModelo( Estructura estructura ){
        HashMap<String, Elemento_m> list_map_elementos = new HashMap<>();
			//	System.out.println("XXXXXXXXXX  -----------  XXXXXXXXXX");
			//	System.out.println("RECORREMOS ELEMENTOS: ");
        this.listaElementos.stream().forEach((ElementoPost element) -> {
					//	System.out.println( "--->  " + element);
            list_map_elementos.put(element.getNombre(), element.getElemToMap(estructura));
        });
			//	System.out.println("  ");
			//	System.out.println("MAPA GENERADO: ");
		//		System.out.println(list_map_elementos);
        return new Modelo(list_map_elementos, estructura);
    }

    public void ejecutar(Estructura estructura){
				System.out.println("  -----------  EJECUTAR VERIFICADO  -----------  ");
				System.out.println("Llamando a generarModelo: ");
        Modelo m = generarNuevoModelo(estructura);

        System.out.println("Modelo Actual: ");
        System.out.println(m);

        Formula f;
        Error_m e;
        boolean result = false;
				System.out.println("Analizamos todas las Formulas ... y ejecutamos AL y AS ");
        for (int i = 0; i < listaSentencias.size(); i++) {
            f = AnalizadorSintactico.EjecutarAnalizador(listaSentencias.get(i).getValor());
            e = AnalizadorSintactico.getError();
            if (e.isWithoutError()){
                e = new Error_m();
                result = f.verificar(m, new HashMap<String, String>(), e);
            }
            System.out.println("[[[[[[[[[[  -----  ]]]]]]]]]]");
            System.out.println(" Formula resultado: " + result + "\n error : " + e.toString());
            System.out.println("[[[[[[[[[[  -----  ]]]]]]]]]]");
						listaSentencias.get(i).setMensaje(e.getId());
						if (e.isWithoutError()){
								if (result){
									listaSentencias.get(i).setEstado("my-icon-true");
								} else{
									listaSentencias.get(i).setEstado("my-icon-false");
								}
            } else {
							listaSentencias.get(i).setEstado("my-icon-alert");
						}
        }
				System.out.println("");System.out.println("");System.out.println("");
				System.out.println("Resultados finales a mandar como respuesta:");
				System.out.println(listaSentencias);
    }

    public List<ElementoPost> getListaElementos() {
      	return listaElementos;
    }

    public void setListaElementos(List<ElementoPost> e) {
	      this.listaElementos = e;
    }

    public List<Sentencia> getListaSentencias() {
        return listaSentencias;
    }

    public void setListaSentencias(List<Sentencia> s) {
      	this.listaSentencias = s;
    }

    @Override
    public String toString() {
        return "RequestWrapper{" + "elements=" + this.listaElementos + ", sentens=" + this.listaSentencias + '}';
    }

}
