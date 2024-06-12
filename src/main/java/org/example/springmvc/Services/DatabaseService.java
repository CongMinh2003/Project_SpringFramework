package org.example.springmvc.Services;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DatabaseService {
    protected SQLServerDataSource getDataSource() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("15102003");
        ds.setServerName("DESKTOP-U3TL1QN\\SQLEXPRESS02");
        ds.setPortNumber(1433);
        ds.setDatabaseName("Hipstershop");
        ds.setTrustServerCertificate(true);

        return ds;
    }
}
