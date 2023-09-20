import java.util.Objects;

/**
 * Classe concreta che rappresenta una <strong>durata</durata>.
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
     * Costruisce una durata dato il suo formato "hh:mm:ss".
     * <p>
     * È richiesto come pre condizione che ogni campo sia lungo 2.
     * 
     * @param s durata in formato stringa
     * @throws NullPointerException     se {@code s} è {@code null}
     * @throws IllegalArgumentException se {@code s} non è nel formato indicato
     * @throws NumberFormatException    se uno dei campi di {@code s} non è valido
     */
    public Durata(final String s) {
        Objects.requireNonNull(s, "s non può essere null");
        final String[] campi = s.split(":");
        if (!(campi.length == 3))
            throw new IllegalArgumentException("s non è nel formato specificato");
        secondi = Integer.parseInt(campi[0]) * 3600 + Integer.parseInt(campi[1]) * 60 + Integer.parseInt(campi[2]);
    }

    /**
     * Costruisce una durata dati i suoi secondi.
     * 
     * @param secondi i secondi
     * @throws IllegalArgumentException se {@code secondi} è negativo
     */
    public Durata(final int secondi) {
        if (secondi < 0)
            throw new IllegalArgumentException("secondi non può essere negativo");
        this.secondi = secondi;
    }

    /**
     * Restituisce una nuova durata ottenuta dalla somma di {@code this} e un'altra
     * durata data.
     * 
     * @param o l'altra durata
     * @return la nuova durata, un valore non negativo
     * @throws NullPointerException se {@code o} è {@code null}
     */
    public Durata più(final Durata o) {
        Objects.requireNonNull(o, "o non può essere null");
        return new Durata(secondi + o.secondi);
    }

    /**
     * Restituisce una nuova durata ottenuta dalla sottrazione di {@code this} e
     * un'altra durata data.
     * 
     * @param o l'altra durata
     * @return la nuova durata
     * @throws NullPointerException     se {@code o} è {@code null}
     * @throws IllegalArgumentException se {@code o} è maggiore di {@code this}
     */
    public Durata meno(final Durata o) {
        Objects.requireNonNull(o, "o non può essere null");
        if (o.secondi > secondi)
            throw new IllegalArgumentException("la durata di o non può essere maggiore di quella di this");
        return new Durata(secondi - o.secondi);
    }

    /**
     * Restituisce la rappresentazione del tipo {@code hh:mm:ss}.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(secondi/3600) + Integer.toString((secondi%3600)/60) + Integer.toString(((secondi%3600)%60)));
        return sb.toString();
    }

}
