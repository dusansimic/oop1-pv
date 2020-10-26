public class Kosarkas {
    private String ime;
    private String pozicija;
    private double korisnost;

    public Kosarkas(String ime, String pozicija, double korisnost) {
        this.ime = ime;
        setPozicijaInternal(pozicija);
        this.korisnost = korisnost;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        setPozicijaInternal(pozicija);
    }

    public double getKorisnost() {
        return korisnost;
    }

    public void setKorisnost(double korisnost) {
        this.korisnost = korisnost;
    }

    private void setPozicijaInternal(String pozicija) {
        if (!pozicija.equals("bek") && !pozicija.equals("krilo") && !pozicija.equals("centar")) {
            pozicija = "bek";
        }
        this.pozicija = pozicija;
    }


    @Override
    public String toString() {
        return "Kosarkas{" +
                "ime='" + ime + '\'' +
                ", pozicija='" + pozicija + '\'' +
                ", korisnost=" + korisnost +
                '}';
    }
}
