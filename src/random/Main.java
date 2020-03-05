package random;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public void read() throws SQLException {
        try {
            readFromDb();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void readFromDb() throws SQLException {
        throw new SQLException();
    }


}


