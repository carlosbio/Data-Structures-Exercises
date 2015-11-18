package ficha01;

import java.util.Random;
import java.util.Arrays;

public class ArrayOrdenado 
{
    private final int [] a = new int[10];
    
    public ArrayOrdenado()
    {
        criaArray();
    }
    
    private void criaArray()
    {
        for(int i=0;i<a.length;)
        {
            Random rand = new Random(); // Inicialização do gerador                
            //int randomNum = rand.nextInt(100 - 1 + 1) + 1; // Geração de um valor entre 1 e 100
            int randomNum = rand.nextInt(20); // Geração de um valor entre 0 e 20
            boolean flag=false; // Flag de repetição a falso

            for(int j=0;j<i;j++)    // Itera pelo array desde o início
                if(a[j]==randomNum) // Se encontra um valor igual ao gerado
                    flag=true;      // Marca a flag a verdadeiro

            if(flag==false) // Se a flag de repetido estiver a falso
            {
                a[i]=randomNum; // Atribui valor
                i++;    // Incrementa i
            }
        }        
        
        Arrays.sort(a); // Ordena
    }
    
    public boolean procuraValor(int i)
    {
        if(i<a.length && i>=0 && a[i]==i)
            return true;
        
        return false;
    }

    @Override
    public String toString() 
    {
        String out="Array: ";
        
        for(int i=0;i<a.length;i++)
            out+="["+a[i]+"]";
        
        return out;
    }
}