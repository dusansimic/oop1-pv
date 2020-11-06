import java.io.*;

public class Spajz {
    private Polica[] police;

    public Spajz(Polica[] police) {
        this.police = police;
    }

    public boolean postaviTegle(Tegla[] tegle) {
        for (int i = 0; i < tegle.length; i++) {
            if (!police[i % police.length].dodajTeglu(tegle[i])) {
                return false;
            }
        }

        return true;
    }

    public static Polica[] ucitajPolice(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(in.readLine().trim());
        Polica[] police = new Polica[n];
        for (int i = 0; i < n; i++) {
            String[] el = in.readLine().split(",");
            Polica p;
            if (el[0].trim().length() > 5) {
                p = new PlasticnaPolica(el[0].trim(), Integer.parseInt(el[1].trim()));
            } else {
                p = new Polica(el[0].trim(), Integer.parseInt(el[1].trim()), 0.0);
            }
            police[i] = p;
        }

        return police;
    }

    public static Tegla[] ucitajTegle(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(in.readLine().trim());
        Tegla[] tegle = new Tegla[n];
        for (int i = 0; i < n; i++) {
            String[] el = in.readLine().split(",");
            tegle[i] = new Tegla(Double.parseDouble(el[0].trim()), Double.parseDouble(el[1].trim()), el[2].trim());
        }
        return tegle;
    }

    public double ukupnaTezina() {
        double sum = 0.0;
        for (Polica p : police) {
            sum += p.trenutnoOpterecenje();
        }
        return sum;
    }

    public Polica plasticnaSaNjavecimOpterecenjem() {
        Polica max = null;
        for (Polica p : police) {
            // Opterecenje ce uvek biti ispod 2.5 jer mi testiramo to prilikom dodavanja stoga se ne mora testirati.
            if (p instanceof PlasticnaPolica && (max == null || p.trenutnoOpterecenje() > max.trenutnoOpterecenje())) {
                max = p;
            }
        }
        return max;
    }
}
