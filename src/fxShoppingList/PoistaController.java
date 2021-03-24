package fxShoppingList;

import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import shoppinglist.Liike;

/**
 * Poistatuote-ominaisuuden controlleri
 * @author aksel
 * @version 24.3.2021
 *
 */
public class PoistaController implements ModalControllerInterface<String> {
    
    @FXML
    private ListChooser<Liike> listChooserPoista;
    
    @FXML
    void handlePeruuta() {
       ModalController.closeStage(listChooserPoista);
    }
    
    @FXML
    void handlePoista() {
            //
    }
    
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
//
}
