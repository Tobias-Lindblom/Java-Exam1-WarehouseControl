package app;

import util.Farger;

public class Main {

    public static void main(String[] args) {

        Farger.rubrik("WAREHOUSE CONTROL");

        System.out.println(Farger.gron("Godkänt"));
        System.out.println(Farger.rod("Stopp"));
        System.out.println(Farger.gul("Information"));

        System.out.println(
                Farger.kapacitetsindikator(75)
        );
    }
}