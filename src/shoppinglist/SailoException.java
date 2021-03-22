package shoppinglist;

/**
 * @author aksel
 * @version 4.3.2021
 * Poikkeusluokka tietorakenteen poikkeuksille
 */
public class SailoException extends Exception {
    private static final long serialVersionUID = 1L;
    
    /**
     * Viesti joka tulostetaan poikkeuksen takia
     * @param viesti käytettävä viesti
     */
    public SailoException(String viesti) {
        super(viesti);
    }
}
