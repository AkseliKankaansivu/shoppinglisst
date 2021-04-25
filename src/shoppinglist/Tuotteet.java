package shoppinglist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


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
     * tallentaa liikkeet tiedostoon
     * @param tiednimi tiedoston nimi
     * @throws SailoException virhe, jos tallennus ei onnistu
     */
    public void tallenna(String tiednimi) throws SailoException {
        File ftied = new File(tiednimi + "/tuotteet.dat");
       try (PrintStream fo = new PrintStream(new FileOutputStream(ftied, false))) {
           for (int i = 0; i<getLkm(); i++) {
               Tuote tuote = anna(i);
               fo.print(tuote.toString());
           }
        } catch (FileNotFoundException e) {
            throw new SailoException("Tiedosto " + ftied.getAbsolutePath() + " ei aukea");
        }
        
    }
    
    /**
     * lukee liikkeet tiedostosta
     * @param hakemisto tiedoston hakemisto
     * @throws SailoException jos tiedoston luku epäonnistuu
     */
    public void lueTied(String hakemisto) throws SailoException {
        String nimi = hakemisto + "/tuotteet.dat";
        File ftied = new File(nimi);
        
        try (Scanner fi = new Scanner(new FileInputStream(ftied))) {
            while (fi.hasNext()) {
                String s = "";
                s = fi.nextLine();
                Tuote tuote = new Tuote();
                tuote.parse(s);
                lisaa(tuote);
            }
        } catch (FileNotFoundException e) {
            throw new SailoException("Ei saa luettua tiedostoa " + nimi);
       // } catch (IOException e) {
       //     throw new SailoException("Ongelmia tiedoston kanssa " + e.getMessage());
        }
    }  
    
   /**
    * @param args ei käytössä
    */
   public static void main(String[] args) {
       Tuotteet tuotteet = new Tuotteet();
       
       try {
           tuotteet.lueTied("Tuotteet");
       } catch (SailoException e) {
           System.err.println(e.getMessage());
       }
       
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
       
       tuotteet.lisaa(tuote1);
       tuotteet.lisaa(tuote2);
       tuotteet.lisaa(tuote3);
       tuotteet.lisaa(tuote4);
     
       
       System.out.println("=======================Liikkeet testi=========================");
       
       List<Tuote> tuotteet2 = tuotteet.annaTuotteet(2);
       
       for (Tuote tuo : tuotteet2) {
           System.out.print(tuo.getTunnusNro() + " ");
           tuo.tulosta(System.out);

       }
       try {
           tuotteet.tallenna("Tuotteet");
       } catch (SailoException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       
   }

/**
     * poistaa valitun liikkeen
     * @param tuote poistettavan liikkeen tunnusnro
     */
    public void poista(Tuote tuote) {
        alkiot.remove(tuote);
    }

/**
 * Poistaa liikkeen tuotteet, kun liike poistetaan
 * @param tunnusNro liikkeen tunnusnro
 */
public void poistaLiikkeenTuotteet(int tunnusNro) {
       for (Iterator<Tuote> it = alkiot.iterator(); it.hasNext();) {
           Tuote tuote = it.next();
           if (tuote.getLiikeID() == tunnusNro) {
               it.remove();
           }
    }
    
}

/**
 * @param id tuotteiden liike
 * @return tuotteiden hinnat
 */
public String getHinnat(int id) {
    double summa = 0;
    for (Iterator<Tuote> it = alkiot.iterator(); it.hasNext();) {
        Tuote tuo = it.next();
        if (tuo.getLiikeID() == id) {
        String temp = tuo.getHinta();
        temp = temp.replace("€", "");
        summa += Double.parseDouble(temp);
        }
    }
    return Double.toString(summa) + "0 €";
}

}
