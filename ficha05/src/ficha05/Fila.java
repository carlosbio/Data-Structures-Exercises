package ficha05;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class Fila<T>
{
    final List<T> list;

    Fila(final List<T> list) 
    {
        this.list = list;
    }
    
    public boolean empty() 
    {
        return list.isEmpty();
    }

    public void add(final T value)
    {
        if (list instanceof LinkedList) 
            ((LinkedList) list).addLast(value);
        else 
            list.add(value);        
    }

    public T remove() 
    { 
        if(!empty())
            if (list instanceof LinkedList)
                return ((LinkedList<T>) list).removeFirst();
            else        
                return  ((ArrayList<T>)list).remove(0); // <--- Resolver este problema!
        else
            throw new EmptyStackException();
    }

    public T element() 
    {
        if (list instanceof LinkedList)        
            return ((LinkedList<T>) list).getFirst();        
        else         
            return ((ArrayList<T>)list).get(0);
    }
}