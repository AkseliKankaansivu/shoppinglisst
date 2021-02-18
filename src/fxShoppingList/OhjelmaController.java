package fxShoppingList;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


/**
 * @author aksel
 * @version 17.2.2021
 *
 */
public class OhjelmaController implements ModalControllerInterface<String> {

    @FXML private TextField hakuehto;
    @FXML private ComboBox<String> cbKentat;
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
