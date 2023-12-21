package jdbc.src.application;

import jdbc.src.db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program3 {

    public static void main(String[] args) {

        Connection connectionDB;
        PreparedStatement preparedStatement;

        try {
            connectionDB = DB.getConnection();

            preparedStatement = connectionDB.prepareStatement(
                    "UPDATE seller " +
                        // A lógica aqui é incrementar o salário atual, por isso BaseSalary = BaseSalary + aumento
                        "SET BaseSalary = BaseSalary + ? " +
                        "WHERE DepartmentID = ?"
            );

            preparedStatement.setDouble(1, 200);
            preparedStatement.setInt(2, 2);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
