import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Classe concreta che implementa il contratto definito in {@link MultiSet}.
 * Questa classe usa una lista con elementi ripetuti per rappresentare il
 * multiset.
 * Le istanze di questa classe sono mutabili.
 */
public class ListMultiSet<E> extends AbstractMultiSet<E> {

    /** Lista contenente gli elementi del multiset. */
    final List<E> elements;

    /*-
     * AF(elements) = multiset i cui elementi sono identificati dagli elementi 
     *                della lista (elementi ripetuti rappresentano lo stesso elemento),
     *                la molteplicità di ogni elemento corrisponde al numero di occorrenze
     *                di tale elemento nelle lista.
     * RI: elements non è null (verificato in costruzione e successivamente in quanto final)
     *     gli elementi di di elements non sono null    (verificato durante l'aggiunta dell'elemento)
     */

    /** Costruisce un nuovo multiset vuoto. */
    public ListMultiSet() {
        elements = new LinkedList<E>();
    }

    @Override
    public int add(E e) {
        Objects.requireNonNull(e, "e non può essere null");
        elements.add(e);
        return multiplicity(e);
    }

    @Override
    public int remove(Object o) {
        Objects.requireNonNull(o, "o non può essere null");
        final int res = multiplicity(o);
        elements.remove(o);
        return res;
    }

    @Override
    public int multiplicity(Object o) {
        Objects.requireNonNull(o, "o non può essere null");
        return Collections.frequency(elements, o);
    }

    @Override
    public MultiSet<E> union(MultiSet<? extends E> o) {
        Objects.requireNonNull(o, "o non può essere null");
        final ListMultiSet<E> res = new ListMultiSet<>();
        for (final E e : this) {
            int max = Math.max(multiplicity(e), o.multiplicity(e));
            res.elements.addAll(Collections.nCopies(max, e));
        }
        for (final E e : o) {
            if (!res.contains(e))
                res.elements.addAll(Collections.nCopies(o.multiplicity(e), e));
        }

        return res;
    }

    @Override
    public MultiSet<E> intersection(MultiSet<? extends E> o) {
        Objects.requireNonNull(o, "o non può essere null");

        final ListMultiSet<E> res = new ListMultiSet<>();
        for (final E e : this)
            if (o.contains(e))
                res.elements.addAll(Collections.nCopies(Math.min(multiplicity(e), o.multiplicity(e)), e));
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private final Iterator<E> it = elements.iterator();
            private E next = null;
            private int idx = -1;

            @Override
            public boolean hasNext() {
                if (next != null)
                    return true;
                while (it.hasNext()) {
                    final E candidate = it.next();
                    if (elements.indexOf(candidate) == ++idx) {
                        next = candidate;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                final E res = next;
                next = null;
                return res;
            }
        };
    }

}
