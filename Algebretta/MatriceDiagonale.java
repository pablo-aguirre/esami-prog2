import java.util.Objects;

/** Classe che implementa una matrice diagonale. */
public class MatriceDiagonale extends MatriceAstratta {

    /** I valori lungo la diagonale. */
    private final int[] values;

    /*-
     * AF:  l'i-esimo elemento di values corrisponde al valore in riga c e colonna r, con c = r
     * RI:  values non è null ed ha sempre almeno un elemento
     */

    /**
     * Costruisce una nuova matrice diagonale dati i valori lungo la diagonale.
     * 
     * @param values i valori
     * @throws NullPointerException     se {@code values} è {@code null}
     * @throws IllegalArgumentException se {@code values} contiene un solo valore
     */
    public MatriceDiagonale(final int[] values) {
        Objects.requireNonNull(values, "L'array values non può essere null");
        if (values.length == 0)
            throw new IllegalArgumentException("L'array values deve avere almeno un elemento.");
        this.values = values.clone();
    }

    @Override
    public int dim() {
        return values.length;
    }

    @Override
    public int val(final int row, final int col) {
        if (row < 0 || row >= dim())
            throw new IndexOutOfBoundsException("La coordinata della riga non è valida ");
        if (col < 0 || col >= dim())
            throw new IndexOutOfBoundsException("La coordinata della colonna non è valida ");
        return row == col ? values[row] : 0;
    }

    @Override
    public Matrice per(final int alpha) {
        if (alpha == 0)
            return new MatriceNulla(dim());
        if (alpha == 1)
            return this;
        final int[] newValues = new int[dim()];
        for (int i = 0; i < values.length; i++)
            newValues[i] = alpha * values[i];
        return new MatriceDiagonale(newValues);
    }

    @Override
    public Matrice più(final Matrice M) {
        Objects.requireNonNull(M, "La matrice M non può essere null.");
        if (!conforme(M))
            throw new IllegalArgumentException("La matrice M non è conforme a this");
        if (M instanceof MatriceNulla)
            return this;
        final int[][] newValues = new int[dim()][dim()];
        for (int r = 0; r < dim(); r++)
            for (int c = 0; c < dim(); c++)
                newValues[r][c] = val(r, c) + M.val(r, c);
        return new MatriceDensa(newValues);
    }

    @Override
    public Matrice per(final Matrice M) {
        Objects.requireNonNull(M, "La matrice non può essere null.");
        if (!conforme(M))
            throw new IllegalArgumentException("Le matrici non sono conformi.");
        if (M instanceof MatriceNulla)
            return M;
        if (M instanceof MatriceIdentità)
            return this;
        return new MatriceDensa(this).per(M);
    }

    @Override
    public Vettore per(final Vettore v) {
        Objects.requireNonNull(v, "Il vettore non può essere null.");
        if (!conforme(v))
            throw new IllegalArgumentException("Il vettore e la matrice non sono conformi.");
        if (v instanceof VettoreNullo)
            return v;
        final int[] temp = new int[values.length];
        for (int i = 0; i < values.length; i++)
            temp[i] = values[i] * v.val(i);
        return new VettoreDenso(temp);
    }

}
