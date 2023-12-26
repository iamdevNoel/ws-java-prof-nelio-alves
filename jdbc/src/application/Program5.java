package jdbc.src.application;
/*
    Este script mostra uma situação de transaction, na qual deseja-se que execute tudo ou nada.
    Existem algumas situações em que não se pode executar tarefas pela metade.
    Por exemplo: uma transferência bancária. Caso ocorra um erro no sistema,
    o dinheiro não pode sair da minha conta sem aparecer na conta da outra pessoa,
    assim como o dinheiro não pode aparecer na conta da outra pessoa sem ter saído da minha.
 */
import jdbc.src.db.DB;
import jdbc.src.db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Program5 {

    public static void main(String[] args) {

        Connection DbConnection = DB.getConnection();
        try {
            // Desligando o commit automático. Agora, todas as alterações ficarão aguardando uma confirmação.
            DbConnection.setAutoCommit(false);

            Statement statement = DbConnection.createStatement();

            int rows1 = statement.executeUpdate(
                    "UPDATE seller " +
                    "SET BaseSalary = 2090 " +
                    "WHERE DepartmentId = 1"
            );

            // Utilize este comando caso queira simular um erro no meio de uma tarefa,
            // para comprovar que ela não será executada pela metade.
            /* if (1 < 2) {
                throw new SQLException("Simulacao de erro a");
            } */

            int rows2 = statement.executeUpdate(
                    "UPDATE seller " +
                        "SET BaseSalary = 3090 " +
                        "WHERE DepartmentId = 2"
            );

            // Commit confirmando todas as alterações.
            // Note que propositalmente o comando de commit fica no final de tudo.
            DbConnection.commit();

            System.out.println("Done! Rows affected: " + (rows1 + rows2));
        } catch (SQLException e) {
            // bloco try dentro de um catch pois o rollback precisa ficar aqui,
            // e ele exige tratamento de exceção
            try {
                // Caso a linha do comando .commit() não seja executada, ou seja,
                // caso ocorra um erro, este bloco catch é acionado
                // e dentro dele acionamos o comando rollback(), que desfaz as alterações até aqui
                DbConnection.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException rollbackException) {
                throw new DbException("Failed to rollback! Caused by: " + rollbackException.getMessage());
            }
        }

    }

}
