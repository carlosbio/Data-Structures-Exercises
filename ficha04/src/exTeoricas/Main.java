package exTeoricas;

public class Main 
{    
    public static void main(String[] args)
    {
        Par <Integer> p = new Par <> (6,9);
        
        System.out.println("Resultado da procura: "+p.procura(p,6));
    }
}