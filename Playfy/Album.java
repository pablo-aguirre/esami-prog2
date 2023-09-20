import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Classe concreta che rappresenta un <strong>album</album>.
 * <p>
 * Un album è caratterizzato da un titolo, un elenco di album (su cui si può
 * iterare)
 * e una {@code Durata} complessiva.
 * <p>
 * Le istanze di questa classe sono immutabili.
 */
public class Album implements Riproducibile, Iterable<Album.Brano> {

    /**
     * Classe concreta che rappresenta un <strong>brano</ovvero>.
     * <p>
     * Un brano è caratterizzato da un titolo e da una {@link Durata}.
     * <p>
     * Le istanze di questa classe sono immutabili.
     */
    public class Brano implements Riproducibile {

        /** Il titolo del brano. */
        public final String titolo;
        /** La durata del brano. */
        public final Durata durata;

        /*
         * RI:
         * - titolo != null e non vuoto
         * - durata != null e non nulla (maggiore di 0)
         */

        /**
         * Costruisce un nuovo brano dato il suo titolo e la sua {@code Durata}.
         * 
         * @param titolo il titolo del brano
         * @param durata la durata del brano
         * @throws NullPointerException se {@code titolo} o {@code durata} sono
         *                              {@code null}
         */

        public Brano(final String titolo, final Durata durata) {
            this.titolo = Objects.requireNonNull(titolo, "il titolo non può essere null");
            this.durata = Objects.requireNonNull(durata, "la durata non può essere null");
        }

        @Override
        public String nome() {
            return titolo;
        }

        @Override
        public Durata durata() {
            return durata;
        }

    }

    /** Il titolo dell'album. */
    public final String titolo;
    /** Lista delle canzoni di cui è composto l'album. */
    private final List<Brano> brani;
    /** Durata complessiva dell'album. */
    public final Durata durata;

    /*
     * AF: album composto da un elenco di brani memorizzati nella lista omonima di
     * durata = somma delle durate delle canzoni
     * 
     * RI:
     * - titolo != null e non vuoto
     * - brani != null e non vuoto
     * - brani non ha ripetizioni
     * - durata = somma delle durate delle singole canzoni
     */

    /**
     * Costruisce un nuovo album a partire da una lista dei titoli delle canzoni e
     * un'altra lista delle rispettive durate.
     * <p>
     * È richiesto come pre-condizione che la durata in posizione i-esima
     * corrisponda al titolo in posizione i-esima.
     * 
     * @param titoli i titoli delle canzoni di cui è composto l'album
     * @param durate le durate delle rispettive canzoni
     * @throws IllegalArgumentException se {@code titoli} e {@code durate} hanno
     *                                  dimensione diversa oppure se hanno lunghezza
     *                                  nulla
     * @throws NullPointerException     se uno dei parametri è {@code null}
     */
    public Album(final String titolo, final List<String> titoli, final List<Durata> durate) {
        Objects.requireNonNull(titoli, "il titoli non possono essere null");
        Objects.requireNonNull(durate, "le durate non possono essere null");
        if (titoli.size() != durate.size() || titoli.size() == 0)
            throw new IllegalArgumentException(
                    "titoli e durate devono contenere degli elementi ed essere di uguale grandezza (diversa da 0)");

        this.titolo = Objects.requireNonNull(titolo, "titolo non può essere null");
        final int nBrani = durate.size();
        brani = new ArrayList<>(nBrani);
        durata = new Durata(0);
        for (int i = 0; i < nBrani; i++) {
            brani.add(new Brano(titoli.get(i), durate.get(i)));
            durata.più(durate.get(i));
        }
    }

    /**
     * Restituisce un brano dato il suo titolo.
     * 
     * @param titolo il titolo del brano richiesto
     * @return il brano con il titolo dato
     * @throws NullPointerException   se {@code titolo} è {@code null}
     * @throws NoSuchElementException se non esiste un brano con il titolo dato
     */
    public Brano getBrano(final String titolo) {
        Objects.requireNonNull(titolo, "titolo non può essere null");
        for (Brano brano : brani)
            if (brano.titolo.equals(titolo))
                return brano;
        throw new NoSuchElementException("Brano col titolo specificato non presente");
    }

    /**
     * Restituisce un brano data la sua posizione nell'album.
     * 
     * @param posizione la posizione del brano richiesto
     * @return il brano in posizione data
     * @throws NoSuchElementException se la posizione indicata non è valida (minore
     *                                di 1 o maggiore del numero di brani)
     */
    public Brano getBrano(final int posizione) {
        if (posizione <= 0 || posizione > brani.size())
            throw new IllegalArgumentException();
        return brani.get(posizione);
    }

    /**
     * Restituisce la posizione nell'album di un brano dato.
     * 
     * @param brano il brano di cui si richiede la posizione
     * @return la posizione del brano nell'album
     * @throws NullPointerException   se {@code brano} è {@code null}
     * @throws NoSuchElementException se l'album non contiene il brano indicato
     */
    public int getPosizione(final Brano brano) {
        Objects.requireNonNull(brano, "brano non può essere null");
        for (int i = 0; i < brani.size(); i++) {
            if (brani.get(i).equals(brano))
                return i;
        }
        throw new NoSuchElementException("Brano specificato non presente");
    }

    @Override
    public String nome() {
        return titolo;
    }

    @Override
    public Durata durata() {
        return durata;
    }

    @Override
    public Iterator<Album.Brano> iterator() {
        return Collections.unmodifiableList()
    }
}
