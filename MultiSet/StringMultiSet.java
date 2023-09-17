/**
 * Interfaccia che descrive il contratto di un MultiSet di {@link String}, una
 * sorta di
 * insieme in cui però ciascun elemento può essere contenuto più di una volta.
 */
public interface StringMultiSet extends Iterable<String> {
    /**
     * Aggiunge un elemento dato a {@code this} e ne
     * restituisce la molteplicità.
     * 
     * @param s l'elemento da aggiungere
     * @return la molteplicità relativa all'elemento aggiunto, un valore non negativo
     * @throws NullPointerException se {@code s} è {@code null}
     */
    int add(String s);

    /**
     * Rimuove l'elemento specificato da {@code this}, restituendone la
     * molteplicità.
     * <p>I tentativi di rimozione di elementi non presenti verranno ignorati.
     * 
     * @param s l'elemento da rimuovere
     * @return la molteplicità relativa all'elemento rimosso, un valore non negativo
     * @throws NullPointerException se {@code s} è {@code null}
     */
    int remove(final String s);

    /**
     * Restitusce {@code true} se e solo se l’elemento specificato appartiene a
     * {@code this}.
     * 
     * @param s l'elemento
     * @return {@code true} se e solo se {@code this} contiene {@code s}
     * @throws NullPointerException se {@code s} è {@code null}
     */
    boolean contains(final String s);

    /**
     * Restituisce la molteplicità in {@code this} dell’elemento specificato.
     * Nel caso l'elemento non appartenga a {@code this}, restituisce {@code 0}.
     * 
     * @param s l'elemento
     * @return la molteplicità di {@code s}, se presente, {@code 0} altrimenti
     * @throws NullPointerException se {@code s} è {@code null}
     */
    int multiplicity(final String s);

    /**
     * Restituisce la cardinalità di {@code this}, valore dato dalla somma delle
     * molteplicità dei suoi elementi.
     * 
     * @return la cardinalità, un valore non negativo
     */
    int size();

    /**
     * Restituisce un multiset ottenuto come unione di {@code this} con quello
     * indicato come argomento.
     * Non modifica {@code this} nè {@code o}.
     * 
     * @param o l'altro multiset
     * @return il nuovo multiset
     * @throws NullPointerException se {@code o} è {@code null}
     */
    StringMultiSet union(final StringMultiSet o);

    /**
     * Restituisce un multiset ottenuto come intersezione di {@code this} con quello
     * indicato come argomento.
     * Non modifica {@code this} nè {@code o}.
     * 
     * @param o l'altro multiset
     * @return il nuovo multiset
     * @throws NullPointerException se {@code o} è {@code null}
     */
    StringMultiSet intersection(StringMultiSet o);
}