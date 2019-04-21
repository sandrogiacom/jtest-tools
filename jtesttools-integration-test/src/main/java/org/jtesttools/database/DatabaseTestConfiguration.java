package org.jtesttools.database;

import javax.sql.DataSource;

import org.jtesttools.database.exception.InvalidDatabaseVendorException;
import org.jtesttools.database.factory.DatabaseFactory;
import org.jtesttools.database.jdbc.AbstractDatabaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@TestConfiguration
public class DatabaseTestConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseTestConfiguration.class);
    AbstractDatabaseTest dbTest;
    private String dbVendor;

    @Autowired
    public DatabaseTestConfiguration() throws InvalidDatabaseVendorException {
        this.dbVendor = System.getProperty("dbVendor", "mysql");
        LOGGER.info("##########################");
        LOGGER.info("dbVendor = " + dbVendor);
        LOGGER.info("##########################");
        dbTest = DatabaseFactory.getDatabase(dbVendor);
    }

    @Bean(name = "dataSource")
    public DataSource datassssSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setDataSource(driverManagerDataSource());
        hikariConfig.setConnectionTimeout(2147483647L);
        hikariConfig.setAutoCommit(true);
        HikariDataSource ds = new HikariDataSource(hikariConfig);
        return ds;
    }

    private DriverManagerDataSource driverManagerDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(
                dbTest.getJdbcUrl(),
                dbTest.getUsername(),
                dbTest.getPassword());
        driverManagerDataSource.setDriverClassName(dbTest.getDriverClassName());
        return driverManagerDataSource;
    }

}
