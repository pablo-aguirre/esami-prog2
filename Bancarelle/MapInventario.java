import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Classe concreta che implementa il contrato definito nell'interfaccia
 * {@link Inventario}.
 * Si basa su una mappa di oggetti {@code E} alle sue quantità.
 * Le istanze di questa classe sono mutabili.
 */
public class MapInventario<E> implements Inventario<E> {
    /** Mappa gli oggetti dell'inventario alle rispettive quantità presenti. */
    private final Map<E, Integer> elements;

    /*
     * AF(elements) = inventario i cui oggetti corrispondono alle chiavi della mappa
     * e le cui quantità corrispondono ai valori associati a tali chiavi.
     * 
     * IR(elements) = vero se:
     * - elements != null (verificato in costruzione e dopo in quanto final)
     * - ogni chiave di elements è != null
     * - ogni valore associato ad ogni chiave è != null e positivo
     */

    /**
     * Costruisce un nuovo inventario vuoto.
     */
    public MapInventario() {
        elements = new HashMap<>();
    }

    /**
     * Costruisce un nuovo inventario data la sua dimensione iniziale.
     * 
     * @param size la dimensione iniziale
     * @throws IllegalArgumentException se {@code size} non è positivo
     */
    public MapInventario(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("La dimensione size deve essere positiva");
        elements = new HashMap<>(size);
    }

    @Override
    public void add(E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void remove(E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int quantity(E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quantity'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}