import java.util.Arrays;
import java.util.Objects;

/**
 * Classe concreta che implementa un {@link BoolVect} denso di taglia assegnata.
 * <p>
 * Le istanze di questa classe sono mutabili.
 */
public class DenseBoolVect extends AbstractBoolVect {

    /** Array che contiene i valori del boolvect. */
    private final boolean[] valori;
    /** La dimensione del boolvect. */
    private int dimensione = 0;

    /*
     * AF:
     * - il componente di posizione i-esima corrisponde a valori[i]
     * - valori.legth corrisponde alla taglia di questo boolvect
     * - l'indice più grande dell'elemento con valore true (+1) corrisponde alla
     * dimensione di questo boolvect
     * 
     * RI:
     * - valori è != null
     * - valori[dimensione - 1] == true && valori[p] == false se p >= dimensione
     * - valori contiene almeno un elemento
     * - dimensione è compreso fra 0 e valori.length (estremi inclusi)
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
    public boolean leggi(final int posizione) {
        Objects.checkIndex(posizione, valori.length);
        if (posizione >= dimensione)
            return false;
        else
            return valori[posizione];
    }

    @Override
    public void scrivi(final int posizione, final boolean valore) {
        Objects.checkIndex(posizione, valori.length);
        if (posizione >= taglia() && valore)
            throw new IndexOutOfBoundsException(
                    "Impossibile scrivere un valore di verità vero in posizione maggiore o uguale alla taglia.");
        valori[posizione] = valore;
        if (valore && posizione >= dimensione)
            dimensione = posizione + 1;
        else if (!valore && posizione == dimensione - 1)
            while (dimensione > 0 && !valori[dimensione - 1])
                dimensione--;
    }

    @Override
    public void and(final BoolVect altro) {
        Objects.requireNonNull(altro, "L'altro boolvect non può essere null.");

        final int dimMax = Math.max(dim(), altro.dim());
        for (int i = 0; i < dimMax; i++)
            scrivi(i, leggi(i) && altro.leggi(i));
    }

    @Override
    public void or(final BoolVect altro) {
        Objects.requireNonNull(altro, "L'altro boolvect non può essere null.");

        if (taglia() < altro.dim())
            throw new IllegalArgumentException("La taglia di questo vettore è minore della dimensione di altro.");
        final int dimMax = Math.max(dim(), altro.dim());
        for (int i = 0; i < dimMax; i++)
            scrivi(i, leggi(i) || altro.leggi(i));
    }

    @Override
    public void xor(final BoolVect altro) {
        Objects.requireNonNull(altro, "L'altro boolvect non può essere null.");

        if (taglia() < altro.dim())
            throw new IllegalArgumentException("La taglia di questo vettore è minore della dimensione di altro.");
        final int dimMax = Math.max(dim(), altro.dim());
        for (int i = 0; i < dimMax; i++)
            scrivi(i, leggi(i) ^ altro.leggi(i));
    }

    @Override
    public void pulisci() {
        Arrays.fill(valori, false);
    }

}
