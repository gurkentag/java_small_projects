package com.company;

/**
 * Die Instanzen der Klasse verschlüsseln Texte um einen gegebenen, oder zufälligen Schlüssel
 */

public class verschlüssel {
    /**
     * Der Text der zu Verschlüsseln ist, wird in einem Array gespeichert
     */
    private char[] listy;
    /**
     * Der Schlüssel Wert, um den verschoben wird, wird als Int gespeichert
     */
    private int key = 1;

    /**
     * Konstruktor, falls kein Schlüssel mit angegeben wird, erstellt einen Zufälligen Schlüssel
     *
     * @param listy Der zu verschlüsselnde Text wird als Char Array übergeben
     */
    public verschlüssel(char[] listy) {
        this.listy = listy;
        key = (int) (Math.random() * 26) + 0;
        System.out.println("the AUTO generated Key  is : " + key);
    }

    /**
     * Konstruktor, falls ein Schlüssel mit angegeben wird
     *
     * @param listy Der zu verschlüsselnde Text wird als Char Array übergeben
     * @param key   Der Schlüssel um den verschoben werden soll
     */
    public verschlüssel(char[] listy, int key) {
        this.listy = listy;
        this.key = key;
    }

    /**
     * Eine Methode um den Aktuellen gespeicherten Text wiederzugeben
     *
     * @return Den Aktuellen Text, entweder vor oder nach verschlüsselung
     */
    public char[] getlist() {
        return this.listy;
    }

    /**
     * Verschlüsselt den Text
     *
     * @return Der Verschlüsselte Text wird als Char Array wiedergegeben
     */
    public char[] schlüsselmanage() {
        //Falls der Schlüssel größer als das Alphabet ist, wird er angepasst. Fall-> (Key = 28) == (Key = 2)
        int modkey = key % 26;


        //verschlüssseln jedes einzelnen Elements
        for (int i = 0; i < listy.length; i++) {

            //Sonderzeichen, wie Leertaste -> ASCII 32 = SPACE etc, abfangen.
            if (listy[i] < 97 || listy[i] > 122) {
                continue;
            }

            //Element um den Key erhöhen
            listy[i] += modkey;

            //Wenn über z hinaus, dann um 26 reduzieren.
            if (listy[i] >= 123) {
                listy[i] -= 26;
            }
        }
        System.out.println();
        return listy;
    }

    /**
     * Methode um den Schlüssel wiederzugeben
     *
     * @return Den Schlüssel als Integer
     */
    public int getkey() {
        return key;
    }


}
