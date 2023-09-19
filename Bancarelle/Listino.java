import java.util.NoSuchElementException;

/**
 * Interfaccia che descrive il contratto di un <strong>listino</strong> di
 * prezzi.
 * <p>
 * Un listino permette di determinare il prezzo di un {@link Giocattolo} secondo
 * una politica a scelta.
 */
public interface Listino {

    /**
     * Indica se il listino conosce il prezzo di un dato giocattolo.
     *
     * @param giocattolo il giocattolo.
     * @return se il listino conosce, o meno, il prezzo del giocattolo.
     * @throws NullPointerException se {@code giocattolo} è {@code null}
     */
    public boolean conosce(final Giocattolo giocattolo);

    /**
     * Restituisce il prezzo complessivo di una quantità di un giocattolo
     * specificato.
     * Il prezzo complessivo dev'essere determinato secondo una politica
     * arbitraria.
     * 
     * @param g        il giocattolo
     * @param n la quantità
     * @return il prezzo complessivo
     * @throws IllegalArgumentException se {@code n} non è positivo
     * @throws NullPointerException     se {@code o} è {@code null}
     * @throws NoSuchElementException   se il giocattolo {@code g} non è noto al
     *                                  listino
     */
    int prezzo(final int n, final Giocattolo g);
}
