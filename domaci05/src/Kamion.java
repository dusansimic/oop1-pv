import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Kamion {
    private Tocak[] niz;

    public Kamion(Tocak[] niz) {
        this.niz = niz;
        postaviNajboljeTockove();
    }

    public static Tocak[] ucitaj(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(in.readLine().trim());
        Tocak[] tocaks = new Tocak[n];
        for (int i = 0; i < n; i++) {
            String[] el = in.readLine().split(",");
            Tocak t;
            if (el.length == 1) {
                t = new TocakSaUniverzalnomGumom(Integer.parseInt(el[0].trim()));
            } else {
                int starost = Integer.parseInt(el[0].trim());
                t = el[1].trim() == "zimska" ? new TocakSaZimskomGumom(starost) : new TocakSaLetnjomGumom(starost);
            }

            tocaks[i] = t;
        }
        return tocaks;
    }

    private void postaviNajboljeTockove() {
        Arrays.sort(niz);
    }

    public boolean vozi() {
        Random r = new Random();
        Tocak t = niz[r.nextInt(niz.length)];
        if (r.nextDouble() < 0.005) {
            t.setPukla(true);
        }
        postaviNajboljeTockove();
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (!niz[i].isUpotrebljiv()) {
                cnt++;
            }
        }

        return cnt < 5;
    }
}
