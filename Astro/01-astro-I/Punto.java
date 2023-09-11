import java.util.Objects;

/**
 * Un punto è un oggetto immutabile a tre coordinate intere,
 * esse sono pubbliche ed immutabili.
 */
public record Punto(int x, int y, int z) {
    /**
     * Produce un nuovo punto ottenuto effettuando la somma tra {@code this} e
     * un altro punto {@code q}.
     * 
     * @param q {@link Punto} da sommare a {@code this}
     * @return un nuovo {@link Punto} ottenuno effettuando {@code this+q}
     * @throws NullPointerException se {@code q} è {@code null}
     */
    public Punto somma(Punto q) {
        Objects.requireNonNull(q, "q non dev'essere null.");
        return new Punto(x + q.x, y + q.y, z + q.z);
    }

    /**
     * Produce un nuovo punto ottenuto effettuando la differenza tra {@code this} e
     * {@code q}.
     * 
     * @param q {@link Punto} da sottrare a {@code this}
     * @return un nuovo {@link Punto} ottenuno effettuando {@code this-q}
     * @throws NullPointerException se {@code q} è {@code null}
     */
    public Punto sottrai(Punto q) {
        Objects.requireNonNull(q, "Il punto q non dev'essere null.");
        return new Punto(x - q.x, y - q.y, z - q.z);
    }

    public int norma() {
        return Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", x, y, z);
    }
}
