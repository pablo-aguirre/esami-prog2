public class MatriceNulla extends MatriceQuadrata {

    public MatriceNulla(int dim) {
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
        return 0;
    }

    @Override
    public MatriceQuadrata per(int alpha) {
        return new MatriceNulla(alpha);
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
