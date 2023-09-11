/**
 * Una {@link StellaFissa} è un {@link CorpoCeleste} con posizione non null,
 * velocità pari a zero ed entrambe immutabili.
 */
public class StellaFissa extends CorpoCeleste {

    private final Punto posizione, velocita;

    public StellaFissa(String nome, final int x, final int y, final int z) {
        super(nome);
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
    }

    @Override
    public void aggiornaVelocita(CorpoCeleste c) {
    }

    @Override
    public String toString() {
        return String.format("Stella fissa, nome: %s, pos: %s", nome, posizione);
    }
}
