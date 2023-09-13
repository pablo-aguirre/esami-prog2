import java.util.Collections;
import java.util.Objects;

/** Classe che implementa il vettore nullo. */
public class VettoreNullo implements Vettore {
    private final int dim;

    public VettoreNullo(final int dim) {
        if (dim <= 0)
            throw new IllegalArgumentException("La dimensione deve essere positiva.");
        this.dim = dim;
    }

    @Override
    public int dim() {
        return dim;
    }

    @Override
    public int val(int i) {
        if (i < 0 || i >= dim)
            throw new IndexOutOfBoundsException("L'indice i non è valido.");
        return 0;
    }

    @Override
    public VettoreNullo per(int alpha) {
        return this;
    }

    @Override
    public Vettore più(Vettore v) {
        Objects.requireNonNull(v, "Il vettore v non può essere null.");
        if (!conforme(v))
            throw new IllegalArgumentException("Il vettore non è conforme a questo.");
        return v;
    }

    @Override
    public String toString() {
        return Collections.nCopies(dim, "0").toString().replace("[","(").replace("]", ")");
    }

}
