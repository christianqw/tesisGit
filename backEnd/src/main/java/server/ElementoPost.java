package server;

//import generadoresPackge.Estructura;
//import generadoresPackge.Estructura_Elemento;
import java.util.HashMap;
import java.util.Map;
//import modeladoPackge.Elemento_m;

public class ElementoPost {

    //Atributos no comparables:
	private String _id;
  private String _img;
  private String _nombre;


  //Atributos Generalizados o Por defecto:
  private String _dominio;
  private String _tipo;
	private String _zona;

	private Integer _left;
  private Integer _top;

  //Atributos Personalizables:
  private String _att1;
  private String _att2;

  /*
  Se realizan los get and set de los atributos para realizar la contruccion
  automatica del objeto dentro del Wrapper.
  */
  public String getId() {
      return _id;
  }

  public void setId(String id) {
      this._id = id;
  }

  public String getTipo() {
      return _tipo;
  }

  public void setTipo(String t) {
      this._tipo = t;
  }

  public String getDominio() {
		  return _dominio;
	}

	public void setDominio(String d) {
			this._dominio = d;
	}

  public String getNombre() {
      return _nombre;
  }

  public void setNombre(String nombre) {
      this._nombre = nombre;
  }

  public String getZona() {
      return _zona;
  }

  public void setZona(String z) {
      this._zona = z;
  }

  public String getImg() {
      return _img;
  }

  public void setImg(String img) {
      this._img = img;
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

  public String getAtt1() {
      return _att1;
  }

  public void setAtt1(String att1) {
      this._att1 = att1;
  }

  public String getAtt2() {
      return _att2;
  }

  public void setAtt2(String att2) {
      this._att2 = att2;
  }
/*
  public Elemento_m getElemToMap(Estructura e){
      Map <String, Integer> aux_M;
      Estructura_Elemento aux_Ee;
      aux_M = new HashMap<>();
      aux_Ee = e.getEstructuraElemento(this._dominio);

      aux_M.put("tipo", aux_Ee.getCodigoValue("tipo", this._tipo));
      aux_M.put("zona", aux_Ee.getCodigoValue("zona", this._zona));
      //System.out.println("No tengo el dominio como atributo dentro del mapa");
      // dominio
      aux_M.put("left", this._left);
      aux_M.put("top", this._top);
      aux_M.put("att1", aux_Ee.getCodigoValue("att1", this._att1));
      aux_M.put("att2", aux_Ee.getCodigoValue("att2", this._att2));

      return new Elemento_m(aux_M, this._nombre);
  }
*/
    @Override
    public String toString() {
        return " \n ElementoPost{" + "_id=" + _id + ", _img=" + _img + ", _nombre=" + _nombre + ", _dominio=" + _dominio + ", _tipo=" + _tipo + ", _zona=" + _zona + ", _left=" + _left + ", _top=" + _top + ", _att1=" + _att1 + ", _att2=" + _att2 + "} \n";
    }

}
