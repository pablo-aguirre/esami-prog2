import java.util.Objects;

/**
 * Classe concreata che implementa una {@link Piastrella} romboidale.
 * Gli oggetti di questo tipo sono immutabili.
 */
public class PiastrellaRomboidale extends Piastrella {

    private final int dMin, dMag;

    /*-
     * AF:  AF(dMin, dMag) = una piastrella romboidale con diagonale maggiore = dMag e diagonale minore = dMin
     * IR:  dMin e dMag sono positive
     */

    /**
     * Inizializza {@code this} affinché rappresenti una piastrella romboidale di
     * diagonale minore e maggiore e prezzo dati.
     * 
     * @param prezzo il prezzo
     * @param dMin   la diagonale minore
     * @param dMag   la diagonale maggiore
     * @throws IllegalArgumentException se {@code dMin} o {@code dMag} non sono positive
     */
    public PiastrellaRomboidale(int prezzo, int dMin, int dMag) {
        super(prezzo);
        if (dMin <= 0 || dMag <= 0)
            throw new IllegalArgumentException("Le diagonali devono essere positive.");
        this.dMin = dMin;
        this.dMag = dMag;
    }

    @Override
    public int superficie() {
        return (dMin * dMag) / 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof PiastrellaRomboidale))
            return false;
        PiastrellaRomboidale o = (PiastrellaRomboidale) obj;
        return dMin == o.dMin && dMag == o.dMag && costo() == o.costo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(dMin, dMag, costo());
    }

}
