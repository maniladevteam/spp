package com.spp.dao;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;

public class ConnectionDAO {
	private static DataSource sppDS = null;
	private static Context sppContext = null;

	public static DataSource spp_mysql() throws Exception {
		if (sppDS != null) {
			return sppDS;
		}

		try {
			if (sppContext == null) {
				sppContext = new InitialContext();
			}

			sppDS = (DataSource) sppContext.lookup("jdbc/spp_mysql");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return sppDS;
	}

	protected static Connection LocalDbConnect() {
		Connection conn = null;
		try {
			conn = spp_mysql().getConnection();
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
