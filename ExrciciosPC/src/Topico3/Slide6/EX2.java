/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.Slide6;

import Topico3.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guerra
 */
public class EX2 {

    public static void main(String argv[]) throws InterruptedException {
        Integer numOfThread = 10;

        //using lambda expression
        Runnable task = () -> {
            System.out.println("Thread number = ");
            System.out.println("Thread criada utilizando lambda");
            System.out.println("id = " + Thread.currentThread().getId());
        };

        for (int i = 0; i <= numOfThread; i++) {
            new Thread(task).start();
            Thread.sleep(1000);
        }

        for (int i = 0; i <= numOfThread; i++) {
            HelloThread helloThread = new HelloThread();
            helloThread.start();
            Thread.sleep(1000);
        }

    }
}

class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread criada com herança");
    }
}
