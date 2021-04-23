package shoppinglist;


import java.util.Collection;
import java.util.List;

/**
 * @author aksel
 * @version 4.3.2021
 * lukee ja kirjoittaa ShoppingListin tiedostoon avustajien tiedoilla
 */
public class ShoppingList {
    private Liikkeet liikkeet = new Liikkeet();
    private Tuotteet tuotteet = new Tuotteet();
    
    
    /**
     * lukee tuotteet ja liikkeet tiedostosta jos on jo valmiiksi
     * @throws SailoException jos tiedostoja luetessa tulee virhe
     */
    public void lueTiedostosta() throws SailoException {
        liikkeet = new Liikkeet();
        tuotteet = new Tuotteet();
        
        liikkeet.lueTied("Liikkeet");
        tuotteet.lueTied("Tuotteet");
    }
    
    /**
     * Tallennetaan shoppinglistin tiedot tiedostoon
     * @throws SailoException jos ongelmia tallentamisessa
     */
    public void tallenna() throws SailoException {
        String virhe = "";
        try {
            liikkeet.tallenna("Liikkeet");
        } catch (SailoException e) {
            virhe += e.getMessage();
        }
        
        try {
            tuotteet.tallenna("Tuotteet");
        } catch (SailoException e) {
            virhe += e.getMessage();
        }
        
        if (!"".equals(virhe)) throw new SailoException(virhe);
    }
    
    
    /**
     * lisätään uusi liike
     * @param liike lisättävä liike
     * @throws SailoException annetaan poikkeuksen vuotaa ulos
     */
    public void lisaa(Liike liike) throws SailoException {
        liikkeet.lisaa(liike);
    }
    
    /**
     * lisää uusi tuote
     * @param tuote lisättävä tuote
     */
    public void lisaa(Tuote tuote) {
        tuotteet.lisaa(tuote);
    }
    
    
    /**
     * @return shoppinglistin liikkeiden lukumäärä
     */
    public int getLiikkeet() {
        return this.liikkeet.getLkm();
    }
    
    /**
     * @param i indeksi josta haetaan
     * @return liikkeen viite i:n kohdassa
     */
    public Liike annaLiike(int i) {
        return this.liikkeet.anna(i);
    }
    
    
    /**
     * @param liike jonka tuotteita haetaan
     * @return liikkeen tuotteet
     */
    public List<Tuote> annaTuotteet(Liike liike) {
        return tuotteet.annaTuotteet(liike.getTunnusNro());
    }
    
    /**
     * @return palauttaa tuotteiden lukumäärän
     */
    public int getTuotteet() {
        return this.tuotteet.getLkm();
    }
    
    /**
     * @param i indeksi, josta tuote haetaan
     * @return tuotteen haetusta indeksistä
     */
    public Tuote annaTuote(int i) {
        return this.tuotteet.anna(i);
    }
    
    /**
     * @param hakuehto hakuehto jolla etsitään
     * @return palauttaa löydetyt
     * @throws SailoException virhe 
     */
    public Collection<Liike> etsi(String hakuehto) throws SailoException { 
        return liikkeet.etsi(hakuehto);
    }
    
    /**
     * @param args ei käytössä
     * @throws SailoException jos vihreitä
     */
    public static void main(String[] args) throws SailoException {
        ShoppingList shoppinglist = new ShoppingList();
        
        shoppinglist.lueTiedostosta();
        // muodostetaan liikkeet
        Liike Citymarket = new Liike();
        Liike Prisma = new Liike();
        
        Citymarket.rekisteroi();
        Citymarket.tayta("Citymarket");
        
        Prisma.rekisteroi();
        Prisma.tayta("Prisma");
        
        
        try {
            shoppinglist.lisaa(Citymarket);
            shoppinglist.lisaa(Prisma);
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        for (int i=0;i<shoppinglist.getLiikkeet();i++) {
            Liike liike = shoppinglist.annaLiike(i);
            System.out.println("Liike indeksissä " + i);
            liike.tulosta(System.out);
        }
        
        // muodostetaan tuotteet
        Tuote tuote1 = new Tuote();
        tuote1.rekisteroi();
        tuote1.tayta(2);
        
        
    }

    /**
     * poistaa valitun liikkeen
     * @param liike poistettava liike
     * @return poistetun liikkeen tunnusnro, 0 jos virhe
     */
    public int poistaLiike(Liike liike) {
        if (liike == null) return 0;
        int ret = liikkeet.poista(liike.getTunnusNro());
        tuotteet.poistaLiikkeenTuotteet(liike.getTunnusNro());
        return ret;
    }

    /**@example
    * <pre name="test">
    * Liike citymarket = new Liike();
    * Liike prisma = new Liike();
    * citymarket.rekisteroi();
    * citymarket.tayta("Citymarket");
    * prisma.rekisteroi();
    * prisma.tayta("Prisma");
    * </pre>st
     * poistaa tuotteen
     * @param tuote poistettava tuote
     */
    public void poistaTuote(Tuote tuote) {
        if (tuote == null) return;
        tuotteet.poista(tuote);
    }

    /**
     * @return tuotteiden hinnat
     */
    public String tuotteetHinta() {
        if (tuotteet.getLkm() == 0) return "";
        return tuotteet.getHinnat();
    }

    

}
