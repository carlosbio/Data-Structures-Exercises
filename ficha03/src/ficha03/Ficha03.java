package ficha03;

public class Ficha03
{   
    public static <T> boolean procuraRepetido(T[] a, T e)  // Exercício 1
    {
        int flag=0;
        
        for(T i:a)     
            if(i==e)
                flag++; // Incrementa caso encontre um valor igual   
        
        return flag>1;  // Devolve true caso a flag seja maior que 1
    }
    
    public static <T> boolean procuraRepetido2(T[] a, Comparable <? super T> e)  // Exercício 2
    {
        int flag=0;
        
        for(T i:a)        
            if(e.compareTo(i)==0)
                flag++; // Incrementa caso encontre um valor igual    
        
        return flag>1;  // Devolve true caso a flag seja maior que 1
    }
    
    public static int compara1(Figura f1, Figura f2)  // Exercício 3, alínea a)
    {
        return f1.compareTo(f2);
    }
    
    public static int compara2(Rectangulo r, Comparable<? super Rectangulo> c)  // Exercício 3, alínea b)
    {
        return c.compareTo(r);
    }
    
    public static <T> int compara3(Comparable<? super T>c, T o)    // Exercício 3, alínea c)
    {
        return c.compareTo(o);
    }
    
    public static <T> boolean search(T [] a, Comparable <? super T> e)
    {         
        for(T i : a)        
            if (e.compareTo(i) <= 0)             
                return true;

        return false;
    }
    
    public static void main(String[] args)
    {
        // --- Exercício 1 ---
        
        //String[] s={"Carlos","Zeca","Andreia","Manel","Chico","Zeca","Inês"};
        //Integer[] i={2,45,6,3,9,6,12,56,19};
       
        //System.out.println("Comparação por referência do valor repetido : "+procuraRepetido(s,"Zeca"));
        //System.out.println("Comparação por referência do valor repetido: "+procuraRepetido(i,6));
        
        // --- Exercício 2 ---
        
        //System.out.println("Comparação pelo compareTo do valor repetido: "+procuraRepetido2(s,"Zeca"));
        //System.out.println("Comparação pelo compareTo do valor repetido: "+procuraRepetido2(i,6));
        
        // --- Exercício 3 ---
        
        //final Rectangulo r1 = new Rectangulo(8, 14);
        //final Rectangulo r2 = new Rectangulo(6, 6);
        //final Quadrado q1 = new Quadrado(6);

        //System.out.println(compara1(r1, r1));
        //System.out.println(compara2(r1, q1));
        //System.out.println(compara3(q1, r2));
        
        // --- Exercício 4 ---

        //Ponto<Integer, Integer> p=new Ponto<Integer,Integer>(3,4);
        //Ponto<Number, Number> x=new Ponto<Number,Number>(0,0);
        
        //System.out.println(p); // Imprime (3,4)
        //System.out.println(x); // Imprime (0,0)
        
        //x.copy(p);
        
        //System.out.println(x); // Imprime (3,4)
        
        //Ponto<String, Integer> erro=new Ponto<String,Integer>("olá",3); // Erro de compilação
        
        // --- Exercício 5 ---
        
        Integer m[]={3,2,6,3};
        String n[]={"Ada", "Albino"};
        
        System.out.println(search(m,2)); // True
        System.out.println(search(n,"Francisco")); // False
    }   
}