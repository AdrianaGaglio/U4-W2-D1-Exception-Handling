package it.epicode.esercizio_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws LitriException {
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Inizializzo auto:");
        Auto auto = new Auto();
        LOGGER.info("Inserisco km e litri");
        int km;
        int litri;
        try {
            System.out.println("Quanti km percorsi?");
            km = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Quanti litri consumati?");
            litri = scanner.nextInt();
            if(litri <= 0) {
                throw new LitriException("Litri non validi", km);
            }
            scanner.nextLine();
            auto.setKmLitri(km, litri);
            System.out.println("Calcolo km/litro:" + auto.calcolaConsumo());
        } catch (LitriException e) {
            LOGGER.error(e.getMessage(), e);
            System.out.println("Specifica un valore valido per i litri consumati:");
            km = e.getKm();
            litri = scanner.nextInt();
            scanner.nextLine();
            auto.setKmLitri(km, litri);
            System.out.println("Calcolo km/litro:" + auto.calcolaConsumo());
        }

    }
}
