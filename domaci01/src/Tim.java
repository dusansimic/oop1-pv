import java.util.Arrays;

public class Tim {
    private Kosarkas[] kosarkasi;

    public Tim(Kosarkas[] kosarkasi) {
        this.kosarkasi = kosarkasi;
    }

    /**
     * Nalazi najkorisnijeg igraca na terenu po indeksu korisnosti. Ukoliko ima dva igraca sa najvecim
     * indeksom korisnosti, kasniji u nizu ce biti vracen. Ukoliko nema igraca u timu, greska je ispisana
     * i prazan string je vracen.
     * @return Ime najkorisnijeg igraca na terenu
     */
    public String najkorisnijiIgracNaTerenu() {
        Kosarkas top;
        if (kosarkasi.length > 0) {
            top = kosarkasi[0];
        } else {
            System.err.println("Nema igraca u timu!");
            return "";
        }

        for (int i = 1; i < kosarkasi.length; i++) {
            if (kosarkasi[i].getKorisnost() >= top.getKorisnost()) {
                top = kosarkasi[i];
            }
        }

        return top.getIme();
    }

    @Override
    public String toString() {
        return "Tim{" +
                "kosarkasi=" + Arrays.toString(kosarkasi) +
                '}';
    }
}
