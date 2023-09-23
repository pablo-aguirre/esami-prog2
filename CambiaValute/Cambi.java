import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Classe concreta che rappresenta l'elenco dei tassi noti al cambiavalute.
 * <p>
 * Le istanze di questa classe ono mutabili.
 */
public class Cambi implements Iterable<Cambi.Tasso> {
    /**
     * Record che rappresenta un <strong>tasso</strong> di cambio.
     * <p>
     * Un tasso di cambio è caratterizzato da due importi (di valute diverse) e
     * permette di convertire qualunque multiplo del primo nello stesso
     * multiplo del secondo.
     * <p>
     * Le istanze di questo tipo sono immutabili.
     */
    public record Tasso(Importo da, Importo a) {
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
         * @throws IllegalArgumentException se le valute dei due importi sono uguali o
         *                                  se uno dei due importi non è positivo
         */
        public Tasso(final Importo da, final Importo a) {
            Objects.requireNonNull(da, "Il primo importo non può essere null.");
            Objects.requireNonNull(a, "Il secondo importo non può essere null.");
            if (!da.isPositive() || !a.isPositive())
                throw new IllegalArgumentException("Gli importi devono essere positivi.");
            if (da.valuta == a.valuta)
                throw new IllegalArgumentException("Le valute dei due importi devono essere diverse.");
            this.da = da;
            this.a = a;
        }

        @Override
        public String toString() {
            return da + " = " + a;
        }

    }

    /** L'elenco dei tassi. */
    private final List<Tasso> tassi = new LinkedList<>();

    /*
     * RI:
     * - tassi è !=null
     * - tassi non deve contenere più di un tasso tra due importi con una data
     * coppia di valute
     * - i tassi sono mantenuti in ordine di aggiunta/aggiornamento
     */

    /**
     * Cerca e restituisce un tasso tra le valute date
     * 
     * @param da la valuta del primo importo
     * @param a  la valuta del secondo importo
     * @return il tasso, se trovato, {@code null} altrimenti
     */
    public Tasso cerca(Valuta da, Valuta a) {
        for (Tasso tasso : tassi)
            if (tasso.da().valuta == da && tasso.a().valuta == a)
                return tasso;
        return null;
    }

    /**
     * Aggiorna, o aggiunge, il tasso di cambio tra due valute all'elenco dei
     * tassi noti.
     *
     * <p>
     * Nel caso fosse noto un tasso tra le due stesse valute del tasso da
     * aggiornasre, questo sostituirà il precedente tasso; viceversa il tasso da
     * aggiornare è di fatto "nuovo" e verrà semplicemente aggiunto alla lista dei
     * tassi noti.
     *
     * @param tasso il tasso da aggiornare.
     * @return {@code true} se il tasso sostituisce un tasso precedentemente
     *         noto, {@code false} viceversa.
     */
    public boolean aggiorna(final Tasso tasso) {
        final Tasso precedente = cerca(tasso.da().valuta, tasso.a().valuta);
        if (precedente != null)
            tassi.remove(precedente);
        tassi.add(tasso);
        return precedente != null;
    }

    @Override
    public Iterator<Cambi.Tasso> iterator() {
        return Collections.unmodifiableList(tassi).iterator();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Tassi:\n");
        Iterator<Tasso> it = tassi.iterator();
        while (it.hasNext())
            sb.append(it.next() + (it.hasNext() ? "\n" : ""));
        return sb.toString();
    }

}
