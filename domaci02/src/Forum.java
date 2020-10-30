import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Forum {
    Objava[] objave;

    public Forum(String fajl) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fajl));

        int brObjava = Integer.parseInt(in.readLine().trim());
        objave = new Objava[brObjava];

        for (int i = 0; i < brObjava; i++) {
            String[] line = in.readLine().split(",");
            objave[i] = new Objava(line[0].trim(), line[1].trim(), Integer.parseInt(line[2].trim()));
        }

        in.close();
    }

    public Objava najpopularnijaObjava(String tema) {
        if (!Objava.validnaTema(tema)) {
            System.err.println("Trazena tema nije validna!");
            return null;
        }

        Objava pop = null;
        for (int i = 0; i < objave.length; i++) {
            if (objave[i].getTema().equals(tema) && (pop == null || objave[i].getBrojKom() > pop.getBrojKom())) {
                pop = objave[i];
            }
        }

        if (pop == null) {
            System.err.println("Ne postoji objava u trazenoj temi!");
        }

        return pop;
    }

    public void statistika() {
        int[] sportStats = new int[]{0, 0};
        int[] hobijiStats = new int[]{0, 0};
        int[] jeziciStats = new int[]{0, 0};
        int[] raznoStats = new int[]{0, 0};

        for (int i = 0; i < objave.length; i++) {
            switch (objave[i].getTema()) {
                case "sport":
                    sportStats[0]++;
                    sportStats[1] += objave[i].getBrojKom();
                    break;
                case "hobiji":
                    hobijiStats[0]++;
                    hobijiStats[1] += objave[i].getBrojKom();
                    break;
                case "strani jezici":
                    jeziciStats[0]++;
                    jeziciStats[1] += objave[i].getBrojKom();
                    break;
                default:
                    raznoStats[0]++;
                    raznoStats[1] += objave[i].getBrojKom();
            }
        }

        System.out.println(String.format("Sport [objave: %d] [komentari: %d]", sportStats[0], sportStats[1]));
        System.out.println(String.format("Hobiji [objave: %d] [komentari: %d]", hobijiStats[0], hobijiStats[1]));
        System.out.println(String.format("Strani jezici [objave: %d] [komentari: %d]", jeziciStats[0], jeziciStats[1]));
        System.out.println(String.format("Razno [objave: %d] [komentari: %d]", raznoStats[0], raznoStats[1]));
    }
}
