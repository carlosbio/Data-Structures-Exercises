package ficha04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ficha04 
{
    public static Double max(Iterable<Double> values)   // Exercício 7
    {
        Double max = null;
        final Iterator<Double> it = values.iterator();  // Cria o iterador para o elemento recebido
        
        while(it.hasNext()) // Enquanto houver próximo
        {
            Double value = it.next();   // Itera para o próximo valor
            
            if(max==null)
                max=value;      // Inicializa max com o primeiro valor            
            else if (value > max)
                max = value;    // Se for maior que o max, substitui           
        }

        return max; // Devolve max
    }
    
    public static <T extends Comparable<? super T>> T maxGeneric(Iterable<T> values)    // Exercício 8
    {
        T max = null;
        final Iterator<T> it = values.iterator();   // Cria o iterador para o elemento recebido

        while(it.hasNext()) // Enquanto houver próximo
        {
            T value = it.next();    // Itera para o próximo valor
            
            if (max == null)            
                max = value;    // Inicializa max com o primeiro valor        
            else if (value.compareTo(max) > 0)                 
                max = value;    // Se for maior que o max, substitui        
        }

        return max; // Devolve max
    }

    public static void main(String[] args)
    {
        DezReais contentor = new DezReais();
        DezReaisMutavel cesto = new DezReaisMutavel();
        final List<Double> list = new ArrayList<>();
        
        Double um = 1.0;
        Double dois = -2.0;
        Double tres = -3.0;
        Double quatro = 4.0;
        Double cinco = 5.0;
        Double seis = -6.0;
        Double sete = 7.0;
        Double oito = -8.0;
        Double nove = -9.0;
        Double dez = -10.0;
        
        contentor.add(um);
        contentor.add(dois);
        contentor.add(tres);
        contentor.add(quatro);
        contentor.add(cinco);
        contentor.add(seis);
        contentor.add(sete);
        contentor.add(oito);
        contentor.add(nove);
        contentor.add(dez);
        
        cesto.add(um);
        cesto.add(dois);
        cesto.add(tres);
        cesto.add(quatro);
        cesto.add(cinco);
        cesto.add(seis);
        cesto.add(sete);
        cesto.add(oito);
        cesto.add(nove);
        cesto.add(dez);
        
        list.add(um);
        list.add(dois);
        list.add(tres);
        list.add(quatro);
        list.add(cinco);
        list.add(seis);
        list.add(sete);
        list.add(oito);
        list.add(nove);
        list.add(dez);
        
//        Iterator i = contentor.iterator();
//
//        while(i.hasNext())
//            System.out.print("["+i.next()+"]");
//        
//        System.out.println("\n");
//        
        Iterator j = cesto.iterator();

        while(j.hasNext())
            System.out.print("["+j.next()+"]");
        
        System.out.println("\n");

        j = cesto.iterator();
        
        while (j.hasNext()) 
        {
            Double db = (Double) j.next();

            j.remove();            
        }
        
        j = cesto.iterator();
            
        while(j.hasNext())
            System.out.print("["+j.next()+"]");
        
        System.out.println("\n");
        
//        for(Double d : list)
//            System.out.print("["+d+"]");
//        
//        System.out.println("\n");
        
//        System.out.println(max(contentor));
//        System.out.println(max(cesto));
//        System.out.println(max(list));
//        
//        System.out.println(maxGeneric(contentor));
//        System.out.println(maxGeneric(cesto));
//        System.out.println(maxGeneric(list));
    }   
}