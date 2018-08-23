/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.Slide17;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guerra
 */


public class Ex5 {

    public static void main(String argv[]) {
        ArrayList<Integer> valores = new ArrayList();
        int[] array = null;
        inputThread t1 = new inputThread(valores);
        
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ex5.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer aux = 0;
        for (int i = 0; i < valores.size(); i++) {
            aux = aux + valores.get(i);
        }
        System.out.println(aux);
    }

}

class inputThread extends Thread{
    ArrayList<Integer> array;
    public inputThread(ArrayList<Integer> valores){
        this.array = valores;
        this.start();
    }
    
    @Override
    public void run() {
        System.out.println("Digite valores e dê enter. Para finalizar insira o número 0");
        Integer valor = 1;
        Scanner scanner = new Scanner(System.in);
        
        try{
            while(!valor.equals(0)){
            valor = scanner.nextInt();
            array.add(valor);
        }        
           throw new InterruptedException();
        } catch (InterruptedException ex) {
            System.out.println("A thread foi interrompida.");
        }
    }
}


