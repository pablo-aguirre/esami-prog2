import java.util.NoSuchElementException;

/**
 * Interfaccia che definisce il contratto di un <strong>inventario</strong>, il
 * quale permette di tenere traccia di oggetti che vengono aggiunti ed
 * eliminati.
 */
public interface Inventario<E> extends Iterable<E> {

    /**
     * Aggiunge un oggetto dall'inventario.
     * 
     * @param e l'oggetto da aggiungere
     * @throws NullPointerException se {@code e} è {@code null}
     */
    void add(E e);

    /**
     * Rimuove un oggetto dall'inventario.
     * 
     * @param e l'oggetto da rimuovere
     * @throws NoSuchElementException se {@code e} non è presente nell'inventario
     * @throws NullPointerException   se {@code e} è {@code null}
     */
    void remove(E e);

    /**
     * Restituisce la quantità presente nell'inventario dell'oggetto specificato.
     * Se l'elemento specificato non è presente restituisce 0.
     * 
     * @param e l'oggetto di cui verificare la quantità
     * @return la quantità
     * @throws NullPointerException se {@code e} è {@code null}
     */
    int quantity(E e);

    /**
     * Restituisce il numero di oggetti presenti nell'inventario.
     * 
     * @return il numero di oggetti
     */
    int size();
}
