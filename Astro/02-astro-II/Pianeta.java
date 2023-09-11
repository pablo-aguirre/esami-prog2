import static java.lang.Math.signum;
import java.util.Objects;

/**
 * Un {@link Pianeta} è un {@link CorpoCeleste} con velocita e posizione
 * mutabili e non nulle.
 */
public class Pianeta extends CorpoCeleste {

    private Punto posizione, velocita;

    public Pianeta(final String name, final int x, final int y, final int z) {
        super(name);
        posizione = new Punto(x, y, z);
        velocita = new Punto(0, 0, 0);
    }

    @Override
    public Punto velocita() {
        return velocita;
    }

    @Override
    public Punto posizione() {
        return posizione;
    }

    @Override
    public void aggiornaPosizione() {
        posizione = posizione.somma(velocita);
    }

    @Override
    public void aggiornaVelocita(CorpoCeleste c) {
        Objects.requireNonNull(c, "c non può essere null");
        Punto d = posizione.sottrai(c.posizione());
        velocita = velocita.somma(new Punto(-(int) signum(d.x()), -(int) signum(d.y()), -(int) signum(d.z())));
    }

    @Override
    public String toString() {
        return String.format("Pianeta, nome: %s, pos: %s, vel: %s", nome, posizione, velocita);
    }
}
