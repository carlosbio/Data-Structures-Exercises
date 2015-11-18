package ficha04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DezReais implements Iterable <Double>   // A implementação da interface Iterable indica a existência do método "fábrica"
{
    public static final int max = 10;
    Double[] numeros;
    private int index = 0;    

    public DezReais()   // Construtor
    {
        numeros = new Double[max];
    }
    
    public DezReais add(Double n)   // Adiciona um número
    {
        if(!canAdd())   // Gera excepeção caso se insira números para além do limite
            throw new IllegalStateException();
      
        numeros[index++] = n; // Adiciona ao array e incrementa o índice do array
        
        return this;        // Devolve este objecto
    }
    
    public boolean canAdd() // Método auxiliar que verifica a capacidade do array
    {
        return index < max; // Devolve true enquanto a capacidade não for atingida
    } 
    
    @Override
    public Iterator<Double> iterator()  // Método que devolve um iterador para esta classe
    {
        return new DezReaisIterator();
    }

    public class DezReaisIterator implements Iterator<Double>   // Método que cria um iterador para esta classe
    {
        private int position = 0;   // Guarda a posição actual do iterador

        @Override
        public boolean hasNext()    // Override do método hasNext
        {
            return position < index;    // Enquanto a posição actual do iterador não tiver atingido o limite máximo
        }

        @Override
        public Double next()    // Override do método next
        {
            if (position > index)   // Caso a posição do iterador ultrapasse o limite máximo       
                throw new NoSuchElementException();            

            return numeros[position++];   // Devolve o valor na posição actual do array e incrementa a posição actual do iterador
        }

        @Override
        public void remove()    // Override do método remove
        {
            throw new UnsupportedOperationException("This iterator does not support the remove() method");
        }
    }
}