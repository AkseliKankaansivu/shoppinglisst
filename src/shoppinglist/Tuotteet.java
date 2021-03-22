package shoppinglist;

/**
 * @author aksel
 * @version 19.3.2021
 * Lukee ja kirjoittaa liikkeet tiedostoon, lisää ja poistaa tuotteita, 
 * etsii ja lajittelee
 */
public class Tuotteet {
    private static final int MAX_TUOTTEET = 10;
    private int lkm = 0;
    private Tuote[] alkiot = new Tuote[MAX_TUOTTEET];
    
    
    /**
     * @param tuote lisää tuotteen tietorakenteeseen
     * @throws SailoException jos alkioita lisätään liikaa
     */
    public void lisaa(Tuote tuote) throws SailoException {
        if (lkm>=alkiot.length) throw new SailoException("Liikaa alkioita taulussa");
        this.alkiot[this.lkm] = tuote;
        lkm++;
     }
    
    /**
     * @return tuotteiden lukumäärä
     */
    public int getLkm() {
        return lkm;
    }
    
    /**
     * palauttaa viitteen i:teen tuotteeseen
     * @param i monennen alkion viite
     * @return viite tuotteeseen, jonka alkio on i
     * @throws IndexOutOfBoundsException jos indeksi ei ole mahdollinen tai sen kohdalla alkiota
     */
    public Tuote anna(int i) throws IndexOutOfBoundsException {
        if (i<0 || this.lkm <= i) throw new IndexOutOfBoundsException("Laiton indeksi");
        return alkiot[i];
    }
    
   /**
    * @param args ei käytössä
    */
   public static void main(String[] args) {
       Tuotteet tuotteet = new Tuotteet();
       Tuote tuote1 = new Tuote();
       Tuote tuote2 = new Tuote();
       
       tuote1.rekisteroi();
       tuote1.tayta();
       tuote2.rekisteroi();
       tuote2.tayta();
       
       try {
        tuotteet.lisaa(tuote1);
        tuotteet.lisaa(tuote2);
    } catch (SailoException e) {
        System.err.println(e.getMessage());
    }
       
       System.out.println("=======================Liikkeet testi=========================");
       
       for (int i = 0;i<tuotteet.getLkm(); i++) {
           Tuote tuote = tuotteet.anna(i);
           System.out.println("Liikkeen indeksi " + i);
           tuote.tulosta(System.out);
       }
   }
}
