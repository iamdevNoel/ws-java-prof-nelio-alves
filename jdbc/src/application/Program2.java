package jdbc.src.application;

import jdbc.src.db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program2 {

    public static void main(String[] args) {

        //DateFormatter que funciona com o Date do import sql. O java.sql.Date não é igual ao java.util.Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                "INSERT INTO seller"
                    + " (Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + " VALUES"
                    // ? == placeholders, espaços vazios que serão preenchidos posteriormente
                    + " (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS // parâmetro para retornar ID da informação inserida no BD
            );

            // Sequência de instruções para substituir os placeholders, conforme seus IDs
            preparedStatement.setString(1, "Gabriel Noberto");
            preparedStatement.setString(2, "contato.gabrielnoberto@gmail.com");
            preparedStatement.setDate(3, new Date(dateFormat.parse("29/05/1999").getTime()));
            preparedStatement.setDouble(4, 2000.00);
            preparedStatement.setInt(5, 4);

            /* Método executeUpdate() insere as instruções no BD
            ** Esse método retorna um int, linhas afetadas pelo método */
            int rowsAffected = preparedStatement.executeUpdate();

            /*
            ** Exibir dados de informações inseridas no BD
            ** Guardar as alterações feitas em um ResultSet
            ** Imprimir o conteúdo da coluna 1 da tabela (Index),
            ** demonstrando qual foi o índice inserido recentemente
            */
            if (rowsAffected > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("Done! Inserted Id info: " + id);
                }
            } else {
                System.out.println("No rows affected.");
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeConnection();
        }

    }

}
