/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.Slide28;

import java.util.ArrayList;

/**
 *
 * @author guerra
 */
public class Ex3 {
    public static void main(String[] args) throws InterruptedException {
        Integer n = 100_000;
        Integer p1,p2,p3,p4;
        p1 = 0;
        p2 = n/4;
        p3 = p2 + n/4;
        p4 = p3 + n/4;
        ArrayList<Integer> arr = new ArrayList<>();
        
        Thread t1 = new Thread(new CalcNumPrimo(1, p2, arr));
        Thread t2 = new Thread(new CalcNumPrimo(p2+1, p3, arr));
        Thread t3 = new Thread(new CalcNumPrimo(p3+1, p4, arr));
        Thread t4 = new Thread(new CalcNumPrimo(p4+1, n, arr));
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
        for (Integer primo : arr) {
            System.out.println("Primo: "+ primo);
        }
    }
}

class CalcNumPrimo implements Runnable{
    ArrayList<Integer> arr;
    Integer ini;
    Integer fim;
    
    public CalcNumPrimo(Integer ini, Integer fim, ArrayList<Integer> arr) {
        this.arr = arr;
        this.ini = ini;
        this.fim = fim;
    }
    
    @Override
    public void run(){
        int contador = 0;
        for (int i = this.ini; i < this.fim; i++) {
            contador = 0;
            for (int j = 1; j <= i; j++) {
                if(i%j == 0){
                    contador ++;
                }
                
            }
            if(contador == 2){
                //System.out.println("Primo: " + i);
                arr.add(i);
            }
        }

    }
}
