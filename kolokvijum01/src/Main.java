import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Prodavnica prodavnica = new Prodavnica(Prodavnica.ucitaj("res/uredjaji.txt"));

        double cena = prodavnica.prodaj();
        System.out.printf("Prosecna cena svih prodanih telefona je %f.\n", cena);
        if (prodavnica.popravi()) {
            System.out.println("Svi pokvareni uredjaji su poravljeni!");
        } else {
            System.out.println("Nisu svi pokvareni uredjaji popravljeni!");
        }
    }
}
