import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe concreta che rappresenta una <strong>Playlist</strong>.
 * <p>
 * Una playlist è caratterizzata da un elenco di brani (anche di {@link Album}
 * diversi) non ripetuti, da un nome e da una {@link Durata} complessiva data
 * dalla somma delle durate delle canzoni di cui è costituita la playlist.
 * <p>
 * Le istanze di questa classe sono mutabili.
 */
public class Playlist implements Riproducibile, Iterable<Album.Brano> {

    /** Il nome della playlist. */
    public final String nome;
    /** Brani che compongono la playlist. */
    private List<Album.Brano> brani;
    /** La durata complessiva. */
    private Durata durata;

    /*
     * RI:
     * - nome != null e non vuoto
     * - brani != null (può essere vuoto)
     * - se brani non è vuoto, ogni elemento di brani è != null
     * - durata != null
     */

    /**
     * Costruisce una playlist vuota dato il suo nome.
     * 
     * @param nome il nome della playlist
     * @throws NullPointerException se {@code nome} è {@code null}
     */
    public Playlist(final String nome) {

    }

    /**
     * Aggiunge il brano dato alla playlist.
     * 
     * @param brano il brano da aggiungere
     * @throws NullPointerException se {@code brano} è {@code null}
     */
    public void aggiungi(final Album.Brano brano) {

    }

    /**
     * Rimuove il brano dato alla playlist.
     * 
     * @param brano il brano da rimuovere
     * @throws NullPointerException   se {@code brano} è {@code null}
     * @throws NoSuchElementException se {@code brano} non appartiene alla playlist
     */
    public void rimuovi(final Album.Brano brano) {

    }

    /**
     * Restituisce {@code true} se il brano specificato appartiene alla playlist.
     * 
     * @param brano il brano di cui verificare la presenza
     * @return {@code true} se e solo se {@code brano} è presente nella playlist
     */
    public boolean contiene(final Album.Brano brano) {

    }

    /**
     * Restituisce la posizione nella playlist del brano indicato.
     * 
     * @param brano il brano di cui si vuole conoscere la posizione
     * @return la posizione nella playlist di {@code brano}
     * @throws NoSuchElementException se {@code brano} non appartiene alla playlist
     */
    public int posizione(final Album.Brano brano) {

    }

    @Override
    public String nome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nome'");
    }

    @Override
    public Durata durata() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'durata'");
    }

    /**
     * Restituisce una nuova playlist ottenuta dalla fusione di {@code this} e
     * quella data
     * <p>
     * La nuova playlist conterrà, in ordine, prima i brani di this e poi quelli di
     * {@code other} (se non già presenti in {@code this}).
     * 
     * @param o l'altra playlist
     * @return la nuova playlist
     * @throws NullPointerException se {@code other} è {@code null}
     */
    public Playlist fusioneCon(final Playlist other) {
        
    }

    @Override
    public Iterator<Album.Brano> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    /**
     * Restituisce un {@code Iterator} sui brani di un album specificato.
     * 
     * @return l'iteratore sui brani di {@code album}
     * @throws NullPointerException   se {@code album} è {@code null}
     * @throws NoSuchElementException se nella playlist non esiste nessun brano
     *                                appartenente all'album specificato
     */
    public Iterator<Album> braniDelAlbum(final Album album) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    /**
     * Restituisce un {@code Iterator} sugli album (non ripetuti) presenti nella
     * playlist.
     * 
     * @return l'iteratore sugli album
     */
    public Iterator<Album> albumIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

}
