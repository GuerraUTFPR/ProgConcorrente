/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.Slide17;

/**
 *
 * @author guerra
 */
public class Ex3 {
     public static void main(String argv[]) {
         ReadFileThread t1 = new ReadFileThread();
         NewThread t2 = new NewThread();
         
         t1.start();
         t2.start();
         
         t1.interrupt();
         t2.interrupt();
     }
}
