package shoppinglist;

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
        tuote1.tayta(2);
        
        
    }

    
}
