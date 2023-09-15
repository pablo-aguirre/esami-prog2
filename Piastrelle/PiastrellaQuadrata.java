/**
 * Classe che rappresenta una {@link Piastrella} quadrata.
 * Gli oggetti di questo tipo sono immutabili.
 */
public class PiastrellaQuadrata extends Piastrella {

    /** Il lato della piastrella, sempre positivo. */
    public final int lato;

    /*-
     * AF:  AF(lato) = una piastrella quadrata con lunghezza lato = lato
     * IR:  lato è sempre positivo
     */

    /**
     * Costruisce una piastrella dato il suo costo e lato.
     * 
     * @param lato  il lato
     * @param costo il costo
     * @throws IllegalArgumentException se {@code lato} o {@code costo} non sono
     *                                  positivi
     */
    public PiastrellaQuadrata(final int lato, final int costo) {
        super(costo);
        if (lato <= 0)
            throw new IllegalArgumentException("Il lato deve essere positivo.");
        this.lato = lato;
    }

    @Override
    public int superficie() {
        return lato * lato;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (!(obj instanceof PiastrellaQuadrata))
    //         return false;
    //     PiastrellaQuadrata o = (PiastrellaQuadrata) obj;
    //     return o.lato == lato && costo() == o.costo();
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(lato, costo());
    // }

}
