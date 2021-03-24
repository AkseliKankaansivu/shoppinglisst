package shoppinglist;

/**
 * @author aksel
 * @version 4.3.2021
 * Lukee ja kiroittaa liikkeet tiedostoon, osaa etsiä ja lajitella 
 */
public class Liikkeet {
    
    private static final int MAX_LIIKKEET = 10;
    private int lkm = 0;
    private Liike[] alkiot = new Liike[MAX_LIIKKEET];
    /**
     * @param liike Liittää liikkeen tietorakenteeseen
     * @throws SailoException jos tietorakenne on jo täynnä
     */
    public void lisaa(Liike liike) throws SailoException {
       if (lkm>=alkiot.length) throw new SailoException("Liikaa alkioita taulussa");
       this.alkiot[this.lkm] = liike;
       lkm++;
    }

    /**
     * @return liikkeiden lukumäärä
     */
    public int getLkm() {
        return lkm;
    }
    
    /**
     * palauttaa viitteen i:teen liikkeeseen
     * @param i monennen alkion viite
     * @return viite liikkeeseen, jonka alkio on i
     * @throws IndexOutOfBoundsException jos indeksi ei ole mahdollinen tai sen kohdalla alkiota
     */
    public Liike anna(int i) throws IndexOutOfBoundsException {
        if (i<0 || this.lkm <= i) throw new IndexOutOfBoundsException("Laiton indeksi");
        return alkiot[i];
    }
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Liikkeet liikkeet = new Liikkeet();
        Liike Citymarket = new Liike();
        Liike Prisma = new Liike();
        Liike Sale = new Liike();
        
        Citymarket.rekisteroi();
        Citymarket.tayta("Citymarket");
        
        Prisma.rekisteroi();
        Prisma.tayta("Prisma");
        
        Sale.rekisteroi();
        Sale.tayta("Sale");
        
        try {
            liikkeet.lisaa(Citymarket);
            liikkeet.lisaa(Prisma);
            liikkeet.lisaa(Sale);
         
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        
        System.out.println("=======================Liikkeet testi=========================");
        
        for (int i = 0;i<liikkeet.getLkm(); i++) {
            Liike liike = liikkeet.anna(i);
            System.out.println("Liikkeen indeksi " + i);
            liike.tulosta(System.out);
        }
    }  
}
