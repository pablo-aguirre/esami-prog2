import java.util.Objects;

/**
 * Classe che rappresenta una {@link Piastrella} triangolare.
 * Gli oggetti di questo tipo sono immutabili.
 */
public class PiastrellaTriangolare extends Piastrella {

    /** La base (sempre positiva). */
    public final int base;
    /** L'altezza (sempre positiva). */
    public final int altezza;

    /*-
     * AF:  AF(base, altezza) = una piastrella triangolare di base e altezza uguali agli omonimi campi.
     * IR:  base e altezza sono positive
     */

    /**
     * Costruisce una piastrella triangolare dato il costo e la lunghezza della sua
     * base altezza.
     * 
     * @param costo   il costo
     * @param base    la base
     * @param altezza l'altezza
     * @throws IllegalArgumentException se costo, base o altezza non sono positivi
     */
    public PiastrellaTriangolare(final int costo, final int base, final int altezza) {
        super(costo);
        if (base <= 0)
            throw new IllegalArgumentException("Base non può essere negativa.");
        if (base <= altezza)
            throw new IllegalArgumentException("Altezza non può essere negativa.");
        this.base = base;
        this.altezza = altezza;
    }

    @Override
    public int superficie() {
        return (base * altezza) / 2;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (!(obj instanceof PiastrellaTriangolare))
    //         return false;
    //     PiastrellaTriangolare o = (PiastrellaTriangolare) obj;
    //     return o.altezza == altezza && o.base == base && costo() == o.costo();
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(base, altezza, costo());
    // }

}
