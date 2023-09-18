import javax.naming.OperationNotSupportedException;

/**
 * Classe concreta che rappresenta una <strong>bancarella<strong>.
 * Una bancarella è dotata di un {@link Listino} e un {@link Inventario}.
 * Le istanze di questa classe sono mutabili.
 */
public class Bancarella {
    /** Il proprietario della bancarella. */
    public final String proprietario;
    /** L'inventario della bancarella. */
    private final Inventario<Vendibile> inventario;
    /** L'inventario relativa al */
    private final Listino listino;

    /*
     * AF(owner, invetory, listino) = una bancarella con proprietario, inventario e
     * listino.
     * 
     * IR(owner, invetory, listino) = true se:
     * - owner != null
     * - inventario != null
     * - listino != null
     */

    /**
     * Costruisce una bancarella dati proprietario, inventario e listino.
     * 
     * @param proprietario il proprietario della bancarella
     * @param inventario   l'inventario
     * @param listino      il listino da usare per il determinato invetario
     * @throws NullPointerException se {@code proprietario} o {@code inventario} o
     *                              {@code listino} sono {@code null}
     */
    public Bancarella(final String proprietario, Inventario<Vendibile> inventario, Listino listino) {
        this.proprietario = proprietario;
        this.inventario = inventario;
        this.listino = listino;
    }

    /**
     * Vende (rimuove) dall'inventario il giocatolo specificato, nella quantità
     * specificata.
     * 
     * @param g        il giocatolo da vendere
     * @param quantità la quantità da vendere
     * @throws IllegalArgumentException se si prova a vendere una quantità maggiore
     *                                  di quella disponibile oppure se il
     *                                  giocattolo non è presente nell'inventario
     */
    public void vendita(Giocattolo g, int quantità) {

    }

    /**
     * Restituisce la quantità disponibile del giocattolo specificato.
     * 
     * @param g il giocattolo
     * @return la quantità disponibile
     * @throws NullPointerException se {@code g} è {@code null}
     */
    public int disponibile(Giocattolo g) {

    }

}
