package serverPackages;

import generadoresPackge.Estructura;
import generadoresPackge.Estructura_Elemento;
import java.util.HashMap;
import java.util.Map;
import modeladoPackge.Elemento_m;

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

  
  public Elemento_m getElemToMap(Estructura e){
      Map <String, Integer> aux_M;
      Estructura_Elemento aux_Ee;
      aux_M = new HashMap<>();
      aux_Ee = e.getEstructuraElemento(this._dominio);
      
      aux_M.put("Tipo", aux_Ee.getCodigoValue("Tipo", this._tipo));
      aux_M.put("Zona", aux_Ee.getCodigoValue("Zona", this._zona));
      aux_M.put("Tipo", this._left);
      aux_M.put("Tipo", this._top);
      aux_M.put("Att1", aux_Ee.getCodigoValue("Att1", this._att1));
      aux_M.put("Att2", aux_Ee.getCodigoValue("Att2", this._att2));
      
      return new Elemento_m(aux_M, this._nombre);
  }
}
