import java.util.Iterator;

/**
 * Classe astratta che implementa il metodno {@link #toString() toString}.
 */
public abstract class AbstractStringMultiSet implements StringMultiSet {

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        final Iterator<String> it = this.iterator();

        while (it.hasNext()) {
            final String s = it.next();
            sb.append(s + ": " + this.multiplicity(s));
            if (it.hasNext())
                sb.append(", ");
        }
        return sb.append("}").toString();
    }
}
