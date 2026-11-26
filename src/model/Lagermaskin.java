package model;

import util.Farger;

public abstract class Lagermaskin {

    private static int antalMaskiner = 0;

    private final String maskinId;
    private final String modell;
    private final int maxLast;
    private final int maxLyfthojd;
    private final String drivning;
    private int aktuellLast;

    // Gemensam konstruktor för samtliga maskiner
    protected Lagermaskin(
            String maskinId,
            String modell,
            int maxLast,
            int maxLyfthojd,
            String drivning,
            int startLast) {

        this.maskinId = maskinId;
        this.modell = modell;
        this.maxLast = maxLast;
        this.maxLyfthojd = maxLyfthojd;
        this.drivning = drivning;
        this.aktuellLast = 0;

        setLast(startLast);

        antalMaskiner++;
    }

    // Getters
    public String getMaskinId() {
        return maskinId;
    }

    public String getModell() {
        return modell;
    }

    public int getMaxLast() {
        return maxLast;
    }

    public int getMaxLyfthojd() {
        return maxLyfthojd;
    }

    public String getDrivning() {
        return drivning;
    }

    public int getAktuellLast() {
        return aktuellLast;
    }

    public static int getAntalMaskiner() {
        return antalMaskiner;
    }

    // Gemensam regel för samtliga maskiner
    public final void setLast (int vikt) {

        if (vikt < 0 || vikt > maxLast) {

            System.out.println(Farger.rod(
                    "[STOPP] " + vikt + " kg är inte tillåtet. "
                    + "tillåten intervall: 0-"
                    + maxLast + " kg."
            ));

            return;
        }

        this.aktuellLast = vikt;
    }

    // Beräknar återstående lastkapacitet
    public int getLedigKapacitet() {
        return maxLast - aktuellLast;
    }

    // Beräknar kapacitetsutnyttjandet i procent
    public int getKapacitetsProcent() {

        return (int) Math.round(
                100.0 * aktuellLast / maxLast
        );
    }

    // Gemensam presentation av maskininformation
    protected void visaInformation(String typ) {

        System.out.println(Farger.gul(
                maskinId + " | " + typ
        ));

        System.out.println(
                "----------------------------------------"
        );

        System.out.println("Modell: " + modell);
        System.out.println("Drivning: " + drivning);

        System.out.println(
                "Max lyfthöjd: " + maxLyfthojd + " mm"
        );
    }

    // Visar maskinens lastkapacitet
    protected void visaKapacitet() {

        System.out.println(
                "Aktuell last: " + aktuellLast
                        + " / " + maxLast + " kg"
        );

        System.out.println(
                Farger.kapacitetsindikator(
                        getKapacitetsProcent()
                )
        );

        // Visar maskinens återstående lastkapacitet
        System.out.println(
                "Ledig kapacitet: "
                        + getLedigKapacitet() + " kg"
        );

        // Kontrollerar maskinens kapacitetsstatus
        if (aktuellLast == maxLast) {

            System.out.println(
                    Farger.gul("Status: FULL KAPACITET")
            );

        } else {

            System.out.println(
                    Farger.gron("Status: LEDIG KAPACITET")
            );
        }
    }

    // Alla maskintyper måste ha ett eget arbetsbeteende
    public abstract void utforArbete();
}
