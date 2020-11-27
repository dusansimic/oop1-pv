import java.text.DecimalFormat;

public abstract class Pivo implements Comparable<Pivo>{
	private String proizvodjac;
	private double jacina;
	private String boja;
	private String tip;
	
	public Pivo(String proizvodjac, double jacina, String boja, String tip) {
		this.proizvodjac = proizvodjac;
		this.jacina = jacina;
		this.boja = boja;
		this.tip = tip;
	}

	abstract boolean jeIzlapelo();

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public double getJacina() {
		return jacina;
	}

	public void setJacina(double jacina) {
		this.jacina = jacina;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.#");
		return "Pivo [proizvodjac=" + proizvodjac + ", jacina=" + df.format(jacina) + ", boja=" + boja + ", tip=" + tip + "]";
	}

	@Override
	public int compareTo(Pivo pivo) {
		if (Double.compare(pivo.getJacina(),this.jacina) > 0)
			return 1;
		if (Double.compare(pivo.getJacina(), this.jacina) < 0)
			return -1;
		return 0;
	}
	
	
	
	
}
