package model;

public class Palldragare extends Lagermaskin {

    // Palldragarens fasta egenskaper
    private static  final int MAX_LAST = 2000;
    private static final int MAX_LYFTHOJD = 200;

    // Konstruktor
    public Palldragare(
            String maskinId,
            String modell,
            int startLast) {

        // Anropar superklassens konstruktor
        super(
                maskinId,
                modell,
                MAX_LAST,
                MAX_LYFTHOJD,
                "Manuell",
                startLast
        );
    }

    // Palldragarens egen version av den abstrakta metoden
    @Override
    public void utforArbete() {

        // Visar maskinens grundinformation
        visaInformation("PALLDRAGARE");

        // Visar palldragarens specifika arbetsuppgift
        System.out.println(
                "Arbete: Förflyttar gods till packstationen."
        );

        // visar maskinens aktuella last och kapacitet
        visaKapacitet();
    }
}
