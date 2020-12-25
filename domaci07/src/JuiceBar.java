import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JuiceBar {
    public static void main(String[] args) {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("res/sokovi.txt"));
            int n = Integer.parseInt(buf.readLine().trim());
            String[][] zabranjeni = new String[2][n];
            for (int i = 0; i < n; i++) {
                String[] par = buf.readLine().split(",");
                zabranjeni[0][i] = par[0].trim();
                zabranjeni[1][i] = par[1].trim();
            }
            Barmen barmen = new Barmen(zabranjeni);
            do {
                String line = buf.readLine();
                if (line != null) {
                    String[] parsed = line.split(",");
                    for (int i = 0; i < parsed.length; i+=2) {
                        try {
                            barmen.dodajVoce(parsed[i].trim(), Integer.parseInt(parsed[i + 1].trim()));
                        } catch (GreskaDodavanje e) {
                            System.out.printf("Desila se greska u toku dodavanja! %s\n", e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("Linija fajla nije ispravno formatirana!");
                        }
                        catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Linija fajla nije ispravno formatirana!");
                        }
                    }
                    try {
                        barmen.promuckaj();
                        barmen.posluzi();
                    } catch (GreskaMuckanje e) {
                        System.out.printf("Desila se greska u toku muckanja! %s\n", e.getMessage());
                    }
                } else {
                    break;
                }
            } while (true);
        } catch (IOException e) {
            System.out.printf("Greska prilikom citanja fajla! %s\n", e.getMessage());
        } catch (Exception e) {
            System.out.printf("The sky is falling! %s\n", e.getMessage());
        }
    }
}
