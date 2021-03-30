package shoppinglist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aksel
 * @version 19.3.2021
 * Lukee ja kirjoittaa liikkeet tiedostoon, lisää ja poistaa tuotteita, 
 * etsii ja lajittelee
 */
public class Tuotteet {
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
    
    
   /**
    * @param args ei käytössä
    */
   public static void main(String[] args) {
       Tuotteet tuotteet = new Tuotteet();
       Tuote tuote1 = new Tuote();
       Tuote tuote2 = new Tuote();
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

       }
   }
}
