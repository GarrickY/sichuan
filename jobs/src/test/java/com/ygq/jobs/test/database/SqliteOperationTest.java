package com.ygq.jobs.test.database;

import com.ygq.jobs.database.SqliteOperation;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteOperationTest {
    @Injectable
    private Statement statement;

    @Injectable
    private Connection connection;

    @Test
    public void testInsertData() throws SQLException, ClassNotFoundException {

        new MockUp<DriverManager>() {
            @SuppressWarnings("unused")
            @Mock
            public Connection getConnection() {
                System.out.println("mock connection.");
                return connection;
            }
        };

        new MockUp<Connection>() {
            @SuppressWarnings("unused")
            @Mock
            public Statement createStatement() {
                System.out.println("mock statement.");
                return statement;
            }
        };
        SqliteOperation db = new SqliteOperation();
        db.insertData();
    }
}
