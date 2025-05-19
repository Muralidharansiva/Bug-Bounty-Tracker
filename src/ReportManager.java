import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportManager {
    public static void addReport(int programId, String title, String severity, String status, double reward) {
        String sql = "INSERT INTO reports (program_id, title, severity, status, reward, submitted_at, updated_at) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try (Connection conn = DBHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, programId);
            pstmt.setString(2, title);
            pstmt.setString(3, severity);
            pstmt.setString(4, status);
            pstmt.setDouble(5, reward);
            pstmt.setString(6, now);
            pstmt.setString(7, now);
            pstmt.executeUpdate();
            System.out.println("✅ Report added.");
        } catch (SQLException e) {
        }
    }
}
