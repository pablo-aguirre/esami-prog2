import java.util.Arrays;
import java.util.Objects;

/** Le istanze di questa classe rappresentano dei vettori densi. */
public class VettoreDenso implements Vettore {

    /** I valori del vettore. */
    private final int[] values;

    /*-
     * AF:  l'i-esimo valore del vettore corrisponde all'i-esimo valore dell'array.
     * RI:  values non è null ed ha almeno un elemento.
     */

    /**
     * Costruttore che costruisce un vettore di dimensione data, con tutti i valori
     * pari a 0.
     * 
     * @param dim la dimensione
     * @throws IllegalArgumentException se la dimensione non è positiva
     */
    private VettoreDenso(final int dim) {
        if (dim <= 0)
            throw new IllegalArgumentException("La dimensione deve essere positiva.");
        values = new int[dim];
    }

    /**
     * Costruisce un vettore a partire da un array.
     * 
     * @param values l'array
     * @throws IllegalArgumentException se {@code values} ha zero elementi
     * @throws NullPointerException     se {@code values} è {@code null}
     */
    public VettoreDenso(final int[] values) {
        Objects.requireNonNull(values, "L'array val non può essere null.");
        if (values.length == 0)
            throw new IllegalArgumentException("Il vettore deve comprendere almeno un valore.");
        this.values = values.clone(); // per proteggere la rappresentazione
    }

    @Override
    public int dim() {
        return values.length;
    }

    @Override
    public int val(final int i) {
        if (i < 0 || i >= values.length)
            throw new IndexOutOfBoundsException("L'indice i non è valido.");
        return values[i];
    }

    @Override
    public Vettore per(int alpha) {
        if (alpha == 0)
            return new VettoreNullo(dim());
        final VettoreDenso res = new VettoreDenso(dim());
        for (int i = 0; i < values.length; i++)
            res.values[i] = values[i] * alpha;
        return res;
    }

    @Override
    public Vettore più(Vettore v) {
        Objects.requireNonNull(v, "Il vettore v non può essere null");
        if (!conforme(v))
            throw new IllegalArgumentException("Il vettore v non è conforme a this.");
        if (v instanceof VettoreNullo)
            return this;
        final VettoreDenso res = new VettoreDenso(dim());
        for (int i = 0; i < values.length; i++)
            res.values[i] = values[i] + v.val(i);
        return res;
    }

    @Override
    public String toString() {
        return Arrays.toString(values).replace("[", "(").replace("]", ")");
    }

}
