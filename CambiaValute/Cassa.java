import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

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
    /** Lista degli importi versati. */
    private final List<Importo> importi;

    /*
     * RI:
     * importi è != null
     * ogni Importo in importi è != null
     * le valute a cui fanno riferimento gli importi non sono ripetuti (se viene
     * versato/prelevato un importo si deve modificare l'importo relativo a tale
     * valuta)
     */

    /**
     * Costruisce una cassa vuota (senza nessun importo).
     */
    public Cassa() {
        importi = new LinkedList<Importo>();
    }

    /**
     * Versa l'importo dato.
     * 
     * @param importo l'importo da versare
     * @throws NullPointerException     se importo è {@code null}
     * @throws IllegalArgumentException se l'importo è negativo
     */
    public void versa(final Importo importo) {

    }

    /**
     * Preleva l'importo dato, se possibile.
     * 
     * @param importo l'importo da prelevare
     * @throws NullPointerException           se importo è {@code null}
     * @throws IllegalArgumentException       se l'importo è negativo
     * @throws OperationNotSupportedException se se la cassa non contiene un importo
     *                                        sufficiente per la valuta richiesta
     */
    public void preleva(final Importo importo) throws OperationNotSupportedException {
    }

    @Override
    public Iterator<Importo> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public String toString() {
        return "Cassa []";
    }

}
