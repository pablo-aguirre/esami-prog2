import java.util.Arrays;

public class MatriceIdentità extends MatriceQuadrata {

    public MatriceIdentità(int dim) {
        super(dim);
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
            return 1;
        return 0;
    }

    @Override
    public MatriceQuadrata per(int alpha) {
        if (alpha == 0)
            return new MatriceNulla(dim);
        if (alpha == 1)
            return new MatriceIdentità(dim);
        final int[] values = new int[dim];
        Arrays.fill(values, 0, dim, alpha);
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
