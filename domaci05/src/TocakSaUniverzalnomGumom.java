import java.util.Random;

public class TocakSaUniverzalnomGumom extends Tocak {
    public TocakSaUniverzalnomGumom(int starost) {
        super((new Random()).nextInt(100) < 3, starost);
    }

    @Override
    public boolean isUpotrebljiv() {
        return !isPukla() && getStarost() < 7;
    }
}
