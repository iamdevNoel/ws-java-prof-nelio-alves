package jdbc.src.application;

import jdbc.src.db.DB;

public class Program {

    public static void main(String[] args) {
        DB.getConnection();
        DB.closeConnection();
    }

}
