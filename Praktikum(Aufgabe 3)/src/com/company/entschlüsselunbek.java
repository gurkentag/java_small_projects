package com.company;
/**
 *
 * Die Instanzen der Klasse berechnen den Schlüssel eines Original- und eines Verschlüsselten Textes_
 *
 */

public class entschlüsselunbek {
    /**
     * Der verschlüsselte Text
     */
    private char[] encrypted;
    /**
     * Der Original/Nicht verschlüsselte Text
     */
    private char[] decrypted;
    /**
     * Der Schlüssel, der gefunden wird
     */
    private int key;

    /**
     * Konstruktor
     * @param encry Der Verschlüsselte Text wird zum vergleichen übergeben
     * @param decry Der Unverschlüsselte Text wird zum vergleichen übergeben
     */
    public entschlüsselunbek(char[] encry, char[] decry) {
        this.encrypted = encry;
        this.decrypted = decry;
    }
    /**
     * Der Schlüssel wird aus den beiden Texten berechnet
     * @return Der Int wert, des errechneten versatzes, der Texte
     */
    public int schluesselausgabe() {

        int ekey = (int)encrypted[0];
        int dkey = (int)decrypted[0];
        key = ekey - dkey;

        if(key < 0) {
            key += 26;
        }

        return key;
    }



}
