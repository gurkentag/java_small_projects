package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Die Instanzen dieser Klasse sind die AufgabenManager des Verschlüsselns und Entschlüsselns von Texten in .txt Dateien
 */
public class menue {
    /**
     * Scanner um Eingaben des Users zu lesen
     */
    private Scanner scan = new Scanner(System.in);
    /**
     * Der Speicherort der .txt Datei, in der der verschlüsselte Text gespeichert wird/werden soll
     */
    private String versch;
    /**
     * Der Speicherort der .txt Datei, in der der original Text gespeichert ist
     */
    private String entsch;
    /**
     * Der Schlüssel mit dem Verschlüsselt werden soll. Wird entweder zufällig generiert, oder vom User mit übergeben
     */
    private int key;

    /**
     * Konstruktor, benötigt keine Parameter
     */
    menue() {

    }

    /**
     * Die Methode Managed den User Input und erstellt entsprechende Instanzen der Klassen, die zum Einlesen, Verschlüsseln und entschlüsseln benötigt werden
     * Ebenso wird das Schreiben des Verschlüsselten Textes hier gemanaged
     *
     * @throws IOException Falls Fehler beim Zugriff auf die .txt Dateien entstehen
     */
    public void start() throws IOException {


        //-----------------------INPUT Handler -------------------------------


        System.out.println("Bitte den Dateipfad des Originaltextes angeben: ");
        this.entsch = scan.nextLine();

        System.out.println("Bitte den Dateipfad Angeben, in den Verschlüsselt werden soll: ");
        this.versch = scan.nextLine();

        while (true) {
            System.out.println("Um zu Schiffrieren, drücken Sie bitte die 1\nUm zu Dechiffrieren, drücken Sie bitte die 2");

            if (scan.hasNextInt()) {
                int eingab = scan.nextInt();
                //-----------------------------------CHIFFRIER--------------------------
                if (eingab == 1) {

                    System.out.println("Enter a valid number for a Key, or anything else for a random generated Key:");
                    if (scan.hasNextInt()) {
                        key = scan.nextInt();
                        System.out.println("You entered: " + key);

                        Formatierung form = new Formatierung(entsch);
                        verschlüssel unverschlüsselt = new verschlüssel(form.ersetzeBuchstaben(form.einlesen()), key);
                        char[] buffer = new char[unverschlüsselt.getlist().length];
                        buffer = String.valueOf(unverschlüsselt.getlist()).toCharArray();

                        verschlüssel verschlüsselt = new verschlüssel(unverschlüsselt.getlist(), key);
                        verschlüsselt.schlüsselmanage();

                        System.out.println("\nDer OriginalText ist: " + String.valueOf(buffer) + "\n");
                        System.out.println("Der Verschlüsselte Text ist: " + String.valueOf(verschlüsselt.getlist()) + "\n");

                        try (FileWriter fw = new FileWriter(versch, true);
                             BufferedWriter bw = new BufferedWriter(fw);
                             PrintWriter out = new PrintWriter(bw)) {
                            out.println(verschlüsselt.getlist());
                            //out.println("Der eingegebene Schlüssel war: "+ key);

                        }
                        char ausgabe = 97;
                        char ausgabeb = 97;
                        for (int i = 0; i < 26; i++) {

                            if (ausgabeb + key > 122) {
                                ausgabeb -= 26;
                            }
                            System.out.println("Die Originaltabelle ist: " + ((char) (ausgabe)) + ": " + (i + 97) + "		Die Verschobene Tabelle ist: " + ((char) (ausgabeb + key)) + ": " + (ausgabeb + key));
                            ausgabe++;
                            ausgabeb++;
                        }

                        scan.close();
                        System.exit(0);


                    } else {
                        key = (int) (Math.random() * 26) + 1;
                        System.out.println("your input was not a valid Number, your auto-generated key is: ??");
                        Formatierung form = new Formatierung(entsch);
                        verschlüssel unverschlüsselt = new verschlüssel(form.ersetzeBuchstaben(form.einlesen()), key);
                        char[] buffer = new char[unverschlüsselt.getlist().length];
                        buffer = String.valueOf(unverschlüsselt.getlist()).toCharArray();

                        verschlüssel verschlüsselt = new verschlüssel(unverschlüsselt.getlist(), key);
                        verschlüsselt.schlüsselmanage();

                        System.out.println("\nDer OriginalText ist: " + String.valueOf(buffer) + "\n");
                        System.out.println("Der Verschlüsselte Text ist: " + String.valueOf(verschlüsselt.getlist()) + "\n");

                        try (FileWriter fw = new FileWriter(versch, true);
                             BufferedWriter bw = new BufferedWriter(fw);
                             PrintWriter out = new PrintWriter(bw)) {
                            out.println(verschlüsselt.getlist());
                            //out.println("Der eingegebene Schlüssel war: "+ key);

                        }
                        char ausgabe = 97;
                        char ausgabeb = 97;
                        for (int i = 0; i < 26; i++) {

                            if (ausgabeb + key > 122) {
                                ausgabeb -= 26;
                            }
                            System.out.println("Die Originaltabelle ist: " + ((char) (ausgabe)) + ": " + (i + 97) + "		Die Verschobene Tabelle ist: " + ((char) (ausgabeb + key)) + ": " + (ausgabeb + key));
                            ausgabe++;
                            ausgabeb++;
                        }
                    }
                    scan.close();
                    System.exit(0);

                }
                //-----------------------------------DECHIFFRIER----------------------------------
                else if (eingab == 2) {
                    System.out.println("Ist der Schlüssel zum Dechiffrieren bekannt, bitte entsprechenden Integer eingeben, \nwenn nicht dann einen beliebigen Buchstaben zum fortsetzten ohne Schlüssel");
                    if (scan.hasNextInt()) {
                        this.key = scan.nextInt();
                        Formatierung form = new Formatierung(versch);
                        List<String> bu = new ArrayList<>(form.einlesen());
                        if (bu.size() == 0) {
                            System.out.println("Es gibt nichts zum Entschlüsseln");

                            scan.close();
                            System.exit(0);
                        }
                        char[] buffer = form.ersetzeBuchstaben(bu);
                        Entschluesserung ent = new Entschluesserung(buffer, key);
                        char[] buff2 = String.valueOf(ent.entschluesseln()).toCharArray();
                        System.out.println("Der entschlüsselte Text ist: \n" + String.valueOf(buff2));
                        System.out.println("Der Schlüssel war: " + key);

                        scan.close();
                        System.exit(0);

                    } else {

                        Formatierung form = new Formatierung(versch);
                        Formatierung forment = new Formatierung(entsch);
                        List<String> bu = new ArrayList<>(form.einlesen());
                        if (bu.size() == 0) {
                            System.out.println("Es gibt nichts zum Entschlüsseln");

                            scan.close();
                            System.exit(0);
                        }
                        char[] buffer = form.ersetzeBuchstaben(bu);
                        char[] bufferent = forment.ersetzeBuchstaben(forment.einlesen());
                        entschlüsselunbek ent = new entschlüsselunbek(buffer, bufferent);
                        this.key = ent.schluesselausgabe();
                        System.out.println("Der Schlüssel war: " + key);

                        Entschluesserung klartext = new Entschluesserung(buffer, key);
                        char[] buff2 = String.valueOf(klartext.entschluesseln()).toCharArray();
                        System.out.println("Der entschlüsselte Text ist: \n" + String.valueOf(buff2));

                        scan.close();
                        System.exit(0);

                    }

                }


            } else {
                System.out.println("Enter a Valid Option.");
                scan.nextLine();
            }

        }

        //--------------Speicherorte der Textdateien-----------------
        // C:\Users\Noah_\Desktop\entsch.txt
        // C:\Users\Noah_\Desktop\versch.txt
        //C:\Users\Noah_\Desktop\java\
    }

}
