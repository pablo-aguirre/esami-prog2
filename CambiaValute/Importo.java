import java.util.Objects;

/**
 * Classe concreta che rappresenta un <strong>importo</strong>.
 * <p>
 * Un importo è caratterizzato da un valore e da una {@link Valuta}.
 * <p>
 * Le istanze di quest classe sono immutabili.
 */
public class Importo implements Comparable<Importo> {
    /** Il valore di questo importo (in centesimi). */
    private final int valore;
    /** La valuta di questo importo. */
    private final Valuta valuta;

    /*
     * IR:
     * valuta != null
     * valore rappresenta l'importo totale in centesimi
     */

    /**
     * Costruisce un nuovo importo date unità, centesimi e valuta.
     * <p>
     * Nel caso si desiderino importi negativi, bisogna indicarlo mediante il
     * parametro unità.
     * 
     * @param unità     le unità
     * @param centesimi i centesimi
     * @param valuta    la valuta
     * @throws NullPointerException     se la valuta è {@code null}
     * @throws IllegalArgumentException se i centesimi sono negativi
     */
    public Importo(final int unità, final int centesimi, final Valuta valuta) {

    }

    /**
     * Fabbrica l'importo zero nella valuta indicata.
     * 
     * @param valuta la valuta
     * @return l'importo pari a zero della valuta sepcificata
     * @throws NullPointerException se la valuta è {@code null}
     */
    public static Importo zero(final Valuta valuta) {

    }

    /**
     * Restitusce un nuovo importo ottenuto dalla somma di {@code this} e un'altro
     * importo dato.
     * 
     * @param altro l'altro importo
     * @return la somma dei due importi
     * @throws NullPointerException se l'laltro importo è {@code null}
     */
    public Importo somma(final Importo altro) {

    }

    /**
     * Restituisce il valore (in centesimi) di questo importo.
     * 
     * @return il valore in centesimi
     */
    public int getValore() {
        return valore;
    }

    /**
     * Restituisce la valuta di questo importo.
     * 
     * @return la valuta
     */
    public Valuta getValuta() {
        return valuta;
    }

    /**
     * Restitusce un nuovo importo ottenuto dalla sottrazione di {@code this} e
     * un'altro importo dato.
     * 
     * @param altro l'altro importo
     * @return la differenza dei due importi
     * @throws NullPointerException se l'laltro importo è {@code null}
     */
    public Importo sottrai(final Importo altro) {

    }

    /**
     * Determina l'equivalente di {@code this} in un'altra valuta dato il tasso di
     * cambio.
     * 
     * @param tasso il tasso di cambio tra {@code this} e l'altra valuta
     * @return l'importo (nell'altra valuta) equivalente a {@code this}
     * @throws NullPointerException se tasso è {@code null}
     */
    public Importo cambia(final CambiaValute.Tasso tasso) {

    }

    @Override
    public int compareTo(Importo o) {
        Objects.requireNonNull(o, "Il parametro o non può essere null.");
        int result = Integer.compare(valore, o.valore);
        if (result == 0)
            result = valuta.compareTo(o.valuta);
        return result;
    }

    /**
     * Due importi sono equivalenti se hanno lo stesso valore e la stessa valuta.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Importo))
            return false;
        Importo o = (Importo) obj;
        return valore == o.valore && valuta.equals(o.valuta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valore, valuta);
    }

    @Override
    public String toString() {
        return valuta.getSimbol() + Integer.toString(valore / 100) + "." + Integer.toString(valore % 100);
    }

}
