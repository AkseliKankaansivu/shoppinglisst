package fxShoppingList;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import shoppinglist.ShoppingList;
import shoppinglist.SailoException;
import shoppinglist.Liike;
/**
 * @author aksel
 * @version 17.2.2021
 *
 */
public class OhjelmaController implements ModalControllerInterface<String> {

    @FXML private TextField hakuehto;
    @FXML private ComboBox<String> cbKentat;
    @FXML private ListChooser<Liike> chooserLiikkeet;
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
        ModalController.showModal(OhjelmaController.class.getResource("tuotteenlisays.fxml"), "Lisäys", null, "");
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
    
    /**
     *  alustaa liikkeet käyttöliittymään
     */
    public void alustaLiikkeet() {
        Liike Citymarket = new Liike();
        Citymarket.rekisteroi();
        Citymarket.taytaCitymarket();
        
        Liike Sale = new Liike();
        Sale.rekisteroi();
        Sale.taytaSale();
        
        Liike Prisma = new Liike();
        Prisma.rekisteroi();
        Prisma.taytaPrisma();
        
        try {
            shoppinglist.lisaa(Citymarket);
            shoppinglist.lisaa(Sale);
            shoppinglist.lisaa(Prisma);
        } catch (SailoException e) {
            // TODO Auto-generated catch block
            Dialogs.showMessageDialog("Ongelmia liikkeissä" + e.getMessage());
            return;
        }
        hae(Citymarket.getTunnusNro());
    }
    
    /**
     * hakee liikkeen ja lisää sen käyttöliittymään
     * @param jnro liikkeen tunnusnumero
     */
    protected void hae(int jnro) {
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

    public void avaaAlku() {
        ModalController.showModal(OhjelmaController.class.getResource("ShoppingListGUIView.fxml"), "Alku", null, "");    
    }
   
}
