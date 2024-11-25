package it.epicode.esercizio_2;

public class LitriException extends Exception {
    private int km;

    public LitriException() {
    }

    public LitriException(String message, int km) {
        super(message);
        this.km = km;
    }

    public int getKm() {
        return this.km;
    }
}
