public class VocniSok {
    private String vrsta;
    private int komadi;
    private double litre;

    public VocniSok(String vrsta, int komadi) {
        this.vrsta = vrsta;
        this.komadi = komadi;
        this.litre = computeLitre(komadi);
    }

    public String getVrsta() {
        return vrsta;
    }

    public int getKomadi() {
        return komadi;
    }

    public void setKomadi(int komadi) {
        this.komadi = komadi;
        this.litre = computeLitre(komadi);
    }

    public double getLitre() {
        return litre;
    }

    private double computeLitre(int komadi) {
        return komadi * 0.1;
    }
}
