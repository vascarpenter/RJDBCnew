package info.urbanek.Rpackage.RJDBC;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OracleConnection;
import java.sql.DatabaseMetaData;

public class JDBCGetConnectionOracle {
	public java.sql.Connection getConnection(String url, String user, String password)
	{
        Properties info = new Properties();
        info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, user);
        info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, password);
//		info.put(OracleConnection.CONNECTION_PROPERTY_TNS_ADMIN, System.getenv("TNS_ADMIN"));
		info.put(OracleConnection.CONNECTION_PROPERTY_TNS_ADMIN, "/opt/oracle/network/admin");

		OracleDataSource ods = null;
		try {
			ods = new OracleDataSource();
			ods.setURL(url);
			ods.setConnectionProperties(info);

			//System.out.println("Called:URL " + url);

			Connection c = ods.getConnection();
			return c;

		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return null;
		}
	}
}