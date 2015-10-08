package server;

public class Elemento {

	private String id;
  private String nombre;
	private String img;
	private Integer left;
  private Integer top;

  private String att1;
  private String att2;

  public String getId() {
      return id;
  }

  public void setId(String id) {
      this.id = id;
  }

  public String getNombre() {
      return nombre;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public String getImg() {
      return img;
  }

  public void setImg(String img) {
      this.img = img;
  }

  public Integer getLeft() {
      return left;
  }

  public void setLeft(Integer left) {
      this.left = left;
  }

  public Integer getTop() {
      return top;
  }

  public void setTop(Integer top) {
      this.top = top;
  }

  public String getAtt1() {
      return att1;
  }

  public void setAtt1(String att1) {
      this.att1 = att1;
  }

  public String getAtt2() {
      return att2;
  }

  public void setAtt2(String att2) {
      this.att2 = att2;
  }
  

}
