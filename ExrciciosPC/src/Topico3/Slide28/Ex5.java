/*
 * Código desenvlvido por Matheus Guerra, para disciplina de Programação concorrente.
 * Execicío 5 do slide 28 (tópico 3)
 * A implementação do algoritmo Merge Sort foi retirada do site https://www.geeksforgeeks.org/merge-sort/
 * Este algoritmo consiste em criar um vetor de tamanho n (podendo ser alterado),
desordenar o vetor e disparar duas threads simultaneamente com a finalidade de ordenar o vetor.
 */
package Topico3.Slide28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author guerra
 */
public class Ex5 {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> numeros = new ArrayList<>();
        int n = 1000;
        for (int i = 1; i < n; i++) { //Sequencia da mega sena
            numeros.add(i);
        }
        //Embaralhamos os números:
        Collections.shuffle(numeros);

        int vet[] = new int[n];
        for (int j = 0; j < numeros.size() ;j++) {
            //System.out.println(numeros.get(j));
            vet[j] = numeros.get(j);
        } 
        
        Thread t1 = new Thread(new ThreadSort(vet, 0, vet.length/2));
        Thread t2 = new Thread(new ThreadSort(vet, (vet.length/2 + 1), vet.length -1));
        t1.start();
        t2.start();       
        
        t1.join();
        t2.join();
        
        for (int i = 0; i < vet.length; i++) {
            System.out.println(vet[i]);
        }
        
    }
}

class ThreadSort implements Runnable{
    int vet[];
    int l;
    int r;

    public ThreadSort(int[] vet, int l, int r) {
        this.vet = vet;
        this.l = l;
        this.r = r;
    }
    
    public void run(){
        MergeSort merge = new MergeSort();
        merge.sort(vet, l, r);
    }
}



/* Java program for Merge Sort */
class MergeSort
{ 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
  
}