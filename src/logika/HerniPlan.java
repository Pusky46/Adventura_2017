package logika;


/**
 * Class HerniPlan - třída představující mapu a stav adventury.
 * 
 * Tato třída inicializuje prvky ze kterých se hra skládá:
 * vytváří všechny prostory, propojuje je vzájemně pomocí východů
 * a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 * @author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Jan Riha
 * @version    ZS 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    
    private Batoh batoh;
    private boolean vyhra = false;
    private boolean prohra = false;
    
    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
        
        batoh = new Batoh();

    }
    
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor luka = new Prostor("lúka","Lúka, tu si sa ocitol a hľadáš cestu domov.");
        Prostor jazero = new Prostor("jazero", "strieborné jazero s horkým pokladom.");
        Prostor dedina = new Prostor("dedina","konečne sa môžeš najesť.");
        Prostor les = new Prostor("les","les s jahodami, malinami a pramenem vody.");
        Prostor cistinka = new Prostor("čistinka","čistinka, na ktorej sa môžeš rozhodnúť kam ďalej.");
        Prostor nadvorie = new Prostor("nádvorie","nádvorie, už len kúsok domov.");
        Prostor hrad = new Prostor("hrad","hrad, konečne si v svojej svätini.");
        
        
        // přiřazují se průchody mezi prostory (sousedící prostory)
        luka.setVychod(jazero);
        luka.setVychod(dedina);
        jazero.setVychod(luka);
        jazero.setVychod(cistinka);
        dedina.setVychod(luka);
        dedina.setVychod(les);
        dedina.setVychod(cistinka);
        cistinka.setVychod(les);
        cistinka.setVychod(jazero);
        cistinka.setVychod(dedina);
        les.setVychod(dedina);
        les.setVychod(cistinka);
        les.setVychod(nadvorie);
        nadvorie.setVychod(les);
        nadvorie.setVychod(hrad);
        hrad.setVychod(nadvorie);
                
        aktualniProstor = hrad;  // hra začíná v domečku
        
        //vytváram veci
        Vec mince = new Vec("mince",true);
        Vec krv = new Vec("krv",true);
        Vec zlato = new Vec("zlato",true);
        Vec dyka = new Vec ("dýka",true);
        Vec klic = new Vec("klíč",true);
        Vec kamen = new Vec("kámen",false);
        
        // vložíme věci do prostorů
        jazero.vlozVec(mince);
        dedina.vlozVec(krv);
        dedina.vlozVec(zlato);
        dedina.vlozVec(dyka);
        les.vlozVec(klic);
        jazero.vlozVec(kamen);
        
        aktualniProstor = luka;  // hra začína na lúke  
        
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }
    
  
   
    
    /**
     * Metoda vrací odkaz na batoh.
     */
    public Batoh getBatoh() {
        return batoh;
     }
     
     /**
     *  Metoda vrací odkaz na výhru.
     *
     *@return     vyhra
     */
    public boolean isVyhra() {
        return vyhra;
    }

    public void setVyhra(boolean stav) {
        this.vyhra = stav;
    }
    
    /**
     *  Metoda vrací odkaz na prohru.
     *
     *@return     prohra
     */
    public boolean isProhra() {
        return prohra;
    }

    public void setProhra(boolean stav) {
        this.prohra = stav;
    }

}
