import java.util.Arrays;

public class Polica {
    private String proizvodjac;
    private int brRedova;
    private double maxOpterecenje;
    private Tegla[] tegle;
    private int brTegli;

    public Polica(String proizvodjac, int brRedova, double maxOpterecenje) {
        this.proizvodjac = proizvodjac;
        this.brRedova = brRedova;
        this.maxOpterecenje = maxOpterecenje;
        this.tegle = new Tegla[10];
        this.brTegli = 0;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public int getBrRedova() {
        return brRedova;
    }

    public double getMaxOpterecenje() {
        return maxOpterecenje;
    }

    public Tegla[] getTegle() {
        return tegle;
    }

    public int getBrTegli() {
        return brTegli;
    }

    public void setMaxOpterecenje(double maxOpterecenje) {
        this.maxOpterecenje = maxOpterecenje;
    }

    public boolean dodajTeglu(Tegla tegla) {
        if (brTegli == 10) {
            return false;
        }

        dodajTegluInternal(tegla);

        return true;
    }

    public double trenutnoOpterecenje() {
        double suma = 0.0;
        for (int i = 0; i < brTegli; i++) {
            suma += tegle[i].getTezina();
        }
        return suma;
    }

    protected void dodajTegluInternal(Tegla t) {
        tegle[brTegli++] = t;
    }

    public double ukupnaZapremina() {
        double suma = 0.0;
        for (Tegla tegla : tegle) {
            suma += tegla.getZapremina();
        }
        return suma;
    }

    @Override
    public String toString() {
        return "Polica{" +
                "proizvodjac='" + proizvodjac + '\'' +
                ", brRedova=" + brRedova +
                ", maxOpterecenje=" + maxOpterecenje +
                ", tegle=" + Arrays.toString(tegle) +
                ", brTegli=" + brTegli +
                '}';
    }
}
