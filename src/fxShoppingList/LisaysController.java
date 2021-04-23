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
import shoppinglist.Tuote;

/**
 * tuotteen lisäämisen controlleri
 * @author aksel
 * @version 18.2.2021
 *
 */
public class LisaysController implements ModalControllerInterface<Tuote>,Initializable {

    
    @FXML
    private void handleOK() {
        uusiTuote.setNimi(tuoteNimi.getText());
        uusiTuote.setMaara(tuoteMaara.getText());
        uusiTuote.setTyyppi(tuoteTyyppi.getText());
        uusiTuote.setHinta(tuoteHinta.getText());
        if ( uusiTuote != null && uusiTuote.getNimi().trim().equals("") ) {
            naytaVirhe("Nimi ei voi olla tyhjä!");
            tuoteNimi.getStyleClass().add("virhe");
            return;
        }
        if (uusiTuote != null && uusiTuote.getMaara().trim().equals("") ) {
            naytaVirhe("Määrä ei voi olla tyhjä!");
            tuoteMaara.getStyleClass().add("virhe");
            return; 
        }
        if (uusiTuote != null && uusiTuote.getHinta().trim().equals("") ) {
            naytaVirhe("Hinta ei voi olla tyhjä!");
            tuoteHinta.getStyleClass().add("virhe");
            return; 
        }
        if (!uusiTuote.getHinta().trim().equals("0123456789")) {
            naytaVirhe("Hinnan pitää olla numero");
            tuoteHinta.getStyleClass().add("virhe");
            return;
        }
        if (uusiTuote != null && uusiTuote.getTyyppi().trim().equals("") ) {
            naytaVirhe("Tyyppi ei voi olla tyhjä!");
            tuoteTyyppi.getStyleClass().add("virhe");
            return; 
        }
        ModalController.closeStage(labelVirhe);
    }
    
   
    @FXML
    private void handlePeruuta() {
        uusiTuote = null;
        ModalController.closeStage(labelVirhe);
    }
    
    @FXML
    private Label labelVirhe;
   
    @FXML
    private TextField tuoteNimi;

    @FXML
    private TextField tuoteMaara;

    @FXML
    private TextField tuoteHinta;

    @FXML
    private TextField tuoteTyyppi;

    //======================================================================================//
    
    private Tuote uusiTuote;
    

    @Override
    public Tuote getResult() {
        return uusiTuote;
    }

    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDefault(Tuote oletus) {
        uusiTuote = oletus;
        
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
    }

    /**
     * Luodaan liikkeen luomisdialogi ja palautetaan uusi tuote tai null
     * @param modalityStage mille ollaan modaalisia
     * @param oletus mitä dataan näytetään oletuksena
     * @return null jos painetaan cancel, muuten tietue
     */
    public static Tuote kysyTuote(Stage modalityStage, Tuote oletus) {
        return ModalController.showModal(OhjelmaController.class.getResource
                ("tuotteenlisays.fxml"), "ShoppingList", modalityStage, oletus, null);
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

}
