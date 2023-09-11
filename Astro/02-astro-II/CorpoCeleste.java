import java.util.Objects;

/**
 * Un corpo celeste ha
 * <ul>
 * <li>nome (non nullo)
 * <li>posizione (dipendente dall'implementazione)
 * <li>velocità
 * </ul>
 */
public abstract class CorpoCeleste {
    final String nome;

    public CorpoCeleste(final String nome) {
        this.nome = Objects.requireNonNull(nome, "Il nome non può essere nullo.");
    }

    /**
     * @return l'energia totale, calcolata come da definizione.
     */
    public final int energia() {
        return posizione().norma() * velocita().norma();
    }

    /**
     * @return la velocità (non null)
     */
    public abstract Punto velocita();

    /**
     * @return la posizione (non null)
     */
    public abstract Punto posizione();

    /**
     * Modifica la posizione di {@code this}.
     */
    public abstract void aggiornaPosizione();

    /**
     * Modifica la velocita di {@code this} a partire dalle informazioni di
     * {@code c}.
     * @param c corpo celeste con cui far interagire {@code this} al fine di modificare la sua velocità.
     */
    public abstract void aggiornaVelocita(final CorpoCeleste c);
}