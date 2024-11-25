package it.epicode.esercizio_3.exceptions;

public class BancaException extends Exception{
    public BancaException() {
    }

    public BancaException(String message) {
        super(message);
    }
}
