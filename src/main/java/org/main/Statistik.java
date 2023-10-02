package org.main;

/**
 * Diese Klasse speichert die Statistik
 * @author Jan Huebner
 * @version 2023-10-ß1
 */
public class Statistik {
    private int insgesamt = 0;

    private int richtig = 0;

    private int falsch = 0;

    public Statistik() {}

    /**
     * Gibt den Insgesamten Wert zurück
     * @return der Insagesamte wert
     */
    public int getInsgesamt() {
        return insgesamt;
    }

    /**
     * Settet den Insgesamten Wert
     * @param insgesamt der Insgesamte Wert
     */
    public void setInsgesamt(int insgesamt) {
        this.insgesamt = insgesamt;
    }

    /**
     * Gibt die richten Werte zurück
     * @return die Richten Werte
     */
    public int getRichtig() {
        return richtig;
    }

    /**
     * Settet die richtiten Werte
     * @param richtig die richtigen Werte
     */
    public void setRichtig(int richtig) {
        this.richtig = richtig;
    }

    /**
     * Gibt die falschen Werte zurück
     * @return die falschen Werte
     */
    public int getFalsch() {
        return falsch;
    }

    /**
     * Settet die falschen Werte
     * @param falsch die falschen Werte
     **/
    public void setFalsch(int falsch) {
        this.falsch = falsch;
    }
}
