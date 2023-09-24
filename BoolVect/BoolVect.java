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
     * 
     * @return la dimensione
     */
    int dim();

    /**
     * Restituisce la taglia di questo boolvect.
     * 
     * @return la taglia
     */
    int taglia();

    /**
     * Restituisce il valore nella posizione data.
     * 
     * @param posizione la posizione del valore da leggere
     * @return il valore
     * @throws IndexOutOfBoundsException se la posizione è minore di zero o maggiore
     *                                   della taglia di questo boolvect
     */
    boolean valore(final int posizione);

    /**
     * Scrive il valore dato nella posizione i-esima.
     * 
     * @param posizione la posizione del valore da scrivere
     * @param valore    il valore da scrivere
     * @throws IndexOutOfBoundsException se la posizione è minore di zero o maggiore
     *                                   della taglia di questo boolvect
     */
    void settaValore(final int posizione, final boolean valore);

    /**
     * Restituisce un BoolVect ottenuto effettuando l'operazione {@coda and}
     * componente a componente tra questo boolvect e un'altro boolvect.
     * <p>
     * La taglia del boolvect risultante viene determinata dalla <em>dimensione
     * minima</em> tra questo boolvect e l'altro.
     * 
     * @param altro l'altro boolvect
     * @return il risultato
     * @throws NullPointerException se altro è {@code null}
     */
    BoolVect and(final BoolVect altro);

    /**
     * Restituisce un BoolVect ottenuto effettuando l'operazione {@coda or}
     * componente a componente tra questo boolvect e un'altro boolvect.
     * <p>
     * La taglia del boolvect risultante viene determinata dalla <em>dimensione
     * massima</em> tra questo boolvect e l'altro.
     * 
     * @param altro l'altro boolvect
     * @return il risultato
     * @throws NullPointerException se altro è {@code null}
     */
    BoolVect or(final BoolVect altro);

    /**
     * Restituisce un BoolVect ottenuto effettuando l'operazione {@coda xor}
     * componente a componente tra questo boolvect e un'altro boolvect.
     * <p>
     * La taglia del boolvect risultante viene determinata dalla <em>dimensione
     * massima</em> tra questo boolvect e l'altro.
     * 
     * @param altro l'altro boolvect
     * @return il risultato
     * @throws NullPointerException se altro è {@code null}
     */
    BoolVect xor(final BoolVect altro);

}
