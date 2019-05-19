package pl.warehouse.dao;

import pl.warehouse.model.Tool;
import pl.warehouse.model.ToolType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToolDaoImpl implements ToolDao {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/warehouse?serverTimezone=GMT&useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "afEq19eKSmWTl72yMcKx";

    public List<Tool> getAllTools() {

        List<Tool> tools = new ArrayList<>();

        String selectSQL = "SELECT * FROM tools";

        try (Connection dbConnection = getDBConnection(); PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Long toolId = rs.getLong("id");
                String toolName = rs.getString("name");
                ToolType toolType = ToolType.valueOf(rs.getString("type"));
                int toolQty =rs.getInt("qty");
                boolean toolAvailability = rs.getBoolean("available");

                tools.add(new Tool(toolName, toolId, toolType, toolQty, toolAvailability));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tools;
    }

    public void setAvailability(Long id, boolean availability) {
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER,DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }
}
