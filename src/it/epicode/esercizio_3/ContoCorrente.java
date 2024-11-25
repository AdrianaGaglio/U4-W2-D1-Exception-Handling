package it.epicode.esercizio_3;

import it.epicode.esercizio_3.exceptions.BancaException;

public class ContoCorrente {
    private String titolare;
    private int nMovimenti;
    private final int maxMovimenti = 50;
    private double saldo;

    public ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        this.nMovimenti = 0;
    }

    public void preleva(double x) throws BancaException {
        if(nMovimenti < maxMovimenti) saldo -= x;
        if(saldo < 0) throw new BancaException("Il conto è in rosso");
        this.nMovimenti++;
    }

    public double restituisciSaldo() {
        return this.saldo;
    }

    public void setSaldo(double x) {
        this.saldo -= x;
    }

    public String getTitolare() {
        return this.titolare;
    }

    public void stampaDettagli() {
        System.out.println("Titolare: " + this.getTitolare() + " - Saldo: " + this.restituisciSaldo());
    }

    public void deposita(double x) {
        this.saldo += x;
    }

}
