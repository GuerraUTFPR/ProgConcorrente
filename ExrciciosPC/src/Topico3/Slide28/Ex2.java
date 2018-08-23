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
public class Ex2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("UnlessGroup");
        UnlessThread t1 = new UnlessThread(group, "1");
        UnlessThread t2 = new UnlessThread(group, "2");
        UnlessThread t3 = new UnlessThread(group, "3");
        group.isDaemon();
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("Nome do grupo: " + group.getName());
        System.out.println("Threads ativas: " + group.activeCount());
        System.out.println("Max prio.: " + group.getMaxPriority());
        
        Thread[] list = new Thread[group.activeCount()];
        int count = group.enumerate(list);
        for (int i = 0; i < count; i++) {
               System.out.println("Main -> Thread " + list[i].getName());
            
        }
        group.interrupt();
        
        
        Thread.sleep(2000);
    }
}
