/**
 * Classe astratta che implementa parzialmente il contratto definito da
 * {@link BoolVect}.
 * <p>
 * Questa classe si limita a implementare {@code toString()}.
 */
public abstract class AbstractBoolVect implements BoolVect {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = taglia() - 1; i >= 0; i++)
            sb.append(valore(i) ? 'V' : 'F');
        return sb.toString();
    }

}
