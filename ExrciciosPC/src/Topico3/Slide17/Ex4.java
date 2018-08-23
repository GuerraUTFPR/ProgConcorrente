/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.Slide17;

import static java.lang.Thread.currentThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author guerra
 */
public class Ex4 {

    public static void main(String argv[]) {
        UnlessThread t1 = new UnlessThread();
        UnlessThread t2 = new UnlessThread();
        UnlessThread t3 = new UnlessThread();

        t1.start();
        t2.start();
        t3.start();

        Random rand = new Random();
        MonitorThread t4 = new MonitorThread(t1,t2,t3);
        t4.start();
        while (true) {
            int n = rand.nextInt(5) + 1;
            if (n == 1) {
                //System.out.println("1");
                t1.interrupt();

            } else if (n == 2) {
                //System.out.println("2");
                t2.interrupt();

            } else if (n == 3) {
                //System.out.println("3");
                t3.interrupt();

            }

            if (!t4.isAlive()) {
                break;
            }

        }
        System.out.println("fim");

    }
}

class UnlessThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread " + currentThread().getId() + " Iniciada");
        while (true) {
            try {
                //System.out.format("Thread %d running\n", Thread.currentThread().getId());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //System.out.println("Thread " + currentThread().getId() + " Finalizada por interrupção");
                break;
            }

        }
        System.out.println("Fim da Thread");
    }
}

class MonitorThread extends Thread {
    Thread t1;
    Thread t2;
    Thread t3;

    public MonitorThread(Thread t1, Thread t2, Thread t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    @Override
    public void run() {
        System.out.println("Monitorando threads");
        while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
            if(!t1.isAlive()){
                System.out.println("Thread " + t1.getId() + " não está ativa");
            }
            if(!t2.isAlive()){
                System.out.println("Thread " + t2.getId() + " não está ativa");
            }
            if(!t2.isAlive()){
                System.out.println("Thread " + t3.getId() + " não está ativa");
            }
            
        }
    }
}
