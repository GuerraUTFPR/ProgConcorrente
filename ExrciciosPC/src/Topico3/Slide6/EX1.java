/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.Slide6;

import Topico3.*;

/**
 *
 * @author guerra
 */
public class EX1 {

    public static void main(String argv[]) {
        Runnable task = () -> {
            System.out.println("Thread criada utilizando lambda");
        };

        new Thread(task).start();
    }
}
