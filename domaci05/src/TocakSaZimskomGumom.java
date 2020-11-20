public class TocakSaZimskomGumom extends Tocak {
    protected TocakSaZimskomGumom(int starost) {
        super(starost);
    }

    @Override
    public boolean isUpotrebljiv() {
        return !isPukla() && getStarost() < 5;
    }
}
