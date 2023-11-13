package com.company;

import java.io.IOException;

/**
 * die Standartklasse Main
 */
public class Main {

    /**
     * die Standartmethode startet das Programm
     *
     * @param args Standartparamether fuer Main
     * @throws IOException Behandlung einer moeglichen Ausnahme
     */
    public static void main(String[] args) throws IOException {
        menue men = new menue();
        men.start();

    }
}
