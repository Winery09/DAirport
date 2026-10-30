public class Passenger {
    private int idPassenger;
    private String fam;
    private String name;
    private String otchestvo;
    private String passport;
    private String telefon;

    public Passenger(int idPassenger, String fam, String name, String otchestvo, String passport, String telefon) {
        this.idPassenger = idPassenger;
        this.fam = fam;
        this.name = name;
        this.otchestvo = otchestvo;
        this.passport = passport;
        this.telefon = telefon;
    }

    public int getIdPassenger() { return idPassenger; }
    public String getFam() { return fam; }
    public String getName() { return name; }
    public String getOtchestvo() { return otchestvo; }
    public String getPassport() { return passport; }
    public String getTelefon() { return telefon; }
}