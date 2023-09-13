import java.util.Objects;

/** Classe che implementa la matrice nulla. */
public class MatriceNulla extends MatriceAstratta {

    private final int dim;

    public MatriceNulla(final int dim) {
        this.dim = dim;
    }

    @Override
    public int dim() {
        return dim;
    }

    @Override
    public int val(int row, int col) {
        if (row < 0 || row >= dim())
            throw new IndexOutOfBoundsException("La coordinata della riga non è valida ");
        if (col < 0 || col >= dim())
            throw new IndexOutOfBoundsException("La coordinata della colonna non è valida ");
        return 0;
    }

    @Override
    public Matrice per(int alpha) {
        return this;
    }

    @Override
    public Matrice più(Matrice M) {
        Objects.requireNonNull(M, "La matrice M non può essere null");
        if (!conforme(M))
            throw new IllegalArgumentException("La matrice M e this non sono conformi.");
        return M;
    }

    @Override
    public Matrice per(Matrice M) {
        Objects.requireNonNull(M, "La matrice M non può essere null");
        if (!conforme(M))
            throw new IllegalArgumentException("La matrice M e this non sono conformi.");
        return this;
    }

    @Override
    public Matrice per(Vettore V) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'per'");
    }

}
