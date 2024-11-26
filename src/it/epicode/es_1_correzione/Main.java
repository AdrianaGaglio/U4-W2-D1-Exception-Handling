package it.epicode.es_1_correzione;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] numeri = getArray();
        boolean stop = false;

        do {
            System.out.println("Inserisci un numero:");
            int numero = scanner.nextInt();
            if (numero != 0) {
                System.out.println("Specifica una posizione:");
                int posizione = scanner.nextInt();
                scanner.nextLine();
                try {
                    numeri[posizione - 1] = numero;
                    printArray(numeri);
                } catch (ArrayIndexOutOfBoundsException e) {
                    LOGGER.error(e.getMessage());
                }
            } else {
                stop = true;
            }


        } while (!stop);

        scanner.close();
    }

    public static int[] getArray() {
        int[] arr = new int[5];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 10);
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
