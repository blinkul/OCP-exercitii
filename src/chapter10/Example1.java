package chapter10;

import java.sql.*;

public class Example1 {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:derby:firstDb";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet result = stmt.executeQuery("SELECT NAME FROM ANIMAL")) {

            while(result.next()) {
                System.out.println(result.getString(1));
            }

        }

    }


}
