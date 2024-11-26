package it.epicode.es_2_correzione;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ArithmeticException {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Inserire km percorsi:");
            int km = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Inserire litri carburante consumati:");
            double litri = scanner.nextDouble();
            scanner.nextLine();
            double kmLitri = km / litri;
            if(Double.isInfinite(kmLitri)) {
                throw new ArithmeticException("Non si può dividere per zero");
            }

            System.out.println("L'auto percorre " + kmLitri + " km al litro.");
        } catch(ArithmeticException e) {
            LOGGER.error(e.getMessage());
//            e.printStackTrace();
        }finally {
            scanner.close();
        }


    }
}
