import java.util.Random;

public class PsecnicnoPivo extends Pivo{

	
	public PsecnicnoPivo(String proizvodjac, String tip) {
		super(proizvodjac, (5.0 + (6.0 - 5.0) * new Random().nextDouble()), ((new Random().nextInt(2) == 1) ? "zuto" : "narandzasto"), tip);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean jeIzlapelo() {
		// TODO Auto-generated method stub		
		return (Math.random() < 0.9) ? true : false;
	}
	
	

}
