package ficha03;

public class Quadrado implements Comparable<Rectangulo>
{
    private final int lado;

    public Quadrado(int l)
    {
        this.lado = l;
    }

    public int getLado() 
    {
        return lado;
    }

    public int getArea()
    {
        return lado * lado;
    }

    @Override
    public int compareTo(Rectangulo o)
    {
        if(this.getArea() == o.getArea())
            return 1;
        else
            return 0;
    }
}