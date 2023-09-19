import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Classe concreta che rappresenta un <strong>inventario</strong>.
 * <p>
 * Un inventario permette di tenere traccia del numero di giocatoli in una
 * collezione di essi; ad esso è possibile aggiungere o rimuovere giocattoli e
 * conoscere quanti giocatoli di un certo tipo contenga.
 * <p>
 * È un {@link Iterable} dei giocattoli che contiene, ordinati per ordine
 * lessicografico del loro {@link Giocattolo#nome}.
 * <p>
 * Le istanze di questa classe sono mutabili.
 */
public class Inventario implements Iterable<Giocattolo> {
    /**
     * Mappa i giocattoli presenti nell'inventario alle rispettive quantità.
     */
    private final Map<Giocattolo, Integer> inventario;

    /*
     * AF(inventario) = inventario i cui giocattoli corrispondono alle chiavi della
     * mappa e le cui quantità corrispondono ai valori associati a tali chiavi.
     * 
     * IR(elements) = vero se:
     * - elements != null (verificato in costruzione e dopo in quanto final)
     * - ogni chiave di elements è != null
     * - ogni valore associato ad ogni chiave è != null e positivo
     */

    /** Costruisce un nuovo inventario vuoto. */
    public Inventario() {
        inventario = new HashMap<Giocattolo, Integer>();
    }

    /**
     * Costruisce un inventario a partire da una mappa che per ogni
     * {@link Giocattolo} indica la loro quantità.
     * 
     * @param inventario la mappa tra giocattoli e la loro quantità
     * @throws NullPointerException     se {@code inventario} è {@code null} o se
     *                                  contiene qualche chiave o valore
     *                                  {@code null}
     * @throws IllegalArgumentException se almeno un valore è non positivo
     */
    public Inventario(final Map<Giocattolo, Integer> inventario) {
        this();
        Objects.requireNonNull(inventario, "L'inventario non può essere null");
        for (Map.Entry<Giocattolo, Integer> e : inventario.entrySet())
            aggiungi(e.getValue(), e.getKey());
    }

    /**
     * Aggiunge a {@code this} un giocattolo con una quantità specificata. Se tale
     * giocattolo è già presente, ne aggiorna la quantità.
     * 
     * @param quantità   numero di giocattoli da aggiungere
     * @param giocattolo il giocattolo da aggiungere
     * @return la quantità presente del giocattolo appena aggiunto
     * @throws NullPointerException     se {@code giocattolo} è {@code null}
     * @throws IllegalArgumentException se {@code quantità} non è positiva
     */
    public int aggiungi(final int quantità, final Giocattolo giocattolo) {
        Objects.requireNonNull(giocattolo, "Il giocattolo non può essere null");
        if (quantità <= 0)
            throw new IllegalArgumentException("La quantità deve essere positiva");
        int res = quantità;
        if (inventario.containsKey(giocattolo))
            res += inventario.get(giocattolo);
        inventario.put(giocattolo, res);
        return res;
    }

    /**
     * Aggiunge a {@code this} giocattolo in quantità pari a {@code 1}.
     * 
     * @param giocattolo il giocattolo
     * @return la quantità presente del giocattolo appena aggiunto
     * @throws NullPointerException se {@code giocattolo} è {@code null}
     */
    public int aggiungi(final Giocattolo giocattolo) {
        Objects.requireNonNull(giocattolo, "Il giocattolo non può essere null");
        return aggiungi(1, giocattolo);
    }

    /**
     * Rimuove (se possibile) la quantità data del giocattolo dato.
     * 
     * @param n          la quantità da rimuovere
     * @param giocattolo il giocattolo
     * @throws NullPointerException     se {@code giocattolo} è {@code null}
     * @throws NoSuchElementException   se {@code giocattolo} non è presente
     *                                  nell'inventario
     * @throws IllegalArgumentException se {@code n} non è positivo o eccede la
     *                                  quantità disponibile
     */
    public int rimuovi(final int n, final Giocattolo giocattolo) {
        Objects.requireNonNull(giocattolo, "Il giocattolo non può essere null");
        if (n <= 0)
            throw new IllegalArgumentException("Il numero n deve essere positivo");
        if (!inventario.containsKey(giocattolo))
            throw new NoSuchElementException("Il giocatolo " + giocattolo + " non è presente");
        final int totale = inventario.get(giocattolo) - n;
        if (totale < 0)
            throw new IllegalArgumentException("Non ci sono abbastanza giocattoli:" + giocattolo);
        if (totale == 0)
            inventario.remove(giocattolo);
        else
            inventario.put(giocattolo, totale);
        return totale;
    }

    /**
     * Restituisce la quantità del giocattolo specificato nell'inventario.
     * 
     * @param giocattolo il giocattolo
     * @return la quantità presente per il giocatolo specificato
     * @throws NullPointerException se {@code giocattolo} è {@code null}
     */
    public int quantità(final Giocattolo giocattolo) {
        Objects.requireNonNull(giocattolo, "Il giocattolo non può essere null");
        return inventario.containsKey(giocattolo) ? inventario.get(giocattolo) : 0;
    }

    @Override
    public Iterator<Giocattolo> iterator() {
        final List<Giocattolo> res = new ArrayList<>(inventario.keySet());
        Collections.sort(res, new Comparator<Giocattolo>() {
            @Override
            public int compare(Giocattolo o1, Giocattolo o2) {
                return o1.nome.compareTo(o2.nome);
            }
        });
        return res.iterator();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Giocattolo g : this)
            sb.append(inventario.get(g) + " " + g + "\n");
        return sb.toString();
    }
}