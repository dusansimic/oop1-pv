import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Prodavnica implements Servis {
    private Uredjaj[] uredjaji;
    private Uredjaj[] zaServis;
    private int brZaServis;

    public Prodavnica(Uredjaj[] uredjaji) {
        this.uredjaji = uredjaji;
        this.zaServis = new Uredjaj[3];
        this.brZaServis = 0;
    }

    public static Uredjaj[] ucitaj(String file) throws IOException {
        BufferedReader buf = new BufferedReader(new FileReader(file));

        int n = Integer.parseInt(buf.readLine().trim());
        Uredjaj[] uredjaji = new Uredjaj[n];

        for (int i = 0; i < n; i++) {
            String[] in = buf.readLine().split(",");
            String boja = in[1].trim();
            double procesor = Double.parseDouble(in[2].trim());
            int ram = Integer.parseInt(in[3].trim());
            double cena = Double.parseDouble(in[4].trim());
            switch (in[0].trim()) {
                case "laptop":
                    boolean kamera = in[5].trim().equals("da");
                    uredjaji[i] = new Laptop(procesor, ram, kamera, cena, boja);
                    break;
                case "desktop":
                    uredjaji[i] = new DesktopRacunar(procesor, ram, cena, boja);
                    break;
                default:
                    uredjaji[i] = new Telefon(procesor, ram, cena, boja);
            }
        }

        buf.close();

        return uredjaji;
    }

    public double prodaj() {
        double sumCena = 0.0;
        int n = 0;
        for (Uredjaj u : uredjaji) {
            if (u.jePotrebanServis()) {
                if (brZaServis != zaServis.length) {
                    zaServis[brZaServis++] = u;
                }
            } else {
                sumCena += u.getCena();
                n++;
            }
        }

        if (n > 0) {
            return sumCena / n;
        }

        return 0.0;
    }

    @Override
    public boolean popravi() {
        Random rand = new Random();
        for (int i = 0; i < brZaServis; i++) {
            if (zaServis[i] instanceof Telefon) {
                if (rand.nextInt(100) < 20) {
                    return false;
                }
            } else {
                if (rand.nextInt(100) < 25) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prodavnica{" +
                "uredjaji=" + Arrays.toString(uredjaji) +
                ", zaServis=" + Arrays.toString(zaServis) +
                ", brZaServis=" + brZaServis +
                '}';
    }
}
