package fxShoppingList;

import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Platform;
import javafx.fxml.FXML;

/**
 * @author aksel
 * @version 3.2.2021
 *
 */
public class ShoppingListGUIController {
    
   /**
    * Aloitusnäytön controllit
    */
    @FXML
    private void handlePoistu() {
        Platform.exit();
    }
    
    @FXML
    private void handleOk() {
        ModalController.showModal(ShoppingListGUIController.class.getResource("ohjelma.fxml"), "ShoppingList", null, "");

    }
    
    //====================================================================================//
    
    
    
    
    

    
     
}