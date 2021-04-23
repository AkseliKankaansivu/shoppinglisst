package fxShoppingList;

import java.util.Collection;
import java.util.List;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fi.jyu.mit.fxgui.StringGrid;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shoppinglist.ShoppingList;
import shoppinglist.Tuote;
import shoppinglist.SailoException;
import shoppinglist.Liike;
/**
 * @author aksel
 * @version 17.2.2021
 *
 */
public class OhjelmaController implements ModalControllerInterface<String> {

    @FXML private TextField liikehakuehto;
    @FXML private ListChooser<Liike> chooserLiikkeet;
    @FXML private StringGrid<Tuote> stringGrid;
    /**
     * Päänäytön controllit
     */
    @FXML
    private void handleTallenna() {
        tallenna();
    }
    
    private void tallenna() {
        try {
            shoppinglist.tallenna();
        } catch (SailoException e) {
            System.err.println(e.getMessage());
        }
    }
    
    @FXML
    private void handleLaheta() {
        lahetaList();
    }

    @FXML 
    private void handleTulosta() {
        Dialogs.showMessageDialog("Ei osata vielä tulostaa");
    }
    
    @FXML
    private void handleLisaaTuote() {
        //ModalController.showModal(OhjelmaController.class.getResource("tuotteenlisays.fxml"), "Lisäys", null, "");
        uusiTuote();
    }
    
    @FXML
    private void handlePoistatuote() {
        poistaTuote();
    }
    
    @FXML
    private void handlePoistaLiike() {
        poistaLiike();
    }
    
    @FXML
    private void handeLisaaLiike() {
        uusiLiike();
       
    }
    @FXML
    private void handleTietoja() {
        Dialogs.showMessageDialog("Versio: 0.1 " +  " Tekijä: Akseli Kankaansivu");
    }
    
    @FXML
    private void handlePoistu() {
        tallenna();
        Platform.exit();
    }
    
    @FXML
    private Label labelVirhe;
    
    @FXML private void handleHakuEhto() {
        if ( liikeKohdalla != null )
            hae(liikeKohdalla.getTunnusNro()); 
     }
     
   //========================================================================================//
    
private ShoppingList shoppinglist;
private Liike liikeKohdalla;
    

    /**
     * Asetetaan käytettävä shoppinglist
     * @param shoppinglist jota käytetään
     */
    public void setShoppingList(ShoppingList shoppinglist) {
        this.shoppinglist = shoppinglist;
        try {
            shoppinglist.lueTiedostosta();
        } catch (SailoException e) {
            System.err.println("Ongelmia tiedoston lukemisessa");
        }
        haeLiike(0);
        liikeKohdalla = chooserLiikkeet.getSelectedObject();
        //alustaLiikkeet();
        naytaLista();
        chooserLiikkeet.addSelectionListener(e -> naytaLista());
        
        
        
    }
    
       /**
         * Hakee liikkeiden tiedot listaan
         * @param jnr jäsenen numero, joka aktivoidaan haun jälkeen
         */
        protected void hae(int jnr) {
            int jnro = jnr;
            if ( jnro == 0) {
                Liike kohdalla = liikeKohdalla;
                if (kohdalla  !=  null) jnro = kohdalla.getTunnusNro(); 
            }

            String ehto = liikehakuehto.getText(); 
            if(ehto.indexOf('*')<0) ehto = "*" + ehto + "*";
            chooserLiikkeet.clear();
    
            int index = 0;
            Collection<Liike> liikkeet;
            try {
                liikkeet = shoppinglist.etsi(ehto);
                int i = 0;
                for (Liike liike:liikkeet) {
                    if (liike.getTunnusNro() == jnro) index = i;
                    chooserLiikkeet.add(liike.getNimi(), liike);
                    i++;
                }
            } catch (SailoException ex) {
                naytaVirhe("Liikkeen hakemisessa ongelmia! " + ex.getMessage());
            }
            chooserLiikkeet.setSelectedIndex(index); // tästä tulee muutosviesti joka näyttää jäsenen
        }
        
        /**
         * Poistaa listchooserista valitun liikkeen
         */
        private void poistaLiike() {
            Liike liike = liikeKohdalla;
            if (liike == null) return;
            if ( !Dialogs.showQuestionDialog("Poisto", "Poistetaanko jäsen: " + liike.getNimi(), "Kyllä", "Ei") )
                return;
            shoppinglist.poistaLiike(liike);
            int index = chooserLiikkeet.getSelectedIndex();
            haeLiike(0);
            chooserLiikkeet.setSelectedIndex(index);
        }
        
        /**
         * Poistaa stringgridistä valitun tuotteen
         */
        private void poistaTuote() {
            Tuote tuote = stringGrid.getObject();
            if (tuote == null) return;
            if ( !Dialogs.showQuestionDialog("Poisto", "Poistetaanko tuote: " + tuote.getNimi(), "Kyllä", "Ei") )
                return;
            shoppinglist.poistaTuote(tuote);
            stringGrid.clear(); //tää
            nayta(shoppinglist.annaTuotteet(liikeKohdalla)); //ja tää  
        }
    
    /**
     * vaihtaa stringgrid listaa
     */
    private void naytaLista() {
        stringGrid.clear(); 
        liikeKohdalla = chooserLiikkeet.getSelectedObject();
        if (liikeKohdalla == null) return;
        nayta(shoppinglist.annaTuotteet(liikeKohdalla));
         
    }

   
    private void nayta(List<Tuote> annaTuotteet) {
        for (int i = 0;i<annaTuotteet.size();i++) {
        Tuote temp = annaTuotteet.get(i);
        stringGrid.add(temp,temp.getNimi(),temp.getMaara(),temp.getHinta(),temp.getTyyppi());
        }
        stringGrid.getSelectionModel().selectAll();
    }

    private void uusiTuote() {
        if (liikeKohdalla == null) return;
        Tuote tuote = new Tuote();
        tuote = LisaysController.kysyTuote(null, tuote);
        if (tuote == null) return;
        tuote.rekisteroi();
        tuote.tayta(liikeKohdalla.getTunnusNro());
        shoppinglist.lisaa(tuote);
        haeTuote(liikeKohdalla.getTunnusNro());
        stringGrid.clear(); //tää
        nayta(shoppinglist.annaTuotteet(liikeKohdalla)); //ja tää      
    }
    
    private void haeTuote(int jnro) {
        stringGrid.clear();
        int index = 0;
        for (int i =0; i < shoppinglist.getTuotteet(); i++) {
            Tuote tuote = shoppinglist.annaTuote(i);
            if (tuote.getTunnusNro() == jnro) index = i;
            stringGrid.add(tuote,tuote.getNimi(),tuote.getMaara(),tuote.getHinta(),tuote.getTyyppi());    
         
        }
        stringGrid.getSelectionModel().select(index);

    }
    
    private void uusiLiike() {
        Liike liike = new Liike();
        // ModalController.showModal(OhjelmaController.class.getResource("liikkeenlisays.fxml"), "Lisäys", null, "");
        liike = LiikkeenLisaysController.kysyLiike(null, liike);
        if (liike == null) return;
        // if (liike == null) return;
        // String nimi = liike.getNimi();
        liike.rekisteroi();
        //liike.tayta(nimi);
               
        try {
            shoppinglist.lisaa(liike);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia liikkeissä" + e.getMessage());
            return;
        }
        haeLiike(liike.getTunnusNro());
    }
    
    private void lahetaList() {
        List<Tuote> lista = shoppinglist.annaTuotteet(chooserLiikkeet.getSelectedObject());
        Object[] tuotelista = lista.toArray(); 
        Tuote tuote = new Tuote();
        String hinta = shoppinglist.tuotteetHinta();
        String liikeNimi = chooserLiikkeet.getSelectedObject().getNimi();
        tuote = LahetysController.laheta(null, tuote, tuotelista, liikeNimi, hinta);
        
    }
    
    /**
     *  alustaa liikkeet käyttöliittymään
     */
   /** public void alustaLiikkeet() {
        Liike Citymarket = new Liike();
        Citymarket.rekisteroi();
        Citymarket.tayta("K-Citymarket");
        
        Liike Sale = new Liike();
        Sale.rekisteroi();
        Sale.tayta("Sale");
        
        Liike Prisma = new Liike();
        Prisma.rekisteroi();
        Prisma.tayta("Prisma");
        
        Liike Lidl = new Liike();
        Lidl.rekisteroi();
        Lidl.tayta("Lidl");
        
        Liike Tokmanni = new Liike();
        Tokmanni.rekisteroi();
        Tokmanni.tayta("Tokmanni");
        
        Liike Kmarket = new Liike();
        Kmarket.rekisteroi();
        Kmarket.tayta("K-Market");
        
        Liike Smarket = new Liike();
        Smarket.rekisteroi();
        Smarket.tayta("S-Market");
        
        try {
            shoppinglist.lisaa(Citymarket);
            shoppinglist.lisaa(Sale);
            shoppinglist.lisaa(Prisma);
            shoppinglist.lisaa(Tokmanni);
            shoppinglist.lisaa(Lidl);
            shoppinglist.lisaa(Kmarket);
            shoppinglist.lisaa(Smarket);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia liikkeissä" + e.getMessage());
            return;
        }
        haeLiike(Citymarket.getTunnusNro());
    }
    */
    
    /**
     * hakee liikkeen ja lisää sen käyttöliittymään
     * @param jnro liikkeen tunnusnumero
     */
    protected void haeLiike(int jnro) {
        chooserLiikkeet.clear();
        
        int index = 0;
        for (int i =0; i < shoppinglist.getLiikkeet(); i++) {
            Liike liike = shoppinglist.annaLiike(i);
            if (liike.getTunnusNro() == jnro) index = i;
            chooserLiikkeet.add(liike.getNimi(), liike);
        }
        chooserLiikkeet.getSelectionModel().select(index);
    }
    
    private void naytaVirhe(String virhe) {
        if ( virhe == null || virhe.isEmpty() ) {
            labelVirhe.setText("");
            labelVirhe.getStyleClass().removeAll("virhe");
            return;
        }
        labelVirhe.setText(virhe);
        labelVirhe.getStyleClass().add("virhe");
    }
    
    @Override
    public String getResult() {
        // 
        return null;
    }

    @Override
    public void handleShown() {
        // 
        
    }

    @Override
    public void setDefault(String arg0) {
        // TODO Auto-generated method stub
        
    }

   
}
