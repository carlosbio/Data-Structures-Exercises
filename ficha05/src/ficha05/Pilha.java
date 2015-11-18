package ficha05;

import java.util.EmptyStackException;
import java.util.List;

public class Pilha<T>   // Exercício 3, alínea a)
{
    private final List<T> list;

    public Pilha(final List<T> li) 
    {
        this.list = li;
    }

    public void push(T item)
    {
        list.add(item);
    }

    public T pop() 
    {
        if (!empty())
            return list.remove(size()-1);
        else
            throw new EmptyStackException();
    }

    public boolean empty() 
    {
        return (list.isEmpty());
    }

    public T peek() 
    {
        if (!empty())
            return list.get(size()-1);
        else
            throw new EmptyStackException();
    }

    public int size() 
    {
        return list.size();
    }

    @Override
    public String toString()
    {
        return "Pilha: " + list.toString();
    }
}