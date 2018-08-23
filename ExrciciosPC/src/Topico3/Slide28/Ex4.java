/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.Slide28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guerra
 */
public class Ex4 {

    public static void main(String[] args) {
        int valor, threads;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um valor a ser buscado.");
        valor = scanner.nextInt();
        System.out.println("Digite a quantidade de threads.");
        threads = scanner.nextInt();

        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i < 10000000; i++) { //Sequencia da mega sena
            numeros.add(i);
        }
        //Embaralhamos os números:
        Collections.shuffle(numeros);
        int ini = 0;
        int next = numeros.size()/threads;
        for (int i = 0; i < threads; i++) {
            //System.out.println("ini: " + ini + "fim: " + next);
            Thread t = new Thread(new BuscaNumero(numeros, valor, ini, next));
            ini = next + 1;
            next = next + numeros.size()/threads;
            t.start();
        }
    }
}

class BuscaNumero implements Runnable {
    List<Integer> list;
    int valor;
    int ini;
    int fim;
    
    public BuscaNumero(List<Integer> list, int valor, int ini, int fim){
        this.list = list;
        this.valor = valor;
        this.ini = ini;
        this.fim = fim;
    }
    @Override
    public void run() {
        for (int i = this.ini; i < this.fim; i++) {
            if(list.get(i).equals(valor)){
                System.out.println("Acheiiii -> " + Thread.currentThread().getName());
                
            }
        }
    }
}
