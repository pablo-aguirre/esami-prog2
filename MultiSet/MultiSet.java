/**
 * <p>
 * Interfaccia che descrive il contratto di un <strong>multiset</strong>.
 * <p>
 * I metodi che hanno per argomento un <strong>elemento</strong> sono:
 * <ul>
 * <li> 
 * <li> 
 * </ul>
 */
interface MultiSet<E> extends Iterable<E> {
    /**
     * Aggiunge l'elemento specificato al multiset.
     * 
     * @param e l'elemento da aggiungere
     * @return la molteplicità dell'elemento dopo l'aggiunta
     * @throws NullPointerException se {@code e} è {@code null}
     * @throws ClassCastException se l'elemento è di tipo tale da non poter essere aggiunto.
     */
    int add(E e);

    /**
     * Rimuove l'elemento (se presente) specificato dal multiset.
     * 
     * @param o l'elemento da rimuovere
     * @return la molteplicità dell'elemento prima della rimozione
     * @throws NullPointerException se {@code o} è {@code null}
     */
    int remove(Object o);

    /**
     * <p>
     * Restituisce {@code true} se e solo se l'elemento specificato appartiene al
     * multiset.
     * <p>
     * Questo metodo ammette una implementazione di default basata sul metodo
     * {@link #multiplicity(Object)}.
     * 
     * @param o l'elemento di cui verificare la presenza
     * @return {@code true} se e solo se {@code o} appartiene al multiset
     * @throws NullPointerException se {@code o} è {@code null}
     */
    default boolean contains(Object o) {
        return multiplicity(o) > 0;
    }

    /**
     * Restituisce la molteplicità dell'elemento specificato.
     * 
     * @param o l'elemento di cui restituire la molteplicità
     * @return la molteplicità dell'elemento, se presente, 0 altrimenti
     * @throws NullPointerException se {@code o} è {@code null}
     */
    int multiplicity(Object o);

    /**
     * <p>
     * Restituisce la cardinalità data dalla somma delle molteplicità degli elementi
     * contenuti nel multiset.
     * <p>
     * Questo metodo ammette un'implementazione di default basata sul metodo
     * {@link #multiplicity(Object)} e sul fatto che gli elementi del supporto sono
     * iterabili.
     * 
     * @return la cardinalità
     */
    default int size() {
        int size = 0;
        for (E e : this)
            size += multiplicity(e);
        return size;
    }

    /**
     * <p>
     * Restituisce un nuovo multiset ottenuto mediante l'unione di {@code this} e di
     * un altro multiset specificato.
     * <p>
     * Questo metodo non modifica nè {@code this} nè {@code o}.
     * 
     * @param o l'altro multiset
     * @return l'unione tra i due multiset
     * @throws NullPointerException se {@code o} è {@code null}
     */
    MultiSet<E> union(MultiSet<? extends E> o);

    /**
     * <p>
     * Restituisce un nuovo multiset ottenuto mediante l'intersezione di
     * {@code this} e di un altro multiset specificato.
     * <p>
     * Questo metodo non modifica nè {@code this} nè {@code o}.
     * 
     * @param o l'altro multiset
     * @return l'intersezione tra i due multiset
     * @throws NullPointerException se {@code o} è {@code null}
     */
    MultiSet<E> intersection(MultiSet<? extends E> o);
}