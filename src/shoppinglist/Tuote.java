/**
 * 
 */
package shoppinglist;

import java.io.OutputStream;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;

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
     * @param liikenro liikkeen johon tuote lisätään tunnusnro
     */
    public void tayta(int liikenro) {
        this.nimi = "Tuote" + " " +  this.tunnusNro;
        this.tyyppi = "Testityyppi";
        this.maara = "Testimäärä";
        this.hinta = 0.0;
        this.shinta = hinta + "€";
        this.liikeID = liikenro;
    }
    
    @Override
    public String toString() {
        return          this.tunnusNro + "|" +
                        this.liikeID + "|" +
                        this.nimi + "|" +
                        this.tyyppi + "|" +
                        this.maara + "|" +
                        this.hinta + "|" + "\r\n";                      
    }
    /**
     * selvittää liikkeen tiedot, pitää huolen, että seuraavaNro on suurempi kuin tuleva tunnusNro
     * @param rivi rivi mistä luetaan
     */
    public void parse(String rivi) {
        StringBuilder sb = new StringBuilder(rivi);
        setTunnusNro(Mjonot.erota(sb,'|',tunnusNro));
        liikeID = Mjonot.erota(sb, '|', liikeID);
        nimi = Mjonot.erota(sb,'|',nimi); 
        tyyppi = Mjonot.erota(sb,'|',tyyppi);
        maara = Mjonot.erota(sb,'|',maara);
        hinta = Mjonot.erota(sb,'|',hinta);   
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
     * Vastuualueet:
     * tietää tuotteen tiedot(ID, nimi, tyyppi), tarkistaa tuotteiden syntaksin ja
     * osaa muuttaa käyttäjän syöttämät merkkijonot tuotteen tiedoiksi
     */
    
    public static void main(String[] args) {
       Tuote tuote1 = new Tuote();
       Tuote tuote2 = new Tuote();
       
       tuote1.rekisteroi();
       tuote1.tayta(1);
       tuote1.tulosta(System.out);
    
       tuote2.rekisteroi();
       tuote2.tayta(2);
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
        out.println(nimi + " " + tyyppi + " " + maara + " " + tunnusNro);
    }

    
    /**
     * tekee pyydetystä tuotteesta roskan
     */
    public void poistaTuote() {
        //this.nimi = null;
    }



}
