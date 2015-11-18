package exTeoricas;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorPar<T> implements Iterator <T> // Cria o iterador adequado para a classe Par
{
    int counter=0;
    Par<T> par;
    
    IteratorPar( Par<T> p) 
    {
        par=p;
    }
    
    @Override
    public boolean hasNext()
    {
        return counter!=2;
    }
    
    @Override
    public T next()
    {    
        switch(counter++)
        {
            case 0: 
                return par.p1;
            case 1: 
                return par.p2;
            default: 
                throw new NoSuchElementException();
        }
    }
    
    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}