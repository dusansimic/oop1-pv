public class PlasticnaPolica extends Polica {
    public PlasticnaPolica(String proizvodjac, int brRedova) {
        super(proizvodjac, brRedova, 4.0);
    }

    @Override
    public boolean dodajTeglu(Tegla tegla) {
        if (getBrTegli() == 10) {
            return false;
        }
        if (trenutnoOpterecenje() + tegla.getTezina() > 2.5) {
            return false;
        }

        dodajTegluInternal(tegla);

        return true;
    }
}
