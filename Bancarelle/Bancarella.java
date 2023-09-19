import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Classe concreta che rappresenta una <strong>bancarella<strong>.
 * Una bancarella è dotata di un {@link Listino} e un {@link Inventario}.
 * <p>
 * È un {@link Iterable} dei giocattoli che contiene il suo inventario, in
 * ordine lessicografico del loro nome.
 * <p>
 * Le istanze di questa classe sono mutabili.
 */
public class Bancarella implements Iterable<Giocattolo> {
    /** Il proprietario della bancarella. */
    public final String proprietario;
    /** L'inventario della bancarella. */
    private final Inventario inventario;
    /** Il listino della bancarella. */
    private final Listino listino;

    /*
     * AF(proprietario, inventario, listino) = una bancarella con proprietario,
     * inventario e
     * listino.
     * 
     * IR(proprietario, inventario, listino) = true se:
     * - proprietario != null e non vuoto
     * - inventario != null
     * - listino != null
     * - listino conosce il prezzo di ogni giocattolo presente nell'inventario
     */

    /**
     * Costruisce una bancarella dati proprietario, inventario e listino.
     * 
     * @param proprietario il proprietario della bancarella
     * @param inventario   l'inventario
     * @param listino      il listino
     * @throws NullPointerException     se uno dei parametri è {@code null}
     * @throws IllegalArgumentException se l'inventario contiene un giocattolo il
     *                                  cui prezzo non è presente nel listino
     */
    public Bancarella(final String proprietario, final Inventario inventario, final Listino listino) {
        this.proprietario = Objects.requireNonNull(proprietario, "Il proprietario non può essere null");
        if (proprietario.isEmpty())
            throw new IllegalArgumentException("Il proprietario non deve essere vuoto.");
        this.listino = Objects.requireNonNull(listino, "Il listino non può essere null");
        this.inventario = Objects.requireNonNull(inventario, "L'inventario non può essere null");
        for (Giocattolo g : inventario)
            if (!listino.conosce(g))
                throw new IllegalArgumentException("Il listino manca del prezzo per:" + g);
    }

    /**
     * Vende (rimuove) dall'inventario il giocatolo specificato, nella quantità
     * specificata.
     * 
     * @param g        il giocatolo da vendere
     * @param quantità la quantità da vendere
     * @throws IllegalArgumentException se si prova a vendere una quantità maggiore
     *                                  di quella disponibile oppure se il
     *                                  giocattolo non è presente nell'inventario
     * @throws NullPointerException     se {@code g} è {@code null}
     */
    public int vende(final Giocattolo g, final int quantità) {
        Objects.requireNonNull(g, "g non può essere null");
        return inventario.rimuovi(quantità, g);
    }

    /**
     * Restituisce la quantità disponibile del giocattolo specificato.
     * 
     * @param g il giocattolo
     * @return la quantità disponibile
     * @throws NullPointerException se {@code g} è {@code null}
     */
    public int quantità(final Giocattolo g) {
        return inventario.quantità(Objects.requireNonNull(g, "g non può essere null"));
    }

    /**
     * Restituisce il prezzo della quantità del giocattolo specificato.
     * 
     * @param num        la quantità da vendere
     * @param giocattolo il giocatolo da vendere
     * @return il prezzo totale
     * @throws NullPointerException     se {@code giocattolo} è {@code null}
     * @throws IllegalArgumentException se {@code num} non è positivo o eccede la
     *                                  quantità disponibile
     * @throws NoSuchElementException   se {@code giocattolo} non è noto al listino
     */
    public int prezzo(final int num, final Giocattolo giocattolo) {
        Objects.requireNonNull(giocattolo, "giocattolo non può essere null");
        return listino.prezzo(num, giocattolo);
    }

    @Override
    public Iterator<Giocattolo> iterator() {
        return inventario.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Bancarella))
            return false;
        return ((Bancarella) obj).proprietario.equals(proprietario);
    }

    @Override
    public int hashCode() {
        return proprietario.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append("Bancarella di: " + proprietario + "\n");
        for (final Giocattolo g : inventario)
            result.append(
                    "num. " + inventario.quantità(g) + " " + g + ", prezzo: " + listino.prezzo(1, g) + "\n");
        return result.toString();
    }

}
