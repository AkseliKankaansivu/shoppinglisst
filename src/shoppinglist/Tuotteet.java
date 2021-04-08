package shoppinglist;

<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;

>>>>>>> tyo5
/**
 * @author aksel
 * @version 19.3.2021
 * Lukee ja kirjoittaa liikkeet tiedostoon, lisää ja poistaa tuotteita, 
 * etsii ja lajittelee
 */
public class Tuotteet {
<<<<<<< HEAD
<<<<<<< HEAD
    private static final int MAX_TUOTTEET = 10;
=======
    private static final int MAX_TUOTTEET = 12;
>>>>>>> tyo5
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
    
=======
    ArrayList<Tuote> alkiot = new ArrayList<Tuote>();
    
    /**
     * @return tuotteiden lukumäärän
     */
    public int getLkm() {
        return alkiot.size();
    }
    
    /**
     * @param jnro etsittävä indeksi
     * @return tuotteen etsitystä indeksistä
     */
    public Tuote anna(int jnro) {
        return alkiot.get(jnro);
    }
    
    /**
     * @param tuote lisää tuotteen tietorakenteeseen
     */
    public void lisaa(Tuote tuote) {
        alkiot.add(tuote);
     }
    
    /**
     * Etsitään liikkeen tuotteet
     * @param tunnusnro mikä tuote etsitään
     * @return lista löydetyistä tuotteista
     */
    public List<Tuote> annaTuotteet(int tunnusnro) {
        List<Tuote> loydetyt = new ArrayList<Tuote>();
        for (Tuote tuo: alkiot) // iteraattori
            if (tuo.getLiikeID() == tunnusnro) loydetyt.add(tuo);
        return loydetyt;
    }
    
    
>>>>>>> tyo5
   /**
    * @param args ei käytössä
    */
   public static void main(String[] args) {
       Tuotteet tuotteet = new Tuotteet();
       Tuote tuote1 = new Tuote();
       Tuote tuote2 = new Tuote();
<<<<<<< HEAD
       
       tuote1.rekisteroi();
       tuote1.tayta();
       tuote2.rekisteroi();
       tuote2.tayta();
       
       try {
        tuotteet.lisaa(tuote1);
        tuotteet.lisaa(tuote2);
<<<<<<< HEAD
=======
       
>>>>>>> tyo5
    } catch (SailoException e) {
        System.err.println(e.getMessage());
    }
       
       System.out.println("=======================Liikkeet testi=========================");
       
       for (int i = 0;i<tuotteet.getLkm(); i++) {
           Tuote tuote = tuotteet.anna(i);
           System.out.println("Liikkeen indeksi " + i);
           tuote.tulosta(System.out);
=======
       Tuote tuote3 = new Tuote();
       Tuote tuote4 = new Tuote();
       
       tuote1.rekisteroi();
       tuote1.tayta(2);
       tuote2.rekisteroi();
       tuote2.tayta(1);
       tuote3.rekisteroi();
       tuote3.tayta(2);
       tuote4.rekisteroi();
       tuote4.tayta(2);
       
       tuotteet.lisaa(tuote4);
       tuotteet.lisaa(tuote1);
       tuotteet.lisaa(tuote2);
       tuotteet.lisaa(tuote3);
     
       
       System.out.println("=======================Liikkeet testi=========================");
       
       List<Tuote> tuotteet2 = tuotteet.annaTuotteet(2);
       
       for (Tuote tuo : tuotteet2) {
           System.out.print(tuo.getTunnusNro() + " ");
           tuo.tulosta(System.out);

>>>>>>> tyo5
       }
   }
}
