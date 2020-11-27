import java.util.Random;

public class PsecnicnoPivo extends Pivo{
	
	public PsecnicnoPivo(String proizvodjac, String tip) {
		// izraz za jacinu piva vraca double vrednost izmedju 5.0 - 6.0
		super(proizvodjac, (5.0 + (6.0 - 5.0) * new Random().nextDouble()), ((new Random().nextInt(2) == 1) ? "zuto" : "narandzasto"), tip);
	}

	@Override
	boolean jeIzlapelo() {		
		return (Math.random() < 0.9) ? true : false;
	}
}
