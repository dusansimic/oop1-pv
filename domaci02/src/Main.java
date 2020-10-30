import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Forum forum = new Forum("res/objave.txt");

        System.out.println("Najpopularnije objave:");
        ispisiNajpopularnijuObjavu(forum.najpopularnijaObjava("sport"));
        ispisiNajpopularnijuObjavu(forum.najpopularnijaObjava("hobiji"));
        ispisiNajpopularnijuObjavu(forum.najpopularnijaObjava("strani jezici"));
        ispisiNajpopularnijuObjavu(forum.najpopularnijaObjava("razno"));
        System.out.println();

        System.out.println("Statistike:");
        forum.statistika();
    }

    public static void ispisiNajpopularnijuObjavu(Objava objava) {
        if (objava != null) {
            System.out.println(objava);
        }
    }
}
