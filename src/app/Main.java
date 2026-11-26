package app;

import model.Lagermaskin;
import model.Motviktstruck;
import model.Ledstaplare;
import model.Palldragare;
import util.Farger;


public class Main {

    private static final String VERSION = "1.0.0";

    public static void main(String[] args) {

        // Skapar våra två första lagermaskiner
        Motviktstruck truck =
                new Motviktstruck("TR-001", "Toyota", 1500);

        Ledstaplare staplare =
                new Ledstaplare("LS-001", "BT", 800);

        Palldragare dragare =
                new Palldragare("PD-001", "BT Lifter", 500);

        // Samlar maskinerna i en gemensam array
        Lagermaskin[] maskiner = {
                truck,
                staplare,
                dragare,
        };

        // Visar programmets huvudrubrik
        Farger.rubrik("WAREHOUSE CONTROL");

        System.out.println(
                "Maskin- och lasthantering"
        );

        System.out.println(
                "Version: " + VERSION
        );

        // Visar antalet registrerade maskiner
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

        int antalTester = 0;
        int godkandaTester = 0;

        for (Lagermaskin maskin : maskiner) {

            // Sparar ursprunglig last innan testerna
            int ursprungligLast = maskin.getAktuellLast();

            // Test 1: Negativ last
            antalTester++;

            if (testaLastregel(maskin, -1, false)) {
                godkandaTester++;
            }

            // Test 2: Last över maxgränsen
            antalTester++;

            if (testaLastregel(
                    maskin, maskin.getMaxLast() + 1, false)) {

                godkandaTester++;
            }

            // Test 3: Minsta tillåtna last
            antalTester++;

            if (testaLastregel(maskin, 0, true)) {
                godkandaTester++;
            }

            // Test 4: Exakt maximal last
            antalTester++;

            if (testaLastregel(
                    maskin, maskin.getMaxLast(), true)) {
                godkandaTester++;
            }

            // Återställer maskinens ursprungliga last
            maskin.setLast(ursprungligLast);

            System.out.println(Farger.cyan(
                    "Ursprunglig last återställd: "
                    + maskin.getAktuellLast() + " kg"
            ));
        }

        // Visar sammanställning av regeltesterna
        Farger.rubrik("TESTRESULTAT");

        System.out.println("Genomförda tester: " + antalTester);

        System.out.println(Farger.gron(
                "Godkända tester: " + godkandaTester
        ));

        System.out.println(
                "misslyckade tester: "
                + (antalTester - godkandaTester)
        );

        if (godkandaTester == antalTester) {

            System.out.println(Farger.gron(
                    "[OK] Samtliga regeltester godkända."
            ));
        } else {

            System.out.println(Farger.rod(
                    "[FEL] Ett eller flera tester misslyckades."
            ));
        }

        // Visar sammanfattningen efter genomförda tester
        visaSammanfattning(maskiner);
    }

    // Polymorfism
    public static void visaMaskin(Lagermaskin maskin) {

        maskin.utforArbete();
    }

    // Testar att lastregeln fungerar enligt förväntat resultat
    private static boolean testaLastregel(
            Lagermaskin maskin,
            int forsok,
            boolean skaAcceptera) {

        // Soarar maskinens aktuella last
        int fore = maskin.getAktuellLast();

        System.out.println(Farger.gul(
                "\nTest: " + maskin.getMaskinId()
        ));

        System.out.println("Före: " + fore + " kg");

        System.out.println(
                "Försöker tilldela: " + forsok + " kg"
        );

        // Visar det förväntade resultatet
        if (skaAcceptera) {
            System.out.println("Förväntat: Accepteras");
        } else {
            System.out.println("Förväntat: Nekas");
        }

        // Försöker ändra maskinens last
        maskin.setLast(forsok);

        int efter = maskin.getAktuellLast();

        System.out.println("Efter: " + efter + " kg");

        // Bestämmer vilket värde vi förväntar oss
        int forvantadLast;

        if (skaAcceptera) {
            forvantadLast = forsok;
        } else {
            forvantadLast = fore;
        }

        // Kontrollerar omm testet lyckades
        if (efter == forvantadLast) {

            System.out.println(Farger.gron(
                    "[OK] Testet lyckades."
            ));

            return true;
        } else {

            System.out.println(Farger.rod(
                    "[FEL] Testet misslyckades."
            ));

            return false;
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
