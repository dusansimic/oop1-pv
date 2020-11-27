import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Kafana implements Sanker{
	
	private Pivo[] piva;
	private String imeKafane;
	private String adresaKafane;
	private int ukupnoPosluzenihPiva;
	
	public Kafana(Pivo[] piva, String imeKafane, String adresaKafane) {
		this.piva = piva;
		this.imeKafane = imeKafane;
		this.adresaKafane = adresaKafane;
		this.ukupnoPosluzenihPiva = 0;
	}

	@Override
	public void posluziPivo() {
		Arrays.sort(piva);
		ukupnoPosluzenihPiva = 0;
		for (int i = 0; i < piva.length; i++) {
			if (!piva[i].jeIzlapelo()) {
				ukupnoPosluzenihPiva++;
			}
 		}		
	}

	public int getUkupnoPosluzenihPiva() {
		return ukupnoPosluzenihPiva;
	}
	
	public double prosecnaJacinaPiva() {
		double prosecnaJacina = 0.0;
		for (int i = 0; i < piva.length; i++) {
			prosecnaJacina += piva[i].getJacina();
		}
		DecimalFormat df = new DecimalFormat("#.#");
		return prosecnaJacina / piva.length;
	}
	 
	public static Pivo[] ucitajPiva(String fajl) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fajl));
		int br = Integer.parseInt(in.readLine().trim());
		Pivo[] piva = new Pivo[br];
		
		for (int i = 0; i < br; i++) {
			Pivo p;
			String[] el = in.readLine().split(";");
			if (el[1].trim().equals("psecnicno")) {
				p = new PsecnicnoPivo(el[0].trim(),"psecnicno");
			} else if (el[1].trim().equals("crveno")) {
				p = new CrvenoPivo(el[0].trim(),"crveno");
			} else {
				p = new KraftPivo(el[0].trim(), "kraft");
			}
			piva[i] = p;			
		}
		
		in.close();
		return piva;
	}

	@Override
	public String toString() {
		String kafana = "Kafana [piva="  + ", imeKafane=" + imeKafane + ", adresaKafane=" + adresaKafane +"]\n";
		
		String svaPiva = "\nPiva u kafani su: \n";
		Arrays.sort(piva);
		for (int i = 0; i < piva.length; i++) {
			svaPiva += "" + piva[i] + "\n";
		}
		return  kafana + svaPiva;
	}
	
	
	
//	public void stampajPiva() {
//		for (Pivo p : piva) {
//			System.out.println(p);
//		}
//	}

}
