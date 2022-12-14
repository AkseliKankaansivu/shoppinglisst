package fxShoppingList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import shoppinglist.ShoppingList;


/**
 * @author aksel
 * @version 3.2.2021
 *
 */
public class ShoppingListMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("ohjelma.fxml"));
            final Pane root = ldr.load();
            final OhjelmaController shoppinglistCtrl = (OhjelmaController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("shoppinglist.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("ShoppingList");
            
            ShoppingList shoppinglist = new ShoppingList();
            shoppinglistCtrl.setShoppingList(shoppinglist);
            
            primaryStage.show();
           
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param args Ei k�yt�ss�
     */
    public static void main(String[] args) {
        launch(args);
    }
}