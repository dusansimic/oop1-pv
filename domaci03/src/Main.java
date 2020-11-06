import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Spajz spajz = new Spajz(Spajz.ucitajPolice("res/police.txt"));
        spajz.postaviTegle(Spajz.ucitajTegle("res/tegle.txt"));
        System.out.println(spajz.ukupnaTezina());
        System.out.println(spajz.plasticnaSaNjavecimOpterecenjem());
    }
}
