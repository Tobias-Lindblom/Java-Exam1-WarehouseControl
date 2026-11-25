package model;

public class Motviktstruck extends Lagermaskin {

    private static final int MAX_LAST = 2500;
    private static final int MAX_LYFTHOJD = 4500;

    // Konstruktor
    public Motviktstruck(
            String maskinId,
            String modell,
            int startLast) {

        super(
                maskinId,
                modell,
                MAX_LAST,
                MAX_LYFTHOJD,
                "Elektrisk",
                startLast
        );
    }

    // Motviktstruckens eget arbetsbeteende
    @Override
    public void utforArbete() {

        visaInformation("MOTVIKTSTRUCK");

        System.out.println(
                "Arbete: Lastar och lossar gods vid lastkajen."
        );

        visaKapacitet();
    }
}
