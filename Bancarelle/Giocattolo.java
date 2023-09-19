import java.util.Objects;

/**
 * Classe concreta che rappresenta un Giocattolo dotato di nome e tipo di
 * materiale di cui è fatto.
 * Le istanze di questa classe sono immutabili.
 */
public class Giocattolo {
    /** Il nome del giocattolo. */
    public final String nome;
    /** Il tipo di materiale di cui è fatto il giocattolo. */
    public final String materiale;

    /*
     * AF(name, materiale) = giocattolo con nome = name, tipo di material = type
     * 
     * RI(name, materiale) = true se:
     * - name e materiale sono != null (verificato in costruzione e successivamente
     * in quanto final)
     */

    /**
     * Costruisce un giocattolo con nome e tipo di materiale dati.
     * 
     * @param nome il nome
     * @param type il tipo di materiale
     * @throws NullPointerException se {@code nome} o {@code materiale} sono null
     */
    public Giocattolo(final String nome, final String materiale) {
        Objects.requireNonNull(nome, "nome non può essere null");
        Objects.requireNonNull(materiale, "materiale non può essere null");
        this.nome = nome;
        this.materiale = materiale;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Giocattolo))
            return false;
        Giocattolo o = (Giocattolo) obj;
        return nome.equals(o.nome) && materiale.equals(o.materiale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, materiale);
    }

    @Override
    public String toString() {
        return nome + " di " + materiale;
    }

}