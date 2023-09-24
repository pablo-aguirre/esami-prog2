/**
 * Interfaccia che descrive il contratto di un <strong>BoolVect</strong>.
 * <p>
 * Un boolvect è un vettore di valori booleani dato da una sequenza di valori di
 * verità ({@code V}/{@code F}).
 * <p>
 * Un boolvect è dotato di una <strong>dimensione</strong>, corrispondente alla
 * posizione più grande dove si trova un valore vero, e da una
 * <strong>taglia</strong> data dalla massima dimensione che può raggiungere
 * (può essere "infinita" = {@link Integer#MAX_VALUE}).
 * <p>
 * Su un boolvect sono definite le seguenti <strong>operazioni</strong>:
 * <ul>
 * <li>lettura dell'i-esimo elemento
 * <li>scrittura dell'i-esimo elemento
 * <li>and logico ({@code &}) componente a componente tra boolvect
 * <li>or logico ({@code |}) componente a componente tra boolvect
 * <li>xor logico ({@code ^}) componente a componente tra boolvect
 * </ul>
 */
public interface BoolVect {

    /**
     * Restituisce la dimensione di questo boolvect.
     * <p>
     * La dimensione è il più grande intero tale che il valore {@code d} di verità
     * in posizione {@code d-1} del boolvect è {@code true}. La dimensione ha un
     * valore compreso tra 0 e la {@code taglia} (estremi inclusi).
     * 
     * @return la dimensione
     */
    int dim();

    /**
     * Restituisce la taglia di questo boolvect.
     * <p>
     * La taglia è il massimo valore possibile per la dimensione. La taglia è un
     * valore positivo sempre maggiore o uguale alla {@code dimensione} e vale
     * {@link Integer#MAX_VALUE} se la dimensione non è limitata.
     * 
     * @return la taglia
     */
    int taglia();

    /**
     * Legge il valore nella posizione data.
     * <p>
     * Se la posizione indicata eccede la dimensione (o taglia) viene restituito
     * {@code false}.
     * 
     * @param posizione la posizione del valore da leggere
     * @return il valore
     * @throws IndexOutOfBoundsException se la posizione è negativa
     */
    boolean leggi(final int posizione);

    /**
     * Scrive il valore dato nella posizione specificata
     * 
     * @param posizione la posizione del valore da scrivere
     * @param valore    il valore da scrivere
     * @throws IndexOutOfBoundsException se la posizione è negativa, o il valore è
     *                                   {@code true} e la posizione è maggiore o
     *                                   uguale alla taglia
     */
    void scrivi(final int posizione, final boolean valore);

    /**
     * Rende questo boolvect uguale all'<em>and componente a componente</em> di
     * questo boolvect e quello specificato.
     * 
     * @param altro l'altro boolvect
     * @throws NullPointerException se altro è {@code null}
     */
    void and(final BoolVect altro);

    /**
     * Rende questo boolVect uguale all'<em>or componente a componente</em> di
     * questo boolvect e quello specificato.
     * 
     * @param altro l'altro boolvect
     * @throws NullPointerException     se altro è {@code null}
     * @throws IllegalArgumentException se la taglia di questo boolvect è minore
     *                                  della dimensione dell'altro boolvect
     */
    void or(final BoolVect altro);

    /**
     * Rende questo boolvect uguale allo <em>xor componente a componente</em> di
     * questo boolvect e quello specificato.
     * 
     * @param altro l'altro boolvect
     * @throws NullPointerException     se altro è {@code null}
     * @throws IllegalArgumentException se la taglia di questo boolvect è minore
     *                                  della dimensione dell'altro boolvect
     */
    void xor(final BoolVect altro);

    /**
     * Rende {@code false} tutti i valori di verità di questo boolvect.
     */
    void pulisci();

    /**
     * Rende questo boolvect uguale ai valori di verità specificati nella stringa
     * data.
     * <p>
     * La stringa data deve contenere solo caratteri '{@code V}' o '{@code F}'.
     * 
     * @param vals la stringa dei valori di verità.
     * @throws IllegalArgumentException se la stringa è più lunga della taglia di
     *                                  questo boolvect
     * @throws NullPointerException     se vals è {@code null}
     */
    default void daString(final String vals) {
        pulisci();
        final int len = vals.length();
        for (int i = 0; i < len; i++)
            scrivi(i, vals.charAt(len - i - 1) == 'V');
    }

}
