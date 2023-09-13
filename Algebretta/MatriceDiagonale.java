import java.util.Objects;

/** Le istanze di questa classe rappresentano delle matrici diagonali. */
public class MatriceDiagonale extends MatriceAstratta {
    
    private final int[] values;

    /*-
     * AF:  l'i-esimo elemento di values corrisponde al valore in riga c e colonna r, con c = r
     * RI:  values non è null ed ha sempre almeno un elemento
     */

    /**
     * Costruisce una nuova matrice diagonale a partire da un array dato;
     * 
     * @param values l'array
     * @throws NullPointerException     se {@code values} è {@code null}
     * @throws IllegalArgumentException se {@code values} contiene un solo valore
     */
    public MatriceDiagonale(int[] values) {
        Objects.requireNonNull(values);
        if (values.length == 0)
            throw new IllegalArgumentException("L'array values deve avere almeno un elemento.");
        this.values = values.clone();
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
        if (row == col)
            return values[row];
        return 0;
    }

    @Override
    public Matrice per(int alpha) {
        if (alpha == 0)
            return new MatriceNulla(dim());
        if (alpha == 1)
            return this;
        final int[] newValues = new int[dim()];
        for (int i = 0; i < newValues.length; i++)
            newValues[i] = alpha * val(i, i);
        return new MatriceDiagonale(newValues);
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
