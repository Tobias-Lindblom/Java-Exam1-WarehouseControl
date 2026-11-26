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

        // Visar programmets huvudrubrik
        Farger.rubrik("WAREHOUSE CONTROL");

        // Visar amtalet registrerade maskiner
        System.out.println(
                "Registrerade maskiner: "
                + Lagermaskin.getAntalMaskiner()
        );

        // Loopar igenom samtliga maskinerna
        for (Lagermaskin maskin : maskiner) {

            System.out.println();

            visaMaskin(maskin);
        }

        // Testar programmets gemensamma lastregler
        Farger.rubrik("REGELTESTER");

        // Försöker överskrida maskinens maximala last
        testaLastregel(maskiner[0], 3000);

        // Försöker tilldela en negativ last
        testaLastregel(maskiner[0], -100);

        // Visar en sammanfattning av samtliga maskiner
        visaSammanfattning(maskiner);
    }

    // Polymorfism
    public static void visaMaskin(Lagermaskin maskin) {

        maskin.utforArbete();
    }

    // Testar att felaktiga lastvärden stoppas
    private static void testaLastregel(
            Lagermaskin maskin, int forsok) {

        // Sparar aktuell last innan förändringen
        int fore = maskin.getAktuellLast();

        // Visar vilken maskin som testas
        System.out.println(Farger.gul(
                "\nTest: " + maskin.getMaskinId()
        ));

        System.out.println(
                "Före: " + fore + " kg"
        );

        System.out.println(
                "Försöker tilldela: " + forsok + " kg"
        );

        // Försöker ändra maskinens last
        maskin.setLast(forsok);

        // Hämtar lasten efter förändringsförsöket
        int efter = maskin.getAktuellLast();

        System.out.println(
                "Efter: " + efter + " kg"
        );

        // Kontrollerar att det ursprungliga värdet är oförändrat
        if (fore == efter) {

            System.out.println(Farger.gron(
                    "[OK] Lasten är oförändrad."
            ));

        } else {

            System.out.println(Farger.rod(
                    "[FEL] Lasten förändrades."
            ));
        }
    }

    // Summerar samtliga maskiners last och kapacitet
    private static void visaSammanfattning(
            Lagermaskin[] maskiner) {

        // Variabler för sammanställningen
        int totalLast = 0;
        int totalKapacitet = 0;

        // Loopar igenom samtliga maskiner och summerar värdena
        for (Lagermaskin maskin : maskiner) {

            totalLast += maskin.getAktuellLast();

            totalKapacitet += maskin.getMaxLast();
        }

        // Beräknar det totala kapacitetsutnyttjandet
        int procent = (int) Math.round(
                100.0 * totalLast / totalKapacitet
        );

        // Visar lageröversiktens rubrik
        Farger.rubrik("LAGERÖVERSIKT");

        System.out.println(
                "Antal maskiner: "
                + Lagermaskin.getAntalMaskiner()
        );

        System.out.println(
                "Total aktuell last: "
                + totalLast + " kg"
        );

        System.out.println(
                "Total lastkapacitet: "
                + totalKapacitet + " kg"
        );

        System.out.println(
                "Ledig lastkapacitet: "
                + (totalKapacitet - totalLast) + " kg"
        );

        // Visar en visuell indikator för den totala kapaciteten
        System.out.println(
                Farger.kapacitetsindikator(procent)
        );

        // Avslutar utskriften
        System.out.println(Farger.cyan(
                "========================================"
        ));
    }
}
