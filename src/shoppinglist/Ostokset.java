package shoppinglist;

/**
 * Lukee ja kirjoittaa ostokset, osaa etsiä ja lajitella, lisää ja poistaa ostoksia
 * @author aksel
 * @version 22.3.2021
 * EI KÄYTÖSSÄ
 */
public class Ostokset {
    private static final int MAX_OSTOKSET = 10;
    private int lkm = 0;
    private Ostos[] alkiot = new Ostos[MAX_OSTOKSET];
    
    /**
     * @param ostos lisää tuotteen tietorakenteeseen
     * @throws SailoException jos alkioita lisätään liikaa
     */
    public void lisaa(Ostos ostos) throws SailoException {
        if (lkm>=alkiot.length) throw new SailoException("Liikaa alkioita taulussa");
        this.alkiot[this.lkm] = ostos;
        lkm++;
     }
    
    /**
     * palauttaa viitteen i:teen ostokseen
     * @param i monennen alkion viite
     * @return viite ostokseen, jonka alkio on i
     * @throws IndexOutOfBoundsException jos indeksi ei ole mahdollinen tai sen kohdalla alkiota
     */
    public Ostos anna(int i) throws IndexOutOfBoundsException {
        if (i<0 || this.lkm <= i) throw new IndexOutOfBoundsException("Laiton indeksi");
        return alkiot[i];
    }
    
    /**
     * @return ostosten lukumäärä
     */
    public int getLkm() {
        return lkm;
    }
    
    
    
    
    
    /**
     * @param args ei käytössä
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
