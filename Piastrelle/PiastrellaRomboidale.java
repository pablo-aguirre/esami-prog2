import java.util.Objects;

/**
 * Classe che rappresenta una {@link Piastrella} romboidale.
 * Gli oggetti di questo tipo sono immutabili.
 */
public class PiastrellaRomboidale extends Piastrella {

    /** La diagonale maggiore (sempre positiva) e non minore di quella minore. */
    public final int diagonaleMaggiore;
    /** La diagonale minore (sempre positiva) e non maggiore di quella maggiore. */
    public final int diagonaleMinore;

    /*-
     * AF:  AF(diagonaleMinore, diagonaleMaggiore) = una piastrella romboidale con diagonale maggiore uguale
     *                       a diagonaleMaggiore e diagonale minore uguale a diagonaleMinore.
     * IR:  diagonaleMinore e diagonaleMaggiore sono positive
     *      diagonaleMinore <= diagonaleMaggiore
     */

    /**
     * Costruisce una piastrella romboidale dato il suo costo e la lunghezza delle
     * sue diagonali.
     * 
     * @param costo il costo
     * @param diagonale1   una delle due diagonali
     * @param diagonale2   l'altra diagonale
     * @throws IllegalArgumentException se {@code diagonaleMinore} o {@code diagonaleMaggiore} non sono
     *                                  positive
     */
    public PiastrellaRomboidale(final int diagonale1, final int diagonale2, final int costo) {
        super(costo);
        if (diagonale1 <= 0 || diagonale2 <= 0)
            throw new IllegalArgumentException("Le diagonali devono essere positive.");
        if (diagonale1 < diagonale2) {
            this.diagonaleMinore = diagonale1;
            this.diagonaleMaggiore = diagonale2;
        } else {
            this.diagonaleMaggiore = diagonale1;
            this.diagonaleMinore = diagonale2;
        }
    }

    @Override
    public int superficie() {
        return (diagonaleMinore * diagonaleMaggiore) / 2;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (!(obj instanceof PiastrellaRomboidale))
    //         return false;
    //     PiastrellaRomboidale o = (PiastrellaRomboidale) obj;
    //     return diagonaleMinore == o.diagonaleMinore && diagonaleMaggiore == o.diagonaleMaggiore && costo() == o.costo();
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(diagonaleMinore, diagonaleMaggiore, costo());
    // }

}
