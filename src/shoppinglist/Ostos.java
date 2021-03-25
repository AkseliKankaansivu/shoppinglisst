package shoppinglist;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Tietää ostoksen tiedot, osaa muuttaa käyttäjän syöttämät merkkijonot, tarkistaa ostoksen syntaksin, tietää liikkeen ID:n,
 * tietää tuotteen ID:n
 * EI KÄYTETÄ   
 * @author aksel
 * @version 22.3.2021
 *
 */
public class Ostos {
    private int tuoteID;
    private int liikeID;
    private double hinta = 0.0;
    private String maara = "";
    private String phinta = "";
    private int tunnusNro;
    private int seuraavaNro = 1;
    
    /**
     * rekisteröi ostokselle tunnusnumeron
     * @return ostoksen tunnusnumero
     */
    public int rekisteroi() {
        this.tunnusNro = seuraavaNro;
        seuraavaNro ++;
        return this.tunnusNro;
    }
    /**
     * täyttää ostoksen tiedot
     */
    public void tayta() {
        this.hinta = 0.0;
        this.maara = "testimäärä";
        this.phinta = hinta + " €";
    }
    
    /**
     * @return liikkeen ID:n
     */
    public int getLiikeID() {
        return this.liikeID;
    }
    
    /**
     * @return tuotteen ID:n
     */
    public int getTuoteID() {
        return this.tuoteID;
    }
    
    /**
     * @param out tietovirta mihin tulostetaan
     */
    public void tulosta(PrintStream out) {
        out.println("Hinta: " + phinta + ", Tunnusnumero: " + tunnusNro + " Määrä: " + maara);
    }
    
    /**
     * @param os tietovirta mihin tulostetaan
     */
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        Ostos ostos1 = new Ostos();
        ostos1.rekisteroi();
        ostos1.tayta();
        ostos1.tulosta(System.out);
    }
    /**
     * tuo ostokselle tiedot tuotteesta
     * @param tuote lisättävä tuote
     */
    public void vieTiedot(Tuote tuote) {
        this.tuoteID = tuote.getTunnusNro();
        
    }
    /**
     * @return  ostoksen tunnusnumeron
     */
    public int getTunnusNro() {
        return this.tunnusNro;
    }
    
    

}
