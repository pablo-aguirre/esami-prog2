import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Classe concreta che implementa il contratto definito nell'interfaccia
 * {@link StringMultiSet}.
 * Si basa su una lista con ripetizioni.
 * Le istanze di questa classe sono mutabili.
 */
public class ListStringMultiSet extends AbstractStringMultiSet {

    /** La lista degli elementi del multiset. */
    private final List<String> elements;

    /*-
     * AF:  Gli n elementi uguali all'interno della lista rappresentano l'elemento con molteplicità pari alle volte che l'elemento si ripete nella lista.
     * IR:  elements != null    (vero in costruzione e successivamente in quanto final)
     *      ogni elemento di elements è != null     (verificato nell'unico metodo che vi aggiunge elementi)
     */

    /** Costruisce un nuovo multiset vuoto. */
    public ListStringMultiSet() {
        elements = new LinkedList<String>();
    }

    /**
     * Costruisce un nuovo multiset a partire da una lista di elementi.
     * 
     * @param l la lista di elementi
     * @throws NullPointerException se {@code l} è {@code null}
     */
    private ListStringMultiSet(List<String> l) {
        Objects.requireNonNull(l, "l non può essere null");
        elements = new LinkedList<String>();
        for (String s : l)
            elements.add(s);
    }

    @Override
    public int add(String s) {
        Objects.requireNonNull(s, "s non può essere null");
        elements.add(s);
        return multiplicity(s);
    }

    @Override
    public int remove(String s) {
        final int res = multiplicity(s);
        elements.remove(s);
        return res;
    }

    @Override
    public boolean contains(String s) {
        return elements.contains(s);
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public int multiplicity(String s) {
        return Collections.frequency(elements, s);
    }

    @Override
    public StringMultiSet union(StringMultiSet o) {
        Objects.requireNonNull(o, "o non può essere null");
        final ListStringMultiSet res = new ListStringMultiSet(elements);
        for (String s : o) {
            if (multiplicity(s) < o.multiplicity(s)) {
                for (int i = 0; i < o.multiplicity(s) - multiplicity(s); i++)
                    res.elements.add(s);
            }
        }
        return res;
    }

    @Override
    public StringMultiSet intersection(StringMultiSet o) {
        Objects.requireNonNull(o, "o non può esser null");
        final ListStringMultiSet res = new ListStringMultiSet();
        for (String s : this)
            if (o.contains(s)) {
                final int min = Math.min(multiplicity(s), o.multiplicity(s));
                for (int i = 0; i < min; i++)
                    res.add(s);
            }
        return res;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private final Iterator<String> it = elements.iterator();
            private String next = null;
            private int idx = -1;

            @Override
            public boolean hasNext() {
                if (next != null)
                    return true;
                while(it.hasNext()) {
                    final String candidate = it.next();
                    if (elements.indexOf(candidate) == ++idx) {
                        next = candidate;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public String next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                final String result = next;
                next = null;
                return result;
            }
        };
    }

}
