public class Tegla {
    private double zapremina;
    private double tezina;
    private String sadrzaj;

    public Tegla(double zapremina, double tezina, String sadrzaj) {
        this.zapremina = zapremina;
        this.tezina = tezina;
        this.sadrzaj = sadrzaj;
    }

    public double getZapremina() {
        return zapremina;
    }

    public double getTezina() {
        return tezina;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    @Override
    public String toString() {
        return "Tegla{" +
                "zapremina=" + ((int) (zapremina*10) / 10.0) +
                ", tezina=" + ((int) (tezina*10) / 10.0) +
                ", sadrzaj='" + sadrzaj + '\'' +
                '}';
    }
}
