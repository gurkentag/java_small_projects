package com.company;

import java.util.Scanner;

/**
 * Basisklasse start das Programm.
 */
public class Main {
    /**
     * die Methode erfolgt die Eingabe in die Console, egzeugt mithilfe der eigegebenen Information das Elternarray
     * und erzeugt eine Instanz von Klasse "Helper".
     *
     * @param args - Standartparameter fue die Methode "Main"
     */
    public static void main(String[] args) {
        System.out.println("Geben Sie die Merkmale fuer Mutter (Reihenfolge: Musterung-Fluegelfarbe-Fuelerforme):");
        //erzeuge das Elternarray
        Schmetterling[] eltern = new Schmetterling[2];
        Scanner scanner = new Scanner(System.in);
        //nehmen drei Merkmale fuer die Mutter und speicheren sie als drei Strings
        String m1Mom = scanner.nextLine();
        String m2Mom = scanner.nextLine();
        String m3Mom = scanner.nextLine();
        //erzege eine Instanz von Schmetterling
        Schmetterling mom = new Schmetterling(m1Mom, m2Mom, m3Mom);
        // legen sie ins Array
        eltern[0] = mom;
        System.out.println("Geben Sie die Merkmale fuer Vater (Reihenfolge: Musterung-Fluegelfarbe-Fuelerforme):");
        String m1Pap = scanner.nextLine();
        String m2Pap = scanner.nextLine();
        String m3Pap = scanner.nextLine();
        Schmetterling pap = new Schmetterling(m1Pap, m2Pap, m3Pap);
        eltern[1] = pap;
        //erzeuge eine Instanz von der Klasse SH
        Schmetterlingshelper sh = new Schmetterlingshelper();
        //erzeuge das Kinderarray
        Schmetterling[] kids = sh.erzeugeDerKinder(eltern);
        //berechne Merkmalkombinationen
        sh.auswertungDerKinder(kids);
        //nehmen aus der Scanner ein Merkmal fuer die Analyse
        System.out.println("\nWaelen Sie ein Merkmal fue die Analyse:");
        String merkmalAnalyse = scanner.nextLine();
        //berechnen Kinder mit einem Merkmal
        sh.auswertungMerkmal(kids, merkmalAnalyse);
    }
}

