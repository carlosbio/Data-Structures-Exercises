package ficha01;

import java.util.Arrays;
import java.util.Random;

public class Matriz
{
    private int [][]a = new int[3][3];
    
    Matriz()
    {
        criaMatriz();
    }
    
    private void criaMatriz()
    {        
        a[0][0] = 2;
        a[0][1] = 4;
        a[0][2] = 6;
        a[1][0] = 10;
        a[1][1] = 15;
        a[1][2] = 19;
        a[2][0] = 22;
        a[2][1] = 27;
        a[2][2] = 35;
        
        
        // -- Tentativa de implementação randomizada -----
        
//        for(int i=0;i<a.length;i++)
//        {
//            for(int j=0;j<a[i].length;)
//            {
//                Random rand = new Random(); // Inicialização do gerador                
//                int randomNum = rand.nextInt(40 - 1 + 1) + 1; // Geração de um valor entre 1 e 40
//                boolean flag=false; // Flag de repetição a falso
//
//                for(int k=0;k<=j;k++)       // Itera pelo array desde o início <-------------- FALTA A SEGUNDA ITERAÇÃO PARA PROCURAR REPETIDOS!
//                    if(a[i][k]==randomNum)  // Se encontra um valor menor ou igual ao gerado
//                        flag=true;          // Marca a flag a verdadeiro
//
//                if(flag==false) // Se a flag de repetido estiver a falso
//                {
//                    a[i][j]=randomNum; // Atribui valor
//                    j++;    // Incrementa i 
//                }
//            }
//        }
//        
//        int []temp = new int[a.length*a.length];
//        int ctr=0;
//        
//        for (int i=0; i < a.length; i++)
//            for(int j=0; j<a[i].length; j++)
//            {
//                temp[ctr]=a[i][j];
//                ctr++;               
//            }
//        
//        Arrays.sort(temp);
//        
//        ctr=0;
//        
//        for (int i=0; i < a.length; i++)
//            for(int j=0; j<a[i].length; j++)
//            {
//                a[i][j] = temp[ctr];
//                ctr++;               
//            }    
    }
    
    @Override
    public String toString() 
    {
        String out="Matriz:\n\n";
        
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[i].length;j++)
                out+=a[i][j]+"\t";
            
            out+="\n\n";
        }
        
        return out;
    }
    
    public boolean procuraNum1(int num)
    {
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[i].length;j++)
                if(a[i][j]==num)
                    return true;
        
        return false;
    }
    
    public boolean procuraNum2(int num)
    {
        int col = a.length;     // Nro. colunas
        int lin = a[0].length;  // Nro. linhas  
 
        int inicio = 0;         // Início da matriz
        int fim = col*lin-1;    // Fim da matriz
 
        while(inicio<=fim)      // Enquanto o início do intervalo for menor ou igual ao fim, a cada iteração
        {
            int meio=(inicio+fim)/2;    // Determina o meio do intervalo
            int meioX=meio/lin;         // Determina o meio horizontal
            int meioY=meio%lin;         // Determina o meio vertical
 
            if(a[meioX][meioY]==num)    // Se encontrar o valor a pesquisar
                return true;
 
            if(a[meioX][meioY]<num)     // Se o valor na matriz for interior ao valor a pesquisar         
                inicio=meio+1;          // Ajusta o início do intervalo para o meio actual mais 1   
            else            
                fim=meio-1;             // Ajusta o fim do intervalo para o meio actual menos 1
        }
 
        return false;   // Caso o valor a pesquisar não se encontre na matriz
    }
}