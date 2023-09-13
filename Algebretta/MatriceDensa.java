import java.util.Objects;

/** Le istanze di questa classe rappresentano delle matrici dense. */
public class MatriceDensa extends MatriceAstratta {

    private final int[][] values;

    /*-
     * AF:  l'elemento di posizione values[r][c] corrisponde al valore al valore in riga r e colonna c.
     * IR:  values contiene almeno un elemento
     *      ogni values[r] contiene almeno un elemento (con r = 0,..,values.legth-1)
     *      values è una matrice quadrata
     */

    /**
     * Costruisce un nuova matrice densa a partire da una matrice data.
     * 
     * @param values la matrice
     * @throws NullPointerException     se {@code values} è {@code null}
     * @throws IllegalArgumentException se {@code values} contiene un solo valore
     */
    public MatriceDensa(int[][] values) {
        Objects.requireNonNull(values);
        if (values.length == 0)
            throw new IllegalArgumentException("La matrice values deve contenere almeno un valore.");

        this.values = new int[values.length][];
        for (int r = 0; r < values.length; r++) {
            if (values[r].length != values.length)
                throw new IllegalArgumentException("La matrice values dev'essere quadrata.");
            this.values[r] = values[r].clone();
        }
    }

    @Override
    public int dim() {
        return values.length;
    }

    @Override
    public int val(int row, int col) {
        if (row < 0 || row >= dim())
            throw new IndexOutOfBoundsException("La coordinata della riga non è valida ");
        if (col < 0 || col >= dim())
            throw new IndexOutOfBoundsException("La coordinata della colonna non è valida ");
        return values[row][col];
    }

    @Override
    public Matrice per(int alpha) {
        if (alpha == 0)
            return new MatriceNulla(dim());
        if (alpha == 1)
            return this;
        final int[][] newValues = new int[dim()][dim()];
        for (int r = 0; r < values.length; r++)
            for (int c = 0; c < values[r].length; c++)
                newValues[r][c] = values[r][c] * alpha;
        return new MatriceDensa(newValues);
    }

    @Override
    public Matrice più(Matrice M) {
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
    public Matrice per(Matrice M) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'per'");
    }

    @Override
    public Matrice per(Vettore V) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'per'");
    }
}
