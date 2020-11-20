import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Kamion k = new Kamion(Kamion.ucitaj("res/tockovi.txt"));

        boolean pokvaren = false;
        for (int i = 0; i < 500 && !pokvaren; i++) {
            pokvaren = !k.vozi();
        }

        if (pokvaren) {
            System.out.println("Kamion se pokvario pre nego sto je prosao 500km!");
        } else {
            System.out.println("Kamion je prosao 500km.");
        }
    }
}
