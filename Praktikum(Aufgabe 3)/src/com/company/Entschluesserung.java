package com.company;

/**
 * die Instanzen von der Klasse erfolgen Entschlüsserung von
 * einem Text anhand eines gegebenen Schlüssels.
 */
public class Entschluesserung {
    /**
     * ein Chararray mit veschlüsseltem Text
     */
    private char[] text;

    /**
     * eine Intvariable mit dem Schlüsselwert
     */
    private int schluessel;

    /**
     * der Klaasenconstructor
     * @param text Chararray mit veschlüsseltem Text
     * @param schluessel Intvariable mit dem Schlüsselwert
     */
    public Entschluesserung(char[] text, int schluessel) {
        this.text = text;
        this.schluessel = schluessel;
    }
    /**
     * die Methode entschlüsst den Text mithilfe des Schlüssels.
     * @return gibt den entschlüsselten Text als ein Chararray zurück
     */
    public char[] entschluesseln() {
        // berechne den Schlüssel immer als Modulo 26, falls er größer, als 26 ist, ist die Verschiebung immer gleich 26
        schluessel = schluessel % 26;
        char[] originalText = text;
        char[] decodText = new char[originalText.length];
        for (int i = 0; i < originalText.length; i++) {
            //speichere Charwert als int Wert
            int zahlOriginal = originalText[i];
            //mit der Bedingung bleiben Sonderzeiche unverändlich
            if(zahlOriginal>122||zahlOriginal<97){
                continue;
            }
            //schiebe den Intwert um Wert von Schlüssel
            zahlOriginal -= schluessel;
            if (zahlOriginal < 97) {
                zahlOriginal += 26;
            }
            //speichere neuen Charwert in neues Array
            decodText[i] = (char)zahlOriginal;
        }
        return decodText;
        }
    }

