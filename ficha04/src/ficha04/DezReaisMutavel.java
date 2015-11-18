package ficha04;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DezReaisMutavel implements Iterable<Double> {

    public static final int max = 10;

    private final Double[] numeros;
    private int index = 0;
    private int alteracoes = 0;

    public DezReaisMutavel()    // Construtor
    {
        numeros = new Double[max];
    }

    public DezReaisMutavel add(final Double value)  // Adiciona um número
    {
        if (!canAdd())  // Verifica se pode adicionar      
            throw new IllegalStateException();
     
        numeros[index++] = value;   // Adiciona e incrementa contador
        alteracoes++;   // Incrementa o contador de alterações

        return this;    // Devolve este objecto
    }

    private void remove(final int position) // Remove um número na posição desejada
    {
        if (position < 0 || position > index)   // Verifica validade da posição      
            throw new IllegalArgumentException();
        
        for (int i = position; i < this.index; i++) // Desloca os números que estão à frente da posição
            numeros[i] = numeros[i + 1];        

        index--;        // Decrementa o contador de números
        alteracoes++;   // Incrementa o contador de alterações
    }

    public boolean canAdd() // Método auxiliar que verifica se é possível adicionar mais números ao array
    {
        return index < max; // Devolve true se a capacidade máxima não foi atingida
    }

    @Override
    public Iterator<Double> iterator()  // Método que devolve um iterador para esta classe
    {
        return new DezReaisMutavelIterator();
    }

    public class DezReaisMutavelIterator implements Iterator<Double>    // Método que cria um iterador para esta classe
    {
        protected int position = 0;
        protected int lastChanges;
        protected boolean hasRemoved = false;

        public DezReaisMutavelIterator()    // Construtor;
        {
            lastChanges = alteracoes;   // Inicializa com as alterações efectuadas
        }

        @Override
        public boolean hasNext()    // Override do método hasNext
        {
            return position < index;    // Verifica se a posição máxima foi atingida
        }

        @Override
        public Double next()    // Override do método next
        {
            if (lastChanges != alteracoes)  // Verifica se houve alteração externa do contentor de dados
                throw new ConcurrentModificationException();            

            if (position < max) // Se a posição for inferior ao limite
            {
                hasRemoved = false; // Marca a flag de alterações a false
                
                if (position > index)   // Caso a posição ultrapasse o index actual
                    throw new NoSuchElementException();
                
                return numeros[position++]; // Devolve o valor na posição actual
            }

            throw new NoSuchElementException();
        }

        @Override
        public void remove()    // Override do método remove
        {
            if (hasRemoved) // Lança excepção se houve remoção
                throw new IllegalStateException();            

            if (lastChanges != alteracoes)  // Lança excepção se houve remoção externa
                throw new ConcurrentModificationException();            

            if (position < 0)   // Lança excepção se a posição for inválida
                throw new IllegalStateException();            

            DezReaisMutavel.this.remove(position);  // Remove o valor na posição actual
            
            position--;         // Decrementa a posição
            lastChanges++;      // Incrementa o contador de alterações
            hasRemoved = true;  // Marca a true a flag de remoção

            throw new UnsupportedOperationException("Este iterador não suporta o método remove()");
        }
    }

    public class DezReaisMutavelPositivosIterator extends DezReaisMutavelIterator   // Iterador alternativo que percorre apenas os elementos positivos
    {
        private static final int NOT_FOUND = -1;

        @Override
        public boolean hasNext()
        {
            return getNext() != NOT_FOUND;
        }
        
        @Override
        public Double next() 
        {
            if (lastChanges != alteracoes) 
                throw new ConcurrentModificationException();
            
            if (position < max)
            {
                position = getNext();
                        
                if (position == NOT_FOUND) 
                    throw new NoSuchElementException();
                
                return numeros[position++];
            }

            throw new NoSuchElementException();
        }

        private int getNext() 
        {
            for (int i = position; i < index; i++)            
                if (numeros[i] > 0)                 
                    return i;           

            return NOT_FOUND;
        }
    }
}