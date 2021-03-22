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
    private int tunnusNro;
    private String nimi = "";
    private String tyyppi = "";
    private static int seuraavaNro = 1;

    
    /**
     * @return tuottee tunnusnumeron
     */
    public int getTunnusNro() {
        return tunnusNro;
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
       tuote1.tayta();
       tuote1.tulosta(System.out);
    
       tuote2.rekisteroi();
       tuote2.tayta();
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

}
