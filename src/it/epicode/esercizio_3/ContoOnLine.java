package it.epicode.esercizio_3;

import it.epicode.esercizio_3.exceptions.BancaException;

public class ContoOnLine extends ContoCorrente {
    private double maxPrelievo;

    public ContoOnLine(String titolare, double saldo, double maxP) {
        super(titolare, saldo);
        this.maxPrelievo = maxP;
    }

    public void stampaSaldo() {
        System.out.println("Titolare: " + this.getTitolare() + " - Saldo: " + this.restituisciSaldo() + " - Num movimenti: " + this.maxPrelievo);
    }

    @Override
    public void preleva(double x) throws BancaException {
        if (x <= this.maxPrelievo) {
            if(this.restituisciSaldo() < 0) throw new BancaException("Il conto é in rosso");
            this.setSaldo(x);
        }
        if (x > maxPrelievo) throw new BancaException("Il prelievo non è disponibile");
    }

    @Override
    public void stampaDettagli() {
        super.stampaDettagli();
    }


}
