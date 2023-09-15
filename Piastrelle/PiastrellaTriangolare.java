import java.util.Objects;

/**
 * Classe concreata che implementa una {@link Piastrella} triangolare.
 * Gli oggetti di questo tipo sono immutabili.
 */
public class PiastrellaTriangolare extends Piastrella {

    private final int base, altezza;

    /*-
     * AF:  AF(base, altezza) = una piastrella triangolare di base = base e altezza = altezza
     * IR:  base e altezza sono positive
     */

    /**
     * Inizializza {@code this} affinché rappresenti una piastrella triangolare di
     * base, altezza e prezzo dati.
     * 
     * @param prezzo  il prezzo
     * @param base    la base
     * @param altezza l'altezza
     * @throws IllegalArgumentException se prezzo o base o altezza sono non positivi
     */
    public PiastrellaTriangolare(int prezzo, int base, int altezza) {
        super(prezzo);
        if (prezzo < 0 || base < 0 || altezza < 0)
            throw new IllegalArgumentException("Prezzo, base e altezza non possono essere negativi.");
        this.base = base;
        this.altezza = altezza;
    }

    @Override
    public int superficie() {
        return (base * altezza) / 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof PiastrellaTriangolare))
            return false;
        PiastrellaTriangolare o = (PiastrellaTriangolare) obj;
        return o.altezza == altezza && o.base == base && costo() == o.costo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, altezza, costo());
    }

}
