import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Classe che rappresenta una pavimentazione data da una collezione di
 * {@link Componente} ciascuno dei quali rappresenta una certa quantità di una
 * {@link Superficie} ({@link Piastrella} o altra pavimentazione); è possibile
 * accedere al suo contenuto tramite iterazione.
 * Gli oggetti di questo tipo sono immutabili.
 */
public class PavimentazioneBis implements Superficie, Iterable<PavimentazioneBis.Componente> {

    /**
     * Un componente di una {@link PavimentazioneBis}, ossia una certa quantità di
     * una data superficie.
     */
    public static class Componente implements Superficie {

        /** La superficie di cui è costituito {@code this}. */
        public final Superficie rivestimento;
        /** La quantità di cui è costituito il componente, è sempre positiva. */
        public final int quantità;

        /*-
         * AF:  
         * RI:  rivestimento non è mai null
         *      quantità è sempre positiva
         */

        /**
         * Costruisce un componente, data la quantità della superficie che lo
         * costituisce.
         * 
         * @param quantità     la quantità
         * @param rivestimento il rivestimento
         * @throws IllegalArgumentException se {@code quantità} non è positiva
         * @throws NullPointerException     se {@code rivestimento} è {@code null}
         */
        public Componente(final int quantità, final Superficie rivestimento) {
            this.rivestimento = Objects.requireNonNull(rivestimento, "Il rivestimento non può essere null.");
            if (quantità <= 0)
                throw new IllegalArgumentException("La quantità dev'essere positiva");
            this.quantità = quantità;
        }

        @Override
        public int costo() {
            return rivestimento.costo() * quantità;
        }

        @Override
        public int superficie() {
            return rivestimento.superficie() * quantità;
        }

    }

    /**
     * La {@code Collection} di componenti compresi in {@code this},
     */
    private final Collection<Componente> componenti;

    /**
     * AF:
     * RI: componenti non è null, non è vuota e non contiene null
     */

    /**
     * Costruisce una pavimentazione data la collezione di componenti che comprende.
     * 
     * @param componenti una collezione di componenti
     * @throws NullPointerException se {@code componenti} è o contiene {@code null}
     * @throws IllegalArgumentException se la collezione è vuota
     */
    public PavimentazioneBis(final Collection<Componente> componenti) {
        this.componenti = List.copyOf(componenti);
        if (componenti.isEmpty())
            throw new IllegalArgumentException("La collezione componenti non può essere vuota.");
    }

    @Override
    public int costo() {
        int totale = 0;
        for (final Superficie s : componenti)
            totale += s.costo();
        return totale;
    }

    @Override
    public int superficie() {
        int totale = 0;
        for (final Superficie s : componenti)
            totale += s.superficie();
        return totale;
    }

    @Override
    public Iterator<PavimentazioneBis.Componente> iterator() {
        return componenti.iterator();
    }

}
