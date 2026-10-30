import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    public List<Ticket> getAllTickets() {
        List<Ticket> list = new ArrayList<>();
        String sql = "SELECT t.*, p.fam AS passenger_fam, f.flight_number FROM tickets t " +
                     "LEFT JOIN passengers p ON t.id_passenger = p.id_passenger " +
                     "LEFT JOIN flights f ON t.id_flight = f.id_flight";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Ticket t = new Ticket(
                    rs.getInt("id_ticket"),
                    rs.getString("passenger_fam"),
                    rs.getString("flight_number"),
                    rs.getString("seat_number"),
                    rs.getDouble("price"),
                    rs.getTimestamp("booking_date")
                );
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}