package server;

import generadoresPackge.Estructura;
import generadoresPackge.Estructura_Elemento;
import java.util.HashMap;
import java.util.Map;
import modeladoPackge.Elemento_m;

public class ElementoPost {

	//Atributos Generalizados o Por defecto:
	private String id;		//no se utiliza... probar si sacando los Set lo ignora al campo. :D
  private String _nombre;
	private String _dominio;
	private Integer _left;
  private Integer _top;

	//Atributos Personalizables:
	  private Map<String, String> _atributos;

	/*
	Se realizan los get and set de los atributos para realizar la contruccion
	automatica del objeto dentro del Wrapper.
	*/
	public String getId() {
			return id;
	}

	public void setId(String id) {
			this.id = id;
	}

  public String getNombre() {
      return _nombre;
  }

  public void setNombre(String nombre) {
      this._nombre = nombre;
  }

	public String getDominio() {
			return _dominio;
	}

	public void setDominio(String dominio) {
			this._dominio = dominio;
	}

  public Integer getLeft() {
      return _left;
  }

  public void setLeft(Integer left) {
      this._left = left;
  }

  public Integer getTop() {
      return _top;
  }

  public void setTop(Integer top) {
      this._top = top;
  }

	public Map<String, String> getAtributos() {
	      return _atributos;
	  }

	public void setAtributos(Map<String, String> params) {
	    this._atributos = params;
	}

	@Override
	public String toString() {
	    return " \n ElementoPost{" + " _nombre=" + _nombre + " _dominio=" + _dominio+", _left=" + _left + ", _top=" + _top + ", atributos=" + this._atributos + "} \n";
	}

  public Elemento_m getElemToMap(Estructura e){
			System.out.println(" ");System.out.println(" ");System.out.println(" ");
			System.out.println("new map: ");

			String key;
      Map <String, Integer> aux_M;
      Estructura_Elemento aux_Ee;
      aux_M = new HashMap<>();
      aux_Ee = e.getEstructuraElemento(this._dominio);
			//System.out.println("dom: " + this._atributos.get('dominio'));
			//System.out.println("Formato Elemento: " );
			//System.out.println(aux_Ee);

    	//System.out.println("cargó left y top... ");
      aux_M.put("left", this._left);
      aux_M.put("top", this._top);
			//System.out.println("No tengo el dominio como atributo dentro del mapa");
			// dominio

			for (Map.Entry<String, String> entrySet : this._atributos.entrySet()) {
			  key = entrySet.getKey();
			  aux_M.put(key, aux_Ee.getCodigoValue(key, entrySet.getValue()));
			}
			//System.out.println("cargó att 1 y 2... ");

			//System.out.println("MAPA GENERADO PARA ELEMENTO_M : ");
			//System.out.println(aux_M);
      return new Elemento_m(aux_M, this._nombre);
  }

}
