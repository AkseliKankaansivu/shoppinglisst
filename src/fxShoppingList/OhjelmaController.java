package fxShoppingList;

import java.util.List;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
<<<<<<< HEAD
<<<<<<< HEAD
import fi.jyu.mit.fxgui.ModalController;
=======
>>>>>>> tyo5
=======
>>>>>>> tyo5
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fi.jyu.mit.fxgui.StringGrid;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import shoppinglist.ShoppingList;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import shoppinglist.Tuote;
>>>>>>> tyo5
=======
import shoppinglist.Tuote;
>>>>>>> tyo5
import shoppinglist.SailoException;
import shoppinglist.Liike;
/**
 * @author aksel
 * @version 17.2.2021
 *
 */
public class OhjelmaController implements ModalControllerInterface<String> {

    @FXML private TextField hakuehto;
    @FXML private ComboBox<String> cbKentat;
    @FXML private ListChooser<Liike> chooserLiikkeet;
<<<<<<< HEAD
<<<<<<< HEAD
=======
    @FXML private StringGrid<Tuote> stringGrid;
>>>>>>> tyo5
=======
    @FXML private StringGrid<Tuote> stringGrid;
>>>>>>> tyo5
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
        //ModalController.showModal(OhjelmaController.class.getResource("tuotteenlisays.fxml"), "Lisäys", null, "");
        uusiTuote();
    }
    
    @FXML
    private void handlePoistatuote() {
        //ModalController.showModal(OhjelmaController.class.getResource("poistatuote.fxml"), "Poista", null, "");
<<<<<<< HEAD
       stringGrid.getObject();
=======
       stringGrid.getObject().poistaTuote();
       
       
>>>>>>> tyo5
    }
    
    @FXML
    private void handeLisaaLiike() {
        uusiLiike();
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
        //
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
   //========================================================================================//
    
private ShoppingList shoppinglist;
<<<<<<< HEAD
=======
private Liike liikeKohdalla;
>>>>>>> tyo5
    
    /**
     * Asetetaan käytettävä shoppinglist
     * @param shoppinglist jota käytetään
     */
    public void setShoppingList(ShoppingList shoppinglist) {
        this.shoppinglist = shoppinglist;
<<<<<<< HEAD
        alustaLiikkeet();
        
    }
    
<<<<<<< HEAD
=======
    private void uusiTuote() {
        Tuote tuote = new Tuote();
        tuote.rekisteroi();
        tuote.tayta();
        Liike temp = chooserLiikkeet.getSelectedObject();
        tuote.vieTiedot(temp.getTunnusNro());
        
        try {
            shoppinglist.lisaa(tuote);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia liikkeissä" + e.getMessage());
            return;
        }
        haeTuote(tuote.getTunnusNro());
    }
    
    /**
     * hakee tuotteen ja liittää sen käyttöliittymään
     * @param jnro haettavan tuotteen indeksi
     */
    protected void haeTuote(int jnro) {
=======
        liikeKohdalla = chooserLiikkeet.getSelectedObject();
        alustaLiikkeet();
        chooserLiikkeet.addSelectionListener(e -> naytaLista());
    }
    
    
    /**
     * vaihtaa stringgrid listaa
     */
    private void naytaLista() {
        stringGrid.clear(); 
        liikeKohdalla = chooserLiikkeet.getSelectedObject();
        if (liikeKohdalla == null) return;
        nayta(shoppinglist.annaTuotteet(liikeKohdalla));
         
    }

   
    private void nayta(List<Tuote> annaTuotteet) {
        for (int i = 0;i<annaTuotteet.size();i++) {
        Tuote temp = annaTuotteet.get(i);
        stringGrid.add(temp,temp.getNimi(),temp.getMaara(),temp.getHinta(),temp.getTyyppi());
        }
        stringGrid.getSelectionModel().selectAll();
    }

    private void uusiTuote() {
        if (liikeKohdalla == null) return;
        Tuote tuote = new Tuote();
        tuote.rekisteroi();
        tuote.tayta(liikeKohdalla.getTunnusNro());
        shoppinglist.lisaa(tuote);
        haeTuote(liikeKohdalla.getTunnusNro());
        stringGrid.clear(); //tää
        nayta(shoppinglist.annaTuotteet(liikeKohdalla)); //ja tää
        
    }
    
    private void haeTuote(int jnro) {
>>>>>>> tyo5
        stringGrid.clear();
        int index = 0;
        for (int i =0; i < shoppinglist.getTuotteet(); i++) {
            Tuote tuote = shoppinglist.annaTuote(i);
            if (tuote.getTunnusNro() == jnro) index = i;
            stringGrid.add(tuote,tuote.getNimi(),tuote.getMaara(),tuote.getHinta(),tuote.getTyyppi());    
<<<<<<< HEAD
            
        }
        stringGrid.getSelectionModel().select(index);
    }
>>>>>>> tyo5
=======
         
        }
        stringGrid.getSelectionModel().select(index);

    }
    
    private void uusiLiike() {
        Liike liike = new Liike();
        liike.rekisteroi();
        liike.tayta("Uusi liike");
               
        try {
            shoppinglist.lisaa(liike);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia liikkeissä" + e.getMessage());
            return;
        }
        haeLiike(liike.getTunnusNro());
    }
    
>>>>>>> tyo5
    /**
     *  alustaa liikkeet käyttöliittymään
     */
    public void alustaLiikkeet() {
        Liike Citymarket = new Liike();
        Citymarket.rekisteroi();
<<<<<<< HEAD
<<<<<<< HEAD
        Citymarket.taytaCitymarket();
        
        Liike Sale = new Liike();
        Sale.rekisteroi();
        Sale.taytaSale();
        
        Liike Prisma = new Liike();
        Prisma.rekisteroi();
        Prisma.taytaPrisma();
=======
=======
>>>>>>> tyo5
        Citymarket.tayta("K-Citymarket");
        
        Liike Sale = new Liike();
        Sale.rekisteroi();
        Sale.tayta("Sale");
        
        Liike Prisma = new Liike();
        Prisma.rekisteroi();
        Prisma.tayta("Prisma");
        
        Liike Lidl = new Liike();
        Lidl.rekisteroi();
        Lidl.tayta("Lidl");
        
        Liike Tokmanni = new Liike();
        Tokmanni.rekisteroi();
        Tokmanni.tayta("Tokmanni");
        
        Liike Kmarket = new Liike();
        Kmarket.rekisteroi();
        Kmarket.tayta("K-Market");
        
        Liike Smarket = new Liike();
        Smarket.rekisteroi();
        Smarket.tayta("S-Market");
<<<<<<< HEAD
>>>>>>> tyo5
=======
>>>>>>> tyo5
        
        try {
            shoppinglist.lisaa(Citymarket);
            shoppinglist.lisaa(Sale);
            shoppinglist.lisaa(Prisma);
<<<<<<< HEAD
<<<<<<< HEAD
        } catch (SailoException e) {
            // TODO Auto-generated catch block
            Dialogs.showMessageDialog("Ongelmia liikkeissä" + e.getMessage());
            return;
        }
        hae(Citymarket.getTunnusNro());
=======
=======
>>>>>>> tyo5
            shoppinglist.lisaa(Tokmanni);
            shoppinglist.lisaa(Lidl);
            shoppinglist.lisaa(Kmarket);
            shoppinglist.lisaa(Smarket);
        } catch (SailoException e) {
            Dialogs.showMessageDialog("Ongelmia liikkeissä" + e.getMessage());
            return;
        }
        haeLiike(Citymarket.getTunnusNro());
<<<<<<< HEAD
>>>>>>> tyo5
=======
>>>>>>> tyo5
    }
    
    /**
     * hakee liikkeen ja lisää sen käyttöliittymään
     * @param jnro liikkeen tunnusnumero
     */
<<<<<<< HEAD
<<<<<<< HEAD
    protected void hae(int jnro) {
=======
    protected void haeLiike(int jnro) {
>>>>>>> tyo5
=======
    protected void haeLiike(int jnro) {
>>>>>>> tyo5
        chooserLiikkeet.clear();
        
        int index = 0;
        for (int i =0; i < shoppinglist.getLiikkeet(); i++) {
            Liike liike = shoppinglist.annaLiike(i);
            if (liike.getTunnusNro() == jnro) index = i;
            chooserLiikkeet.add(liike.getNimi(), liike);
        }
        chooserLiikkeet.getSelectionModel().select(index);
    }
    
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

<<<<<<< HEAD
<<<<<<< HEAD
    public void avaaAlku() {
        ModalController.showModal(OhjelmaController.class.getResource("ShoppingListGUIView.fxml"), "Alku", null, "");    
    }
=======
>>>>>>> tyo5
=======
>>>>>>> tyo5
   
}
