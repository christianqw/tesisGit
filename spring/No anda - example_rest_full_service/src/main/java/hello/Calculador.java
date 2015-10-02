package hello;

public class Calculador {

    private final long id;
    private final int val1;
    private final int val2;

    public Calculador(long id, int val1, int val2) {
        this.id = id;
        this.val1 = val1;
        this.val2 = val2;
    }

    public long getId() {
        return id;
    }

    public int getVal1() {
        return val1;
    }

    public int getVal2(){
        return val2;
    }

    public int calcular(){
      return (val1 + val2);
    }
}
