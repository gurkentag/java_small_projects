package com.company;

import java.util.*;

/**
 * die Klasse enthaelt Methoden, mithilfe deren das Programm ausgefuert wird
 * und das Ergebnis erhalten wird.
 */
public class Schmetterlingshelper {

    /**
     * die Methode generiert eine Randomezahl fue die Kinderanzahl.
     *
     * @return - gibt die Randomezahl zurueck
     */
    public int generiereAnzahlDerKinder() {
        return (int) (1000 + Math.random() * (2000 - 1000 + 1));
    }
    /**
     * die Methode erfolgt die zufaellige Vererbung der Merkmale von Eltern zu Kinder.
     *
     * @return - gibt zufaellig eine Zahl: entweder 0 oder 1
     */
    public int mischeElternArray() {
        return (int) (Math.random() * 2);
    }
    /**
     * die Methode erhaelt zuerst die Anzahl der Kinder, dann fuert die zufaellige Vererbung von Merkmalen
     * mit Ergeugen der Kinder und sammelt sie in ein Array.
     * @param eltern - Elternarray
     * @return - gibt das Array mit Kinder zurueck
     */
    public Schmetterling[] erzeugeDerKinder(Schmetterling[] eltern) {
        int anzahlDerKinder = this.generiereAnzahlDerKinder();
        //erzeuge neues Array fuer Kinder
        Schmetterling[] kinder = new Schmetterling[anzahlDerKinder];
        for (int i = 0; i < kinder.length; i++) {
            //drei mal generieren eine Zahl fuer jedes Kind
            int zahl = this.mischeElternArray();
            int zahl1 = this.mischeElternArray();
            int zahl2 = this.mischeElternArray();
            //erzeuge neues Kind mit zufaelligen Merkmalen
            Schmetterling k = new Schmetterling(eltern[zahl].getMusterung(), eltern[zahl1].getFluegelfarbe(), eltern[zahl2].getFuehlerform());
            kinder[i] = k;
        }
        return kinder;
    }
    /**
     * die Methode zaehlt, wie viele Kinder welche Merkmalkombination haben,
     * und sammelt das Resultat in Map. Danach ruft die andere Methode,
     * um die Auswertung in Prozenten zu erhalten.
     *
     * @param kinder - nimmt als Parameter Array von Kinder
     */
    public void auswertungDerKinder(Schmetterling[] kinder) {
        Map<String, Integer> kinderUndMerkmale = new HashMap<>();
        for (int i = 0; i < kinder.length; i++) {
            //eine Variable fuer den Key von Typ String
            String s = kinder[i].getMusterung() + ", " + kinder[i].getFluegelfarbe() + ", " + kinder[i].getFuehlerform();
            //zaehlen die Zufaelle von Key
            if (kinderUndMerkmale.containsKey(s)) {
                kinderUndMerkmale.put(s, kinderUndMerkmale.get(s) + 1);
            } else {
                kinderUndMerkmale.put(s, 1);
            }
        }
        // rufen die andere Methode, die ststische Auswertung durchfuert
        this.auswertungInProzenten(kinderUndMerkmale, kinder);
    }
    /**
     * die Methode zaehlt Kinder mit einem bestimmten Merkmal und liegt sie in Map.
     * Danach ruft die andere Methode,Danach ruft die andere Methode,um die Auswertung in Prozenten zu erhalten.
     *
     * @param kinder-das Array mit allen Kinder
     * @param merkmal-besonderes Merkmal
     */
    public void auswertungMerkmal(Schmetterling[] kinder, String merkmal) {
        Map<String, Integer> kinderMitMerkmal = new HashMap<>();
        for (int i = 0; i < kinder.length; i++) {
            //speichern Merkmale in eine Stringvariable
            String s = kinder[i].getMusterung() + ", " + kinder[i].getFluegelfarbe() + ", " + kinder[i].getFuehlerform();
            //zaehlen Merkmalszufaelle
            if (s.contains(merkmal)&&kinderMitMerkmal.containsKey(s)) {
                    kinderMitMerkmal.put(s, kinderMitMerkmal.get(s) + 1);
                } else if(s.contains(merkmal)&&!kinderMitMerkmal.containsKey(s)) {
                   kinderMitMerkmal.put(s, 1);
            }
        }
        //rufen die andere Methode, die ststische Auswertung durchfuert
        this.auswertungInProzenten(kinderMitMerkmal, kinder);
    }
    /**
     * die Methode berechnet die statische Auswertung sowohl fuer Merkmalkombinationen,
     * als auch fuer ein bestimmtes Merkmal und gibt das Resultat in die Console aus.
     * @param kids-Map mit Merkmal/Merkmalkombinationen
     * @param kinder-  Originales Kinderarray
     */
    public void auswertungInProzenten(Map<String, Integer> kids, Schmetterling[] kinder) {
        //neue Map fuer, um die statistischen Ergebnisse zu speichern
        Map<String, Double> auswertungInProzenten = new HashMap<>();
        for (Map.Entry<String, Integer> k : kids.entrySet()) {
            //berechnen, wie viele Kinder was haben in Prozenten
            double prozenten = 1.0 * k.getValue() / kinder.length * 100;
            //speichern in die Map
            auswertungInProzenten.put(k.getKey(), prozenten);
            //runden die Doublezahlen
            String gerundeteProzente = String.format("%.2f", auswertungInProzenten.get(k.getKey()));
            //Geben die Auswertung in solche Form aus
            System.out.println("\n" + gerundeteProzente + "% Kinder haben Merkmalkombination: " + k.getKey());

        }
    }
}




