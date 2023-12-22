package jdbc.src.application;

import jdbc.src.db.DB;
import jdbc.src.db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program4 {

    public static void main(String[] args) {

        Connection connectionDB;
        PreparedStatement preparedStatement;

        connectionDB = DB.getConnection();
        try {
            preparedStatement = connectionDB.prepareStatement(
                    "DELETE FROM department WHERE Id = ?"
            );
            preparedStatement.setInt(1, 2);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeConnection();
        }

    }

}
