import java.util.Random;

public class Telefon extends Uredjaj {
    public Telefon(double jacina, int ram, double cena, String boja) {
        super(jacina, ram, true, cena, boja);
    }

    @Override
    public boolean jePotrebanServis() {
        Random rand = new Random();
        boolean pokvaren = rand.nextInt(100) < 7;
        if (pokvaren) {
            int i = rand.nextInt(3);
            String komponenta = MOGUCE_POKVARENE_KOMPONENTE[i];
            System.out.printf("%s je pokvaren%s, potreban je servis!\n", komponenta, i == 1 ? "a" : "");
        }
        return pokvaren;
    }
}
