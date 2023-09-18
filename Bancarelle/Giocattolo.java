/**
 * Classe concreta che rappresenta un Giocattolo dotato di nome e tipo di
 * materiale di cui è fatto.
 * Le istanze di questa classe sono mutabili (il prezzo può cambiare).
 */
public class Giocattolo extends Vendibile {
    /** Il nome del giocattolo. */
    public final String name;
    /** Il tipo di materiale del giocattolo. */
    public final String type;

    /*
     * AF(name, type, price) = giocattolo con nome = name, tipo di material = type e
     * prezzo = price
     * 
     * RI(name, type, price) = vero se:
     * - name e type sono != null (verificato in costruzione e successivamente in
     * quanto final)
     * - price è positivo
     */

    /**
     * Costruisce un giocattolo con nome, tipo e prezzo dati.
     * 
     * @param name  il nome
     * @param type  il tipo
     * @param price il prezzo del giocatolo
     * @throws NullPointerException     se {@code name} o {@code type} sono null
     * @throws IllegalArgumentException se {@code price} non è positivo
     */
    public Giocattolo(final String name, final String type, final int price) {

    }

    @Override
    public boolean equals(Object obj) {

    }

    @Override
    public int hashCode() {

    }

    @Override
    public int price() {
        return price;
    }

}