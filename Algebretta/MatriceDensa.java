import java.util.Arrays;

public class MatriceDensa extends MatriceQuadrata {

    private final int[][] values;

    public MatriceDensa(int dim, int[][] values) {
        super(dim);
        for (int i = 0; i < dim; i++)
            values[i] = Arrays.copyOf(values[i], dim);
        this.values = Arrays.copyOf(values, dim);
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
        return values[row][column];
    }

    @Override
    public MatriceQuadrata per(int alpha) {
        if (alpha == 0)
            return new MatriceNulla(dim);
        if (alpha == 1)
            return new MatriceDensa(dim, values);
        final int[][] values = new int[dim][dim];
        for (int r = 0; r < dim; r++)
            for (int c = 0; c < dim; c++)
                values[r][c] = this.values[r][c] * alpha;
        return new MatriceDensa(dim, values);
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
