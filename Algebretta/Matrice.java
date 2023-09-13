/**
 * Questa interfaccia descrive il contratto di una matrice quadrata (immutabile)
 * a valori interi.
 */
public interface Matrice {
    /**
     * Restituisce la dimensione di {@code this}, un valore sempre positivo.
     * 
     * @return la dimensione
     */
    int dim();

    /**
     * Restituisce il valore di coordinate {@code row} e {@code col}.
     * 
     * @param row la riga
     * @param col la colonna
     * @return il valore
     * @throws IndexOutOfBoundsException se le coordinate date non sono valide
     *                                   (minori di zero oppure maggiori o uguali
     *                                   alle dimensioni di {@code this})
     */
    int val(final int row, final int col);

    /**
     * Restituisce una nuova matrice ottenuta dal prodotto di {@code this} per uno
     * scalare dato.
     * 
     * @param alpha lo scalare
     * @return la nuova matrice
     */
    Matrice per(final int alpha);

    /**
     * Restituisce una nuova matrice ottenuta dalla somma matriciale fatta tra
     * {@code this} e un'altra matrice data.
     * 
     * @param M la matrice
     * @return la nuova matrice
     * @throws NullPointerException     se {@code M} è {@code null}
     * @throws IllegalArgumentException se {@code M} e {@code this} non sono
     *                                  conformi
     */
    Matrice più(final Matrice M);

    /**
     * Restituisce una nuova matrice ottenuta dal prodotto matriciale fatto tra
     * {@code this} e un'altra matrice data.
     * 
     * @param M la matrice
     * @return la nuova matrice
     * @throws NullPointerException     se {@code M} è {@code null}
     * @throws IllegalArgumentException se {@code M} e {@code this} non sono
     *                                  conformi
     */
    Matrice per(final Matrice M);

    /**
     * Restituisce il vettore ottenuto moltiplicanod {@code this} per il vettore
     * dato.
     * 
     * @param v il vettore
     * @return il risultato
     * @throws NullPointerException se {@code v} è {@code null}
     * @throws IllegalArgumentException se {@code this} e {@code v} non sono conformi
     */
    Vettore per(final Vettore v);

    /**
     * Restituisce {@code true} se e solo se la dimensione di {@code this} è uguale
     * a quella della matrice data.
     * 
     * @param M la matrice
     * @return {@code true} se e solo se la matrice {@code M} è conforme a
     *         {@code this}
     * @throws NullPointerException se {@code M} è {@code null}
     */
    default boolean conforme(final Matrice M) {
        return dim() == M.dim();
    }

    /**
     * Restituisce {@code true} se e solo se la dimensione di {@code this} è uguale
     * a quella del {@link Vettore} dato.
     * 
     * @param V il vettore
     * @return {@code true} se e solo se il {@link Vettore} {@code V} è conforme a
     *         {@code this}
     * @throws NullPointerException se {@code V} è {@code null}
     */
    default boolean conforme(final Vettore V) {
        return dim() == V.dim();
    }

}