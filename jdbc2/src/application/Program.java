package jdbc2.src.application;

import jdbc2.src.db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args) {
        // variável para o Java se conectar com o banco de dados, conforme login no arquivo db.properties
        Connection connection;
        // variável para armazenar uma instrução SQL
        Statement statement;
        // variável para armazenar o resultado (query) retornado de uma instrução SQL
        ResultSet resultSet;

        try {
            connection = DB.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from department");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id") + ", " + resultSet.getString("Name"));
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        } finally {
            DB.closeConnection();
        }

    }

}
