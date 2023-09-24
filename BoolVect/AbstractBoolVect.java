/**
 * Classe astratta che implementa parzialmente il contratto definito
 * dall'interfaccia {@link BoolVect}.
 * <p>
 * Questa classe provvede una implementazione di {@link #toString()}.
 */
public abstract class AbstractBoolVect implements BoolVect {
    /**
     * Restituisce la versione testule di questo BoolVect.
     * <p>
     * Se la dimensione del BoolVect è 0 restituisce '{@code F}', altrimenti
     * restituisce una stringa che comprende solo caratteri ('{@code F}' o
     * '{@code V}') in numero pari alla dimensione di questo boolvect.
     *
     * @return la rappresentazione testuale di questo boolvect come da specifiche
     */
    @Override
    public String toString() {
        if (dim() == 0)
            return "F";
        final StringBuilder b = new StringBuilder();
        for (int i = dim() - 1; i >= 0; i--)
            b.append(leggi(i) ? 'V' : 'F');
        return b.toString();
    }
}
