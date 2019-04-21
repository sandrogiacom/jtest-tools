package org.jtesttools.database.jdbc.mysql;

import org.jtesttools.database.jdbc.AbstractDatabaseTest;
import org.testcontainers.containers.MySQLContainer;

public class MySqlDatabaseTest extends AbstractDatabaseTest {

    MySQLContainer mysql;

    public MySqlDatabaseTest() {
        mysql = new MySQLContainer()
                .withConfigurationOverride("mysql_conf_override");
        mysql.start();
        setJdbcDatabaseContainer(mysql);
    }

    @Override
    public String getDriverClassName() {
        return mysql.getDriverClassName();
    }

}
