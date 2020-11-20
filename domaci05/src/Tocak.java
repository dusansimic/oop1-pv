import java.util.Random;

public abstract class Tocak implements Comparable<Tocak> {
    private boolean pukla;
    private int starost;

    public Tocak(int starost) {
        this.pukla = (new Random()).nextInt(100) == 0;
        this.starost = starost;
    }

    protected Tocak(boolean pukla, int starost) {
        this.pukla = pukla;
        this.starost = starost;
    }

    public boolean isPukla() {
        return pukla;
    }

    public void setPukla(boolean pukla) {
        this.pukla = pukla;
    }

    public int getStarost() {
        return starost;
    }

    public abstract boolean isUpotrebljiv();

    @Override
    public int compareTo(Tocak tocak) {
        if (isUpotrebljiv() != tocak.isUpotrebljiv()) {
            return isUpotrebljiv() ? -1 : 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Tocak{" +
                "pukla=" + pukla +
                ", starost=" + starost +
                '}';
    }
}
