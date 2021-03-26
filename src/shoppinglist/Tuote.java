/**
 * 
 */
package shoppinglist;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author aksel
 * @version 4.3.2021
 *
 */
public class Tuote {
    private int liikeID;
    private int tunnusNro;
    private String nimi = "";
    private String tyyppi = "";
    private String maara = "";
    private double hinta = 0.0;
    private String shinta = "";
    private static int seuraavaNro = 1;

    
    /**
     * @return tuottee tunnusnumeron
     */
    public int getTunnusNro() {
        return tunnusNro;
    }
    
    /**
     * @return palauttaa liikkeen johon tuote kuuluu
     */
    public int getLiikeID() {
        return liikeID;
    }
    
    
    /**
     * @return palauttaan tuotteen hinnan
     */
    public String getHinta() {
        return shinta;
    }
    
    /**
     * @return palauttaa tuotteen määrän
     */
    public String getMaara() {
        return maara;
    }
    
    /**
     * @return tuotteen tyyppi
     */
    public String getTyyppi() {
        return this.tyyppi;
    }
    
    /**
     * @return tuotteen nimen
     */
    public String getNimi() {
        return this.nimi;
    }
    
    /**
     * rekisteroi tuotteelle tunnusnumeron
     * @return tuotteen tunnusnumero
     */
    public int rekisteroi() {
        this.tunnusNro = seuraavaNro;
        seuraavaNro++;
        return this.tunnusNro;
    }
    
    /**
     * antaa tuotteelle tiedot
     */
    public void tayta() {
        this.nimi = "Tuote" + " " +  this.tunnusNro;
        this.tyyppi = "Testityyppi" + " " + this.tunnusNro;
        this.maara = "Testimäärä";
        this.hinta = 0.0;
        this.shinta = hinta + "€";
    }
    /**
     * @param args ei käytössä
     * Vastuualueet:
     * tietää tuotteen tiedot(ID, nimi, tyyppi), tarkistaa tuotteiden syntaksin ja
     * osaa muuttaa käyttäjän syöttämät merkkijonot tuotteen tiedoiksi
     */
    
    public static void main(String[] args) {
       Tuote tuote1 = new Tuote();
       Tuote tuote2 = new Tuote();
       
       tuote1.rekisteroi();
       //tuote1.tayta();
       tuote1.tulosta(System.out);
    
       tuote2.rekisteroi();
       //tuote2.tayta();
       tuote2.tulosta(System.out);
    }

    /**
     * tulostaa tuotteen tiedot
     * @param os tulostuksen tietovirta
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    /**
     * tulostetaan tuotteen tiedot
     * @param out käytetty tietovirta
     */
    public void tulosta(PrintStream out) {
        out.println("Nimi: " + nimi + ", Tyyppi: " + tyyppi + ",  Tunnusnumero: " + tunnusNro);
    }


    /**
     * @param liikenro liike, johon tuote on lisätty
     */
    public void vieTiedot(int liikenro) {
        this.liikeID = liikenro;
        
    }

}
