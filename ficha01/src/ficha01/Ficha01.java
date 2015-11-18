package ficha01;

public class Ficha01 
{
    public static String findPopular(int[] a)
    {
        int count = 1, tempCount;
        int popular = a[0];
        int temp;
        String maioritario = "Maioritário: ";
        
        for (int i = 0; i < (a.length - 1); i++)
        {
            temp = a[i];    // Guarda o valor actual em temp
            tempCount = 0;  // Reset do contador de ocorrências
          
            for (int j = 1; j < a.length; j++)  // Corre o array para determinar quantas vezes ocorre o valor actual        
                if (temp == a[j])
                    tempCount++;
          
            if (tempCount > count)  // Se foi o mais popular, guarda-se o valor e o nro de ocorências
            {
                popular = temp;
                count = tempCount;
            }
        }
        
        if(count>a.length/2)        
            maioritario += popular;
        else
            maioritario += "não existe";
        
        return maioritario;
    }
    
    public static void main(String[] args)
    {
        // --- Exercício 1 ---
        
        //long startTime = System.nanoTime();
        //int soma=0,n=100;
        
        //for(int i=0;i<n;i++)      // 4887 nanosegundos
        //    soma++;
        
        //for(int i=0;i<n;i+=2)     // 2793 nanosegundos
        //    soma++;
        
        //for(int i=0;i<n;i++)      // 414720 nanosegundos
        //    for(j=0;j<n;j++)
        //        soma++;
        
        //for(int i=0;i<n;i++)      // 9076 nanosegundos
        //    soma++;        
        //for(int j=0;j<n;j++)
        //    soma++;
        
        //for(int i=0;i<n;i++)      // 4092045 nanosegundos
        //    for(int j=0;j<n*n;j++)
        //        soma++;
        
        //for(int i=0;i<n;i++)      // 230400 nanosegundos
        //    for(int j=0;j<i;j++)
        //        soma ++;
        
        //for(int i=0;i<n;i++)      // 8433558543 nanosegundos
        //    for(int j=0;j<n*n;j++)
        //        for(int k=0;k<j;k++)
        //            soma ++;
        
        //for(int i=1;i<n;i*=2)     // 1396 nanosegundos
        //    soma++;
        
        //long endTime = System.nanoTime();

        //long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        
        //System.out.println("Tempo de execução: "+duration);
        
        // --- Exercício 2 ---
        
        //ArrayOrdenado array = new ArrayOrdenado();
        
        //System.out.println(array.toString());
        
        //System.out.println(array.procuraValor(1)+"\n");
        
        // --- Exercício 3 ---
        
        //Matriz mat = new Matriz();

        //System.out.println(mat.toString());
        
        //System.out.println(mat.procuraNum1(19)+"\n");
        
        //System.out.println(mat.procuraNum2(35)+"\n");
        
        // --- Exercício 4 ---
        
        int[] a1 = {3,3,4,2,4,4,2,4,4}; // 4 é maioritário (aparece mais do que N/2 vezes)
        int[] a2 = {3,3,4,2,4,4,2,4};  // 4 não é maioritário
        
        System.out.println(findPopular(a2));
        
//            --- Implementação para valores repetidos
//        int candidato=a1[0];
//        int folga=1;
        
//        for(int i=1;i<a1.length;i++)
//        {            
//            if(a1[i]==candidato)
//                folga++;
//            else
//            {
//                if(candidato==-1)
//                {
//                    candidato=a1[i];
//                    folga=1;
//                }
//                else
//                {
//                    --folga;
//                
//                    if(folga==0)
//                        candidato=-1;
//                }                
//            }
//        }
    }   
}