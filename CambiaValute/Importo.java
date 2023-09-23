import java.util.Objects;

/**
 * Classe concreta che rappresenta un <strong>importo</strong>.
 * <p>
 * Un importo è caratterizzato da un valore e da una {@link Valuta} e permette,
 * dato un altro importo, di:
 * <ul>
 * <li>ottenere la loro somma
 * <li>ottenere la loro differenza
 * <li>compararli in base al loro valore (se della stessa valuta)
 * </ul>
 * <p>
 * Le istanze di questa classe sono immutabili.
 */
public class Importo implements Comparable<Importo> {
    /** Il valore di questo importo (in centesimi). */
    private final int valore;
    /** La valuta di questo importo. */
    public final Valuta valuta;

    /*
     * IR:
     * valuta != null
     * valore rappresenta l'importo in centesimi
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
        Objects.requireNonNull(valuta, "La valuta non può essere null");
        if (centesimi < 0)
            throw new IllegalArgumentException("I centesimi non possono essere negativi.");
        valore = Math.addExact(unità * 100, centesimi);
        this.valuta = valuta;
    }
  /** Metodo di fabbricazione che restituisce un importo data la sua
   * rappresentazione come stringa.
   *
   * Il <em>formato</em> di un importo è dato dal simbolo della valuta seguito
   * senza spazi dal valore dell'importo (eventualmente preceduto dal segno
   * <samp>-</samp>), con la parte decimale separata dalla parte dei centesimi
   * da un punto; entrambe le parti sono opzionali e la parte dei centesimi, se
   * presente, deve essere lunga esattamente due caratteri.
   *
   * @param importo la string che descrive l'importo.
   * @return l'importo.
   * @throws NullPointerException se la stringa è <code>null</code>.
   * @throws IllegalArgumentException se la stringa non è nel formato corretto.
   */
  public static Importo valueOf(String importo) {
    Objects.requireNonNull(importo, "L'importo non può essere null.");
    Valuta valuta = Valuta.valueOf(importo.charAt(0));
    String[] parti = importo.substring(1).split("\\.");
    if (parti.length > 2) throw new IllegalArgumentException("L'importo contiene più di un punto decimale.");
    int centesimi = 0;
    try {
      centesimi = parti[0].isEmpty() ? 0 : Integer.parseInt(parti[0]) * 100;
      if (parti.length == 2)
        if (parti[1].length() == 2) centesimi += Integer.parseInt(parti[1]);
        else throw new IllegalArgumentException("La parte dei centesimi deve essere lunga due caratteri.");
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("L'importo contiene parti non convertibili ad un numero.");
    }
    return new Importo(centesimi, valuta);
  }
    /**
     * Costruisce un nuovo importo dato il suo valore in centesimi e la sua valuta.
     * 
     * @param centesimi i centesimi
     * @param valuta    la valuta
     * @throws NullPointerException se la valuta è {@code null}
     */
    private Importo(final int valore, final Valuta valuta) {
        Objects.requireNonNull(valuta, "La valuta non può essere null");
        this.valore = valore;
        this.valuta = valuta;
    }

    /**
     * Metodo di fabbricazione che restituisce l'importo zero nella valuta indicata.
     * 
     * @param valuta la valuta
     * @return l'importo pari a zero della valuta sepcificata
     * @throws NullPointerException se la valuta è {@code null}
     */
    public static Importo zero(final Valuta valuta) {
        Objects.requireNonNull(valuta, "La valuta non può essere null.");
        return new Importo(0, 0, valuta);
    }

    /**
     * Metodo di produzione che restituisce un nuovo importo ottenuto dalla somma di
     * {@code this} e un'altro importo dato.
     * 
     * @param altro l'altro importo
     * @return la somma dei due importi
     * @throws NullPointerException     se l'laltro importo è {@code null}
     * @throws IllegalArgumentException se l'altro importo ha valuta diversa da
     *                                  quella di {@code this}
     */
    public Importo somma(final Importo altro) {
        Objects.requireNonNull(altro, "L'altro importo non può essere null.");
        if (!valuta.equals(altro.valuta))
            throw new IllegalArgumentException("Le due valute sono diverse.");
        return new Importo(valore + altro.valore, valuta);
    }

    /**
     * Restitusce un nuovo importo ottenuto dalla differenza di {@code this} e
     * un'altro importo dato.
     * 
     * @param altro l'altro importo
     * @return la differenza dei due importi
     * @throws NullPointerException se l'laltro importo è {@code null}
     */
    public Importo differenza(final Importo altro) {
        Objects.requireNonNull(altro, "L'altro importo non può essere null.");
        if (valuta != altro.valuta)
            throw new IllegalArgumentException("Le due valute sono diverse.");
        return new Importo(valore - altro.valore, valuta);
    }

    /**
     * Determina l'equivalente di {@code this} in un'altra valuta dato il tasso di
     * cambio.
     * 
     * @param tasso il tasso di cambio tra {@code this} e l'altra valuta
     * @return l'importo (nell'altra valuta) equivalente a {@code this}
     * @throws NullPointerException     se tasso è {@code null}
     * @throws IllegalArgumentException se il tasso non va dalla valuta di
     *                                  {@code this}
     */
    public Importo equivalente(final Cambi.Tasso tasso) {
        Objects.requireNonNull(tasso, "Il tasso di cambio non può essere null.");
        if (tasso.da().valuta != valuta)
            throw new IllegalArgumentException("Il tasso non va dalla valuta di this.");
        return new Importo((valore / tasso.da().valore) * tasso.a().valore, tasso.a().valuta);
    }

    /**
     * Metodo che consente di stabilire se questo importo ha valore zero.
     *
     * @return se questo importo vale zero.
     */
    public boolean isZero() {
        return valore == 0;
    }

    /**
     * Metodo che consente di stabilire se questo importo ha valore strettamente
     * positivo.
     *
     * @return se questo importo ha valore strettamente positivo.
     */
    public boolean isPositive() {
        return valore > 0;
    }

    @Override
    public int compareTo(Importo o) {
        Objects.requireNonNull(o, "Il parametro o non può essere null.");
        if (o.valuta != valuta)
            throw new ClassCastException("Non è possibile confrontare importi di valute diverse.");
        return Integer.compare(valore, o.valore);
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
        final Importo o = (Importo) obj;
        return valore == o.valore && valuta == o.valuta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valore, valuta);
    }

    @Override
    public String toString() {
        return String.format("%c%d.%02d", valuta.getSimbol(), valore / 100, valore % 100);
    }

}
