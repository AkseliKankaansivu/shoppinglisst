package fxShoppingList;

import fi.jyu.mit.fxgui.ModalController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import shoppinglist.ShoppingList;

/**
 * @author aksel
 * @version 3.2.2021
 *
 */
public class ShoppingListGUIController {
    
   /**
    * Aloitus näytön controllit
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
    private ShoppingList shoppinglist;

    /**
     * Asetetaan käytettävä shoppinglist
     * @param shoppinglist jota käytetään
     */
    public void setShoppingList(ShoppingList shoppinglist) {
        this.shoppinglist = shoppinglist;
        
    }
    
    
    

    
     
}