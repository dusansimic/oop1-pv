import java.util.Random;

public class CrvenoPivo extends Pivo{
	
	public CrvenoPivo(String proizvodjac, String tip) {
		super(proizvodjac, 8.0, "crveno", tip);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean jeIzlapelo() {
		// TODO Auto-generated method stub
		return (new Random().nextInt(2) == 1) ? true : false;
	}

}
