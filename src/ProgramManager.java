import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProgramManager {
    public static void addProgram(String name, String platform, String scope) {
        String sql = "INSERT INTO programs (name, platform, scope) VALUES (?, ?, ?)";
        try (Connection conn = DBHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, platform);
            pstmt.setString(3, scope);
            pstmt.executeUpdate();
            System.out.println("✅ Program added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
