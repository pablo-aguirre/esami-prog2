import java.util.Arrays;
import java.util.Objects;

/** Classe che implementa la matrice identità. */
public class MatriceIdentità extends MatriceAstratta {

    private final int dim;

    public MatriceIdentità(int dim) {
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
