package fxShoppingList;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import shoppinglist.Tuote;

/**
 * Controlleri lähetysdialogille
 */
public class LahetysController implements ModalControllerInterface<Tuote>,Initializable{

    @FXML
    private ListChooser<Object> listChooserLaheta;

    @FXML
    private Label hintaLabel;

    @FXML
    private Label liikeLabel;

    @FXML
    void handleLaheta() {
        if ( !Dialogs.showQuestionDialog("Poisto", "Lähetetäänkö lista -> " + nimi, "Kyllä", "Ei") )
            return;
        Dialogs.showMessageDialog("Lista lähetetty!");
        ModalController.closeStage(liikeLabel);
    }

    @FXML
    void handlePeruuta() {
        tuote = null;
        ModalController.closeStage(liikeLabel);
    }
    
    private void haeTuote() {
        listChooserLaheta.clear();
        int index = 0;
        for (int i =0; i < lista.length; i++) {
            Object tuote1 = lista[i];
            listChooserLaheta.add(tuote1);    
        }
        listChooserLaheta.getSelectionModel().select(index);

    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        liikeLabel.setText(nimi);
        hintaLabel.setText(ohinta);
        haeTuote();
        
    }

    @Override
    public Tuote getResult() {
        return tuote;
    }

    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDefault(Tuote oletus) {
        tuote = oletus;
        
    }

    private Tuote tuote;
    private static String nimi;
    private static Object[] lista;
    private static String ohinta;
    /**
     * aukaistaan lähetysdialogi
     * @param modalityStage mille ollaan modaalisia
     * @param tuotelist tuotelista objecti arrayna
     * @param oletus oletettu tuote
     * @param liikeNimi liikkeen nimi, johon lähetetää
     * @param hinta ostosten hinta
     * @return null
     */
    public static Tuote laheta(Stage modalityStage, Tuote oletus, Object[] tuotelist, String liikeNimi, String hinta) {
        nimi = liikeNimi;
        lista = tuotelist;
        ohinta = hinta;
        return ModalController.showModal(OhjelmaController.class.getResource
                ("lahetys.fxml"), "ShoppingList", modalityStage, oletus, null);
    }

}
