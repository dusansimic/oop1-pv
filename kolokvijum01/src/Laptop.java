import java.util.Random;

public class Laptop extends Uredjaj {
    public Laptop(double jacina, int ram, boolean kamera, double cena, String boja) {
        super(jacina, ram, kamera, cena, boja);
    }

    @Override
    public boolean jePotrebanServis() {
        Random rand = new Random();
        boolean pokvaren = rand.nextInt(100) < 5;
        if (pokvaren) {
            int i = rand.nextInt(3);
            String komponenta = MOGUCE_POKVARENE_KOMPONENTE[i];
            System.out.printf("%s je pokvaren%s, potreban je servis!\n", komponenta, i == 1 ? "a" : "");
        }
        return pokvaren;
    }
}
