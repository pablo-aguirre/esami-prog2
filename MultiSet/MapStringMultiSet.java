import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Classe concreta che implementa l'interfaccia {@link StringMultiSet} mediante
 * della classe astratta {@link AbstractStringMultiSet}.
 * Le istanze di questa classe sono mutabili.
 */
public class MapStringMultiSet extends AbstractStringMultiSet {

    /** Mappa le stringhe sulle molteplicità degli elementi. */
    private Map<String, Integer> elements;

    /*-
     * AF:  ogni elemento con chiave key di elements corrisponde ad un elemento del multiset la cui molteplicità corrisponde al value associato all'elemento con tale chiave
     * RI:  elements != null
     *      ogni chiave (String) di elements è != null
     *      ogni valore associato ad ogni chiave è positivo
     */

    /**
     * Costruisce un nuovo multiset vuoto.
     */
    public MapStringMultiSet() {
        elements = new TreeMap<String, Integer>();
    }

    @Override
    public int add(final String s) {
        Objects.requireNonNull(s, "s non può essere null");
        if (!contains(s)) {
            elements.put(s, 1);
            return 0;
        }
        int res = elements.get(s) + 1;
        elements.put(s, res);
        return res;
    }

    /**
     * @throws NoSuchElementException se {@code this} non contiene {@code s}
     */
    @Override
    public int remove(final String s) {
        Objects.requireNonNull(s, "s non può essere null");
        if (!contains(s))
            throw new NoSuchElementException("elemento " + s + " non presente");
        int res = elements.get(s);
        elements.replace(s, --res);
        return res;
    }

    @Override
    public boolean contains(final String s) {
        Objects.requireNonNull(s, "s non può essere null");
        return elements.containsKey(s);
    }

    @Override
    public int multiplicity(final String s) {
        Objects.requireNonNull(s, "s non può essere null");
        return elements.get(s);
    }

    @Override
    public int size() {
        int res = 0;
        for (String k : elements.keySet())
            res += elements.get(k);
        return res;
    }

    @Override
    public StringMultiSet union(final StringMultiSet o) {
        Objects.requireNonNull(o, "o non può essere null");
        MapStringMultiSet res = new MapStringMultiSet();
        for (String k : o) {
            int max = o.multiplicity(k);
            if (contains(k) && multiplicity(k) > max)
                max = multiplicity(k);
            res.elements.put(k, max);
        }
        for (String k : this)
            if (!res.contains(k))
                res.elements.put(k, multiplicity(k));
        return res;
    }

    @Override
    public StringMultiSet intersection(StringMultiSet o) {
        Objects.requireNonNull(o, "o non può essere null");
        MapStringMultiSet res = new MapStringMultiSet();
        for (String k1 : this) {
            if (o.contains(k1)) {
                int min = multiplicity(k1) < o.multiplicity(k1) ? multiplicity(k1) : o.multiplicity(k1);
                for (int i = 0; i < min; i++)
                    res.add(k1);
            }
        }
        return res;
    }

    @Override
    public Iterator<String> iterator() {
        return Collections.unmodifiableSet(elements.keySet()).iterator();
    }
}
