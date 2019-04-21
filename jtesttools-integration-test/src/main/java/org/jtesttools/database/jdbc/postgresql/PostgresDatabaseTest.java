package org.jtesttools.database.jdbc.postgresql;

import org.jtesttools.database.jdbc.AbstractDatabaseTest;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresDatabaseTest extends AbstractDatabaseTest {

    PostgreSQLContainer postgresql;

    public PostgresDatabaseTest() {
        postgresql = new PostgreSQLContainer();
        postgresql.start();
        setJdbcDatabaseContainer(postgresql);
    }

    @Override
    public String getDriverClassName() {
        return postgresql.getDriverClassName();
    }

}
