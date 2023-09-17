import java.util.Iterator;

/**
 * Classe astratta che implementa parzialmente {@link StringMultiSet}.
 */
public abstract class AbstractStringMultiSet implements StringMultiSet {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        Iterator<String> it = this.iterator();
        while (it.hasNext()) {
            String k = it.next();
            sb.append(k + ": " + this.multiplicity(k));
            if (it.hasNext())
                sb.append(", ");
        }
        return sb.append("}").toString();
    }
}
