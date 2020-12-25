public class GreskaDodavanje extends Exception {
    private VocniSok sok;

    public GreskaDodavanje(String vrsta, VocniSok sok) {
        super(vrsta + " nije uspesno dodata");
        this.sok = sok;
    }
}
