/**
 * Interfaccia che descrive il contratto di una superficie, cioè una qualunque
 * entità dotata di costo e superficie.
 */
public interface Superficie {

    /**
     * Restituisce l'area totale della superficie.
     * 
     * @return l'area, ha sempre valore positivo
     */
    int superficie();

    /**
     * Restituisce il costo della superficie.
     * 
     * @return il costo, ha sempre valore positivo
     */
    int costo();

}