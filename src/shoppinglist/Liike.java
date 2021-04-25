package shoppinglist;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Comparator;

import fi.jyu.mit.ohj2.Mjonot;

/**
 * @author aksel
 * @version 4.3.2021
 * Sisältää liikkeiden nimet ja ID numeron 
 * 
 */
public class Liike {
    private int tunnusNro;
    private String nimi = "";
    private static int seuraavaNro = 1;
    
    /**
     * Liikkeiden vertailija luokka aakkosjärjestykseen
     * @author aksel
     * @version 23.4.2021
     *
     */
    public static class Vertailija implements Comparator<Liike>, Cloneable {

        @Override
        public int compare(Liike liike1, Liike liike2) {
            return liike1.nimi.compareTo(liike2.nimi);
        }
        
    }
    
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
     * Hakee Liikkeen tiedot
     * @param liikenimi liikkeen nimi 
     */
    public void tayta(String liikenimi) {
        this.nimi = liikenimi;
    }
    
    /**
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
    
    @Override
    public String toString() {
        return  this.tunnusNro + "|" + this.nimi + "|" + "\r\n";
    }
    
    /**
     * selvittää liikkeen tiedot, pitää huolen, että seuraavaNro on suurempi kuin tuleva tunnusNro
     * @param rivi rivi
     */
    public void parse(String rivi) {
       StringBuilder sb = new StringBuilder(rivi);
       setTunnusNro(Mjonot.erota(sb,'|',tunnusNro));
       nimi = Mjonot.erota(sb,'|',nimi); 
    }
    
    /**
     * asettaa tunnusnumeron ja samalla varmistaa, että 
     * seuraava numero on aina suurempi
     * @param nr asetettava tunnusnro
     */
    public void setTunnusNro(int nr) {
        tunnusNro = nr;
        if (tunnusNro >= seuraavaNro) seuraavaNro = tunnusNro + 1;
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
        
        Citymarket.tayta("Citymarket");
        Citymarket.tulosta(System.out);
        
        Prisma.tayta("Prisma");
        Prisma.tulosta(System.out);
        
        Sale.tayta("Sale");
        Sale.tulosta(System.out);
        
    }

    /**
     * setteri liikkeen nimelle
     * @param nimi liikkeen nimi
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    /**
    @Override
    public Liike clone() throws CloneNotSupportedException {
        Liike uusi;
        uusi = (Liike) super.clone();
        return uusi;
    }
    */
}
