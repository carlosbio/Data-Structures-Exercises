package ficha03;

public abstract class Figura implements Comparable<Figura>
{
    public abstract int getArea();

    @Override
    public int compareTo(final Figura figura) 
    {
        if(this.getArea() == figura.getArea())
            return 1;
        else
            return 0;
    }
}