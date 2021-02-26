package fxShoppingList;

import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;

/**
 * tuotteen lisäämisen controlleri
 * @author aksel
 * @version 18.2.2021
 *
 */
public class LisaysController implements ModalControllerInterface<String> {

    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void handleShown() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDefault(String arg0) {
        // TODO Auto-generated method stub
        
    }
    
    @FXML
    private void handleOK() {
        ModalController.showModal(OhjelmaController.class.getResource("Virheellinensyotto.fxml"), "Lisäys", null, "");
    }

}
