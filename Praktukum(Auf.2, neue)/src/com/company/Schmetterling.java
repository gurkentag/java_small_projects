package com.company;

/**
 * die Klasse beschreibt, wie einen Schmetterling aussihst und welche Parameter hat.
 */
public class Schmetterling {
    /**
     * erstes Merkmal - Musterung
     */
    private String musterung;
    /**
     * zweites Merkmal -die Farbe der Fluegel
     */
    private String fluegelfarbe;
    /**
     * drittes Merkmal - die Form der Fuehler
     */
    private String fuehlerform;

    /**
     * der Klassenconstructor: jeder Schmetterling soll drei Merkmale haben.
     * @param musterung-erstes Merkmal
     * @param fluegelfarbe-zweites Merkmal
     * @param fuehlerform-drittes Merkmal
     */
    public Schmetterling(String musterung, String fluegelfarbe, String fuehlerform) {
        this.musterung = musterung;
        this.fluegelfarbe = fluegelfarbe;
        this.fuehlerform = fuehlerform;
    }

    /**
     * ein Getter fuer die Farbe von Fluegeln.
     * @return - gibt den Wert der Fluegelfarbe zurueck
     */
    public String getFluegelfarbe() {
        return fluegelfarbe;
    }

    /**
     * ein Getter fuer die Form der Fueler.
     * @return - gibt den Wert von fuehlerform zurueck
     */
    public String getFuehlerform() {
        return fuehlerform;
    }

    /**
     * ein Getter fuer Musterung.
     * @return -gibt den Wert von Musterung zurueck
     */
    public String getMusterung() {
        return musterung;
    }

}
