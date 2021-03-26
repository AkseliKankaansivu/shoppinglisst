package shoppinglist;

/**
 * @author aksel
 * @version 4.3.2021
 * lukee ja kirjoittaa ShoppingListin tiedostoon avustajien tiedoilla
 */
public class ShoppingList {
    private Liikkeet liikkeet = new Liikkeet();
    private Tuotteet tuotteet = new Tuotteet();
    
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
     * @throws SailoException annetaan poikkeuksen vuotaa ulos
     */
    public void lisaa(Tuote tuote) throws SailoException {
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
     * @return shoppinglistin tuotteiden lukumäärä
     */
    public int getTuotteet() {
        return this.tuotteet.getLkm();
    }
    
    /**
     * @param i indeksi josta haetaan
     * @return tuotteet viite i:n kohdassa
     */
    public Tuote annaTuote(int i) {
        return this.tuotteet.anna(i);
    }
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        ShoppingList shoppinglist = new ShoppingList();
        
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
        //tuote1.tayta();
        
        try {
            shoppinglist.lisaa(tuote1);
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        for (int i=0;i<shoppinglist.getTuotteet();i++) {
            Tuote tuote = shoppinglist.annaTuote(i);
            System.out.println("Tuote indeksissä " + i);
            tuote.tulosta(System.out);
        }
        
        
        
    }
}
