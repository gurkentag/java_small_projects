package com.company;

/**
 * Basisklasse start das Programm
 */
public class Main {
    /**
     * Die Methode erzeugt zwei Spieler und sammelt sie in Array.
     * Dann erzeugt eine Instanz von Klasse Spiel und ruft die Methode "spielen", un das Spiel anzufangen.
     * @param args- Basisparameter fuer die Methode Main
     */
    public static void main(String[] args) {
        Spieler spieler = new Spieler("Tom");
        Spieler spieler1 = new Spieler("Mark");
        Spieler[] spielers = {spieler, spieler1};

        Spiel spiel = new Spiel(spielers);
        spiel.spielen();
    }
}
