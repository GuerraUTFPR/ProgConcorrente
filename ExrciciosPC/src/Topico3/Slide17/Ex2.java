/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Topico3.Slide17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guerra
 */
public class Ex2 {

    public static void main(String argv[]) {
        ReadFileThread t1 = new ReadFileThread();
        t1.start();

    }
}

class ReadFileThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread " + currentThread().getId() + " Iniciada");
        try {
            FileReader arq = new FileReader("/home/guerra/Área de trabalho/UTFPR/PC/ExrciciosPC/src/Topico3/Slide17/Ex5.java");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
            while (linha != null) {
                System.out.printf("%s\n", linha);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("Thread " + currentThread().getId() + " Finalizada");
                    break;
                }
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

    }
}
