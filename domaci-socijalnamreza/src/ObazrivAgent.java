public class ObazrivAgent extends TajniAgent {
	public ObazrivAgent(String kodnoIme) {
		super(kodnoIme);
	}

	public void proslediInformaciju(TajniAgent izvor) {
		if (kontaktiraniAgenti.size() == kontakti.size() - 1) {
			return;
		}
		if (kontakti.size() > 1) {
			TajniAgent kontakt = null;
			do {
				int kome = (int) (Math.random() * kontakti.size());
				kontakt = kontakti.get(kome);
				if (kontakt != izvor && !kontaktiraniAgenti.contains(kontakt.toString())) {
					kontaktiraniAgenti.add(kontakt.toString());
					kontakt.primiInformaciju(this);
				}
			} while (kontakt == izvor);
		}
	}
}
