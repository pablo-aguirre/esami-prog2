import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Classe concreta che rappresenta un <strong>cambia valute</strong>.
 * <p>
 * Un cambia valute è un servizio dotato di una {@link Cassa} che, data
 * una serie di {@link Tasso}, può cambiare a richiesta un importo
 * da una data valuta ad una valuta differente.
 * <p>
 * Le istanze di questa classe sono mutabili.
 */
public class CambiaValute {

    /** La cassa del cambia valute. */
    private final Cassa cassa = new Cassa();
    /** La lista di tassi di cambio noti al cambia valute. */
    private final Cambi cambi = new Cambi();

    /*
     * RI:
     * - cassa e cambi != null
     */

    /**
     * Costruisce un nuovo cambia valute dati gli importi iniziali.
     * 
     * @param importi gli importi da versare
     * @throws NullpointerException     se importi è, o contiene, {@code null}
     * @throws IllegalArgumentException se uno degli importi non è positivo
     */
    public CambiaValute(final List<Importo> importi) {
        Objects.requireNonNull(importi, "Gli importi non possono essere null.");
        for (Importo importo : importi)
            cassa.versa(importo);
    }

    /**
     * Aggiorna un tasso di cambio dato il suo nuovo tasso.
     * Se non esiste il tasso specificato, esso viene aggiunto.
     * 
     * @param tasso il nuovo tasso
     * @return {@code true} se il tasso sostituisce un tasso già presente,
     *         {@code false} altrimenti
     * @throws NullPointerException se tasso è {@code null}
     */

    public boolean aggiorna(final Cambi.Tasso tasso) {
        Objects.requireNonNull(tasso, "Il tasso non può essere null.");
        return cambi.aggiorna(tasso);
    }

    /**
     * Effettua un cambio di un dato importo in una nuova valuta, se possibile.
     * <p>
     * Nei seguenti casi:
     * <ul>
     * <li>tasso non disponibile
     * <li>la valuta di {@code da} e {@code valuta} sono identiche
     * <li>fondi nella valuta richiesta non sono disponibili
     * </ul>
     * viene generata un'eccezione indicando il caso specifico.
     * 
     * @param da     l'importo richiesto
     * @param valuta la valuta da cambiare
     * @throws NullpointerException     se da o valuta sono {@code null}
     * @throws IllegalArgumentException in uno dei casi specificati sopra
     */
    public Importo cambia(final Importo da, Valuta valuta) {
        Objects.requireNonNull(da, "L'importo non può essere null.");
        Objects.requireNonNull(valuta, "La valuta non può essere null.");
        if (da.valuta == valuta)
            throw new IllegalArgumentException("Il cambio tra due valute uguali non è possibile.");
        final Cambi.Tasso tasso = cambi.cerca(da.valuta, valuta);
        if (tasso == null)
            throw new IllegalArgumentException("Il tasso di cambio richiesto non è disponibile.");
        final Importo a = da.equivalente(tasso);
        if (cassa.totale(valuta).compareTo(a) < 0)
            throw new IllegalArgumentException("Fondi non sufficienti.");
        cassa.versa(da);
        cassa.preleva(a);
        return a;
    }

    /**
     * Restituisce un iteratore che consente di iterare gli importi presenti nella
     * cassa del cambio valute.
     * 
     * @return l'iteratore
     */
    public Iterator<Importo> importi() {
        return cassa.iterator();
    }

    /**
     * Restituisce un iteratore che consente di iterare i tassi noti al cambia
     * valute.
     * 
     * @return l'iteratore
     */
    public Iterator<Cambi.Tasso> tassi() {
        return cambi.iterator();
    }

    @Override
    public String toString() {
        return cambi.toString() + "\n" + cassa.toString();
    }

}
