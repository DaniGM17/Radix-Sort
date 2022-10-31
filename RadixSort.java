
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dania
 */
public class RadixSort {

    public static BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
    public static String entrada;

    public static int[] leerArreglo(int n) throws IOException {
        int[] a = new int[n];
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < a.length; i++) {
            System.out.println("Escriba el valor [" + i + "]: ");
            entrada = bufer.readLine();
            a[i] = Integer.parseInt(entrada);
        }
        return a;
    }

    public static void radixSort(int[] listaD, int t) {
        int max = gMax(listaD, t);
        for(int place=1; max/place>0; place*=10){
            countingSort(listaD, t, place);
        }
            
    }

    public static int gMax(int[] listaD, int t){
        int max = listaD[0];
        for(int i=1; i<t; i++){
            if(listaD[i]>max){
                max = listaD[i];
            }
        }
        return max;
    }
    
    public static void countingSort(int[] listaD, int t, int place){
        int[] salida = new int [t+1];
       
       int max = listaD[0];
       for(int i=1; i<t; i++){
           if(listaD[i]>max){
               max=listaD[i];
           }
       }
       int[] contar = new int[max+1];
       for(int i=0; i<max; i++){
           contar[i]=0;
       }
       
       for(int i=0; i<t; i++){
           contar[listaD[i]]++;
       }
       
       for(int i=1; i<=max; i++){
           contar[i] += contar[i-1];
       }
       
       for(int i=t-1; i>=0; i--){
           salida[contar[listaD[i]]-1] = listaD[i];
           contar[listaD[i]]--;
       }
       
       for(int i=0; i<t; i++){
           listaD[i] = salida[i];
       }
    }
    
    public static void imprimirArreglo(int[] a) {
        System.out.println("-------------------------");
        System.out.println("Lista ordenada");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%4d", a[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException {
        int[] array;
        int t;
        System.out.println("Programa que ordena la lista de números");
        System.out.println("Escribe la longitud de la lista a ingresar: ");
        entrada = bufer.readLine();
        t = Integer.parseInt(entrada);
        array = leerArreglo(t);
        radixSort(array, t);
        imprimirArreglo(array);
    }
}
