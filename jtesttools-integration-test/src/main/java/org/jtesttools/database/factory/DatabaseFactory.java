package org.jtesttools.database.factory;

import org.jtesttools.database.DataBaseVendor;
import org.jtesttools.database.exception.InvalidDatabaseVendorException;
import org.jtesttools.database.jdbc.AbstractDatabaseTest;
import org.jtesttools.database.jdbc.mysql.MySqlDatabaseTest;
import org.jtesttools.database.jdbc.oracle.OracleDatabaseTest;
import org.jtesttools.database.jdbc.postgresql.PostgresDatabaseTest;

public class DatabaseFactory {

    public static AbstractDatabaseTest getDatabase(String dbVendor) throws InvalidDatabaseVendorException {
        DataBaseVendor vendor = DataBaseVendor.of(dbVendor);

        switch (vendor) {
            case MYSQL:
                return new MySqlDatabaseTest();
            case ORACLE:
                return new OracleDatabaseTest();
            case POSTGRESQL:
                return new PostgresDatabaseTest();
            default:
                throw new InvalidDatabaseVendorException(dbVendor + " is not supported!");
        }
    }
}
