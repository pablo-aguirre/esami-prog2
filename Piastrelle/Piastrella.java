/** Classe astratta che implementa parzialmente una {@link Superficie}. */
public abstract class Piastrella implements Superficie {
    /** Il prezzo della Piastrella. */
    private int prezzo;

    /*-
     * AF:  ?
     * RI:  prezzo non può essere negativo
     */

    /**
     * Inizializza il prezzo di {@code this}.
     * 
     * @param prezzo il prezzo
     * @throws IllegalArgumentException se {@code prezzo} non è positivo
     */
    public Piastrella(int prezzo) {
        if (prezzo < 0)
            throw new IllegalArgumentException("Il prezzo deve essere positivo.");
        this.prezzo = prezzo;
    }

    @Override
    final public int costo() {
        return prezzo;
    }

    @Override
    public abstract int superficie();

}
