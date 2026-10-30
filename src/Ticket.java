import java.util.Date;

public class Ticket {
    private int idTicket;
    private String passengerFam;
    private String flightNumber;
    private String seatNumber;
    private double price;
    private Date bookingDate;

    public Ticket(int idTicket, String passengerFam, String flightNumber, String seatNumber, double price, Date bookingDate) {
        this.idTicket = idTicket;
        this.passengerFam = passengerFam;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.price = price;
        this.bookingDate = bookingDate;
    }

    public int getIdTicket() { return idTicket; }
    public String getPassengerFam() { return passengerFam; }
    public String getFlightNumber() { return flightNumber; }
    public String getSeatNumber() { return seatNumber; }
    public double getPrice() { return price; }
    public Date getBookingDate() { return bookingDate; }
}