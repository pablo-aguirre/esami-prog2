import java.util.Iterator;

/**
 * Classe astratta che implementa {@link #toString()}.
 */
public abstract class AbstractMultiSet<E> implements MultiSet<E> {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        final Iterator<E> it = iterator();

        while (it.hasNext()) {
            final E tmp = it.next();
            sb.append(tmp + ": " + multiplicity(tmp));
            if (it.hasNext())
                sb.append(", ");
        }
        return sb.append("}").toString();
    }
}
