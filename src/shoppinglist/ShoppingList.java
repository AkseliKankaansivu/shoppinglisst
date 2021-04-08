package shoppinglist;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> tyo5
/**
 * @author aksel
 * @version 4.3.2021
 * lukee ja kirjoittaa ShoppingListin tiedostoon avustajien tiedoilla
 */
public class ShoppingList {
    private Liikkeet liikkeet = new Liikkeet();
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private Tuotteet tuotteet = new Tuotteet();
    private Ostokset ostokset = new Ostokset();
>>>>>>> tyo5
=======
    private Tuotteet tuotteet = new Tuotteet();
>>>>>>> tyo5
    
    /**
     * lisätään uusi liike
     * @param liike lisättävä liike
     * @throws SailoException annetaan poikkeuksen vuotaa ulos
     */
    public void lisaa(Liike liike) throws SailoException {
        liikkeet.lisaa(liike);
    }
    
    /**
<<<<<<< HEAD
<<<<<<< HEAD
=======
     * lisää uusi tuote
     * @param tuote lisättävä tuote
     * @throws SailoException annetaan poikkeuksen vuotaa ulos
     */
    public void lisaa(Tuote tuote) throws SailoException {
        tuotteet.lisaa(tuote);
    }
    
    /**
     * @param ostos lisättävä ostos
     * @throws SailoException poikkeus vuotaa ulos
     */
    public void lisaa(Ostos ostos) throws SailoException {
        ostokset.lisaa(ostos);
    }
    
    /**
>>>>>>> tyo5
=======
     * lisää uusi tuote
     * @param tuote lisättävä tuote
     */
    public void lisaa(Tuote tuote) {
        tuotteet.lisaa(tuote);
    }
    
    
    /**
>>>>>>> tyo5
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
    
<<<<<<< HEAD
    /**
<<<<<<< HEAD
=======
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
     * @param i indekis josta haetaan
     * @return ostoksen viite i:n kohdassa
     */
    public Ostos annaOstos(int i) {
        return this.ostokset.anna(i);
    }
    
    /**
     * @return ostoksen määrän
     */
    public int getOstokset() {
        return this.ostokset.getLkm();
    }
    
    /**
>>>>>>> tyo5
=======
    
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
>>>>>>> tyo5
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        ShoppingList shoppinglist = new ShoppingList();
<<<<<<< HEAD
<<<<<<< HEAD
=======
        
        // muodostetaan liikkeet
>>>>>>> tyo5
=======
        
        // muodostetaan liikkeet
>>>>>>> tyo5
        Liike Citymarket = new Liike();
        Liike Prisma = new Liike();
        
        Citymarket.rekisteroi();
<<<<<<< HEAD
<<<<<<< HEAD
        Citymarket.taytaCitymarket();
        
        Prisma.rekisteroi();
        Prisma.taytaPrisma();
=======
=======
>>>>>>> tyo5
        Citymarket.tayta("Citymarket");
        
        Prisma.rekisteroi();
        Prisma.tayta("Prisma");
<<<<<<< HEAD
>>>>>>> tyo5
=======
>>>>>>> tyo5
        
        
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> tyo5
        
        // muodostetaan tuotteet
        Tuote tuote1 = new Tuote();
        tuote1.rekisteroi();
<<<<<<< HEAD
        tuote1.tayta();
        
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
        
        // muodostetaan ostokset
        Ostos ostos1 = new Ostos();
        ostos1.rekisteroi();
        ostos1.tayta();
        try {
            shoppinglist.lisaa(ostos1);
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        
>>>>>>> tyo5
    }
=======
        tuote1.tayta(2);
        
        
    }

    
>>>>>>> tyo5
}
