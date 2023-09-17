import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Classe concreta che implementa il contratto definito nelll'interfaccia {@link StringMultiSet} basata su
 * una mappa tra elementi e loro molteplicità.
 * Le istanze di questa classe sono mutabili.
 */
public class MapStringMultiSet extends AbstractStringMultiSet {

    /** Mappa che, per ciascun elemento del multiset, ne indica la molteplicità. */
    private final Map<String, Integer> elements;

    /*-
     * AF:  ogni elemento con chiave key di elements corrisponde ad un elemento del multiset la cui molteplicità corrisponde al value associato all'elemento con tale chiave
     * RI:  elements != null    (vero in costruzione e successivamente in quanto final)
     *      ogni chiave (String) di elements è != null      (garantito dai metodi che ne mutano il contenuto)
     *      ogni valore associato ad ogni chiave è positivo
     */

    /**
     * Costruisce un nuovo multiset vuoto.
     */
    public MapStringMultiSet() {
        elements = new HashMap<String, Integer>();
    }

    @Override
    public int add(final String s) {
        Objects.requireNonNull(s, "s non può essere null");
        int m = multiplicity(s);
        elements.put(s, ++m);
        return m;
    }

    @Override
    public int remove(final String s) {
        Objects.requireNonNull(s, "s non può essere null");
        int m = multiplicity(s);
        if (m == 1)
            elements.remove(s);
        else if (m > 1)
            elements.put(s, m - 1);
        return m;
    }

    @Override
    public int multiplicity(final String s) {
        Objects.requireNonNull(s, "s non può essere null");
        return elements.containsKey(s) ? elements.get(s) : 0;
    }

    @Override
    public boolean contains(final String s) {
        Objects.requireNonNull(s, "s non può essere null");
        return elements.containsKey(s);
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
        for (String k : o)
            res.elements.put(k, Math.max(o.multiplicity(k), multiplicity(k)));
        for (String k : this)
            if (!res.contains(k))
                res.elements.put(k, multiplicity(k));
        return res;
    }

    @Override
    public StringMultiSet intersection(StringMultiSet o) {
        Objects.requireNonNull(o, "o non può essere null");
        MapStringMultiSet res = new MapStringMultiSet();
        for (String k : this) 
            if (o.contains(k))
                res.elements.put(k, Math.min(o.multiplicity(k), multiplicity(k)));
        return res;
    }

    @Override
    public Iterator<String> iterator() {
        return Collections.unmodifiableSet(elements.keySet()).iterator();
    }
}
