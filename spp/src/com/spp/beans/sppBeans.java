package com.spp.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.codehaus.jettison.json.JSONObject;
import org.json.JSONArray;

import com.spp.beans.sppBeans;
import com.spp.dao.ConnectionDAO;
import com.spp.helper.ResultSetConverter;

public class sppBeans {
	
	
	public JSONArray UserInfo(String param_userid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_userinfo(?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_userid);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray AgentInfo(String param_userid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_agentinfo(?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_userid);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray UserAuditLog(String param_userid, String param_role, String param_fxnexec, String param_name) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_userauditlog(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_userid);
			query.setString(2, param_role);
			query.setString(3, param_fxnexec);
			query.setString(4, param_name);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray UserAccessKey(String param_accesskey, String param_tm_id) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_accesskey(?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_accesskey);
			query.setString(2, param_tm_id);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray UserAccessKeyCheck(String param_accesskey) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_accesskeycheck(?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_accesskey);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public void UserAccessKeyValid(String param_accesskey) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_accesskeyvalidate(?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_accesskey);
			
			rs = query.executeQuery();

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		
	}
	
	public JSONArray UserIntroInfo(String param_userid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_intro_info(?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_userid);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray UserIntroDisable(String param_userid, String param_intro) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_intro_disable(?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_userid);
			query.setString(2, param_intro);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewFreq(String param_view, Integer param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.view_freq(?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_yearno);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");
		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray ViewFreqCm(String param_view, Integer param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.view_freq_cm(?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_yearno);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");
		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray ViewUpdateDate(String param_view, String param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call updatedate()";
			query = connection.prepareCall(sql);
			
			rs = query.executeQuery();
			
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray ViewWorkgroupList(String param_tm_id) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp_assigned_workgroup(?)";
			query = connection.prepareCall(sql);
				query.setString(1, param_tm_id);
				
			rs = query.executeQuery();		
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewAgentList(String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp_assigned_agent_workgroup(?)";
			query = connection.prepareCall(sql);
				query.setString(1, param_workgroup);
				
			rs = query.executeQuery();		
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewWorkgroupInfo(String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp_workgroup_info(?)";
			query = connection.prepareCall(sql);
				query.setString(1, param_workgroup);
				
			rs = query.executeQuery();		
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");
			

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	
	public JSONArray ViewSppScore(String param_view, Integer param_freqno, Integer param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_overall_score(?,?,?)";
			query = connection.prepareCall(sql);
			 
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray ViewSppScoreGroupProdLc(String param_view, Integer param_freqno, Integer param_yearno, String param_prodlclist) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_productlcgroup_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_prodlclist);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreProdLc(String param_view, Integer param_freqno, Integer param_yearno, String param_prodlc) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_productlc_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_prodlc);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray ViewSppScoreProdLcList(String param_view, Integer param_freqno, Integer param_yearno, String param_prodlclist) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_productlc_list_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_prodlclist);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreProdLcListTimeBucket(String param_view, Integer param_freqno, Integer param_yearno, String param_prodlclist) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_productlc_list_timebucket_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_prodlclist);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreDetractSupport(String param_view, Integer param_freqno, Integer param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_overall_detractsupport_score(?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreFactorBuckets(String param_view, Integer param_freqno, Integer param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_overall_factorbuckets_score(?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	//PRODUCT FAMILY
	
	public JSONArray ViewSppScoreDetractSupportProdLc(String param_view, Integer param_freqno, Integer param_yearno, String param_prodlc) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_productlc_detractsupport_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_prodlc);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreFactorBucketsProdLc(String param_view, Integer param_freqno, Integer param_yearno, String param_prodlc) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_productlc_factorbuckets_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_prodlc);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	//WORKGROUP
	
	public JSONArray ViewSppScoreWg(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_workgroup_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	
	public JSONArray ViewSppScoreWgList(String param_view, Integer param_freqno, Integer param_yearno, String param_prodlc) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_workgroup_list_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_prodlc);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreWgTimeBucket(String param_view, Integer param_freqno, Integer param_yearno, String param_prodlc) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_workgroup_list_timebucket_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_prodlc);

			
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreDetractSupportWg(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_workgroup_detractsupport_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreFactorBucketsWg(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_workgroup_factorbuckets_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreAgTimeBucket(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_agent_list_timebucket_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);

			
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreAgList(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_agent_list_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	//Team Score
	
	public JSONArray ViewSppScoreTm(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_team_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray ViewSppScoreDetractSupportTm(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_team_detractsupport_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreFactorBucketsTm(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.`spp_team_factorbuckets_score`(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreTmAgTimeBucket(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_team_agent_list_timebucket_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);

			
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreTmAgList(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_team_agent_list_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	//Agent
	
	public JSONArray ViewSppScoreAg(String param_view, Integer param_freqno, Integer param_yearno, String param_empid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_agent_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_empid);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray ViewSppScoreDetractSupportAg(String param_view, Integer param_freqno, Integer param_yearno, String param_empid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_agent_detractsupport_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_empid);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreFactorBucketsAg(String param_view, Integer param_freqno, Integer param_yearno, String param_empid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.`spp_agent_factorbuckets_score`(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_empid);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray ViewSppScoreAgItTimeBucket(String param_view, Integer param_freqno, Integer param_yearno, String param_empid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_agent_issuetype_timebucket_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_empid);

			
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppScoreAgItList(String param_view, Integer param_freqno, Integer param_yearno, String param_empid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_agent_issuetype_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_empid);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	//RAwDATa
	
	public JSONArray ViewSppRawData(String param_view, String param_fxngroup, Integer param_freqno, Integer param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_rawdata_view(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setString(2, param_fxngroup);
			query.setInt(3, param_freqno);
			query.setInt(4, param_yearno);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
		

	public JSONArray ViewSppWgRawData(String param_view, Integer param_freqno, Integer param_yearno, String param_workgroup, String param_empid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_rawdata_wg_view(?,?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_workgroup);
			query.setString(5, param_empid);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	public JSONArray ViewSppTmRawData(String param_view, Integer param_freqno, Integer param_yearno, String param_tm_id, String param_empid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_rawdata_tm_view(?,?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_tm_id);
			query.setString(5, param_empid);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppAgRawData(String param_view, Integer param_freqno, Integer param_yearno, String param_empid) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_rawdata_ag_view(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			query.setString(4, param_empid);
			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppVerbatim(String param_serialno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_rawdata_verbatim(?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_serialno);

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	
	//CROSS MODULAR
	public JSONArray ViewSppCmOverall(String param_view, Integer param_freqno, Integer param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_overall_cm_score(?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppCmTimeBuckets(String param_view, Integer param_freqno, Integer param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_productlc_cm_list_timebucket_score(?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setInt(2, param_freqno);
			query.setInt(3, param_yearno);
			

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppCmWgOverall(String param_view, String param_profam, Integer param_freqno, Integer param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_workgroup_cm_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setString(2, param_profam);
			query.setInt(3, param_freqno);
			query.setInt(4, param_yearno);
			

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	public JSONArray ViewSppCmWgTimeBuckets(String param_view, String param_profam, Integer param_freqno, Integer param_yearno) throws SQLException, Exception {

		CallableStatement query = null;
		Connection connection = null;  
		ResultSet rs = null;
		org.json.JSONArray jason = new org.json.JSONArray();
		JSONObject success = null;
		
		try {

			connection = ConnectionDAO.spp_mysql().getConnection();
			String sql = "call spp.spp_workgroup_cm_list_timebucket_score(?,?,?,?)";
			query = connection.prepareCall(sql);
			
			query.setString(1, param_view);
			query.setString(2, param_profam);
			query.setInt(3, param_freqno);
			query.setInt(4, param_yearno);
			

			
			rs = query.executeQuery();
			
			return ResultSetConverter.convert(rs);

		} catch (SQLException e) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + e.getMessage() + "\"");
		} catch (NullPointerException ne) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ne.getMessage() + "\"");
		} catch (Exception ex) {
			success = new JSONObject("{\"error\":\"error\",\"errorReport\":" + ex.getMessage() + "\"");

		} finally {

			try {
				if (query != null)
					query.close();
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.getMessage();
			}

		}
		return null;
	}
	
	
	
	
	
}
