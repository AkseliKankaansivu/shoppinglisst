package shoppinglist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fi.jyu.mit.ohj2.WildChars;

/**
 * @author aksel
 * @version 4.3.2021
 * Lukee ja kiroittaa liikkeet tiedostoon, osaa etsiä ja lajitella 
 */
public class Liikkeet implements Iterable<Liike>{
    
    private static int MAX_LIIKKEET = 10;
    private int lkm = 0;
    private Liike[] alkiot = new Liike[MAX_LIIKKEET];
    //private String tiedostonNimi = "";
    /**
     * @param liike Liittää liikkeen tietorakenteeseen
     * @throws SailoException jos tietorakenne on jo täynnä
     */
    public void lisaa(Liike liike) throws SailoException {
       if (lkm>=alkiot.length) {  //throw new SailoException("Liikaa alkioita taulussa");
          MAX_LIIKKEET++;
          Liike[] uusi = new Liike[MAX_LIIKKEET];
          for (int i=0;i<alkiot.length;i++) {
              uusi[i]=alkiot[i];
          }
          alkiot = uusi;   
       }
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
     * tallentaa liikkeet tiedostoon
     * @param tiednimi tiedoston nimi
     * @throws SailoException virhe, jos tallennus ei onnistu
     */
    public void tallenna(String tiednimi) throws SailoException {
        File ftied = new File(tiednimi + "/liikkeet.dat");
       try (PrintStream fo = new PrintStream(new FileOutputStream(ftied, false))) {
           for (int i = 0; i<getLkm(); i++) {
               Liike liike = anna(i);
               fo.print(liike.toString());
           }
        } catch (FileNotFoundException e) {
            throw new SailoException("Tiedosto " + ftied.getAbsolutePath() + " ei aukea");
        }
        
    }
    /**
     * Lukee jäsenistön tiedostosta. 
     * @throws SailoException jos lukeminen epäonnistuu
     * 
     * @example
     * <pre name="test">
     * #THROWS SailoException 
     * #import java.io.File;
     * 
     *  Liikkeet liikkeet = new Liikkeet();
     *  Liike liike1 = new Liike(), liike2 = new Liike();
     *  liike1.tayta("1");
     *  liike2.tayta("2");
     *  String hakemisto = "testiliikkeet";
     *  String tiedNimi = hakemisto+"/nimet";
     *  File ftied = new File(tiedNimi+".dat");
     *  File dir = new File(hakemisto);
     *  dir.mkdir();
     *  ftied.delete();
     *  liikkeet.lueTied(tiedNimi); #THROWS SailoException
     *  liikkeet.lisaa(liike1);
     *  liikkeet.lisaa(liike2);
     *  liikkeet.tallenna("Liikkeet");
     *  liikkeet = new Liikkeet();            // Poistetaan vanhat luomalla uusi
     *  liikkeet.lueTied("Liikkeet");  // johon ladataan tiedot tiedostosta.
     *  liikkeet.lisaa(liike1);
     *  liikkeet.tallenna("Liikkeet");
     * </pre>
     */
    
    /**
     * lukee liikkeet tiedostosta
     * @param hakemisto tiedoston hakemisto
     * @throws SailoException jos tiedoston luku epäonnistuu
     */
    public void lueTied(String hakemisto) throws SailoException {
        String nimi = hakemisto + "/liikkeet.dat";
        File ftied = new File(nimi);
        
        try (Scanner fi = new Scanner(new FileInputStream(ftied))) {
            while (fi.hasNext()) {
                String s = "";
                s = fi.nextLine();
                Liike liike = new Liike();
                liike.parse(s);
                lisaa(liike);
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
        Liikkeet liikkeet = new Liikkeet();
        
        try {
            liikkeet.lueTied("Liikkeet");
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        
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
        try {
            liikkeet.tallenna("Liikkeet");
        } catch (SailoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        
    }

    @Override
    public Iterator<Liike> iterator() {
        return new LiikkeetIterator();
    }
    
    /**
     * palauttaa haettavat collectionina
     * @param hakuehto hakuehto
     * @return löydetyt
     */
    public Collection<Liike> etsi(String hakuehto) {
        List<Liike> loytyneet = new ArrayList<Liike>();
        for (Liike liike : this) {
            if (WildChars.onkoSamat(liike.getNimi(), hakuehto))
            loytyneet.add(liike);
        }
        Collections.sort(loytyneet, new Liike.Vertailija());
        return loytyneet;
    }
    /**
     * @author aksel
     * @version 23.4.2021
     * luokka liikkeiden iteroimiseksi
     */
    public class LiikkeetIterator implements Iterator<Liike> {
    private int kohdalla = 0;
        @Override
        public boolean hasNext() {
            return kohdalla < getLkm();
        }

        /**
        * Annetaan seuraava jäsen
        * @return seuraava jäsen
        * @throws NoSuchElementException jos seuraava alkiota ei enää ole
        * @see java.util.Iterator#next()
        */
       @Override
       public Liike next() throws NoSuchElementException {
           if ( !hasNext() ) throw new NoSuchElementException("Ei oo");
           return anna(kohdalla++);
       }

        
    }
    /**
     * poistaa valitun liikkeen
     * @param tunnusNro poistettavan liikkeen tunnusnro
     * @return 1 jos jotain poistettiin, 0 jos ei löydy
     */
    public int poista(int tunnusNro) {
        int ind = etsiId(tunnusNro);
        if (ind<0) return 0;
        lkm--;
        for (int i = ind;i<lkm;i++)
            alkiot[i] = alkiot[i+1];
        alkiot[lkm] = null;
        return 1;
    }
    
    /**
     * etsii liikkeen tunnusnumeron avulla
     * @param tunnusNro etsittävän liikkeen tunnusnro
     * @return liikkeen indeksi
     */
    public int etsiId(int tunnusNro) {
        for (int i = 0;i<lkm;i++) 
            if (tunnusNro == alkiot[i].getTunnusNro()) return i;
        return -1;
    }

    
}
