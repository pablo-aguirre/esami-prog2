public interface Vettore {
    /**
     * @return la dimensione di {@code this}
     */
    public int dim();

    /**
     * @param i l'indice del valore da restituire
     * @return il valore in posizione {@code i}-esima
     */
    public int val(final int i);

    /**
     * @param alpha uno scalare
     * @return il prodotto {@code this*alpha}
     */
    public Vettore per(final int alpha);

    /**
     * @param v il vettore da sommare a {@code this}
     * @return la somma vettoriale {@code this+v}
     */
    public Vettore più(final Vettore v);
}