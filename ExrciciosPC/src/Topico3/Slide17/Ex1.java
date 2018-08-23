package Topico3.Slide17;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guerra
 */
public class Ex1 {

    public static void main(String argv[]) {
        NewThread t1 = new NewThread();
        NewThread t2 = new NewThread();
        NewThread t3 = new NewThread();
        
        t1.start();
        t2.start();
        t3.start();

 

    }
}

class NewThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread criada com herança");
        Random rand = new Random();
        int  n = rand.nextInt(5) + 1;
        n = n * 1000;
                try {
                    Thread.sleep(n);
                } catch (InterruptedException e) {
                    System.out.println("Thread " + currentThread().getId() + " Finalizada");
                }
        System.out.println("Fim da Thread");

    }
}
