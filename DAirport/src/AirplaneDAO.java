import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDAO {
    public List<Airplane> getAllAirplanes() {
        List<Airplane> list = new ArrayList<>();
        String sql = "SELECT * FROM airplanes";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Airplane airplane = new Airplane(
                    rs.getInt("id_airplane"),
                    rs.getString("model"),
                    rs.getInt("capacity"),
                    rs.getString("status")
                );
                list.add(airplane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}