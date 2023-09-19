import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * <p>
 * Classe concreta che implementa il contratto definito da {@link Listino}.
 * <p>
 * Un <strong>listino moltiplicativo</strong> determina il prezzo totale di
 * {@code n} giocattoli dello stesso tipo moltiplicando il prezzo unitario di
 * quel tipo di giocattolo per {@code n}.
 * <p>
 * Le istanze di questa classe sono immutabili.
 */
public class ListinoMoltiplicativo implements Listino {

    /** Mappa che tiene traccia dei prezzi di un singolo giocattolo. */
    private final Map<Giocattolo, Integer> prezzi;

    /*
     * AF(prezzi) = listino di prezzi unitari di un insieme di giocattoli
     * dove ogni giocattolo è identificato univocamente dalle chiavi della mappa
     * e ogni prezzo corrisponde al valore associato a tale chiave
     * 
     * RI(prezzi) = vero se:
     * - prezzi != null
     * - ogni chiave è != null
     * - ogni valore è != null e positivo
     */

    /**
     * Costruisce un listino data una mappa da giocattoli al loro prezzo unitario.
     * 
     * @param prezzi la mappa
     * @throws NullPointerException     se {@code prezzi} è {@code null}
     * @throws IllegalArgumentException se almeno un valore della mappa non è
     *                                  positivo
     */
    public ListinoMoltiplicativo(final Map<Giocattolo, Integer> prezzi) {
        Objects.requireNonNull(prezzi, "prezzi non può essere null");
        this.prezzi = new HashMap<Giocattolo, Integer>();

        for (Map.Entry<Giocattolo, Integer> e : prezzi.entrySet()) {
            final Giocattolo g = Objects.requireNonNull(e.getKey(), "Non ci possono essere chiavi nulle nella mappa.");
            final Integer p = Objects.requireNonNull(e.getValue(), "Non ci possono essere valori nulli nella mappa.");
            if (p <= 0)
                throw new IllegalArgumentException("Il prezzo di " + g + "non può essere negativo.");
            this.prezzi.put(g, p);
        }
    }

    /**
     * Restituisce il prezzo unitario di un dato giocattolo.
     * 
     * @param giocattolo il giocattolo di cui determinare il prezzo
     * @return il prezzo unitario di {@code giocattolo}
     * @throws NullPointerException   se {@code giocattolo} è {@code null}
     * @throws NoSuchElementException se {@code this} non contiene
     *                                {@code giocattolo}
     */
    public int prezzoUnitario(final Giocattolo giocattolo) {
        Objects.requireNonNull(giocattolo, "Il giocattolo non può essere null.");
        final Integer res = prezzi.get(giocattolo);
        if (res == null)
            throw new NoSuchElementException("Il giocattolo " + giocattolo + " non è presente.");
        return res;
    }

    @Override
    public boolean conosce(final Giocattolo giocattolo) {
        return prezzi.containsKey(Objects.requireNonNull(giocattolo, "giocattolo non può essere null"));
    }

    @Override
    public int prezzo(final int n, final Giocattolo g) {
        Objects.requireNonNull(g, "Il giocattolo non può essere null.");
        if (n <= 0)
            throw new IllegalArgumentException("n deve essere positivo");
        return prezzoUnitario(g) * n;
    }

}
