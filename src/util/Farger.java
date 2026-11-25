package util;

public class Farger {

    private static String RESET = "\u001B[0m";
    private static String ROD = "\u001B[31m";
    private static String GRON = "\u001B[32m";
    private static String GUL = "\u001B[33m";
    private static String CYAN = "\u001B[36m";
    private static String GRA = "\u001B[90m";

    private static final int STAPEL_LANGD = 20;

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

        int fyllda = (int) Math.round(
                procent / 100.0 * STAPEL_LANGD
        );

        String stapel = "";

        for (int i = 0; i < STAPEL_LANGD; i++) {

            if (i < fyllda) {

                if (procent == 100) {
                    stapel += gul("█");
                } else {
                    stapel += gron("█");
                }

            } else {
                stapel += gra("░");
            }
        }

        return stapel + " " + procent + "%";
    }

}

