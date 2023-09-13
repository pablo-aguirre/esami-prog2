/**
 * Interfaccia che descrive il contratto di un vettore immutabile a valori
 * interi.
 */
public interface Vettore {
    /**
     * Restituisce la dimensione di {@code this}, è un valore sempre positivo.
     * 
     * @return la dimensione
     */
    int dim();

    /**
     * Restituisce il valore di coordinata data di {@code this}.
     * 
     * @param i la coordinata
     * @return il valore
     * @throws IndexOutOfBoundsException se la coordinata è negativa, o maggiore o
     *                                   uguale alla dimensione di {@code this}
     */
    int val(final int i);

    /**
     * Restituisce un nuovo vettore ottenuto moltiplicando {@code this} per lo
     * scalare dato.
     * 
     * @param alpha lo scalare
     * @return il nuovo vettore
     */
    Vettore per(final int alpha);

    /**
     * Restituisce un nuovo vettore ottenuto sommando {@code this} al vettore dato.
     * 
     * @param v il vettore
     * @return il nuovo vettore
     * @throws NullPointerException     se il vettore {@code v} è {@code null}
     * @throws IllegalArgumentException se i vettori non sono conformi
     */
    Vettore più(final Vettore v);

    /**
     * Restituisce {@code true} se e solo se il vettore {@code v} ha la stessa
     * dimensione di {@code this}.
     * 
     * @param v il vettore
     * @return {@code true} se e solo se il vettore {@code v} è conforme a
     *         {@code this}
     * @throws NullPointerException se il vettore {@code v} è {@code null}
     */
    default boolean conforme(final Vettore v) {
        return dim() == v.dim();
    }

    /**
     * Restituisce {@code true} se e solo se la matrice {@code M} ha la stessa
     * dimensione di {@code this}.
     * 
     * @param M la matrice
     * @return {@code true} se e solo se la matrice {@code M} è conforme a
     *         {@code this}
     * @throws NullPointerException se la matrice {@code M} è {@code null}
     */
    default boolean conforme(final Matrice M) {
        return dim() == M.dim();
    }

}