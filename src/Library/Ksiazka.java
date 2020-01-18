package Library;

public class Ksiazka {

    private String nazwa;
    private String rodzaj;
    private int rok_wydania;

    public Ksiazka(String nazwa, String rodzaj, int rok_wydania) {
        this.nazwa = nazwa;
        this.rodzaj = rodzaj;
        this.rok_wydania = rok_wydania;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public String getRodzaj() {
        return this.rodzaj;
    }

    public int getRok_wydania() {
        return this.rok_wydania;
    }

    @Override
    public String toString() {
        return nazwa;
    }
}
