package ficha05;

import java.util.LinkedList;
import java.util.List;

public class PilhaMelhorada<T>  // Exercício 3, alínea c)
{
    final List<T> list;

    PilhaMelhorada(final List<T> list) 
    {
        this.list = list;
    }

    public boolean empty() 
    {
        return list.isEmpty();
    }

    public T peek()
    {
        if (list instanceof LinkedList)        
            return ((LinkedList<T>) list).getLast();        
        else         
            return list.get(list.size() - 1);        
    }

    public void push(final T value)
    {
        if (list instanceof LinkedList) 
            ((LinkedList<T>) list).addLast(value);
        else 
            list.add(value);        
    }

    public T pop()
    {
        if (list instanceof LinkedList) 
            return ((LinkedList<T>) list).removeLast();
        else 
            return list.remove(list.size() - 1);        
    }
}