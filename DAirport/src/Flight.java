import java.util.Date;

public class Flight {
    private int idFlight;
    private String flightNumber;
    private String airplaneModel;
    private String departureCity;
    private String arrivalCity;
    private Date departureTime;
    private Date arrivalTime;

    public Flight(int idFlight, String flightNumber, String airplaneModel, String departureCity, String arrivalCity, Date departureTime, Date arrivalTime) {
        this.idFlight = idFlight;
        this.flightNumber = flightNumber;
        this.airplaneModel = airplaneModel;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public int getIdFlight() { return idFlight; }
    public String getFlightNumber() { return flightNumber; }
    public String getAirplaneModel() { return airplaneModel; }
    public String getDepartureCity() { return departureCity; }
    public String getArrivalCity() { return arrivalCity; }
    public Date getDepartureTime() { return departureTime; }
    public Date getArrivalTime() { return arrivalTime; }
}