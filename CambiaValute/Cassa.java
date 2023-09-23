import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Classe concreta che rappresenta una <strong>cassa</strong>.
 * <p>
 * Una cassa è un "contenitore" nel quale è possibile versare importi in
 * qualunque valuta e prelevare importi (se la cassa ne contiene a sufficienza).
 * <p>
 * È iterabile sugli importi diversi da zero.
 * <p>
 * Le istanze di questa classe sono mutabili.
 */
public class Cassa implements Iterable<Importo> {
    /** Mappa che associa a ciascuna valuta il suo importo in cassa. */
    private final Map<Valuta, Importo> valute2importi = new EnumMap<>(Valuta.class);

    /*
     * RI:
     * - valute2importi è != null
     * - ogni chiave (valuta) e valore (importi) è != null
     * - gli importi sono positivi
     * - le valute degli importi devono corrispondere alla chiave
     */

    /**
     * Restituisce l'importo totale presente in cassa in una data valuta.
     * 
     * @param valuta la valuta
     * @return l'importo
     * @throws NullPointerException se la valuta è {@code null}
     */
    public Importo totale(Valuta valuta) {
        Objects.requireNonNull(valuta, "La valuta non può essere null.");
        final Importo totale = valute2importi.get(valuta);
        return totale == null ? Importo.zero(valuta) : totale;
    }

    /**
     * Versa l'importo dato.
     * 
     * @param importo l'importo da versare
     * @throws NullPointerException     se importo è {@code null}
     * @throws IllegalArgumentException se l'importo è negativo
     */
    public void versa(final Importo importo) {
        Objects.requireNonNull(importo, "L'importo non può essere null");
        valute2importi.put(importo.valuta, totale(importo.valuta).somma(importo));
    }

    /**
     * Preleva l'importo dato.
     * 
     * @param importo l'importo da prelevare
     * @throws NullPointerException     se importo è {@code null}
     * @throws IllegalArgumentException se l'importo è negativo o superiore al
     *                                  totale in cassa per la sua valuta.
     */
    public void preleva(final Importo importo) {
        Objects.requireNonNull(importo, "L'importo non può essere null.");
        if (!importo.isPositive())
            throw new IllegalArgumentException("Non si possono prelevare importi negativi.");
        final Importo resto = totale(importo.valuta).differenza(importo);
        if (resto.isZero())
            valute2importi.remove(resto.valuta);
        else if (!resto.isPositive())
            throw new IllegalArgumentException("Importo richiesto non disponibile.");
        else
            valute2importi.put(importo.valuta, resto);

    }

    @Override
    public Iterator<Importo> iterator() {
        return Collections.unmodifiableCollection(valute2importi.values()).iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cassa:\n");
        Iterator<Importo> it = iterator();
        while (it.hasNext())
            sb.append(it.next() + (it.hasNext() ? "\n" : ""));
        return sb.toString();
    }

}
