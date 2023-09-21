import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/**
 * Classe concreta che rappresenta una <strong>playlist</strong>.
 * <p>
 * Una playlist è caratterizzata da un elenco di brani (appartenenti anche ad
 * {@link Album}
 * diversi) non ripetuti, da un nome e da una {@link Durata} complessiva data
 * dalla somma delle durate delle canzoni di cui è costituita la playlist.
 * <p>
 * Le istanze di questa classe sono mutabili.
 */
public class Playlist implements Iterable<Album.Brano> {

    /** Il nome della playlist. */
    private String nome;
    /** Brani che compongono la playlist. */
    private List<Album.Brano> brani;
    /** La durata complessiva. */
    private Durata durata;

    /*
     * RI:
     * - nome != null e non vuoto
     * - brani != null (può essere vuoto)
     * - se brani non è vuoto, ogni elemento di brani è != null
     * - durata != null e uguale alla somma delle durate dei brani
     */

    /**
     * Costruisce una playlist vuota dato il suo nome.
     * 
     * @param nome il nome della playlist
     * @throws NullPointerException     se il nome è {@code null}
     * @throws IllegalArgumentException se il nome è vuoto
     */
    public Playlist(final String nome) {
        brani = new ArrayList<>();
        setNome(nome);
    }

    /**
     * Modifica il nome della playlist.
     * 
     * @param nome il nuovo nome da assegnare alla playlist
     * @throws NullPointerException     se il nome è {@code null}
     * @throws IllegalArgumentException se il nome è vuoto
     */
    public void setNome(final String nome) {
        if (Objects.requireNonNull(nome, "Il nome non può essere null.").isEmpty())
            throw new IllegalArgumentException("Il nome non può essere vuoto.");
        this.nome = nome;
    }

    /**
     * Restituisce il nome della playlist.
     * 
     * @return il nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce la durata complessiva della playlist.
     * 
     * @return la durata
     */
    public Durata getDurata() {
        return durata;
    }

    /**
     * Restituisce il numero di brani della playlist.
     *
     * @return il numero di brani di questa playlist.
     */
    public int numeroBrani() {
        return brani.size();
    }

    /**
     * Restituisce il brano nella posizione indicata.
     * 
     * @param posizione la posizione
     * @return il brano
     * @throws IndexOutOfBoundsException se la posizione non è valida (minore di 0 o
     *                                   maggiore del numero di brani presenti nella
     *                                   playlist)
     */
    public Album.Brano brano(final int posizione) {
        if (posizione <= 0 || posizione > brani.size())
            throw new IndexOutOfBoundsException("La posizione data non è valida.");
        return brani.get(posizione - 1);
    }

    /**
     * Aggiunge il brano dato alla playlist.
     * 
     * @param brano il brano da aggiungere
     * @throws NullPointerException se il brano è {@code null}
     */
    public void accoda(final Album.Brano brano) {
        Objects.requireNonNull(brano, "Il brano non può essere null.");
        brani.add(brano);
        durata = durata.più(brano.durata);
    }

    /**
     * Rimuove il brano dato alla playlist.
     * 
     * @param brano il brano da rimuovere
     * @throws NullPointerException   se il brano è {@code null}
     * @throws NoSuchElementException se il brano non è è contenuto nella playlist
     */
    public void rimuovi(final Album.Brano brano) {
        Objects.requireNonNull(brano, "Il brano non può essere null.");
        if (!brani.contains(brano))
            throw new NoSuchElementException("Il brano indicato non è contenuto nella playlist.");
        brani.remove(brano);
        durata = durata.meno(brano.durata);
    }

    /**
     * Restituisce {@code true} se il brano specificato appartiene alla playlist.
     * 
     * @param brano il brano di cui verificare la presenza
     * @return {@code true} se e solo se {@code brano} è presente nella playlist
     * @throws NullPointerException se il brano è {@code null}
     */
    public boolean contiene(final Album.Brano brano) {
        return brani.contains(brano);
    }

    /**
     * Restituisce la posizione nella playlist del brano indicato.
     * 
     * @param brano il brano di cui si vuole conoscere la posizione
     * @return la posizione nella playlist di brano
     * @throws NullPointerException   se il brano è {@code null}
     * @throws NoSuchElementException se il brano non appartiene alla playlist
     */
    public int posizione(final Album.Brano brano) {
        Objects.requireNonNull(brano, "Il brano non può essere null.");
        if (!brani.contains(brano))
            throw new NoSuchElementException("Il brano indicato non è contenuto nella playlist.");
        return brani.indexOf(brano) + 1;
    }

    /**
     * Restituisce una nuova playlist ottenuta dalla fusione di {@code this} e
     * quella data.
     * <p>
     * La nuova playlist conterrà, in ordine, prima i brani di {@code this} e poi
     * quelli di
     * {@code other} (se non già presenti in {@code this}).
     * 
     * @param nome  il nome della nuova playlist
     * @param other l'altra playlist
     * @return la nuova playlist
     * @throws NullPointerException   se {@code other} o {@code nome} sono
     *                                {@code null}
     * @throws IllegalAccessException se il nome è vuoto
     */
    public Playlist fondiCon(final String nome, final Playlist other) {
        if (Objects.requireNonNull(nome, "Il nome non può essere null.").isEmpty())
            throw new IllegalArgumentException("Il nome non può essere vuoto.");
        Objects.requireNonNull(other, "L'altra playlist non può essere null.");
        final Playlist fusa = new Playlist(nome);
        for (final Album.Brano brano : this)
            fusa.accoda(brano);
        for (final Album.Brano brano : other)
            if (!fusa.contiene(brano))
                fusa.accoda(brano);
        return fusa;
    }

    @Override
    public Iterator<Album.Brano> iterator() {
        return Collections.unmodifiableList(brani).iterator();
    }

    /**
     * Restituisce un iteratore che enumera i brani della playlist appartenenti al
     * album specificato.
     * 
     * @return l'iteratore
     * @throws NullPointerException se l'album è {@code null}
     */
    public Iterator<Album.Brano> brani(final Album album) {
        Objects.requireNonNull(album, "L'album non può essere null.");
        return new Iterator<Album.Brano>() {

            /** Un iteratore su tutti i brani della playlist. */
            private final Iterator<Album.Brano> it = iterator();
            /** Il prossimo brano da restituire. */
            private Album.Brano next = null;

            @Override
            public boolean hasNext() {
                if (next != null)
                    return true;
                while (it.hasNext()) {
                    next = it.next();
                    if (next.album().equals(album))
                        return true;
                }
                next = null;
                return false;
            }

            @Override
            public Album.Brano next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                final Album.Brano res = next;
                next = null;
                return res;
            }

        };
    }

    /**
     * Restituisce un iteratore che enumera gli album (senza ripetizioni) delle
     * canzoni contenute nella playlist.
     * 
     * @return l'iteratore sugli album
     */


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Nome playlist: " + nome);
        int i = 1;
        for (Album.Brano brano : brani) {
            sb.append(i + " - " + brano.asString(true));
            i++;
        }
        return sb.append("Durata totale: " + durata).toString();
    }

}
