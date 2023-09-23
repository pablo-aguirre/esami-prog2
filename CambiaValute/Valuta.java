/**
 * Enum che rappresenta una <strong>valuta</strong>.
 * <p>
 * Un valuta è composta da un nome (non vuoto) e da un simbolo (carattere).
 * <p>
 * Le valute presenti sono:
 * <ul>
 * <li>Dollaro ($)
 * <li>Euro (€)
 * <li>Franco (₣)
 * <li>Lira (₺)
 * <li>Rupia (₹)
 * <li>Sterlina (£)
 * <li>Yen (¥)
 * </ul>
 * <p>
 */
public enum Valuta {
    Dollaro('$'),
    Euro('€'),
    Franco('₣'),
    Lira('₺'),
    Rupia('₹'),
    Sterlina('£'),
    Yen('¥');

    /** Il simbolo della valuta. */
    private final char simbol;

    /**
     * Restituisce il simbolo di questa valuta.
     * 
     * @return il simbolo
     */
    public char getSimbol() {
        return this.simbol;
    }

    /**
     * Inizializza il simbolo di questa valuta.
     */
    private Valuta(final char simbol) {
        this.simbol = simbol;
    }
}