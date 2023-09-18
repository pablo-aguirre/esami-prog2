import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Classe concreta che implementa il contratto definito dall'interfaccia
 * {@link Multiset}. Si basa su una mappa dagli elementi {@code E} alle sue
 * molteplicità.
 * Le istanze di questa classe sono mutabili.
 */
public class HashMapMultiSet<E> extends AbstractMultiSet<E> {

    /** Mappa gli elementi di tipo {@code E} alle sue molteplicità. */
    final Map<E, Integer> elements;

    /*-
     * AF(elements) =   multiset i cui elementi corrispondono alle chiavi della
     *                  mappa e le cui molteplicità corrispondono ai valori
     *                  associati a tali chiavi
     * IR(elements) =   elements != null    (verificato in costruzione e successivamente in quanto final)
     *                  ogni elemento della mappa è != null     (verificato durante l'aggiunta)
     *                  i valori associati alle chiavi sono > 0
     */

    /** Costruisce un nuovo multiset vuoto. */
    public HashMapMultiSet() {
        elements = new HashMap<E, Integer>();
    }

    @Override
    public int add(E e) {
        Objects.requireNonNull(e, "e non può essere null");
        final int res = multiplicity(e) + 1;
        elements.put(e, res);
        return res;
    }

    @Override
    public int remove(Object o) {
        Objects.requireNonNull(o, "o non può essere null");
        final int res = multiplicity(o);
        if (res == 1)
            elements.remove(o);
        if (res > 1)
            elements.put((E) o, res - 1);
        return res;
    }

    @Override
    public boolean contains(Object o) {
        Objects.requireNonNull(o, "o non può essere null");
        return elements.get(o) != null ? true : false;
    }

    @Override
    public int size() {
        int res = 0;
        for (E e : this)
            res += multiplicity(e);
        return res;
    }

    @Override
    public int multiplicity(Object o) {
        Objects.requireNonNull(o, "o non può essere null");
        return contains(o) ? elements.get(o) : 0;
    }

    @Override
    public MultiSet<E> union(MultiSet<? extends E> o) {
        Objects.requireNonNull(o, "o non può essere null");
        final HashMapMultiSet<E> res = new HashMapMultiSet<E>();
        for (E e : this)
            if (o.contains(e))
                res.elements.put(e, Math.max(multiplicity(e), o.multiplicity(e)));
            else
                res.elements.put(e, multiplicity(e));
        for (E e : o)
            if (!res.contains(e))
                res.elements.put(e, o.multiplicity(e));
        return res;
    }

    @Override
    public MultiSet<E> intersection(MultiSet<? extends E> o) {
        Objects.requireNonNull(o, "o non può essere null");

        final HashMapMultiSet<E> res = new HashMapMultiSet<E>();
        for (E e : this)
            if (o.contains(e))
                res.elements.put(e, Math.min(multiplicity(e), o.multiplicity(e)));
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return Collections.unmodifiableSet(elements.keySet()).iterator();
    }

}