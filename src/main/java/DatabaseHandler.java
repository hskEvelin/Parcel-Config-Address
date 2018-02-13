package main.java;

import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class DatabaseHandler {
	private ConnectionSource connectionSource;
	private boolean initDone;
	private boolean connected;
	private static DatabaseHandler handler;

	private DatabaseHandler() {

	}

	public synchronized static DatabaseHandler getDatabaseHandler() {
		if (handler == null) {
			handler = new DatabaseHandler();
		}
		return handler;
	}

	public synchronized ConnectionSource connect(String url) {
		
		if (!connected) {
			try {
				connectionSource = new JdbcConnectionSource(url);
				System.out.println("Connected to Database");
				connected = true;
				return connectionSource;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} else
			return connectionSource;

	}

	public synchronized void initTables() {
		try {
			//TableUtils.createTableIfNotExists(connectionSource, Board.class);
			TableUtils.createTableIfNotExists(connectionSource, Zone.class);
			TableUtils.createTableIfNotExists(connectionSource, Size.class);
			TableUtils.createTableIfNotExists(connectionSource, PriceTable.class);
			TableUtils.createTableIfNotExists(connectionSource, Country.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
