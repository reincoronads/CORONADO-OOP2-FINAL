package config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbConnector {
    private static HikariDataSource dataSource;
    
    // Static initializer to configure the connection pool
    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/gymdb");
        config.setUsername("root");
        config.setPassword("");
        
        // Connection pool configuration (adjust these values as needed)
        config.setMaximumPoolSize(100);          // Maximum number of connections
        config.setMinimumIdle(5);               // Minimum idle connections
        config.setConnectionTimeout(30000);     // 30 seconds
        config.setIdleTimeout(600000);         // 10 minutes
        config.setMaxLifetime(1800000);        // 30 minutes
        config.setAutoCommit(true);
        
        // MySQL-specific optimizations
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
        
        dataSource = new HikariDataSource(config);
    }

    // Get a connection from the pool
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Function to retrieve data
    public ResultSet getData(String sql) throws SQLException {
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(sql);
        // Note: The caller is now responsible for closing the connection
    }

    // Function to save data
    public int insertData(String sql) {
        try (Connection connection = getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
            return 1;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            return 0;
        }
    }

    // Function to update data
    public void updateData(String sql) {
        try (Connection connection = getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            } else {
                System.out.println("Data Update Failed!");
            }
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
        }
    }

    public int getCount(String sql) throws SQLException {
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    // Test the database connection
    public void testConnection() {
        try (Connection connection = getConnection()) {
            System.out.println("Database connection is successful!");
        } catch (SQLException ex) {
            System.out.println("Failed to connect to the database.");
            ex.printStackTrace();
        }
    }
    
    // Shutdown the connection pool when application exits
    public static void shutdown() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}