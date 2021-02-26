package fxShoppingList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author aksel
 * @version 3.2.2021
 *
 */
public class ShoppingListMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("ShoppingListGUIView.fxml"));
            final Pane root = ldr.load();
            //final ShoppingListGUIController shoppinglistCtrl = (ShoppingListGUIController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("shoppinglist.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("ShoppingList");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei käytössä
     */
    public static void main(String[] args) {
        launch(args);
    }
}