import java.util.Objects;

/** Classe che implementa la matrice nulla. */
public class MatriceNulla extends MatriceAstratta {

    /** La dimensione della matrice. */
    private final int dim;

    /*-
     * AF:  la matrice nulla di dimensioni pari a dim
     * RI:  dim > 0
     */

    /**
     * Costruisca una matrice nulla data la sua dimensione.
     * 
     * @param dim la dimensione
     * @throws IllegalArgumentException se {@code dim} non è positiva
     */
    public MatriceNulla(final int dim) {
        if (dim <= 0)
            throw new IllegalArgumentException("La dimensione dev'essere positiva.");
        this.dim = dim;
    }

    @Override
    public int dim() {
        return dim;
    }

    @Override
    public int val(final int row, final int col) {
        if (row < 0 || row >= dim())
            throw new IndexOutOfBoundsException("La coordinata della riga non è valida ");
        if (col < 0 || col >= dim())
            throw new IndexOutOfBoundsException("La coordinata della colonna non è valida ");
        return 0;
    }

    @Override
    public Matrice per(final int alpha) {
        return this;
    }

    @Override
    public Matrice più(final Matrice M) {
        Objects.requireNonNull(M, "La matrice M non può essere null.");
        if (!conforme(M))
            throw new IllegalArgumentException("La matrice M e this non sono conformi.");
        return M;
    }

    @Override
    public Matrice per(final Matrice M) {
        Objects.requireNonNull(M, "La matrice M non può essere null");
        if (!conforme(M))
            throw new IllegalArgumentException("La matrice M e this non sono conformi.");
        return this;
    }

    @Override
    public Vettore per(final Vettore v) {
        Objects.requireNonNull(v, "Il vettore v non può essere null.");
        if (!conforme(v))
            throw new IllegalArgumentException("Il vettore e la matrice non sono conformi.");
        return new VettoreNullo(dim);
    }

}
