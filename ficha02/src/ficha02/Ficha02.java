package ficha02;

import java.util.Random;
import java.util.Arrays;

public class Ficha02
{
    static int[] criaArrayCom(int valor, int dimensao, boolean diferentes)  // Alínea 1
    {
        int array[] = new int[dimensao];
                
        array[0]=valor; // Atribui o valor indicado na primeira posição

        for(int i=1;i<dimensao;) // Itera pelo array a partir da segunda posição
        {
            Random rand = new Random(); // Inicialização do gerador                
            int randomNum = rand.nextInt(30 - 1 + 1) + 1; // Geração de um valor entre 1 e 10
            boolean flag=false; // Flag de repetição a falso

            for(int j=0;j<i;j++)    // Itera pelo array desde o início
                if(array[j]==randomNum) // Se encontra um valor igual ao gerado
                    flag=true;  // Marca a flag a verdadeiro

            if(diferentes==true&&flag==false) // Se a flag de repetido estiver a falso e diferentes a true
            {
                array[i]=randomNum; // Atribui valor
                i++;    // Incrementa i
            }
            else if(diferentes==false)
            {
                array[i]=randomNum; // Atribui valor
                i++;    // Incrementa i
            }
        }

        Arrays.sort(array); // Ordena
        
        return array;
    }
    
    static int[] criaArraySem(int valor, int dimensao, boolean diferentes)  // Alínea 2
    {
        int array[] = new int[dimensao];
        
        for(int i=0;i<dimensao;) // Itera pelo array a partir da segunda posição
        {
            Random rand = new Random(); // Inicialização do gerador                
            int randomNum = rand.nextInt(30 - 1 + 1) + 1; // Geração de um valor entre 1 e 10
            boolean flag=false; // Flag de repetição a falso

            for(int j=0;j<i;j++)    // Itera pelo array desde o início
                if(array[j]==randomNum||valor==randomNum) // Se encontra um valor igual ao gerado
                    flag=true;  // Marca a flag a verdadeiro

            if(diferentes==true && flag==false) // Se a flag de repetido estiver a falso e diferentes a true
            {
                array[i]=randomNum; // Atribui valor
                i++;    // Incrementa i
            }
            else if(diferentes==false && valor!=randomNum)
            {
                array[i]=randomNum; // Atribui valor
                i++;    // Incrementa i
            }
        }

        Arrays.sort(array); // Ordena
        
        return array;
    }
    
    static void mostraArray(int a[])
    {
        for(int i=0;i<a.length;i++)
            System.out.print("a["+i+"]="+a[i]+"  ");
    }
    
    static boolean pesquisaBinRec(int[] a, int valor)   // Alínea 3 - Método de pesquisa binária recursiva que recebe o array e o valor a pesquisar
    {
        return pesquisaBinRec(a, 0, a.length-1, valor);    // Devolve  chamada ao método de pesquisa binária recursiva
    }

    static boolean pesquisaBinRec(int[] a, int inicio, int fim, int valor)  // Alínea 3 - Método de pesquisa binária recursiva
    {
        int meio = (inicio + fim) / 2;  // Determina a posição do meio do array
    
        if(fim < inicio)    // Caso o fim seja menor que o inicio
            return false;

        if(valor==a[meio])  // Se estiver no meio
            return true;
        else if(valor<a[meio])  // Se for inferior ao meio
            return pesquisaBinRec(a, inicio, meio - 1, valor);
        else    // Se for superior ao meio
            return pesquisaBinRec(a, meio + 1, fim, valor);
    }
    
    static boolean pesquisaBinIte(int a[], int valor)   // Alínea 4 - Método de pesquisa binária iterativa 
    {   
        int inicio=0,fim=a.length-1;
        
        while (inicio <= fim)   // Enquanto o inicio for menor ou igual que o fim
        {    
            int meio = (inicio + fim) / 2;  // Elemento do meio

            if (valor < a[meio])        // Caso a chave esteja na metade esquerda
                fim = meio - 1;         // Actualiza o fim   
            else if (valor > a[meio])   // Caso a chave esteja na metade direita
                inicio = meio + 1;      // Actualiza o inicio
            else  
                return true;    // O valor existe
        }  
 
        return false;  // O valor não existe
    }
    
    static int pesquisaBinPos(int a[], int valor)   // Alínea 5 - Método de pesquisa binária iterativa 
    {   
        int inicio=0,fim=a.length-1;    // Inicializa com as posições de inicio e fim
        
        while (inicio <= fim)   // Enquanto o inicio for menor ou igual que o fim
        {    
            int meio = (inicio + fim) / 2;  // Elemento do meio

            if (valor < a[meio])        // Caso a chave esteja na metade esquerda
                fim = meio - 1;         // Actualiza o fim   
            else if (valor > a[meio])   // Caso a chave esteja na metade direita
                inicio = meio + 1;      // Actualiza o inicio
            else  
                return meio;    // O valor existe e devolve a sua posição no array
        }  
 
        return -1;  // O valor não existe
    }
    
    static int pesquisaBinDesloc(int a[], int valor)   // Alínea 6 - Método de pesquisa binária iterativa 
    {   
        int inicio=0,fim=a.length-1;
        
        while (inicio <= fim)   // Enquanto o inicio for menor que o fim
        {    
            int meio = (inicio + fim) / 2;  // Elemento do meio

            if (valor < a[meio])        // Caso a chave esteja na metade esquerda
                fim = meio - 1;         // Actualiza o fim   
            else if (valor > a[meio])   // Caso a chave esteja na metade direita
                inicio = meio + 1;      // Actualiza o inicio
            else  
                return meio;    // O valor existe e devolve a sua posição no array
        }  
 
        return (inicio+1)*(-1);  // O valor não existe e devolve a posição prevista
    }
    
    static double pesquisaBinPercent(int a[], int valor)   // Alínea 7 
    {   
        int inicio=0,fim=a.length-1;
        
        while (inicio <= fim)   // Enquanto o inicio for menor que o fim
        {    
            int meio = (inicio + fim) / 2;  // Elemento do meio

            if (valor < a[meio])        // Caso a chave esteja na metade esquerda
                fim = meio - 1;         // Actualiza o fim   
            else if (valor > a[meio])   // Caso a chave esteja na metade direita
                inicio = meio + 1;      // Actualiza o inicio
            else
                return (double)meio/a.length;   // Existindo, divide a posição deste pelo tamanho do array
        }

        return (double)inicio/a.length; // Não existindo, divide a posição inicial prevista pelo tamanho do array
    }
    
    static int pesquisaBinInterv(int a[], int min, int max)   // Alínea 8 
    {   
        int inicio=0,fim=a.length-1,meio;
        int int1=0,int2=0;
        boolean flag1=false,flag2=false;
        
        while (inicio <= fim)   // Enquanto o inicio for menor que o fim (ciclo que procura o início do intervalo)
        {    
            meio = (inicio + fim) / 2;  // Elemento do meio

            if (min < a[meio])      // Caso o valor esteja na metade esquerda
                fim = meio - 1;     // Actualiza o fim   
            else if (min > a[meio]) // Caso o valor esteja na metade direita
                inicio = meio + 1;  // Actualiza o inicio
            else
            {
                int1=meio+1;        // Guarda o valor do início do intervalo e soma 1  (exclui o próprio)
                flag1=true;         // Marca a flag de validação a true
                break;              // Sai do ciclo
            }
        }
        
        if(flag1==false)    // Caso a flag não tiver sigo marcada
            int1=inicio+1;  // Não existindo, o inicio do intervalo será o valor previsto e soma 1  (exclui o próprio)
        
        inicio=0;       // Reset
        fim=a.length-1; // Reset
        
        while (inicio <= fim)   // Enquanto o inicio for menor que o fim (ciclo de determina o fim do intervalo)
        {    
            meio = (inicio + fim) / 2;  // Elemento do meio

            if (max < a[meio])      // Caso a chave esteja na metade esquerda
                fim = meio - 1;     // Actualiza o fim   
            else if (max > a[meio]) // Caso a chave esteja na metade direita
                inicio = meio + 1;  // Actualiza o inicio
            else
            {
                int2=meio+1;        // Guarda o valor da posição do fim do intervalo e soma 1  (exclui o próprio)
                flag2=true;         // Marca a flag de validação
                break;              // Sai do ciclo
            }
        }
        
        if(flag2==false)    // Caso a flag de validação não tiver sido marcada
            int2=inicio;    // Não existindo, o fim do intervalo será o valor previsto
        
        return int2-int1+1; // Devolve o nº de elementos dentro do intervalo
    }
    
    static boolean pesquisaBinRep(int a[], int valor)   // Alínea 9 - Método de pesquisa binária iterativa 
    {   
        int inicio=0,fim=a.length-1;
        
        while (inicio <= fim)   // Enquanto o inicio for menor que o fim
        {            
            int meio = (inicio + fim) / 2;  // Elemento do meio

            if (valor < a[meio])        // Caso a chave esteja na metade esquerda
                fim = meio - 1;         // Actualiza o fim   
            else if (valor > a[meio])   // Caso a chave esteja na metade direita
                inicio = meio + 1;      // Actualiza o inicio
            else
            {                
                if(meio==0&&a[meio+1]==a[meio]) // Se o valor estiver na primeira posição e o valor à direita for igual
                    return true;
                else if(meio==a.length-1&&a[meio-1]==a[meio]) // Se valor estiver na ultima posição e o valor à esquerda for igual
                    return true;
                else if(meio!=0&&meio!=a.length-1&&(a[meio+1]==a[meio]||a[meio-1]==a[meio])) // Se o valor não estiver nos extremos e algum dos vizinhos for igual
                    return true;
                else
                    return false;
            }
        } 
        
        return false;
    }
    
    static int pesquisaBinInf(int a[], int valor)   // Alínea 10 - Método de pesquisa binária iterativa 
    {   
        int inicio=0,fim=a.length-1;
        
        while (inicio <= fim)   // Enquanto o inicio for menor que o fim
        {            
            int meio = (inicio + fim) / 2;  // Elemento do meio

            if (valor < a[meio])        // Caso a chave esteja na metade esquerda
                fim = meio - 1;         // Actualiza o fim   
            else if (valor > a[meio])   // Caso a chave esteja na metade direita
                inicio = meio + 1;      // Actualiza o inicio
            else
            {                
                if(meio==0)
                    return a[meio];
                else
                    return a[meio-1];
            }
        }
        
        if(inicio==0&&a[inicio]==valor)        
            return a[inicio];
        else if(inicio==0&&a[inicio]!=valor)
            return valor;
        else
            return a[inicio-1];
    }
    
    static boolean pesquisaBinNeg(int a[], int valor)   // Alínea 11 - Método de pesquisa binária iterativa 
    {   
        int inicio=0,fim=a.length-1;
        
        while (inicio <= fim)   // Enquanto o inicio for menor que o fim
        {    
            int meio = (inicio + fim) / 2;  // Elemento do meio

            if(valor<0&&a[meio]<0)          // Se o valor a pesquisar e o meio forem negativos
            {
                if (valor < a[meio])        // Caso a chave esteja na metade esquerda
                    fim = meio - 1;         // Actualiza o fim   
                else if (valor > a[meio])   // Caso a chave esteja na metade direita
                    inicio = meio + 1;      // Actualiza o inicio
                else  
                    return true;            // O valor existe  
            }
            else if(valor>=0&&a[meio]<0)    // Se o valor a pesquisar é positivo e o meio é negativo
                fim = meio - 1;             // Actualiza o fim 
            else if(valor<0&&a[meio]>=0)    // Se o valor a pesquisar é negativo eo meio é positivo
                inicio = meio + 1;          // Actualiza o inicio
            else                            // Se o valor a pesquisar e o meio forem positivos
            {
                if (valor < a[meio])        // Caso a chave esteja na metade esquerda
                    fim = meio - 1;         // Actualiza o fim   
                else if (valor > a[meio])   // Caso a chave esteja na metade direita
                    inicio = meio + 1;      // Actualiza o inicio
                else  
                    return true;    // O valor existe
            }
        }  
 
        return false;  // O valor não existe
    }
    
    static int pesquisaBinInd(int a[])   // Alínea 12 - Método de pesquisa binária iterativa 
    {   
        int inicio=0,fim=a.length-1;    // Inicializa com as posições de inicio e fim
        
        while (inicio <= fim)   // Enquanto o inicio for menor ou igual que o fim
        {    
            int meio = (inicio + fim) / 2;          // Elemento do meio

            if (meio < a[meio])                     // Caso o valor seja superior ao valor índice
            {
                if(meio>0&&((meio-1)<(a[meio-1])))  // Caso o valor na posição inferior seja superior ao valor do índice inferior
                    fim = meio - 1;                 // Actualiza o fim   
                else
                    return meio;                    // Senão, devolve o valor do índice actual (primeira ocorrência)
            }
            else if (meio >= a[meio])               // Caso a chave esteja na metade direita
                inicio = meio + 1;                  // Actualiza o inicio
        }  
 
        return -1;  // O valor não existe
    }
    
    public static void main(String[] args) 
    {
        //int vector[] = criaArraySem(12,10,true);
        
        //mostraArray(vector);
        
        //System.out.print("\n\nResultado da pesquisa recursiva: "+pesquisaBinRec(vector,13)+"\n\n");
        
        //System.out.print("\n\nResultado da pesquisa iterativa: "+pesquisaBinIte(vector,13)+"\n\n");
        
        //System.out.print("\n\nResultado da pesquisa binária (posição do valor 6): "+pesquisaBinPos(vector,6)+"\n\n");
        
        //System.out.print("\n\nResultado da pesquisa binária (deslocamento do valor 6): "+pesquisaBinDesloc(vector,6)+"\n\n");
        
        //System.out.print("\n\nResultado da pesquisa binária (% valores inferiores a 12): "+pesquisaBinPercent(vector,12)+"\n\n");
        
        //System.out.print("\n\nResultado da pesquisa binária (nº valores entre [5,15]): "+pesquisaBinInterv(vector,5,15)+"\n\n");
        
        //System.out.print("\n\nResultado da pesquisa binária (verificar se o valor 6 está repetido): "+pesquisaBinRep(vector,6)+"\n\n");
         
        //System.out.print("\n\nResultado da pesquisa binária (maior valor inferior a 12): "+pesquisaBinInf(vector,12)+"\n\n");

        //int temp[] = {3,6,8,-10,-3,-2,-1};        
        //mostraArray(temp); 
        //System.out.print("\n\nResultado da pesquisa binária: "+pesquisaBinNeg(temp,6)+"\n\n");
        
        int temp[] = {3,7,12,15};        
        mostraArray(temp); 
        System.out.print("\nResultado da pesquisa binária: "+pesquisaBinInd(temp)+"\n\n");
        
        int temp2[] = {-3,1,7,12,15};        
        mostraArray(temp2); 
        System.out.print("\nResultado da pesquisa binária: "+pesquisaBinInd(temp2)+"\n\n");
        
        int temp3[] = {-15,-14,1,2,3,4};        
        mostraArray(temp3); 
        System.out.print("\nResultado da pesquisa binária: "+pesquisaBinInd(temp3)+"\n\n");
    }   
}