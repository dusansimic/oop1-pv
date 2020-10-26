public class Main {

    public static void main(String[] args) {
        Tim tim = new Tim(new Kosarkas[]{
                new Kosarkas("Mirosalv Raduljica", "centar", 54.1),
                new Kosarkas("Nikola Jokic", "bek", 75.4),
                new Kosarkas("Boban Marjanovic", "bek", 53.6),
                new Kosarkas("Bogdan Bogdanovic", "krilo", 67.2),
                new Kosarkas("Marko Simonovic", "krilo", 62.1),
        });

        System.out.println(tim);
        System.out.println(tim.najkorisnijiIgracNaTerenu());
    }
}
