package shoppinglist;


import java.util.Collection;
import java.util.List;

/**
 * @author aksel
 * @version 4.3.2021
 * lukee ja kirjoittaa ShoppingListin tiedostoon avustajien tiedoilla
 */
public class ShoppingList {
    private Liikkeet liikkeet = new Liikkeet();
    private Tuotteet tuotteet = new Tuotteet();
    
   
    /**
    * Testien alustus
    * @example
    * <pre name="testJAVA">
    * #import shoppinglist.SailoException;
    *  private ShoppingList shoppinglist;
    *  private Liike citymarket;
    *  private Liike prisma;
    *  private int lid1;
    *  private int lid2;
    *  private Tuote oivariini;
    *  private Tuote patonki;
    *  private Tuote korppu; 
    *  private Tuote maito; 
    *  private Tuote lapio;
    *  
    *  
    *  public void alustaShoppingList() {
    *    shoppinglist = new ShoppingList();
    *    citymarket = new Liike(); citymarket.tayta("Citymarket"); citymarket.rekisteroi();
    *    prisma = new Liike(); prisma.tayta("Prisma"); prisma.rekisteroi();
    *    lid1 = citymarket.getTunnusNro();
    *    lid2 = prisma.getTunnusNro();
    *    oivariini = new Tuote(); oivariini.tayta(lid2);
    *    patonki = new Tuote(); patonki.tayta(lid1);
    *    korppu = new Tuote(); korppu.tayta(lid2); 
    *    maito = new Tuote(); maito.tayta(lid1); 
    *    lapio = new Tuote(); lapio.tayta(lid2);
    *    try {
    *    shoppinglist.lisaa(citymarket);
    *    shoppinglist.lisaa(prisma);
    *    shoppinglist.lisaa(oivariini);
    *    shoppinglist.lisaa(patonki);
    *    shoppinglist.lisaa(korppu);
    *    shoppinglist.lisaa(maito);
    *    shoppinglist.lisaa(lapio);
    *    } catch ( Exception e) {
    *       System.err.println(e.getMessage());
    *    }
    *  }
    * </pre>
   */
    
    
    /**
     * lukee tuotteet ja liikkeet tiedostosta jos on jo valmiiksi
     * @throws SailoException jos tiedostoja luetessa tulee virhe
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
     
    public void lueTiedostosta() throws SailoException {
        liikkeet = new Liikkeet();
        tuotteet = new Tuotteet();
        
        liikkeet.lueTied("Liikkeet");
        tuotteet.lueTied("Tuotteet");
    }
    
    /**
     * Tallennetaan shoppinglistin tiedot tiedostoon
     * @throws SailoException jos ongelmia tallentamisessa
     */
    public void tallenna() throws SailoException {
        String virhe = "";
        try {
            liikkeet.tallenna("Liikkeet");
        } catch (SailoException e) {
            virhe += e.getMessage();
        }
        
        try {
            tuotteet.tallenna("Tuotteet");
        } catch (SailoException e) {
            virhe += e.getMessage();
        }
        
        if (!"".equals(virhe)) throw new SailoException(virhe);
    }
    
    
    /**
      * Lisää kerhoon uuden liikkeen
      * @param liike lisättävä jäsen
      * @throws SailoException jos lisäystä ei voida tehdä
      * @example
      * <pre name="test">
      * #THROWS SailoException  
      *  alustaShoppingList();
      *  shoppinglist.etsi("*").size() === 2;
      *  shoppinglist.lisaa(citymarket);
      *  shoppinglist.etsi("*").size() === 3;
      */
    public void lisaa(Liike liike) throws SailoException {
        liikkeet.lisaa(liike);
    }
    
    /**
     * lisää uusi tuote
     * @param tuote lisättävä tuote
     */
    
    public void lisaa(Tuote tuote) {
        tuotteet.lisaa(tuote);
    }
    
    
    /**
     * @return shoppinglistin liikkeiden lukumäärä
     */
    public int getLiikkeet() {
        return this.liikkeet.getLkm();
    }
    
    /**
     * @param i indeksi josta haetaan
     * @return liikkeen viite i:n kohdassa
     */
    public Liike annaLiike(int i) {
        return this.liikkeet.anna(i);
    }
    
    
    /**
    * Haetaan kaikki liikkeen tuotteet
    * @param liike liike jonka tuotteet haetaan
    * @return tietorakenne jossa viiteet löydetteyihin harrastuksiin
    * @example
    * <pre name="test">
    * #import java.util.*;
    *  alustaShoppingList();
    *  Liike tokmanni = new Liike();
    *  tokmanni.rekisteroi();
    *  try {
    *    shoppinglist.lisaa(tokmanni);
    *} catch (SailoException e) {
    *   // TODO Auto-generated catch block
    *   e.printStackTrace();
    *}
    *  List<Tuote> loytyneet;
    *  loytyneet = shoppinglist.annaTuotteet(tokmanni);
    *  loytyneet.size() === 0; 
    *  loytyneet = shoppinglist.annaTuotteet(citymarket);
    *  loytyneet.size() === 2; 
    *  loytyneet.get(0) == patonki === true;
    *  loytyneet.get(1) == maito === true;
    *  loytyneet = shoppinglist.annaTuotteet(prisma);
    *  loytyneet.size() === 3; 
    *  loytyneet.get(0) == oivariini === true;
    * </pre> 
    */
    public List<Tuote> annaTuotteet(Liike liike) {
        return tuotteet.annaTuotteet(liike.getTunnusNro());
    }
    
    /**
     * @return palauttaa tuotteiden lukumäärän
     */
    public int getTuotteet() {
        return this.tuotteet.getLkm();
    }
    
    /**
     * @param i indeksi, josta tuote haetaan
     * @return tuotteen haetusta indeksistä
     */
    public Tuote annaTuote(int i) {
        return this.tuotteet.anna(i);
    }
    
    /** 
     * Palauttaa "taulukossa" hakuehtoon vastaavien liikkeiden viitteet 
     * @param hakuehto hakuehto   
     * @return tietorakenteen löytyneistä jäsenistä 
     * @throws SailoException Jos jotakin menee väärin
     * @example 
     * <pre name="test">
     *   #THROWS CloneNotSupportedException, SailoException
     *   alustaShoppingList();
     *   Liike liike3 = new Liike(); liike3.rekisteroi();
     *   shoppinglist.lisaa(liike3);
     *   Collection<Liike> loytyneet = shoppinglist.etsi("*citymarket*");
     *   loytyneet.size() === 1;
     * </pre>
     */ 
    public Collection<Liike> etsi(String hakuehto) throws SailoException { 
        return liikkeet.etsi(hakuehto);
    }
    
    /**
     * @param args ei käytössä
     * @throws SailoException jos vihreitä
     */
    public static void main(String[] args) throws SailoException {
        ShoppingList shoppinglist = new ShoppingList();
        
        shoppinglist.lueTiedostosta();
        // muodostetaan liikkeet
        Liike Citymarket = new Liike();
        Liike Prisma = new Liike();
        
        Citymarket.rekisteroi();
        Citymarket.tayta("Citymarket");
        
        Prisma.rekisteroi();
        Prisma.tayta("Prisma");
        
        
        try {
            shoppinglist.lisaa(Citymarket);
            shoppinglist.lisaa(Prisma);
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
        
        for (int i=0;i<shoppinglist.getLiikkeet();i++) {
            Liike liike = shoppinglist.annaLiike(i);
            System.out.println("Liike indeksissä " + i);
            liike.tulosta(System.out);
        }
        
        // muodostetaan tuotteet
        Tuote tuote1 = new Tuote();
        tuote1.rekisteroi();
        tuote1.tayta(2);
        
        
    }

    /**
  * Poistaa liikkeistä ja tuotteista tiedot 
  * @param liike liike jokapoistetaan
  * @return montako liikettä poistettiin
  * @example
  * <pre name="test">
  * #THROWS Exception
  *   alustaShoppingList();
  *   shoppinglist.etsi("*").size() === 2;
  *   shoppinglist.annaTuotteet(citymarket).size() === 2;
  *   shoppinglist.poistaLiike(citymarket) === 1;
  *   shoppinglist.etsi("*").size() === 1;
  *   shoppinglist.annaTuotteet(citymarket).size() === 0;
  * </pre>
  */
    public int poistaLiike(Liike liike) {
        if (liike == null) return 0;
        int ret = liikkeet.poista(liike.getTunnusNro());
        tuotteet.poistaLiikkeenTuotteet(liike.getTunnusNro());
        return ret;
    }

    /** 
    * Poistaa valitun tuotteen 
    * @param tuote poistettava tuote 
    * @example
    * <pre name="test">
    * #THROWS Exception
    *   alustaShoppingList();
    *   shoppinglist.annaTuotteet(citymarket).size() === 2;
    *   shoppinglist.poistaTuote(patonki);
    *   shoppinglist.annaTuotteet(citymarket).size() === 1;
    */ 
    public void poistaTuote(Tuote tuote) {
        if (tuote == null) return;
        tuotteet.poista(tuote);
    }

    /**
     * @param liike jonka tuotteiden hinta haaetaan
     * @return tuotteiden hinnat
     */
    public String tuotteetHinta(Liike liike) {
        int id = liike.getTunnusNro();
        if (tuotteet.getLkm() == 0) return "";
        return tuotteet.getHinnat(id);
    }

    /** 
     * Korvaa liikkeen tietorakenteessa. Etsitään saman tunnusnumeron liike.
     * Jos ei löydy liikettä, lisätään se uutena 
     * @param liike lisätäävän jäsenen viite.  Huom tietorakenne muuttuu omistajaksi 
     * @throws SailoException jos tietorakenne on jo täynnä 
     * @example
     * <pre name="test">
     * #THROWS SailoException  
     *  alustaShoppingList();
     *  shoppinglist.etsi("*").size() === 2;
     *  shoppinglist.korvaaTaiLisaa(citymarket);
     *  shoppinglist.etsi("*").size() === 2;
     * </pre>
     */ 
    public void korvaaTaiLisaa(Liike liike) throws SailoException {
        liikkeet.korvaaTaiLisaa(liike);     
    }
}
