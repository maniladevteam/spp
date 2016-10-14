package com.spp.roleinfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.spp.dao.ConnectionDAO;


public class GlobalHdprDAO {


	public GlobalHdprBean userinfo(GlobalHdprBean userinfo, String uid) throws SQLException, NamingException {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Connection connection = null; 

        
        try {
        	connection = ConnectionDAO.spp_mysql().getConnection();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {

            statement = connection.prepareStatement("SELECT * FROM alluserroles WHERE username = ? LIMIT 1");
                        statement.setString(1, uid);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {

            	userinfo.setGroupname(resultSet.getString ("groupname"));            	

            }
        }catch (Exception e){
        	e.getMessage();
        	
        } finally {
        	
            try { resultSet.close(); } catch (SQLException logOrIgnore) {
            	
            }
            try { statement.close(); } catch (SQLException logOrIgnore) {}
            try { connection.close(); } catch (SQLException logOrIgnore) {}
        }

        return userinfo;
    }
	
}
