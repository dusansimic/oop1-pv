import java.util.LinkedList;

public abstract class TajniAgent {
	private String kodnoIme;
	
	private boolean primioInformaciju;
	
	protected LinkedList<TajniAgent> kontakti = 
		new LinkedList<TajniAgent>();

	protected LinkedList<String> kontaktiraniAgenti = new LinkedList<String>();
	
	public TajniAgent(String kodnoIme) {
		this.kodnoIme = kodnoIme;
	}
	
	public void dodajKontakt(TajniAgent kontakt) {
		kontakti.add(kontakt);
	}
	
	public void primiInformaciju(TajniAgent izvor) {
		System.out.println(izvor + " --> " + this);
		if (primioInformaciju) {
			return;
		}
		primioInformaciju = true;
		proslediInformaciju(izvor);
	}
	
	public boolean primioInformaciju() {
		return primioInformaciju;
	}
	
	public abstract void proslediInformaciju(TajniAgent izvor);

	public String toString() {
		return kodnoIme;
	}
}
