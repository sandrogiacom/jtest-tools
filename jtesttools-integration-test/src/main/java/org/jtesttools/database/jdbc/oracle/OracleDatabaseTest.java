package org.jtesttools.database.jdbc.oracle;

import org.jtesttools.database.jdbc.AbstractDatabaseTest;
import org.testcontainers.containers.OracleContainer;

public class OracleDatabaseTest extends AbstractDatabaseTest {

    private static final String IMAGE_NAME = "pengbai/docker-oracle-12c-r1";
    OracleContainer oracle;

    public OracleDatabaseTest() {
        oracle = new OracleContainer(IMAGE_NAME);
        oracle.start();
        setJdbcDatabaseContainer(oracle);
    }

    @Override
    public String getDriverClassName() {
        return oracle.getDriverClassName();
    }

}
