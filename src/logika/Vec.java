/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/*******************************************************************************
 * Instance třídy Vec představují ...
 *
 * @author    jméno autora
 * @version   0.00.000
 */
public class Vec
{
    //== Datové atributy (statické i instancí)======================================
    private String nazev;
    private boolean prenositelna;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public Vec(String nazev, boolean prenositelna)
    {
        this.nazev = nazev;
        this.prenositelna = prenositelna;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     * Vrací název veci.
     */
    public String getNazev() {
        return nazev;
    }
    
       
    /**
     * Vec je prenositelna.
     */
    public boolean isPrenositelna() {
        return prenositelna;
    }

    //== Soukromé metody (instancí i třídy) ========================================

}
