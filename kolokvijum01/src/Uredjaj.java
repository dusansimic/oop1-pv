import java.util.Random;

public abstract class Uredjaj {
    private double jacina;
    private int ram;
    private boolean kamera;
    private double cena;
    private String boja;

    private final String[] MOGUCE_BOJE = new String[]{"crna", "bela", "siva"};
    protected final String[] MOGUCE_POKVARENE_KOMPONENTE = new String[]{"procesor", "maticna ploca", "ram"};

    public Uredjaj(double jacina, int ram, boolean kamera, double cena, String boja) {
        this.jacina = jacina;
        this.ram = ram;
        this.kamera = kamera;
        this.cena = cena;
        this.boja = getComputedBoja(boja);
    }

    public double getJacina() {
        return jacina;
    }

    public void setJacina(double jacina) {
        this.jacina = jacina;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public boolean isKamera() {
        return kamera;
    }

    public void setKamera(boolean kamera) {
        this.kamera = kamera;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = getComputedBoja(boja);
    }

    private String getComputedBoja(String boja) {
        if (boja.equals("crna") || boja.equals("bela") || boja.equals("siva")) {
            return boja;
        }
        return MOGUCE_BOJE[(new Random()).nextInt(3)];
    }

    public abstract boolean jePotrebanServis();

    @Override
    public String toString() {
        return "Uredjaj{" +
                "jacina=" + jacina +
                ", ram=" + ram +
                ", kamera=" + kamera +
                ", cena=" + cena +
                ", boja='" + boja + '\'' +
                '}';
    }
}
