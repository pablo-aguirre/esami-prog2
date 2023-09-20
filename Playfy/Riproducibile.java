/**
 * Interfaccia che descrive il contratto di un oggetto {@code Riproducibile}.
 */
public interface Riproducibile {

    /**
     * Restituisce il nome.
     * 
     * @return il nome
     */
    String nome();

    /**
     * Restituisc la durata.
     * 
     * @return la durata
     */
    Durata durata();

}