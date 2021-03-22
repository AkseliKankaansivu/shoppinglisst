package shoppinglist;

/**
 * @author aksel
 * @version 4.3.2021
 * lukee ja kirjoittaa ShoppingListin tiedostoon avustajien tiedoilla
 */
public class ShoppingList {
    private Liikkeet liikkeet = new Liikkeet();
    
    /**
     * lisätään uusi liike
     * @param liike lisättävä liike
     * @throws SailoException annetaan poikkeuksen vuotaa ulos
     */
    public void lisaa(Liike liike) throws SailoException {
        liikkeet.lisaa(liike);
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
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        ShoppingList shoppinglist = new ShoppingList();
        Liike Citymarket = new Liike();
        Liike Prisma = new Liike();
        
        Citymarket.rekisteroi();
        Citymarket.taytaCitymarket();
        
        Prisma.rekisteroi();
        Prisma.taytaPrisma();
        
        
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
    }
}
