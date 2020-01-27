package Library;

public enum Genre {
    HORROR("Horror"),
    SCI_FI("Science-Fiction"),
    FABULARNA("Fabularna"),
    REPORTAZ("Reportaż"),
    BIOGRAFIA("Biografia"),
    NAUKOWA("Naukowa");
    private final String display;
    private Genre(String s)
    {
        display=s;
    }
    @Override
    public String toString()
    {
        return display;
    }
}
