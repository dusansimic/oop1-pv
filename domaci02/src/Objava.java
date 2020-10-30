public class Objava {
    String naslov;
    String tema;
    int brojKom;

    public Objava(String naslov, String tema, int brojKom) {
        this.naslov = naslov;
        setTemaInternal(tema);
        this.brojKom = brojKom;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        setTemaInternal(tema);
    }

    void setTemaInternal(String tema) {
        if (!validnaTema(tema)) {
            tema = "razno";
        }
        this.tema = tema;
    }

    public int getBrojKom() {
        return brojKom;
    }

    public void setBrojKom(int brojKom) {
        this.brojKom = brojKom;
    }

    public static boolean validnaTema(String tema) {
        return tema.equals("sport") || tema.equals("hobiji") || tema.equals("strani jezici") || tema.equals("razno");
    }

    @Override
    public String toString() {
        return String.format("%s [%s] - %d", naslov, tema, brojKom);
    }
}
