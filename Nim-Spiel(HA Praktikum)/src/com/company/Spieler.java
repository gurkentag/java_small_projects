package com.company;

/**
 * die Klasse "Spieler" beschreibt einen Spieler
 */
public class Spieler {

    private String name;
    private int anzahlDerSteine;

    /**
     * der Klassenconstructor
     * @param name - der Name eines Spielers
     */
    public Spieler(String name) {
        this.name = name;


    }

    /**
     * eine Getter Methode fuer den Namen
     * @return - gibt den Namen eines Spielers zuruek
     */
    public String getName() {
        return this.name;
    }

    /**
     * eine Setter Methode fuer AnzahlDerSteine
     * @param anzahlDerSteine - wie viele Steine hat einen Spieler
     */
    public void setAnzahlDerSteine(int anzahlDerSteine) {
        this.anzahlDerSteine = anzahlDerSteine;
    }

    /**
     * eine Getter Methode fuer AnzahlDerSteine
     * @return gibt Anzahl der Steine zuruek
     */
    public int getAnzahlDerSteine() {
        return this.anzahlDerSteine;
    }
}
