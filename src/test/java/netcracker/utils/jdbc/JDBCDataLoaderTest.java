package netcracker.utils.jdbc;

import com.netcracker.utils.jdbc.JDBCDataLoader;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class JDBCDataLoaderTest {

    @Test
    void readAll() throws SQLException, ClassNotFoundException {
       JDBCDataLoader jdbcDataLoader = new JDBCDataLoader();
       jdbcDataLoader.readAll();
    }

}