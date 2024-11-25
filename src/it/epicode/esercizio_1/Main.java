package it.epicode.esercizio_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    public static void stampaArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Inizializzo l'array di numeri random");
        int[] numeri = new int[5];

        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = (int) (Math.random() * 11);
        }

        stampaArray(numeri);

        LOGGER.info("Chiedo all'utente di modificare l'array");
        int numero;
        int posizione;

        while (true) {
            try {
                System.out.println("Inserisci un numero:");
                numero = scanner.nextInt();
                if(numero == 0) {
                    LOGGER.info("Uscita dal programma!");
                    scanner.close();
                    break;
                }
                scanner.nextLine();
                System.out.println("In che posizione vuoi inserire il numero?");
                posizione = scanner.nextInt();
                if (posizione < 1 || posizione > numeri.length) {
                    throw new PosizioneNonValidaException("Posizione non valida", numero);
                }
                scanner.nextLine();
                numeri[posizione - 1] = numero;
                System.out.println("Array aggiornato:");
                stampaArray(numeri);
            } catch(PosizioneNonValidaException e) {
                LOGGER.error(e.getMessage());
                System.out.println("Inserisci una nuova posizione:");
                posizione = scanner.nextInt();
                scanner.nextLine();
                numeri[posizione - 1] = e.getNumero();
                System.out.println("Array aggiornato:");
                stampaArray(numeri);
            }
        }
        }
    }
