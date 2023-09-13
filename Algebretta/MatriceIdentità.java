import java.util.Arrays;
import java.util.Objects;

/** Classe che implementa la matrice identità. */
public class MatriceIdentità extends MatriceAstratta {
    /** La dimensione della matrice. */
    private final int dim;

    /*-
     * AF:  la matrice identità di dimensioni pari a dim
     * RI:  dim > 0
     */

    /**
     * Costruisce una matrice identità di dimensione data.
     * 
     * @param dim la dimensione
     * @throws IllegalArgumentException se {@code dim} non è positiva
     */
    public MatriceIdentità(int dim) {
        if (dim <= 0)
            throw new IllegalArgumentException("La dimensione deve essere positiva.");
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
        if (row == col)
            return 1;
        return 0;
    }

    @Override
    public Matrice per(int alpha) {
        if (alpha == 0)
            return new MatriceNulla(dim());
        if (alpha == 1)
            return this;
        final int[] newValues = new int[dim()];
        Arrays.fill(newValues, 0, newValues.length, alpha);
        return new MatriceDiagonale(newValues);
    }

    @Override
    public Matrice più(Matrice M) {
        Objects.requireNonNull(M, "La matrice M non può essere null.");
        if (!conforme(M))
            throw new IllegalArgumentException("La matrice M non è conforme a this");
        if (M instanceof MatriceNulla)
            return this;
        return new MatriceDensa(this).più(M);
    }

    @Override
    public Matrice per(Matrice M) {
        Objects.requireNonNull(M, "La matrice non può essere null.");
        if (!conforme(M))
            throw new IllegalArgumentException("Le matrici non sono conformi.");
        return M;
    }

    @Override
    public Vettore per(final Vettore v) {
        Objects.requireNonNull(v, "Il vettore non può essere null.");
        if (!conforme(v))
            throw new IllegalArgumentException("Il vettore e la matrice non sono conformi.");
        return v;
    }

}
