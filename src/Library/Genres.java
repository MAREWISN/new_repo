package Library;

public enum Genres {

    BIOGRAFIA("Biografia"),
    HISTORYCZNA("Historyczny"),
    KRYMINAL ("Kryminał"),
    SCI_FI("Science-Fiction"),
    REPORTAZ("Reportaż");

    private final String display;

    Genres(String s)
    {
        display = s;
    }

    @Override
    public String toString() {
        return display;
    }
}
