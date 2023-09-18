/**
 * Interfaccia che descrive il contratto di un <strong>listino</strong>, il
 * quale permette di rappresentare diverse politiche di prezzo per un oggetto
 * {@link Vendibile}.
 */
public interface Listino {
    /**
     * Restituisce il prezzo complessivo della quantità di un oggetto vendibile specificato.
     * Il prezzo complessivo viene determinato secondo una politica di prezzo.
     * 
     * @param o        l'oggetto
     * @param quantity la quantità
     * @return il prezzo complessivo
     * @throws IllegalArgumentException se {@code quantity} non è positivo
     * @throws NullPointerException     se {@code o} è {@code null}
     */
    int totalPrice(Vendibile o, int quantity);
}
