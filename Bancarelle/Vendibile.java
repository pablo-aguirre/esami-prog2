/**
 * Classe astratta che implemente parzialmente un oggetto
 * <strong>vendibile</strong>, ossia un oggetto dotato di un
 * <strong>prezzo</strong>.
 */
public abstract class Vendibile {

    /** Il prezzo dell'oggetto. */
    private final int price;

    /*
     * RI: prezzo > 0   (verificato in costruzione e successivamente in quanto final)
     */

    /**
     * Inizializza il prezzo dell'oggetto.
     * 
     * @param price il prezzo
     * @throws IllegalArgumentException se {@code price} non è positivo
     */
    public Vendibile(int price) {
        this.price = price;
    }

    /**
     * Restituisce il prezzo dell'oggetto.
     * 
     * @return il prezzo, un valore positivo
     */
    public int price() {
        return price;
    }

}
