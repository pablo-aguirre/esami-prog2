/**
 * Classe astratta e immutabile che rappresenta una <em> piastrella; implementa
 * parzialmente l'interfaccia {@link Superficie}, il cui stato è dato dal
 * costo.
 */
public abstract class Piastrella implements Superficie {

    /** Il costo della piastrella, sempre positivo. */
    private final int costo;

    /**
     * Costruisce una piastrella dato il suo costo.
     * 
     * @param costo il costo
     * @throws IllegalArgumentException se {@code costo} non è positivo
     */
    public Piastrella(final int costo) {
        if (costo <= 0)
            throw new IllegalArgumentException("Il costo deve essere positivo.");
        this.costo = costo;
    }

    @Override
    public int costo() {
        return costo;
    }
}
