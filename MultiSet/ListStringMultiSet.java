import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
    public int multiplicity(String s) {
        int res = 0;
        for (String e : elements)
            if (s.equals(e))
                res += 1;
        return res;
    }

    @Override
    public StringMultiSet union(StringMultiSet o) {
        ListStringMultiSet res = new ListStringMultiSet(elements);
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
        ListStringMultiSet res = new ListStringMultiSet();
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
        return Collections.unmodifiableSet(new HashSet<String>(elements)).iterator();
    }

}
