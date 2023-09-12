import java.util.Arrays;

public class MatriceDiagonale extends MatriceQuadrata {

    private final int[] values;

    public MatriceDiagonale(int dim, int[] values) {
        super(dim);
        this.values = Arrays.copyOf(values, values.length);
    }

    /**
     * @throws IllegalArgumentException se {@code row} o {@code column} non sono
     *                                  degli indici validi
     */
    @Override
    public int val(int row, int column) {
        if (row < 0 || row >= dim)
            throw new IllegalArgumentException("row dev'essere un indice valido");
        if (column < 0 || column >= dim)
            throw new IllegalArgumentException("column dev'essere un indice valido");
        if (row == column)
            return values[row];
        return 0;
    }

    @Override
    public MatriceQuadrata per(int alpha) {
        if (alpha == 0) return new MatriceNulla(dim);
        if (alpha == 1) return new MatriceDiagonale(dim, values);
        final int[] values = new int[dim];
        for (int i = 0; i < values.length; i++)
            values[i] = val(i, i) * alpha;
        return new MatriceDiagonale(dim, values);
    }

    @Override
    public MatriceQuadrata più(MatriceQuadrata m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'più'");
    }

    @Override
    public MatriceQuadrata per(MatriceQuadrata m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'per'");
    }

}
