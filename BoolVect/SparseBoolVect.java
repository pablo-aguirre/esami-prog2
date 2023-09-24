import java.util.ArrayList;
import java.util.List;

/**
 * Classe concreta che implementa un {@link BoolVect} sparso.
 * <p>
 * Le istanze di questa classe sono mutabili.
 */
public class SparseBoolVect extends AbstractBoolVect {

    /**
     * Record che rappresenta un <strong>componente</strong> di un boolvect sparso.
     * <p>
     * Un componente è caratterizzato dalla sua posizione nel boolvect e dal valore
     * che assume in quest'ultimo.
     * <p>
     * Gli oggetti di questo tipo sono mutabili.
     */
    private class Componente {

        /** La posizione nel boolvect. */
        private final int posizione;
        /** Il valore del componente. */
        private boolean valore;

        /**
         * Costruisce un componente in una data posizione con un dato valore.
         * 
         * @throws IllegalArgumentException se posizione è minore di 0.
         */
        private Componente(final int posizione, final boolean valore) {
            if (posizione < 0)
                throw new IllegalArgumentException("La posizione non può essere negativa.");
            this.posizione = posizione;
            this.valore = valore;
        }

        /**
         * Modifica il valore di questo componente.
         * 
         * @param valore
         */
        private void settaValore(final boolean valore) {
            this.valore = valore;
        }

        @Override
        public String toString() {
            return valore ? "V" : "F";
        }

    }

    /** Lista contenente i valori di questo vettore. */
    private final List<Componente> valori;
    /** La dimensione del boolvect. */
    private int dimensione;
    /** La taglia del boolvect. */
    private int taglia;

    /*
     * RI:
     * - valori != null
     * - ogni elemento di valori != null
     */

    /**
     * Costruisce un nuovo boolvect sparso di taglia massima data.
     * 
     * @throws IllegalArgumentException se la taglia non è positiva.
     */
    public SparseBoolVect(final int taglia) {
        if (taglia <= 0)
            throw new IllegalArgumentException("La taglia deve essere positiva.");
        valori = new ArrayList<Componente>();
        this.taglia = taglia;
        dimensione = 0;
    }

    @Override
    public int dim() {
        return dimensione;
    }

    @Override
    public int taglia() {
        return taglia;
    }

    @Override
    public boolean valore(int posizione) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'valore'");
    }

    @Override
    public void settaValore(int posizione, boolean valore) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'settaValore'");
    }

    @Override
    public BoolVect and(BoolVect altro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'and'");
    }

    @Override
    public BoolVect or(BoolVect altro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'or'");
    }

    @Override
    public BoolVect xor(BoolVect altro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'xor'");
    }

}
