import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
    public List<Flight> getAllFlights() {
        List<Flight> list = new ArrayList<>();
        String sql = "SELECT f.*, a.model AS airplane_model FROM flights f " +
                     "LEFT JOIN airplanes a ON f.id_airplane = a.id_airplane";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Flight f = new Flight(
                    rs.getInt("id_flight"),
                    rs.getString("flight_number"),
                    rs.getString("airplane_model"),
                    rs.getString("departure_city"),
                    rs.getString("arrival_city"),
                    rs.getTimestamp("departure_time"),
                    rs.getTimestamp("arrival_time")
                );
                list.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}