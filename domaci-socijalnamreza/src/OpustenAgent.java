public class OpustenAgent extends TajniAgent {
	public OpustenAgent(String kodnoIme) {
		super(kodnoIme);
	}

	public void proslediInformaciju(TajniAgent izvor) {
		if (kontaktiraniAgenti.size() == kontakti.size() - 1) {
			return;
		}
		for (int i = 0; i < kontakti.size(); i++) {
			TajniAgent kontakt = kontakti.get(i);
			if (kontakt != izvor && !kontaktiraniAgenti.contains(kontakt.toString())) {
				kontaktiraniAgenti.add(kontakt.toString());
				kontakt.primiInformaciju(this);
			}
		}
	}
}
