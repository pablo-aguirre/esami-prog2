import java.util.Objects;

/**
 * Classe concreata che implementa una {@link Piastrella} quadrata.
 * Gli oggetti di questo tipo sono immutabili.
 */
public class PiastrellaQuadrata extends Piastrella {

    private final int lato;

    /*-
     * AF:  AF(lato) = una piastrella quadrata di lato = lato
     * IR:  lato è positivo
     */

    /**
     * Inizializza {@code this} affinché rappresenti una piastrella quadrata di
     * lato e prezzo dati.
     * 
     * @param lato il lato
     * @throws IllegalArgumentException se {@code lato} non è positivo
     */
    public PiastrellaQuadrata(int prezzo, int lato) {
        super(prezzo);
        if (lato <= 0)
            throw new IllegalArgumentException("Il lato deve essere positivo.");
        this.lato = lato;
    }

    @Override
    public int superficie() {
        return lato * lato;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof PiastrellaQuadrata))
            return false;
        PiastrellaQuadrata o = (PiastrellaQuadrata) obj;
        return o.lato == lato && costo() == o.costo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(lato, costo());
    }

}
