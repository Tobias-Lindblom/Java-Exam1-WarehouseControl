package app;

import model.Lagermaskin;
import model.Motviktstruck;
import model.Ledstaplare;
import util.Farger;

public class Main {

    public static void main(String[] args) {

        // Skapar våra två första lagermaskiner
        Motviktstruck truck =
                new Motviktstruck("TR-001", "Toyota", 1500);

        Ledstaplare staplare =
                new Ledstaplare("LS-001", "BT", 800);

        // Samlar maskinerna i en gemensam array
        Lagermaskin[] maskiner = {
                truck,
                staplare,
        };

        Farger.rubrik("WAREHOUSE CONTROL");

        System.out.println(
                "Registrerade maskiner: "
                + Lagermaskin.getAntalMaskiner()
        );

        // Loopar igenom maskinerna
        for (Lagermaskin maskin : maskiner) {

            System.out.println();

            visaMaskin(maskin);
        }
    }

    // Polymorfism
    public static void visaMaskin(Lagermaskin maskin) {

        maskin.utforArbete();
    }
}
