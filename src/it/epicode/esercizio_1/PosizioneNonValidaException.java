package it.epicode.esercizio_1;

public class PosizioneNonValidaException extends Exception {
    private int numero;

    public PosizioneNonValidaException() {
    }

    public PosizioneNonValidaException(String message, int numero) {
        super(message);
        this.numero = numero;
    }

    public int getNumero() {
        return this.numero;
    }
}
