import java.util.Objects;

/** Le istanze di questa classe rappresentano delle matrici dense. */
public class MatriceDensa extends MatriceAstratta {

    /** I valori della matrice. */
    private final int[][] values;

    /*-
     * AF:  l'elemento di posizione values[r][c] corrisponde al valore al valore in riga r e colonna c.
     * IR:  values non è null
     *      values è una matrice quadrata di dimensione almeno 1x1
     */

    /**
     * Costruisce una matrice di dimensione data, con tutti i valori pari a 0.
     * 
     * @param dim la dimensione
     * @throws IllegalArgumentException se {@code dim} non è positiva
     */
    private MatriceDensa(final int dim) {
        if (dim <= 0)
            throw new IllegalArgumentException("La dimensione deve essere positiva.");
        values = new int[dim][dim];
    }

    /**
     * Costruisce un nuova matrice densa a partire da un array (di array).
     * 
     * @param values l'array
     * @throws NullPointerException     se {@code values} è {@code null}
     * @throws IllegalArgumentException se {@code values} contiene un solo valore
     */
    public MatriceDensa(final int[][] values) {
        Objects.requireNonNull(values, "La matrice values non può essere null.");
        if (values.length == 0)
            throw new IllegalArgumentException("La matrice values deve contenere almeno un valore.");

        this.values = new int[values.length][];
        for (int r = 0; r < values.length; r++) {
            if (values[r].length != values.length)
                throw new IllegalArgumentException("La matrice values dev'essere quadrata.");
            this.values[r] = values[r].clone();
        }
    }

    /**
     * Costruisce una matrice copiando i valori di una matrice data.
     *
     * @param A la matrice
     * @throws IllegalArgumentException se la matrice è {@code null}
     */
    public MatriceDensa(final Matrice A) {
        this(Objects.requireNonNull(A, "La matrice A non può essere null.").dim());
        for (int r = 0; r < dim(); r++)
            for (int c = 0; c < dim(); c++)
                values[r][c] = A.val(r, c);
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
        return values[row][col];
    }

    @Override
    public Matrice per(final int alpha) {
        if (alpha == 0)
            return new MatriceNulla(dim());
        if (alpha == 1)
            return this;
        final MatriceDensa res = new MatriceDensa(dim());
        for (int r = 0; r < dim(); r++)
            for (int c = 0; c < dim(); c++)
                res.values[r][c] = this.values[r][c] * alpha;
        return res;
    }

    @Override
    public Matrice più(final Matrice M) {
        Objects.requireNonNull(M, "La matrice M non può essere null.");
        if (!conforme(M))
            throw new IllegalArgumentException("La matrice M non è conforme a this");
        if (M instanceof MatriceNulla)
            return this;
        final MatriceDensa res = new MatriceDensa(dim());
        for (int r = 0; r < dim(); r++)
            for (int c = 0; c < dim(); c++)
                res.values[r][c] = this.values[r][c] + M.val(r, c);
        return res;
    }

    @Override
    public Matrice per(Matrice M) {
        Objects.requireNonNull(M, "La matrice M non può essere null.");
        if (!conforme(M))
            throw new IllegalArgumentException("La matrice M non è conforme a this.");
        if (M instanceof MatriceNulla)
            return M;
        if (M instanceof MatriceIdentità)
            return this;
        final MatriceDensa res = new MatriceDensa(dim());
        for (int r = 0; r < dim(); r++)
            for (int c = 0; c < dim(); c++)
                for (int i = 0; i < dim(); i++)
                    res.values[r][c] += this.values[r][i] * M.val(i, c);
        return res;
    }

    @Override
    public Vettore per(final Vettore v) {
        Objects.requireNonNull(v, "Il vettore v non può essere null.");
        if (!conforme(v))
            throw new IllegalArgumentException("Il vettore v non è conforme a this.");
        if (v instanceof VettoreNullo)
            return v;
        final int[] temp = new int[values.length];
        for (int i = 0; i < values.length; i++)
            for (int j = 0; j < values.length; j++)
                temp[i] += values[i][j] * v.val(j);
        return new VettoreDenso(temp);
    }
}
