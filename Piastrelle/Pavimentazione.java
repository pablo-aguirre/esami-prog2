import java.util.HashMap;
import java.util.Map;

/**
 * Classe concreta che implementa una Pavimetazione.
 * Gli oggetti di questa classe sono mutabili.
 */
public class Pavimentazione implements Superficie {

    private final Map<Superficie, Integer> pavimentazione;

    /*-
     * AF:  AF(pavimentazione) = collezione di superfici (altre pavimentazioni o piastrelle) con le relative quantità
     * IR:  pavimentazione non è null
     */

    /**
     * Inizilizza {@code this} affinché rappresenti una collezione di pavimentazioni
     * vuota.
     */
    public Pavimentazione() {
        pavimentazione = new HashMap<Superficie, Integer>();
    }

    /**
     * @throws IllegalStateException se {@code this} è vuota
     */
    @Override
    public int superficie() {
        if (pavimentazione.size() == 0)
            throw new IllegalStateException("La pavimentazione è vuota.");
        int somma = 0;
        for (Superficie s : pavimentazione.keySet())
            somma += s.superficie() * pavimentazione.get(s);
        return somma;
    }

    /**
     * @throws IllegalStateException se {@code this} è vuota
     */
    @Override
    public int costo() {
        if (pavimentazione.size() == 0)
            throw new IllegalStateException("La pavimentazione è vuota.");
        int costo = 0;
        for (Superficie s : pavimentazione.keySet())
            costo += s.costo() * pavimentazione.get(s);
        return costo;
    }

    /**
     * Aggiunge una superficie a {@code this} in una quantità data.
     * 
     * @param s la superficie
     * @param n la quantità
     * @throws IllegalStateException se {@code this} è vuota
     * @throws IllegalArgumentException se {@code n} è negativa
     */
    public void addSuperficie(Superficie s, int n) {
        if (pavimentazione.size() == 0)
            throw new IllegalStateException("La pavimentazione è vuota.");
        if (n <= 0)
            throw new IllegalArgumentException("La quantità n deve essere positiva.");
        pavimentazione.put(s, n);
    }

}