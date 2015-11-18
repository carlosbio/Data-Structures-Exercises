package ficha03;

public class Ponto <T extends Number, S extends Number> // Alínea 4
{
    T x;
    S y;

    public Ponto(T x, S y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public S getY() {
        return y;
    }

    public void setY(S y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Ponto{" + "x=" + x + ", y=" + y + '}';
    }
    
    public void copy (Ponto <? extends T,? extends S> p)
    {
        x=p.x;
        y=p.y;
    }
}