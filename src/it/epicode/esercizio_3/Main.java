package it.epicode.esercizio_3;

import it.epicode.esercizio_3.exceptions.BancaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws BancaException {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Inizializzo conto corrente");
        ContoCorrente cc = new ContoCorrente("Mario Rossi", 1000.0);
        cc.stampaDettagli();
        LOGGER.info("Inizializzo conto online");
        ContoOnLine co = new ContoOnLine("Luigi Verdi", 1000.0, 500.0);
        co.stampaDettagli();

        double importo;
        int tipo;
        while (true) {
            System.out.println("Da quale conto vuoi prelevare? 1-CC 2-CO");
            tipo = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Quanto vuoi prelevare?");
            importo = scanner.nextDouble();
            scanner.nextLine();
            if (tipo == 1) {
                try {
                    cc.preleva(importo);
                } catch (BancaException e) {
                    LOGGER.error(e.getMessage());
                    return;
                }
                System.out.println("Saldo aggiornato: +" + cc.restituisciSaldo());
            } else if (tipo == 2) {
                try {
                    co.preleva(importo);
                } catch (BancaException e) {
                    if (cc.restituisciSaldo() < 0) {
                        LOGGER.error(e.getMessage());

                    } else {
                        System.out.println("Quanto vuoi prelevare?");
                        importo = scanner.nextDouble();
                        co.preleva(importo);
                        System.out.println("Saldo aggiornato: +" + co.restituisciSaldo());
                    }

                }
                System.out.println("Saldo aggiornato: +" + co.restituisciSaldo());
            }

        }
    }
}
