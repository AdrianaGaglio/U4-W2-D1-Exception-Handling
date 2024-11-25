package it.epicode.esercizio_2;

public class Auto {
    private int km;
    private int litriCarburante;

    public Auto() {
    }

    public void setKmLitri(int km, int litriCarburante) throws LitriException {
        if (litriCarburante <= 0) {
            throw new LitriException("Litri non validi", km);
        }
    this.km =km;
    this.litriCarburante =litriCarburante;
    }

    public double calcolaConsumo() {
        double consumo = this.km / this.litriCarburante;
        return consumo;

    }


}
