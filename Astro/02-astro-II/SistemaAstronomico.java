import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Un {@code SistemaAstronomico} è una collezione di {@link CorpoCeleste}.
 * È mutabile in quanto i pianeti possono cambiare la loro posizione
 */
public class SistemaAstronomico {
    private final SortedSet<CorpoCeleste> corpiCelesti = new TreeSet<CorpoCeleste>(
            new Comparator<>() {
                @Override
                public int compare(CorpoCeleste o1, CorpoCeleste o2) {
                    return o1.nome.compareTo(o2.nome);
                }
            });

    public void aggiungi(final CorpoCeleste c) {
        corpiCelesti.add(Objects.requireNonNull(c, "c non può essere null"));
    }

    /**
     * Simula l'evoluzione del sistema solare.
     * @param passi da far eseguire al sistema solare
     * @throw IllegalArgumentException se {@code passi < 0}
     */
    public void simula(final int passi) {
        if (passi < 0)
            throw new IllegalArgumentException("passi non può essere negativo");
        for (int i = 0; i < passi; i++) {
            for (final CorpoCeleste p : corpiCelesti) {
                for (CorpoCeleste c : corpiCelesti) {
                    if (p == c)
                        continue;
                    p.aggiornaVelocita(c);
                }
            }
            for (final CorpoCeleste c : corpiCelesti)
                c.aggiornaPosizione();
        }
    }

    public long energia() {
        long res = 0;
        for (final CorpoCeleste c : corpiCelesti)
            res += c.energia();
        return res;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        final Iterator<CorpoCeleste> it = corpiCelesti.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext())
                sb.append('\n');
        }
        return sb.toString();
    }
}
