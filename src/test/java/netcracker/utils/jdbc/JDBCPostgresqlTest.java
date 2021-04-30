package netcracker.utils.jdbc;

import com.netcracker.utils.jdbc.JDBCPostgresql;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCPostgresqlTest {

    public static JDBCPostgresql jdbcPostgresql;

    @Test
    public void shouldGetJdbcConnection() throws SQLException {
        jdbcPostgresql = new JDBCPostgresql();
        try(Connection connection = jdbcPostgresql.getNewConnection()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }
    }

    @Before
    public void init() throws SQLException {
        jdbcPostgresql = (JDBCPostgresql) jdbcPostgresql.getNewConnection();
    }
    @After
    public void close() throws SQLException {
        jdbcPostgresql.getConnection().close();
    }

}