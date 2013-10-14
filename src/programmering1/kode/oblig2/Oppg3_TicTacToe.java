package programmering1.kode.oblig2;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 23.09.13
 * Time: 13:05
 */



public class Oppg3_TicTacToe {

    // Hvert "celle" i brettet kan ha kun 3 forskjellige tilstander. Disse defineres som konstanter.
    public static final int TOMT_FELT = 0;
    public static final int KRYSS = 1;
    public static final int RUNDING = 2;

    // Spillet har 4 forskjellige tilstander. Disse defineres også..
    public static final int SPILLET_PAGAR = 0;
    public static final int UAVGJORT = 1;
    public static final int KRYSS_VANT = 2;
    public static final int RUNDING_VANT = 3;


    public static final int RADER = 3, KOLONNER = 3; // definerer st0rrelsen paa brettet
    public static int[][] brett = new int[RADER][KOLONNER]; // brettet lages av en todimensjonal array
    public static int spillStatus;  // statusen paa spillet
    public static int aktivSpiller; // spilleren som staar for tur (kryss eller runding)
    public static int aktivRad, aktivKolonne; // rad og kolonne til den aktive spilleren.

    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Velkommen til Tic-Tac-Toe: Versjon 1.0");
        System.out.println("VEILEDNING: Ved ditt trekk, velg f0rst rad (1-3) bruk MELLOMROM deretter kolonne (1-3)");
        System.out.println("Trykk deretter ENTER for å spille ditt trekk.");
        System.out.println("Eks: 2 1 + ENTER");
        System.out.println("**************************************************");

        startSpillet();   //spillet startes
           //deretter  brukes while-do l0kke for aa holde spillet i gang.
        do {
            nesteTrekk(aktivSpiller);
            oppdaterSpillet(aktivSpiller, aktivRad, aktivKolonne);
            skrivUtBrettet();

            if (spillStatus == KRYSS_VANT) {
                System.out.println("Spiller X vant!");
            } else if (spillStatus == RUNDING_VANT) {
                System.out.println("Spiller O vant!");
            } else if (spillStatus == UAVGJORT) {
                System.out.println("Det ble uavgjort!");
            }
            // bytt spiller og fortsett til en av de andre tilstandene inntreffer
            aktivSpiller = (aktivSpiller == KRYSS) ? RUNDING : KRYSS;
        } while (spillStatus == SPILLET_PAGAR);
    }

    /** Her settes spillet opp */
    public static void startSpillet() {
        for (int rad = 0; rad < RADER; ++rad) {
            for (int kolonne = 0; kolonne < KOLONNER; ++kolonne) {
                brett[rad][kolonne] = TOMT_FELT;  // alle felt settes som tomme
            }
        }
        spillStatus = SPILLET_PAGAR; // setter status paa spillet til aktiv
        aktivSpiller = KRYSS;  // bestemmer at spilleren med X begynner.
    }

    //Spiller definert av aktivSpiller metoden spiller sitt trekk ved å velge rad og deretter kolonne.
    //Deretter oppdateres de globale variablene aktivRad og aktivKolonne.

    public static void nesteTrekk(int aktivSpiller) {
        boolean sjekkInput = false;  // denne sjekker at inntastede verdier er gyldige.
        do {
            if (aktivSpiller == KRYSS) {
                System.out.print("Spiller 'X' - ditt trekk er: ");
            } else {
                System.out.print("Spiller 'O' - ditt trekk er: ");
            }
            int row = sc.nextInt() - 1;  // Java begynner å telle på 0,1,2 osv..  derfor en liten justering, siden brukeren blir bedt om aa taste inn 1-3 istedenfor 0-2.
            int col = sc.nextInt() - 1;
            if (row >= 0 && row < RADER && col >= 0 && col < KOLONNER && brett[row][col] == TOMT_FELT) {
                aktivRad = row;
                aktivKolonne = col;
                brett[aktivRad][aktivKolonne] = aktivSpiller;  // update game-brett content
                sjekkInput = true;  // dersom OK, gaa ut av loopen
            } else {
                System.out.println("Trekket (" + (row + 1) + "," + (col + 1)
                        + ") er ikke gyldig. Pr0v igjen...");
            }
        } while (!sjekkInput);  // fortsett loopen frem til gyldig valg tas av spiller.
    }

    //Oppdaterer spillStatus etter at spilleren med aktivtTrekk har plassert verider paa aktivtRad og aktivKolonne

    public static void oppdaterSpillet(int aktivTrekk, int aktivtRad, int aktivKolonne) {
        if (harVunnet(aktivTrekk, aktivtRad, aktivKolonne)) {  // sjekk for seier
            spillStatus = (aktivTrekk == KRYSS) ? KRYSS_VANT : RUNDING_VANT;
        } else if (erUavgjort()) {  // sjekk for tap
            spillStatus = UAVGJORT;
        }
        // hvis ingen av de tilstandene inntreffer, saa gjelder SPILLET_PAGAR.
    }

    /** uavgjort bestemmes ved at det ikke finnes flere tomme celler og ingen av de andre tilstandene har inntruffet. */

    public static boolean erUavgjort() {
        for (int row = 0; row < RADER; ++row) {
            for (int col = 0; col < KOLONNER; ++col) {
                if (brett[row][col] == TOMT_FELT) {
                    return false;  // tom celle finnes, dermed fortsetter spillet
                }
            }
        }
        return true;  // naar denne blir true saa endres spillstatus til uavgjort og spillet avsluttes.
    }

    /** For aa sjekke om en spiller har vunnet, saa sjekkes alle mulige kombinasjoner paa brettet. Den aktive spilleren ved f0rste "true" paa denne sjekken vinner spillet. */
    public static boolean harVunnet(int aktivSpiller, int currentRow, int currentCol) {
        return (brett[currentRow][0] == aktivSpiller         // sjekk 3 av samme type paa rad
                && brett[currentRow][1] == aktivSpiller
                && brett[currentRow][2] == aktivSpiller
                || brett[0][currentCol] == aktivSpiller      // sjekk 3 av samme type i kollonne
                && brett[1][currentCol] == aktivSpiller
                && brett[2][currentCol] == aktivSpiller
                || currentRow == currentCol            // sjekk diagonalt
                && brett[0][0] == aktivSpiller
                && brett[1][1] == aktivSpiller
                && brett[2][2] == aktivSpiller
                || currentRow + currentCol == 2  // sjekk den motsatte diagonalen
                && brett[0][2] == aktivSpiller
                && brett[1][1] == aktivSpiller
                && brett[2][0] == aktivSpiller);
    }

    /** denne metoden skriver ut brettet etter hvert trekk */
    public static void skrivUtBrettet() {
        for (int row = 0; row < RADER; ++row) {
            for (int col = 0; col < KOLONNER; ++col) {
                skrivUtCelle(brett[row][col]);
                if (col != KOLONNER - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row != RADER - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    /** Skriver ut hver enkelt celle. De har 3 forskjellige statuser som kan vises. */
    public static void skrivUtCelle(int content) {
        switch (content) {
            case TOMT_FELT:  System.out.print("   "); break;
            case RUNDING: System.out.print(" O "); break;
            case KRYSS:  System.out.print(" X "); break;
        }
    }
}