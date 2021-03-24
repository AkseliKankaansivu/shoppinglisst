package fxShoppingList;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fi.jyu.mit.fxgui.StringGrid;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import shoppinglist.ShoppingList;
import shoppinglist.Tuote;
import shoppinglist.SailoException;
import shoppinglist.Liike;
import shoppinglist.Ostos;
/**
 * @author aksel
 * @version 17.2.2021
 *
 */
public class OhjelmaController implements ModalControllerInterface<String> {

    @FXML private TextField hakuehto;
    @FXML private ComboBox<String> cbKentat;
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
        Dialogs.showMessageDialog("Tallennettaan, ei toimi vielä");
    }
    
    @FXML
    private void handleLaheta() {
        Dialogs.showMessageDialog("Ei osata lähettää vielä!");
    }

    @FXML 
    private void handleTulosta() {
        Dialogs.showMessageDialog("Ei osata vielä tulostaa");
    }
    
    @FXML
    private void handleLisaaTuote() {
        //ModalController.showModal(OhjelmaController.class.getResource("tuotteenlisays.fxml"), "Lisäys", null, "");
        uusiOstos();
    }
    
    @FXML
    private void handlePoistatuote() {
        ModalController.showModal(OhjelmaController.class.getResource("poistatuote.fxml"), "Poista", null, "");
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
    private void handleOK() {
        //
    }
    /**
    @FXML private void handleHakuehto() {
        String hakukentta = cbKentat.getSelectionModel().getSelectedItem();
        String ehto = hakuehto.getText(); 
        if ( ehto.isEmpty() )
            naytaVirhe(null);
        else
            naytaVirhe("Ei osata vielä hakea " + hakukentta + ": " + ehto);
     }
     **/
   //========================================================================================//
    
private ShoppingList shoppinglist;
    
    /**
     * Asetetaan käytettävä shoppinglist
     * @param shoppinglist jota käytetään
     */
    public void setShoppingList(ShoppingList shoppinglist) {
        this.shoppinglist = shoppinglist;
        alustaLiikkeet();
        
    }
    
    private void uusiOstos() {
        Ostos ostos = new Ostos();
        ostos.rekisteroi();
        ostos.tayta();
        Tuote tuote = new Tuote();
        tuote.rekisteroi();
        tuote.tayta();
        ostos.vieTiedot(tuote);
        try {
            shoppinglist.lisaa(tuote);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia liikkeissä" + e.getMessage());
            return;
        }
        haeTuote(tuote.getTunnusNro());
    }
    
    /**
     * hakee tuotteen ja liittää sen käyttöliittymään
     * @param jnro haettavan tuotteen indeksi
     */
    protected void haeTuote(int jnro) {
        stringGrid.clear();
        int index = 0;
        for (int i =0; i < shoppinglist.getTuotteet(); i++) {
            Tuote tuote = shoppinglist.annaTuote(i);
            if (tuote.getTunnusNro() == jnro) index = i;
            stringGrid.add(tuote.getNimi(),tuote.getMaara(),tuote.getHinta(),tuote.getTyyppi());    
            
        }
        stringGrid.getSelectionModel().select(index);
    }
    /**
     *  alustaa liikkeet käyttöliittymään
     */
    public void alustaLiikkeet() {
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
