import java.util.Arrays;
import java.util.Objects;

/**
 * Le istanze di questa classe rappresentano dei vettori densi.
 * Gli oggetti di questo tipo sono immutabili.
 */
public class VettoreDenso implements Vettore {

    private final int[] values;

    /**
     * Inizializza {@code this} affinché rappresenti un vettore (denso) contenente i
     * valori dell'array {@code values}.
     * 
     * @param values array contenente i valori da assegnare a {@code this}
     */
    public VettoreDenso(int[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    @Override
    public int dim() {
        return values.length;
    }

    /**
     * @throws IllegalArgumentException se {@code i} non è un indice valido
     */
    @Override
    public int val(int i) {
        if (i < 0 || i >= values.length)
            throw new IllegalArgumentException("indice non valido");
        return values[i];
    }

    @Override
    public Vettore per(int alpha) {
        final int[] values = new int[dim()];
        for (int i = 0; i < values.length; i++)
            values[i] = val(i) * alpha;
        return new VettoreDenso(values);
    }

    /**
     * @throws IllegalArgumentException se {@code v} e {@code this} hanno dimensione
     *                                  diversa
     * @throws NullPointerException     se {@code v} è null
     */
    @Override
    public Vettore più(Vettore v) {
        Objects.requireNonNull(v, "v non può essere null");
        if (v.dim() != dim())
            throw new IllegalArgumentException("il vettore v non ha la stessa dimensione di this");
        final int[] values = new int[dim()];
        for (int i = 0; i < values.length; i++) {
            values[i] = val(i) + v.val(i);
        }
        return new VettoreDenso(values);
    }

    @Override
    public String toString() {
        int iMax = dim() - 1;
        if (iMax == -1)
            return "()";

        StringBuilder b = new StringBuilder("(");
        for (int i = 0;; i++) {
            b.append(val(i));
            if (i == iMax)
                return b.append(')').toString();
            b.append(", ");
        }
    }

}
