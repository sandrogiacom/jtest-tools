package org.jtesttools.database;


import org.jtesttools.database.exception.InvalidDatabaseVendorException;

public enum DataBaseVendor {

    ORACLE("oracle"),
    MYSQL("mysql"),
    POSTGRESQL("postgresql");

    DataBaseVendor(String dbVendor) {
    }

    public static DataBaseVendor of(String dbVendor) throws InvalidDatabaseVendorException {
        switch (dbVendor) {
            case "oracle":
                return ORACLE;
            case "mysql":
                return MYSQL;
            case "postgresql":
                return POSTGRESQL;
            default:
                throw new InvalidDatabaseVendorException("dbVendor must be [oracle, mysql or postgresql])");
        }
    }
}
