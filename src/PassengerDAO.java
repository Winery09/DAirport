import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO {
    public List<Passenger> getAllPassengers() {
        List<Passenger> list = new ArrayList<>();
        String sql = "SELECT * FROM passengers";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Passenger p = new Passenger(
                    rs.getInt("id_passenger"),
                    rs.getString("fam"),
                    rs.getString("name"),
                    rs.getString("otchestvo"),
                    rs.getString("passport"),
                    rs.getString("telefon")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}