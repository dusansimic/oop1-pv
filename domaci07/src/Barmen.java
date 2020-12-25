import java.util.LinkedList;
import java.util.List;

public class Barmen implements Mixer {
    List<VocniSok> sokovi;
    String[][] parovi;
    int korakSmotanosti;

    public Barmen(String[][] parovi) {
        this.sokovi = new LinkedList<VocniSok>();
        this.parovi = parovi;
        this.korakSmotanosti = 0;
    }

    @Override
    public void dodajVoce(String voce, int brojKomada) throws GreskaDodavanje {
        for (VocniSok sok : sokovi) {
            if (!uklapaSe(voce, sok.getVrsta())) {
                throw new GreskaDodavanje(voce, sok);
            }
        }
        sokovi.add(new VocniSok(voce, brojKomada));
    }

    private boolean uklapaSe(String voce1, String voce2) {
        boolean uklapaSe = true;
        for (String[] par : parovi) {
            if ((par[0].equals(voce1) && par[1].equals(voce2)) || (par[1].equals(voce1) && par[0].equals(voce2))) {
               uklapaSe = false;
            }
        }
        return uklapaSe;
    }

    @Override
    public void promuckaj() throws GreskaMuckanje {
        korakSmotanosti++;
        if (korakSmotanosti % 3 == 0) {
            sokovi.clear();
            throw new GreskaMuckanje("Barmen je prosuo koktel.");
        }
        if (korakSmotanosti % 7 == 0) {
            sokovi.clear();
            throw new GreskaMuckanje("Barmen je razbio casu.");
        }
    }

    @Override
    public void posluzi() {
        double suma = 0.0;
        for (VocniSok sok : sokovi) {
            System.out.printf("%s ", sok.getVrsta());
            suma += sok.getLitre();
        }
        System.out.printf("%.2f\n", suma);
        sokovi.clear();
    }
}
