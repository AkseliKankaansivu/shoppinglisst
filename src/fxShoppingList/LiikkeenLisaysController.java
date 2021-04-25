package fxShoppingList;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shoppinglist.Liike;

/**
 * tuotteen lisäämisen controlleri
 * @author aksel
 * @version 18.2.2021
 *
 */
public class LiikkeenLisaysController implements ModalControllerInterface<Liike>,Initializable {

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Liike getResult() {
        return uusiLiike;
    }

    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDefault(Liike oletus) {
        uusiLiike = oletus;
        naytaLiike(uusiLiike);
    }
    
    @FXML private Label labelVirhe;
    @FXML private TextField liikeNimi;
   
    @FXML private void handleOK() {
        uusiLiike.setNimi(liikeNimi.getText());
        if ( uusiLiike != null && uusiLiike.getNimi().trim().equals("") ) {
            naytaVirhe("Nimi tyhjä!");
            liikeNimi.getStyleClass().add("virhe");
            return;
        }
        ModalController.closeStage(labelVirhe);
    }
    

    @FXML private void handleCancel() {
        uusiLiike = null;
        ModalController.closeStage(labelVirhe);
    }
    
    private Liike uusiLiike;
    /**
     * Luodaan liikkeen luomisdialogi ja palautetaan uusi liike tai null
     * @param modalityStage mille ollaan modaalisia
     * @param oletus mitä dataan näytetään oletuksena
     * @return null jos painetaan cancel, muuten tietue
     */
    public static Liike kysyLiike(Stage modalityStage, Liike oletus) {
        return ModalController.showModal(OhjelmaController.class.getResource
                ("liikkeenlisays.fxml"), "ShoppingList", modalityStage, oletus, null);
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

 
    private void naytaLiike(Liike liike) {
        if (liike == null) return;
        liikeNimi.setText(liike.getNimi());
    }
    

}
