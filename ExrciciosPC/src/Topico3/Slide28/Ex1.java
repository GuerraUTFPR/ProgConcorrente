/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.Slide28;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guerra
 */
public class Ex1 {

    public static void main(String argv[]) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("UnlessThreads");
        UnlessThread t1 = new UnlessThread(group, "1");
        UnlessThread t2 = new UnlessThread(group, "2");
        UnlessThread t3 = new UnlessThread(group, "3");
        t1.start();
        t2.start();
        t3.start();

        int count = 0;
        Random rand = new Random();
        while (count < 100) {
            System.out.println(group.getName() + " Threads ativas: " + group.activeCount());
            Thread.sleep(1000);
            
            int n = rand.nextInt(20) + 1;
            if (n == 1 && t1.isAlive()) {
                t1.interrupt();
            } else if (n == 2 && t2.isAlive()) {
                t2.interrupt();
            } else if (n == 3 && t3.isAlive()) {
                t3.interrupt();
            }
            count += 1;
        }
    }
}

class UnlessThread extends Thread {

    UnlessThread(ThreadGroup group, String name) {
        super(group, name);
        //this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Thread " + currentThread().getName());
                currentThread().sleep(2000);
            } catch (InterruptedException e) {
                //System.out.println("Thread " + currentThread().getId() + " Finalizada");
                break;
            }
        }
    }
}
