import java.util.Random;

public class TocakSaLetnjomGumom extends Tocak {
    public TocakSaLetnjomGumom(int starost) {
        super((new Random()).nextInt(100) < 5, starost);
    }

    @Override
    public boolean isUpotrebljiv() {
        return !isPukla() && getStarost() < 10;
    }
}
