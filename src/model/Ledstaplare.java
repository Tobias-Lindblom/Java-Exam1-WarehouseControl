package model;

public class Ledstaplare extends Lagermaskin {

    private static final int MAX_LAST = 1200;
    private static final int MAX_LYFTHOJD = 3000;

    // Konstruktor
    public Ledstaplare(
            String maskinId,
            String modell,
            int startLast) {

        super(
                maskinId,
                modell,
                MAX_LAST,
                MAX_LYFTHOJD,
                "elektrisk",
                startLast
        );
    }

    // Ledstaplarens eget arbetsbeteende
    @Override
    public void utforArbete() {

        visaInformation("LEDSTAPLARE");

        System.out.println(
                "Arbete: Placerar gods i ett lagerstallage"
        );

        visaKapacitet();
    }
}
