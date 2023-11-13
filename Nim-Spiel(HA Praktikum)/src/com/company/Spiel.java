package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * die Klasse "Spiel" beschreibt, wie das Spiel aussieht, und enthaeltet die Methoden dafuer
 */

public class Spiel {
    private Spieler[] spielers;

    /**
     * der Klassenconstructor
     *
     * @param spielers- ein Array mit zwei Instanzen von der Klasse "Spieler"
     */
    public Spiel(Spieler[] spielers) {
        this.spielers = spielers;

    }

    /**
     * Die Methode mischt Array mit Spieler durch,um den ersten Spieler zufaellig zu bestimmen
     *
     * @param spielers -nimmt als Parameter das Array mit zwei Spieler
     */
    public void spielAnfangen(Spieler[] spielers) {
        List<Spieler> spielerList = Arrays.asList(spielers);
        Collections.shuffle(spielerList);
        this.spielers = spielerList.toArray(spielers);

    }

    /**
     * Die Methode wird von Methode Main angerufen und fuehrt das Spiel. Die bestimmt Steinhaufen, Anzahl der Steine von beiden Spieler und am Ende des Spiels gibt den Gewinner in die Console aus.
     */
    public void spielen() {
        //rufen die Methode,un den ersten Spieler zu bestimmen
        this.spielAnfangen(spielers);
        //geben in die Console Spielregeln aus
        System.out.println("Spielregeln:Jeder Spieler nimmt im Wechsel 1-3 Steine.Verloren hat der Spieler, der den letzten Stein nimmt.");
        //inizialisieren die Variable,die Runde zaehlt
        int runde = 0;
        //generieren den Steinhaufen mit der Anzahl der Steine von 20 bis 30
        int steinhaufen = (int) (20 + Math.random() * (30 - 20 + 1));
        // die Variable vom Typ "Spieler" speichert den Spieler, der jetzt dran ist, ausser das letzten Mal,
        // so wird den Gewwiner bestimmt
        Spieler gewinnSpieler = null;
        while (true) {
            runde++;
            for (int i = 0; i < spielers.length; i++) {
                //generiere die Anzahl der Steine fuer einen Spieler zufaellig von 1 bis 3
                spielers[i].setAnzahlDerSteine((int) (1 + Math.random() * 3));
                //die Bedingung setzt den Steinhaufen auf 0, falls ein Spieler mehr Steine, als vorhanden wuerfelt
                if (steinhaufen - spielers[i].getAnzahlDerSteine() < 0) {
                    spielers[i].setAnzahlDerSteine(steinhaufen);
                    steinhaufen = 0;
                    //ansonsten werden die Steine ganz normal vom Steinhaufen abgezogen
                } else {
                    steinhaufen = steinhaufen - spielers[i].getAnzahlDerSteine();
                }

                // geben in die Console, wer dran ist und wie viele Steine es noch gibt
                System.out.println("aktueller Spieler: " + spielers[i].getName());
                System.out.println("Steine im Steinhaufen: " + steinhaufen);
                //die Bedingung endet das Spiel, wenn es keine Steine mehr gibt und
                // gibt in die Console Spielrunden und den Namen des Gewinners
                if (steinhaufen == 0) {
                    System.out.println("Spielrunden: " + runde);
                    System.out.println(gewinnSpieler.getName() + " hat gewonnen");
                    return;

                }
                gewinnSpieler = spielers[i];


            }
        }
    }
}
