package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * die Klasse erfolgt das Einlesen vom eingegebenen Text und dessen Formatierung
 * und enthält notwendige Methoden dafür.
 */
public class Formatierung {
    /**
     * ein BufferedReder, der für Lesen gebraucht wird
     */
    private BufferedReader leser;

    /**
     * der Klassenconstructer
     *
     * @param pfad nimmt als Parameter den Namen und gleichzeitig die Adresse vom Text
     * @throws IOException Behandlung von einer möglichen Exception
     */
    public Formatierung(String pfad) throws IOException {
        InputStream is = new FileInputStream(pfad);
        this.leser = new BufferedReader(new InputStreamReader(is));
    }

    /**
     * die Methode ließt den Text,solange der nicht leere Zeilen enthält.
     *
     * @return gibt den eingelesenen Text in Form von einer Arrayliste mit Strings
     * @throws IOException Behandlung von einer möglichen Exception
     */
    public List<String> einlesen() throws IOException {
        List<String> eingelesenerText = new ArrayList<>();
        String zeile = new String();
        //ließ den Text, solange die Zeilen nicht leer sind
        boolean finished = false;
        while (!finished) {
            zeile = this.leser.readLine();
            if (zeile != null) {
                eingelesenerText.add(zeile);
            } else {
                finished = true;
            }
        }
        this.leser.close();
        return eingelesenerText;
    }

    /**
     * die Methode ersetzt Umlaute und "ß" fier die weitere Anwendung.
     *
     * @param text nimmt als Parameter eingelesenen Text in Form von einer Stringliste
     * @return gibt das Ergebnis als ein Chararray zurück
     */
    public char[] ersetzeBuchstaben(List<String> text) {
        StringBuilder sb = new StringBuilder();
        //speichere jedes einzelnes Zeichen,gleichzeitig es ins kleine umzuwandeln
        for (int i = 0; i < text.size(); i++) {
            sb.append(text.get(i).toLowerCase());
        }
        while (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }
        for (int i = 0; i < sb.length(); i++) {
            switch (sb.charAt(i)) {
                case 'ü':
                    sb.deleteCharAt(i);
                    sb.insert(i, 'u');
                    sb.insert(i + 1, 'e');
                    break;

                case 'ä':
                    sb.deleteCharAt(i);
                    sb.insert(i, 'a');
                    sb.insert(i + 1, 'e');
                    break;

                case 'ö':
                    sb.deleteCharAt(i);
                    sb.insert(i, 'o');
                    sb.insert(i + 1, 'e');
                    break;

                case 'ß':
                    sb.deleteCharAt(i);
                    sb.insert(i, 's');
                    sb.insert(i + 1, 's');
                    break;
                default:

            }
        }
        return sb.toString().toCharArray();

    }

}
