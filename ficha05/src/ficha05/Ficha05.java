package ficha05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Ficha05
{ 
    public static <T> void CollectionsFill(List<T> list, T value)  // Exercício 1
    {       
        ListIterator<T> li = list.listIterator();   // Cria um iterador para a lista recebida

        while(li.hasNext()) // Enquanto houver próximo
        {
            li.next();      // Itera para o próximo valor
            li.set(value);  // Altera o valor actual pelo valor recebido
        }        
    }
    
    public static <T> void printReverse(List<T> list)   // Exercício 2
    {
        ListIterator<T> li = list.listIterator(list.size());    // Cria um iterador para da lista recebida e coloca-o no fim desta

        while(li.hasPrevious()) // Enquanto houver anterior
            System.out.print("["+li.previous()+"]");    // Itera para o próximo valor anterior e imprime
        
        System.out.println("\n");
    }
    
    public static final int PILHA_TAM = 1000000;
    
    public static void time(final Runnable r, final String operation) 
    {
        long start = System.nanoTime();

        r.run();

        long end = System.nanoTime();

        System.out.println("Tempo de execução da operação '" + operation + "': " + (end - start)+"\n");
    }
   
    public static <T> void CollectionsReverse(List<T> list) // Exercício 5
    {
        for(int i=0;i<list.size()/2;i++)    // Corre a list até meio
        {
            T first = list.get(i);                  // Guarda o valor à cabeça
            T last =  list.get(list.size()-i-1);    // Guarda o valor à cauda          
            
            list.set(i, last);                  // Atribui à cabeça o valor da cauda a cada iteração
            list.set(list.size()-i-1,first);    // Atribui à cauda o valor da cabeça a cada iteração
        }
    }
    
    public static <T> void removeParesConstante(final List<T> list)   // Exercício 6, alínea a)
    {
        int i = 0;
        
        final ListIterator<T> it = list.listIterator(); // Cria um iterador para a lista
        
        while(it.hasNext()) // Enquanto existir próximo
        {
            it.next();  // Passa para o próximo elemento
            i++;        // Incrementa o contador
            
            if (i%2 == 0)     // Se devolver resto zero, é par           
                it.remove();    // Remove elemento           
        }
    }

    public static <T> void removeParesLinear(final List<T> list)  // Exercício 6, alínea b)
    {
        int i = 1;
        int j = 2;
        
        for (; i < list.size() / 2; i++, j += 2)        
            list.set(i, list.get(j));        
    }

    public static void main(String[] args)
    {
        // --- Exercício 1 ---
        
        //List list = new ArrayList();    // Cria um array list
        
        //for (int i = 0; i < 10; i++)    // Popula o array list
        //  list.add("");        
        
        //CollectionsFill(list, "valor");
        
        //list.set(0,"um");    // Modifica o primeiro elemento
        //list.set(9,10);      // Modifica o último elemento
        
        //System.out.println(list);   // Mostra o array list

        // --- Exercício 2 ---
    
        //printReverse(list);
        
        // --- Exercício 3 ---
        
        // alínea a)
        
        //final Pilha alPilha = new Pilha(new ArrayList<Integer>(PILHA_TAM));
        //final Pilha llPilha = new Pilha(new LinkedList<Integer>());
        
        // alínea b)
        
//        System.out.println("--- Tempos para Pilha ---\n");
//        
//        time(new Runnable() 
//        {
//            @Override
//            public void run() 
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    alPilha.push(i);                
//            }
//        }, "Preencher Pilha ArrayList com " + PILHA_TAM + " elementos");
//        
//        time(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    llPilha.push(i);                
//            }
//        }, "Preencher Pilha LinkedList com " + PILHA_TAM + " elementos");
//        
//        time(new Runnable() 
//        {
//            @Override
//            public void run()
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    alPilha.peek();                
//            }
//        }, "Peek à Pilha ArrayList " + PILHA_TAM + " vezes");
//        
//        time(new Runnable()
//        {
//            @Override
//            public void run() 
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    llPilha.peek();                
//            }
//        }, "Peek à Pilha LinkedList " + PILHA_TAM + " vezes");
//        
//        time(new Runnable() 
//        {
//            @Override
//            public void run()
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    alPilha.pop();                
//            }
//        }, "Pop à Pilha ArrayList para " + PILHA_TAM + " elementos");
//        
//        time(new Runnable()
//        {
//            @Override
//            public void run() 
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    llPilha.pop();                
//            }
//        }, "Pop à Pilha LinkedList para " + PILHA_TAM + " elementos");
        
        // alínea c)
        
//        final PilhaMelhorada alPilhaM = new PilhaMelhorada(new ArrayList<Integer>(PILHA_TAM));
//        final PilhaMelhorada llPilhaM = new PilhaMelhorada(new LinkedList<Integer>());
//        
//        System.out.println("\n--- Tempos para PilhaMelhorada ---\n");
//        
//        time(new Runnable() 
//        {
//            @Override
//            public void run() 
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    alPilhaM.push(i);                
//            }
//        }, "Preencher PilhaMelhorada ArrayList com " + PILHA_TAM + " elementos");
//        
//        time(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    llPilhaM.push(i);                
//            }
//        }, "Preencher PilhaMelhorada LinkedList com " + PILHA_TAM + " elementos");
//        
//        time(new Runnable() 
//        {
//            @Override
//            public void run()
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    alPilhaM.peek();                
//            }
//        }, "Peek à PilhaMelhorada ArrayList " + PILHA_TAM + " vezes");
//        
//        time(new Runnable()
//        {
//            @Override
//            public void run() 
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    llPilhaM.peek();                
//            }
//        }, "Peek à PilhaMelhorada LinkedList " + PILHA_TAM + " vezes");
//        
//        time(new Runnable() 
//        {
//            @Override
//            public void run()
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    alPilhaM.pop();                
//            }
//        }, "Pop à PilhaMelhorada ArrayList para " + PILHA_TAM + " elementos");
//        
//        time(new Runnable()
//        {
//            @Override
//            public void run() 
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    llPilhaM.pop();                
//            }
//        }, "Pop à PilhaMelhorada LinkedList para " + PILHA_TAM + " elementos");
        
        // --- Exercício 4 ---
        
//        final Fila alFila = new Fila(new ArrayList<Integer>(PILHA_TAM));
//        final Fila llFila = new Fila(new LinkedList<Integer>());
//        
//        System.out.println("\n--- Tempos para Fila ---\n");
//        
//        time(new Runnable() 
//        {
//            @Override
//            public void run() 
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    alFila.add(i);                
//            }
//        }, "Preencher Fila ArrayList com " + PILHA_TAM + " elementos");
//        
//        time(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    llFila.add(i);                
//            }
//        }, "Preencher Fila LinkedList com " + PILHA_TAM + " elementos");
//        
//        time(new Runnable() 
//        {
//            @Override
//            public void run()
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    alFila.element();                
//            }
//        }, "Consultar Fila ArrayList para " + PILHA_TAM + " elementos");
//        
//        time(new Runnable()
//        {
//            @Override
//            public void run() 
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    llFila.element();                
//            }
//        }, "Consultar Fila LinkedList para " + PILHA_TAM + " elementos");
//        
//        time(new Runnable() 
//        {
//            @Override
//            public void run()
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    alFila.remove();                
//            }
//        }, "Remover elementos da Fila ArrayList " + PILHA_TAM + " vezes");
//        
//        time(new Runnable()
//        {
//            @Override
//            public void run() 
//            {
//                for(int i = 0; i < PILHA_TAM; i++) 
//                    llFila.remove();                
//            }
//        }, "Remover elementos da Fila LinkedList " + PILHA_TAM + " vezes");
        
        // --- Exercício 5 ---
        
//        List list = new LinkedList();    // Cria uma linked list
//        
//        for (int i = 0; i < 10; i++)    // Popula a linked list
//          list.add("");        
//        
//        list.set(0,1);
//        list.set(1,2);
//        list.set(2,3);
//        list.set(3,4);
//        list.set(4,5);
//        list.set(5,6);
//        list.set(6,7);
//        list.set(7,8);
//        list.set(8,9);
//        list.set(9,10);
//        
//        System.out.println(list);
//        
//        CollectionsReverse(list);   // Inverte a ordem da lista
//        
//        System.out.println(list);
        
        // --- Exercício 6 ---
        
        List list = new LinkedList();    // Cria uma linked list
        
        for (int i = 0; i < 10; i++)    // Popula a linked list
          list.add("");        
        
        list.set(0,1);
        list.set(1,2);
        list.set(2,3);
        list.set(3,4);
        list.set(4,5);
        list.set(5,6);
        list.set(6,7);
        list.set(7,8);
        list.set(8,9);
        list.set(9,10);
        
        System.out.println(list);
        
        removeParesLinear(list);   // Inverte a ordem da lista
        
        System.out.println(list);

    }   
}