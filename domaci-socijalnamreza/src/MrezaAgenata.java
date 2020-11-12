import java.io.*;
import java.util.HashMap;

public class MrezaAgenata {
	private TajniAgent[] agent;
	
	private HashMap<String, TajniAgent> indeks =
		new HashMap<String, TajniAgent>();
	
	public MrezaAgenata(String agentiFajl, String kontaktiFajl) 
		throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(agentiFajl));
		
		int brAgenata = Integer.parseInt(br.readLine().trim());
		agent = new TajniAgent[brAgenata];
		
		for (int i = 0; i < brAgenata; i++) {
			String linija = br.readLine();
			String[] tok = linija.split(",");
			String tip = tok[0].trim();
			String kodnoIme = tok[1].trim();
			
			if (tip.equals("obazriv"))
				agent[i] = new ObazrivAgent(kodnoIme);
			else
				agent[i] = new OpustenAgent(kodnoIme);
			
			indeks.put(kodnoIme, agent[i]);
		}
		br.close();
		
		br = new BufferedReader(new FileReader(kontaktiFajl));
		String linija = null;
		while ((linija = br.readLine()) != null) {
			String[] tok = linija.split(",");
			TajniAgent agent1 = indeks.get(tok[0].trim());
			TajniAgent agent2 = indeks.get(tok[1].trim());
			if (agent1 != null && agent2 != null) {
				agent1.dodajKontakt(agent2);
				agent2.dodajKontakt(agent1);
			}
		}
	}
	
	public void propagirajInformaciju() {
		int rndIndex = (int) (Math.random() * agent.length);
		TajniAgent start = agent[rndIndex];
		start.primiInformaciju(null);
		System.out.println("Pocinje od " + start);
		
		for (int i = 0; i < agent.length; i++) {
			if (agent[i].primioInformaciju()) {
				System.out.println(agent[i]);
			}
		}
	}
}
