package util;

public class Farger {

    // Konstanter för terminalens ANSI-färger
    private static final String RESET = "\u001B[0m";
    private static final String ROD = "\u001B[31m";
    private static final String GRON = "\u001B[32m";
    private static final String GUL = "\u001B[33m";
    private static final String CYAN = "\u001B[36m";
    private static final String GRA = "\u001B[90m";

    // Bestämmer kapacitetsindikatorns längd
    private static final int STAPEL_LANGD = 20;

    // Förhindrar att objekt av hjälpklassen skapas
    private Farger() {
    }

    // Metoder för färgsättning av text
    public static String rod(String text) {
        return ROD + text + RESET;
    }
    public static String gron(String text) {
        return GRON + text + RESET;
    }
    public static String gul(String text) {
        return GUL + text + RESET;
    }
    public static String cyan(String text) {
        return CYAN + text + RESET;
    }
    public static String gra(String text) {
        return GRA + text + RESET;
    }

    // Skapar en gemensam rubrik
    public static void rubrik(String text) {

        System.out.println();

        System.out.println(cyan(
                "========================================"
        ));

        System.out.println(cyan("   " + text));

        System.out.println(cyan(
                "========================================"
        ));
    }

    // Skapar en visuell kapacitetsindikator
    public static String kapacitetsindikator(int procent) {

        // Beräknar antalet fyllda segment
        int fyllda = (int) Math.round(
                procent / 100.0 * STAPEL_LANGD
        );

        String stapel = "";
        String fylltSegment;

        // Bestämmer färgen på de fyllda segmenten
        if (procent == 100) {
            fylltSegment = gul("█");
        } else {
            fylltSegment = gron("█");
        }

        // Bygger upp kapacitetsindikatorn
        for (int i = 0; i < STAPEL_LANGD; i++) {

            if (i < fyllda) {
                stapel += fylltSegment;
            } else {
                stapel += gra("░");
            }
        }

        // Returnerar den färdiga stapeln med procentvärde
        return stapel + " " + procent + "%";
    }
}