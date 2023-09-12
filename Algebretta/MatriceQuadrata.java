public abstract class MatriceQuadrata {

    /** La dimensione di {@code this} */
    protected final int dim;

    public MatriceQuadrata(int dim) {
        this.dim = dim;
    }

    /**
     * @return la dimensione di {@code this}
     */
    public final int dim() {
        return dim;
    }

    /**
     * @param row    la riga del valore da restituire
     * @param column la colonna del valore da restituire
     * @return il valore di {@code this} in riga {@code row} e colonna
     *         {@code column}
     */
    public abstract int val(final int row, final int column);

    /**
     * @param alpha lo scalare per cui moltiplicare {@code this}
     * @return il prodotto {@code this*alpha}
     */
    public abstract MatriceQuadrata per(final int alpha);

    /**
     * @param m la matrice da sommare a {@code this}
     * @return la somma matricale {@code this+m}
     */
    public abstract MatriceQuadrata più(final MatriceQuadrata m);

    /**
     * @param m la matrice per cui moltiplicare {@code this}
     * @return il prodotto matriciale {@code this*m}
     */
    public abstract MatriceQuadrata per(final MatriceQuadrata m);

    @Override
    public String toString() {
        int iMax = dim - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int r = 0; r < dim; r++) {
            for (int c = 0; c < dim; c++) {
                b.append(val(r, c));
                if (c == iMax)
                    b.append("; ");
                else
                    b.append(", ");
            }
        }

        b.append(", ");
        return b.toString();

    }
}
