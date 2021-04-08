package shoppinglist;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author aksel
 * @version 4.3.2021
 * Lukee ja kiroittaa liikkeet tiedostoon, osaa etsiä ja lajitella 
 */
public class Liikkeet {
    
    private static final int MAX_LIIKKEET = 10;
    private int lkm = 0;
    private Liike[] alkiot = new Liike[MAX_LIIKKEET];
    //private String tiedostonNimi = "";
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

    
}
