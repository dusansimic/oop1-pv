import java.util.Random;

public class KraftPivo extends Pivo{
	
	public KraftPivo(String proizvodjac, String tip) {		
		// za jacinu piva, izraz vraca vrednost izmedju 6 i 11
		super(proizvodjac, (6.0 + (11.0 - 6.0) * new Random().nextDouble()), nekaBoja(), tip);
	}

	@Override
	boolean jeIzlapelo() {
		double r = Math.random();
		return (r < 0.9 && r> 0.7) ? false : true;
	}
	
	private static String nekaBoja() {

		String[] bojePiva = {"svetlo", "crno", "tamno"};
		int r = new Random().nextInt(3);
		return bojePiva[r];
	}

}
