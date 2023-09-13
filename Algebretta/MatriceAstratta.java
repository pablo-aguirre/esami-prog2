/**
 * Classe astratta creata per implementare efficientemente
 * {@link Object#toString()}
 */
public abstract class MatriceAstratta implements Matrice {
    @Override
    public String toString() {
        int iMax = dim() - 1;
        StringBuilder sb = new StringBuilder("[");
        for (int r = 0; r < dim(); r++) {
            for (int c = 0; c < dim(); c++) {
                sb.append(val(r, c));
                if (c != iMax)
                    sb.append(", ");
            }
            if (r != iMax)
                sb.append("; ");
        }
        return sb.append(']').toString();
    }
}
