package exTeoricas;

import java.util.Iterator;

public class Par <T> implements Iterable <T>    // A implementação da interface Iterable indica a existência do método "fábrica"
{
    T p1,p2;

    @Override
    public Iterator<T> iterator()   // Método "fábrica" que devolve um iterador adequado
    {
        return new IteratorPar<>(this);
    }
    
    public <T> boolean procura(Iterable<T> m, T o)  // Método procura
    {
        Iterator<T> it=m.iterator();
        
        boolean proximo=it.hasNext();
        
        while(proximo)
        {
            if(it.next()==o)    // Compara referência, não conteúdo
                return true;
            
            proximo=it.hasNext();
        }
        
        return false;
    }

    public Par(T p1, T p2)  // Construtor
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public T getP1()        // Getter
    {
        return p1;
    }

    public void setP1(T p1) // Setter   
    {
        this.p1 = p1;
    }

    public T getP2()        // Getter
    {
        return p2;
    }

    public void setP2(T p2) // Setter
    {
        this.p2 = p2;
    }

    @Override
    public String toString()
    {
        return "Par{" + "p1=" + p1 + ", p2=" + p2 + '}';
    }
}