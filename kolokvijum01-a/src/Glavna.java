import java.io.IOException;
import java.text.DecimalFormat;

public class Glavna {

	public static void main(String[] args) throws IOException {
		
		//radi lepseg predstavljanja decimalnih brojeva
		DecimalFormat df = new DecimalFormat("#.##");
		
		Kafana kafana = new Kafana(Kafana.ucitajPiva("res/pivoteka.txt"), "Pavle Korcagin", " Ćirila i Metodija 2а");
		System.out.println(kafana);
		System.out.println("Prosecna jacina piva u kafani je: " + df.format(kafana.prosecnaJacinaPiva()));
		kafana.posluziPivo();
		System.out.println("Ukupno posluzenih piva: " + kafana.getUkupnoPosluzenihPiva());
		
	}

}
