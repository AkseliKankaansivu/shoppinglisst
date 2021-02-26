package shoppinglist;

import java.io.OutputStream;
import java.io.PrintStream;

public class Liikke {
    private int tunnusNro;
    private String nimi = "";
    private static int seuraavaNro = 1;
    

    
    public void tulosta(PrintStream out) {
        out.println("Nimi: " + nimi + ", Tunnusnumero: " + tunnusNro);
    }
    
    public void tulosta(OutputStream os) {
        tulosta(new PrintStream(os));
    }
    
    public void vastaaCitymarket() {
        this.nimi = "K-Citymarket";
    }
    
    public void vastaaPrisma( ) {
        this.nimi = "Prisma";
    }
    
    public int rekisteroi() {
        this.tunnusNro = seuraavaNro;
        seuraavaNro ++;
        return this.tunnusNro;
    }
    
    public int getTunnusNro() {
        return tunnusNro;
    }
    
    public static void main(String[] args) {
        Liikke Citymarket = new Liikke();
        Liikke Prisma = new Liikke();
        
        Citymarket.rekisteroi();
        Prisma.rekisteroi();
        
        Citymarket.tulosta(System.out);
        Citymarket.vastaaCitymarket();
        Citymarket.tulosta(System.out);
        
      
        Prisma.tulosta(System.out);
        Prisma.vastaaPrisma();
        Prisma.tulosta(System.out);
        
        
        
    }
}
