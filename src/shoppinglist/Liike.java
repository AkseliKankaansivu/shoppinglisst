package shoppinglist;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author aksel
 * @version 4.3.2021
<<<<<<< HEAD
 * Sisältää liikkeiden nimet ja ID numeron, tarkistaa syntaksin 
=======
 * Sisältää liikkeiden nimet ja ID numeron 
>>>>>>> tyo5
 * 
 */
public class Liike {
    private int tunnusNro;
    private String nimi = "";
    private static int seuraavaNro = 1;
    

    
    /**
     * tulostaa liikkeen tiedot
     * @param out tietovirta johon tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println("Nimi: " + nimi + ", Tunnusnumero: " + tunnusNro);
    }
    
    /**
     * tulostaa liikkeen tiedot
     * @param os tietovirta johon tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    /**
<<<<<<< HEAD
<<<<<<< HEAD
     * Hakee Citymarketin tiedot
     */
    public void taytaCitymarket() {
        this.nimi = "K-Citymarket";
    }
    
    /**
     * Hakee Prisman tiedot
     */
    public void taytaPrisma( ) {
        this.nimi = "Prisma";
    }
    
    /**
     * Hakee Salen tiedot
     */
    public void taytaSale() {
        this.nimi = "Sale";
    }
    /**
=======
=======
>>>>>>> tyo5
     * Hakee Liikkeen tiedot
     * @param liikenimi liikkeen nimi 
     */
    public void tayta(String liikenimi) {
        this.nimi = liikenimi;
    }
    
    /**
<<<<<<< HEAD
>>>>>>> tyo5
=======
>>>>>>> tyo5
     * @example
    * <pre name="test">
    * Liike sale = new Liike();
    * Liike tokmanni = new Liike();
    * sale.getTunnusNro() === 0;
    * sale.rekisteroi();
    * sale.getTunnusNro() === 1;
    * tokmanni.rekisteroi();
    * int n1 = sale.getTunnusNro();
    * int n2 = tokmanni.getTunnusNro();
    * n2-n1 === n1;
    * </pre>
     */
    
    /**
     * hakee liikkeen tunnusnumeron
     * @return palauttaa tunnusnumeron
     */
    public int rekisteroi() {
        this.tunnusNro = seuraavaNro;
        seuraavaNro ++;
        return this.tunnusNro;
    }
    
    /**
     * @return liikkeen tunnusnumeron
     */
    public int getTunnusNro() {
        return tunnusNro;
    }
    
    /**
     * @return liikkee nimi
     */
    public String getNimi() {
        return this.nimi;
    }
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Liike Citymarket = new Liike();
        Liike Prisma = new Liike();
        Liike Sale = new Liike();
        
        Citymarket.rekisteroi();
        Prisma.rekisteroi();
        Sale.rekisteroi();
        
<<<<<<< HEAD
<<<<<<< HEAD
        Citymarket.taytaCitymarket();
        Citymarket.tulosta(System.out);
        
        Prisma.taytaPrisma();
        Prisma.tulosta(System.out);
        
        Sale.taytaSale();
=======
=======
>>>>>>> tyo5
        Citymarket.tayta("Citymarket");
        Citymarket.tulosta(System.out);
        
        Prisma.tayta("Prisma");
        Prisma.tulosta(System.out);
        
        Sale.tayta("Sale");
<<<<<<< HEAD
>>>>>>> tyo5
=======
>>>>>>> tyo5
        Sale.tulosta(System.out);
        
    }
}
