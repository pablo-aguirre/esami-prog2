import java.util.Arrays;
import java.util.Objects;

/**
 * Classe concreta che implementa un {@link BoolVect} denso.
 * <p>
 * Le istanze di questa classe sono mutabili.
 */
public class DenseBoolVect extends AbstractBoolVect {

    /** Array che contiene i valori del boolvect. */
    private final boolean[] valori;
    /** La dimensione del boolvect. */
    private int dimensione;

    /*
     * AF:
     * - il componente di posizione i-esima corrisponde a valori[valori.length-i-1]
     * - valori.legth corrisponde alla taglia di questo boolvect
     * - l'indice più dell'elemento di valori con valore true (+1) corrisponde alla
     * dimensione di questo boolvect
     * 
     * RI:
     * - valori è != null
     * - valori contiene almeno un elemento
     * - dimensione è compreso fra 1 e valori.length
     */

    /**
     * Costruisce un boolvect di taglia massima data.
     * 
     * @param taglia la taglia
     * @throws IllegalArgumentException se taglia è minore o uguale a zero
     */
    public DenseBoolVect(final int taglia) {
        if (taglia <= 0)
            throw new IllegalArgumentException("La taglia deve essere positiva.");
        valori = new boolean[taglia];
        dimensione = 0;
    }

    /**
     * Costruisce un boolvect a partire dalla sua rappresentazione testuale del
     * tipo: "{@code FFVFFFVVV}".
     * <p>
     * La stringa valori deve contenere solo caratteri '{@code V}' o '{@code F}', in
     * caso contrario viene sollevata un'eccezione.
     * 
     * @param valori la rappresentazione testuale del boolvect
     * @throws IllegalArgumentException se la stringa data non è nel formato
     *                                  specificato oppure se è vuota
     * @throws NullPointerException     se valori è {@code null}
     */
    public DenseBoolVect(final String valori) {
        if (Objects.requireNonNull(valori, "La stringa valori non può essere null.").isEmpty())
            throw new IllegalArgumentException("La stringa valori non può essere vuota");
        if (!valori.matches("^[VF]*"))
            throw new IllegalArgumentException("La stringa valori non è nel formato specificato.");

        final int taglia = valori.length();
        dimensione = 0;
        this.valori = new boolean[taglia];
        for (int i = 0; i < this.valori.length; i++) {
            if (valori.charAt(taglia - i - 1) == 'V') {
                this.valori[i] = true;
                dimensione = i + 1;
            } else
                this.valori[i] = false;
        }
    }

    @Override
    public int dim() {
        return dimensione;
    }

    @Override
    public int taglia() {
        return valori.length;
    }

    @Override
    public boolean valore(final int posizione) {
        Objects.checkIndex(posizione, valori.length);
        return valori[posizione];
    }

    @Override
    public void settaValore(final int posizione, final boolean valore) {
        Objects.checkIndex(posizione, valori.length);
        valori[posizione] = valore;
        if (valore && posizione > dimensione)
            dimensione = posizione;
    }

    @Override
    public BoolVect and(final BoolVect altro) {
        Objects.requireNonNull(altro, "L'altro boolvect non può essere null.");

        final DenseBoolVect res = new DenseBoolVect(Math.min(dimensione, altro.dim()));
        for (int i = 0; i < res.taglia(); i++)
            res.valori[i] = valori[i] && altro.valore(i);
        res.dimensione = res.taglia();
        return res;
    }

    @Override
    public BoolVect or(final BoolVect altro) {
        Objects.requireNonNull(altro, "L'altro boolvect non può essere null.");

        final DenseBoolVect res = new DenseBoolVect(Math.max(dimensione, altro.dim()));
        for (int i = 0; i < res.taglia(); i++)
            res.valori[i] = valori[i] || altro.valore(i);
        res.dimensione = res.taglia();
        return res;
    }

    @Override
    public BoolVect xor(final BoolVect altro) {
        Objects.requireNonNull(altro, "L'altro boolvect non può essere null.");

        final DenseBoolVect res = new DenseBoolVect(Math.max(dimensione, altro.dim()));
        for (int i = 0; i < res.taglia(); i++) {
            res.valori[i] = valori[i] ^ altro.valore(i);
            if(res.valori[i])
                res.dimensione = i + 1;
        }
        return res;
    }

}
