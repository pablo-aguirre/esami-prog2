import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Classe concreta che rappresenta un <strong>album</strong>.
 * <p>
 * Un album è caratterizzato da un titolo, un elenco di brani (su cui si può
 * iterare) e una durata complessiva.
 * <p>
 * Le istanze di questa classe sono immutabili.
 */
public class Album implements Iterable<Album.Brano> {

    /**
     * Classe concreta (interna ad {@link Album}) che rappresenta un
     * <strong>brano</strong>.
     * <p>
     * Un brano è caratterizzato da un titolo e da una durata (non nulli).
     * <p>
     * Le istanze di questa classe sono immutabili e possono essere istanziate
     * esclusivamente dal costruttore di {@link Album}.
     */
    public class Brano {

        /** Il titolo del brano. */
        public final String titolo;
        /** La durata del brano. */
        public final Durata durata;

        /*
         * RI:
         * - titolo != null e non vuoto
         * - durata != null e maggiore di 0
         */

        /**
         * Costruisce un nuovo brano dato il suo titolo e la sua durata.
         * 
         * @param titolo il titolo del brano
         * @param durata la durata del brano
         * @throws NullPointerException     se titolo o durata sono {@code null}
         * @throws IllegalArgumentException se titolo è vuoto o durata è 0
         */
        public Brano(final String titolo, final Durata durata) {
            if (Objects.requireNonNull(titolo, "Il titolo non può essere null.").isEmpty())
                throw new IllegalArgumentException("Il titolo non può essere vuoto.");
            if (Objects.requireNonNull(durata, "La dura non può essere null.").secondi == 0)
                throw new IllegalArgumentException("La durata non può essere 0.");
            this.titolo = titolo;
            this.durata = durata;
        }

        /**
         * Getter che restituisce l'album di appartenenza del brano.
         * 
         * @return l'album di appartenenza di {@code this}
         */
        public Album album() {
            return Album.this;
        }

        /**
         * Restituisce una rapprensentazione di questo brano come stringa
         * 
         * @param album se {@code true} aggiunge l'album alla rappresentazione
         * @return una rappresentazione testuale del brano
         */
        public String asString(final boolean album) {
            return String.format("\"%s\" (%s)%s", titolo, durata, album ? ", da \"(" + Album.this.titolo + "\")" : "");
        }

        @Override
        public String toString() {
            return asString(false);
        }
    }

    /** Il titolo dell'album. */
    public final String titolo;
    /** Lista dei brani di cui è composto l'album. */
    private final Brano[] brani;
    /** Durata complessiva dell'album. */
    public final Durata durata;

    /*
     * RI:
     * - titolo != null e non vuoto
     * - brani != null e non vuoto
     * - brani non contiene null e non ha ripetizioni
     * - brani contiene solo brani corrispondenti ad istanze di questo album
     * - durata = somma delle durate dei brani di cui è composto questo album
     */

    /**
     * Costruisce un nuovo album a partire da una lista di titoli dei brani e
     * un'altra lista delle rispettive durate.
     * <p>
     * È richiesto come pre-condizione che la durata in posizione i-esima
     * corrisponda al brano con titolo in posizione i-esima.
     * 
     * @param titolo il titolo dell'album
     * @param titoli i titoli dei brani di cui è composto l'album
     * @param durate le durate delle rispettive canzoni
     * @throws NullPointerException     se uno dei parametri è {@code null} o una
     *                                  delle liste contiene {@code null}
     * @throws IllegalArgumentException se titolo è vuoto,
     *                                  se la dimensione di titoli è diversa da
     *                                  quella di durate o uno delle due è 0,
     *                                  se uno dei titoli è vuoto,
     *                                  oppure se una delle durate è 0
     * 
     */
    public Album(final String titolo, final List<String> titoli, final List<Durata> durate) {
        Objects.requireNonNull(titolo, "Il titolo non può essere null.");
        if (Objects.requireNonNull(titoli, "La lista titoli non può essere null.").isEmpty())
            throw new IllegalArgumentException("La lista titoli è vuota.");
        if (Objects.requireNonNull(durate, "La lista durate non può essere null.").isEmpty())
            throw new IllegalArgumentException("La lista durate è vuota.");
        if (titoli.size() != durate.size())
            throw new IllegalArgumentException("Le due liste devono avere lo stesso numero di elementi.");

        this.titolo = titolo;
        final int nBrani = durate.size();
        brani = new Brano[nBrani];
        Durata durata = new Durata(0);
        for (int i = 0; i < nBrani; i++) {
            final Durata di = durate.get(i);
            brani[i] = new Brano(titoli.get(i), di);
            durata = durata.più(di);
        }
        this.durata = durata;
    }

    /**
     * Restituisce il numero di brani presenti nell'album.
     * 
     * @return il numero di brani
     */
    public int numeroBrani() {
        return brani.length;
    }

    /**
     * Restituisce un brano dato il suo titolo.
     * <p>
     * Non è garnatito che l'album contenga un solo brano con il titolo dato;
     * pertanto questo metodo restituisce la prima occorrenza di tale brano (se
     * presente).
     * 
     * @param titolo il titolo del brano richiesto
     * @return il brano con il titolo dato
     * @throws NullPointerException   se titolo è {@code null}
     * @throws NoSuchElementException se l'album non contiene un brano con il titolo
     *                                dato
     */
    public Brano brano(final String titolo) {
        Objects.requireNonNull(titolo, "Il titolo non può essere null.");
        for (final Brano brano : brani)
            if (brano.titolo.equals(titolo))
                return brano;
        throw new NoSuchElementException("Brano col titolo specificato non presente.");
    }

    /**
     * Restituisce un brano data la sua posizione nell'album.
     * 
     * @param posizione la posizione del brano richiesto
     * @return il brano in posizione data
     * @throws IndexOutOfBoundsException se la posizione indicata non è valida
     *                                   (minore di 1 o maggiore del numero di
     *                                   brani presenti nell'album)
     */
    public Brano brano(final int posizione) {
        if (posizione <= 0 || posizione > brani.length)
            throw new IllegalArgumentException();
        return brani[posizione - 1];
    }

    /**
     * Restituisce la posizione nell'album di un brano dato.
     * 
     * @param brano il brano di cui si richiede la posizione
     * @return la posizione del brano nell'album
     * @throws NullPointerException   se il brano è {@code null}
     * @throws NoSuchElementException se l'album non contiene il brano indicato
     */
    public int posizione(final Brano brano) {
        Objects.requireNonNull(brano, "Il brano non può essere null.");
        for (int i = 0; i < brani.length; i++)
            if (brani[i].equals(brano))
                return i + 1;
        throw new NoSuchElementException("Brano specificato non presente nell'album.");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Titolo album: " + titolo + "\n");
        for (int i = 0; i < brani.length; i++)
            sb.append(i + 1 + " - " + "\"" + brani[i].titolo + "\" (" + brani[i].durata + ")\n");
        return sb.append("Durata totale: " + durata).toString();
    }

    @Override
    public Iterator<Album.Brano> iterator() {
        return Arrays.asList(brani).iterator();
    }
}
