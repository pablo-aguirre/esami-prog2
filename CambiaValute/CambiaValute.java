import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

/**
 * Classe concreta che rappresenta un <strong>cambia valute</strong>.
 * <p>
 * Un cambia valute è un servizio dotato di una {@link Cassa} che, data
 * una serie di {@link Tasso}, può cambiare a richiesta un importo
 * (in una data valuta) in una valuta differente.
 * <p>
 * Le istanze di questa classe sono mutabili.
 */
public class CambiaValute implements Iterable<CambiaValute.Tasso> {

    /**
     * Record che rappresenta un <strong>tasso</strong> di cambio.
     * <p>
     * Un tasso di cambio è caratterizzato da due importi (di valute diverse) e
     * permette di convertire qualunque multiplo del primo nello stesso
     * multiplo del secondo.
     * <p>
     * Le istanze di questo tipo sono immutabili.
     */
    public static record Tasso(Importo importo1, Importo importo2) {
        /*
         * RI:
         * importo1 e importo2 sono != null
         * importo1 e importo2 hanno valuta diversa
         * importo1 e importo2 hanno valore positivo
         */

        /**
         * Costruisce un tasso di cambio dati l'importo di una valuta e l'importo di
         * un'altra valuta.
         * 
         * @param primo   il primo importo
         * @param secondo il secondo importo
         * @throws NullPointerException     se uno dei parametri è {@code null}
         * @throws IllegalArgumentException se le valute dei due importi sono uguali
         * 
         */
        public Tasso(final Importo importo1, final Importo importo2) {
            this.importo1 = importo1;
            this.importo2 = importo2;
        }

        /**
         * Due tassi sono equivalenti se hanno le valute dei loro importi
         * rispettivamente uguali.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof Tasso))
                return false;
            Tasso o = (Tasso) obj;
            return o.importo1.getValuta().equals(importo1.getValuta());
        }

        @Override
        public int hashCode() {
            return Objects.hash(importo1.getValuta().hashCode(), importo2.getValuta().hashCode());
        }

        @Override
        public String toString() {
            return importo1.toString() + "=" + importo2.toString();
        }

    }

    /** La cassa. */
    private final Cassa cassa;
    /** La lista di tassi di cambio. */
    private final List<Tasso> tassi;

    /*
     * RI:
     * cassa e tassi != null
     * tassi non vuoto e non contiene tassi uguali
     */

    /**
     * Costruisce un nuovo cambia valute data una lista di importi da depositare.
     * 
     * @param importi la lista degli importi da depositare nella {@link Cassa}
     * @throws NullPointerException     se importi è {@code null}
     * @throws IllegalArgumentException se importi contiene almeno due importi con
     *                                  la stessa valuta
     */
    public CambiaValute(final List<Importo> importi) {

    }

    /**
     * Aggiorna un tasso di cambio dato il suo nuovo tasso.
     * Se non esiste il tasso specificato, esso viene aggiunto.
     * 
     * @param tasso il nuovo tasso
     * @throws NullPointerException se tasso è {@code null}
     */

    public void aggiorna(final CambiaValute.Tasso tasso) {

    }

    /**
     * Effettua un cambio di un dato importo in una nuova valuta, se possibile.
     * <p>
     * Nei seguenti casi:
     * <ul>
     * <li>tasso non disponibile
     * <li>la valuta di {@code importo} e {@code valuta} sono identiche
     * <li>fondi nella {@code valuta} richiesta non sono disponibili
     * </ul>
     * viene generata un'eccezione indicando il caso specifico.
     * 
     * @param importo l'importo richiesto
     * @param valuta  la valuta da cambiare
     * @throws OperationNotSupportedException l'operazione richiesta non è
     *                                        supportata
     */
    public void cambio(final Importo importo, final Valuta valuta) throws OperationNotSupportedException {
    }

    @Override
    public Iterator<Tasso> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public String toString() {
        return "CambiaValute []";
    }

}
