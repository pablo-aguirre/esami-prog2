import java.util.Objects;

/**
 * Classe concreta che rappresenta una <strong>durata</strong>.
 * <p>
 * Una durata è un valore non negativo del tipo {@code hh:mm:ss}.
 * <p>
 * Le istanze di questa classe sono immutabili.
 */
public class Durata {
    /** La durata in secondi. */
    public final int secondi;

    /*
     * AF: durata del tipo hh:mm:ss / mm:ss (ore nulle) / ss (ore e minuti nulli)
     * 
     * RI: secondi non è negativo
     */

    /**
     * Costruisce una durata dati i suoi secondi.
     * 
     * @param secondi i secondi
     * @throws IllegalArgumentException se {@code secondi} è negativo
     */
    public Durata(final int secondi) {
        if (secondi < 0)
            throw new IllegalArgumentException("Il parametro secondi non può essere negativo.");
        this.secondi = secondi;
    }

    /**
     * Fabbrica una durata data una stringa del formato "hh:mm:ss".
     * 
     * @param s la durata nel formato specificato
     * @return una durata
     * @throws NullPointerException     se {@code s} è {@code null}
     * @throws IllegalArgumentException se {@code s} non è nel formato indicato
     * @throws NumberFormatException    se uno dei campi di {@code s} non
     *                                  rappresenta un numero
     */
    public static Durata valueOf(final String s) {
        Objects.requireNonNull(s, "La stringa s non può essere null.");
        if (s.isEmpty())
            throw new IllegalArgumentException("La stringa s non può essere vuota.");
        final String[] campi = s.split(":");
        if (!(campi.length == 3))
            throw new IllegalArgumentException("La stringa s non è nel formato specificato.");
        final int ore = Integer.parseInt(campi[0]);
        final int minuti = Integer.parseInt(campi[1]);
        final int secondi = Integer.parseInt(campi[2]);
        return new Durata(ore * 3600 + minuti * 60 + secondi);
    }

    /**
     * Restituisce una nuova durata ottenuta dalla somma di {@code this} e un'altra
     * durata data.
     * 
     * @param other l'altra durata
     * @return la nuova durata, un valore non negativo
     * @throws NullPointerException se {@code other} è {@code null}
     */
    public Durata più(final Durata other) {
        Objects.requireNonNull(other, "Il parametro other non può essere null.");
        return new Durata(secondi + other.secondi);
    }

    /**
     * Restituisce una nuova durata ottenuta dalla sottrazione di {@code this} e
     * un'altra durata data.
     * 
     * @param other l'altra durata
     * @return la differenza delle durate
     * @throws NullPointerException     se {@code other} è {@code null}
     * @throws IllegalArgumentException se {@code other} è maggiore di {@code this}
     */
    public Durata meno(final Durata other) {
        Objects.requireNonNull(other, "Il parametro other non può essere null.");
        if (other.secondi > secondi)
            throw new IllegalArgumentException("La durata di other non può essere maggiore di quella di this.");
        return new Durata(secondi - other.secondi);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(secondi / 3600 == 0 ? "" : Integer.toString((secondi / 3600)) + ":");
        sb.append((secondi / 60) % 60 == 0 ? "" : Integer.toString((secondi / 60) % 60) + ":");
        sb.append(Integer.toString(secondi % 60));
        return sb.toString();
    }

}
