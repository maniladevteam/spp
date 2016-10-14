package com.spp.controller;

import java.sql.SQLException;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;
import org.json.JSONArray;

import com.spp.beans.*;

@Path("/action-spp")
public class sppController {
	@POST
	@Produces(MediaType.TEXT_HTML)
	public String Status() {
		return "You are running the ";
	}
	
	@Path("/userinfo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrUserInfo(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_userid = json.optString("param_userid", "");
		

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.UserInfo(param_userid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/agentinfo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrAgentInfo(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_userid = json.optString("param_userid", "");
		

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.AgentInfo(param_userid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/userauditlog")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrUserAuditLog(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_userid = json.optString("param_userid", "");
			String param_role = json.optString("param_role", "");
			String param_fxnexec = json.optString("param_fxnexec", "");
			String param_name = json.optString("param_name", "");

		

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.UserAuditLog(param_userid, param_role, param_fxnexec, param_name);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	@Path("/useraccesskey")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrUserAccessKey(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_accesskey = json.optString("param_accesskey", "");
			String param_tm_id = json.optString("param_tm_id", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.UserAccessKey(param_accesskey, param_tm_id);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/useraccesskeycheck")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrUserAccessKeyCheck(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_accesskey = json.optString("param_accesskey", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.UserAccessKeyCheck(param_accesskey);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/useraccesskeyvalid")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrUserAccessKeyValid(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_accesskey = json.optString("param_accesskey", "");
			
			sppBeans sppBean = new sppBeans();
			sppBean.UserAccessKeyValid(param_accesskey);
			
			//rb = Response.ok(JSONreturn.toString()).build();
			return rb = Response.ok("{\"update\":\"updated\"}").build();

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	@Path("/userintroinfo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrUserIntroInfo(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_userid = json.optString("param_userid", "");

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.UserIntroInfo(param_userid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	@Path("/userintrodisable")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrUserIntroDisable(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_userid = json.optString("param_userid", "");
			String param_intro = json.optString("param_intro", "");

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.UserIntroDisable(param_userid, param_intro);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}

	@Path("/viewfreq")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewFreq(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewFreq(param_view, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	@Path("/viewfreqcm")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewFreqCm(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewFreq(param_view, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppupdatedate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppUpdateDate(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_yearno = json.optString("param_yearno", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewUpdateDate(param_view, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppworkgrouplist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewWorkgroupList(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_tm_id = json.optString("param_tm_id", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewWorkgroupList(param_tm_id);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();
	}
	
	
	@Path("/sppagentlist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewAgentList(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_workgroup = json.optString("param_workgroup", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewAgentList(param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();
	}
	
	
	@Path("/sppworkgroupinfo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewWorkgroupInfo(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_workgroup = json.optString("param_workgroup", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewWorkgroupInfo(param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	

	@Path("/sppscore")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScore(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScore(param_view, param_freqno, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	@Path("/sppscoregroupprodlc")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreGroupProdLc(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_prodlclist= json.optString("param_prodlclist", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreGroupProdLc(param_view, param_freqno, param_yearno, param_prodlclist);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoreprodlclist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreProdLcList(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_prodlclist= json.optString("param_prodlclist", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreProdLcList(param_view, param_freqno, param_yearno, param_prodlclist);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoreprodlclisttimebucket")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreProdLcListTimeBucket(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_prodlclist= json.optString("param_prodlclist", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreProdLcListTimeBucket(param_view, param_freqno, param_yearno, param_prodlclist);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoredetractsupport")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreDetractSupport(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreDetractSupport(param_view, param_freqno, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscorefactorbuckets")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreFactorBuckets(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreFactorBuckets(param_view, param_freqno, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	//PRODUCT FAMILY
		
	@Path("/sppscoreprodlc")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreProdLc(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_prodlc= json.optString("param_prodlc", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreProdLc(param_view, param_freqno, param_yearno, param_prodlc);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoredetractsupportprodlc")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreDetractSupportProdLc(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_prodlc = json.optString("param_prodlc", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreDetractSupportProdLc(param_view, param_freqno, param_yearno, param_prodlc);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscorefactorbucketsprodlc")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreFactorBucketsProdLc(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_prodlc = json.optString("param_prodlc", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreFactorBucketsProdLc(param_view, param_freqno, param_yearno, param_prodlc);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	
	///WORKGROUP
	
	
	@Path("/sppscorewg")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreWg(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_workgroup = json.optString("param_workgroup", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreWg(param_view, param_freqno, param_yearno, param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	@Path("/sppscorewglist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreWgList(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_prodlc= json.optString("param_prodlc", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreWgList(param_view, param_freqno, param_yearno, param_prodlc);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscorewgtimebucket")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreWgListTimeBucket(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_prodlc= json.optString("param_prodlc", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreWgTimeBucket(param_view, param_freqno, param_yearno, param_prodlc);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoredetractsupportwg")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreDetractSupportWg(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_workgroup = json.optString("param_workgroup", "");

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreDetractSupportWg(param_view, param_freqno, param_yearno, param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscorefactorbucketswg")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreFactorBucketsWg(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_workgroup = json.optString("param_workgroup", "");

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreFactorBucketsWg(param_view, param_freqno, param_yearno, param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoreagtimebucket")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreAgListTimeBucket(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_workgroup= json.optString("param_workgroup", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreAgTimeBucket(param_view, param_freqno, param_yearno, param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	
	
	@Path("/sppscoreaglist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreAgList(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_workgroup= json.optString("param_workgroup", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreAgList(param_view, param_freqno, param_yearno, param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	//TEAM SCORE
	
	@Path("/sppscoretm")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreTm(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_workgroup= json.optString("param_workgroup", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreTm(param_view, param_freqno, param_yearno, param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	
	
	@Path("/sppscoredetractsupporttm")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreDetractSupportTm(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_workgroup = json.optString("param_workgroup", "");

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreDetractSupportTm(param_view, param_freqno, param_yearno, param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscorefactorbucketstm")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreFactorBucketsTm(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_workgroup = json.optString("param_workgroup", "");

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreFactorBucketsTm(param_view, param_freqno, param_yearno, param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoretmagtimebucket")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreTmAgTimeBucket(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_workgroup= json.optString("param_workgroup", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreTmAgTimeBucket(param_view, param_freqno, param_yearno, param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	
	
	@Path("/sppscoretmaglist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreTmAgList(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_workgroup= json.optString("param_workgroup", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreTmAgList(param_view, param_freqno, param_yearno, param_workgroup);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	//AGENT
	
	
	@Path("/sppscoreag")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreAg(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_empid= json.optString("param_empid", "");
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreAg(param_view, param_freqno, param_yearno, param_empid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	
	@Path("/sppscoredetractsupportag")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreDetractSupportAg(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_empid = json.optString("param_empid", "");

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreDetractSupportAg(param_view, param_freqno, param_yearno, param_empid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscorefactorbucketsag")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreFactorBucketsAg(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			String param_empid = json.optString("param_empid", "");

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreFactorBucketsAg(param_view, param_freqno, param_yearno, param_empid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	@Path("/sppscoretmagittimebucket")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreAgItTimeBucket(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_empid= json.optString("param_empid", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreAgItTimeBucket(param_view, param_freqno, param_yearno, param_empid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoreagitlist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppScoreAgItList(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_empid= json.optString("param_empid", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppScoreAgItList(param_view, param_freqno, param_yearno, param_empid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}

	//RAW DATA
	
	@Path("/sppscorerawdata")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppRawData(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_fxngroup = json.optString("param_fxngroup", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppRawData(param_view, param_fxngroup, param_freqno, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();
	}
	
	
	
	@Path("/sppscorewgrawdata")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppWgRawData(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_workgroup = json.optString("param_workgroup", "");
			String param_empid = ((json.optString("param_empid", "")).equals("") ? "0" :  json.optString("param_empid", "0"));
			
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppWgRawData(param_view, param_freqno, param_yearno, param_workgroup, param_empid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoretmrawdata")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppTmRawData(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_tm_id = json.optString("param_workgroup", "");
			String param_empid = ((json.optString("param_empid", "")).equals("") ? "0" :  json.optString("param_empid", "0"));
			
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppTmRawData(param_view, param_freqno, param_yearno, param_tm_id, param_empid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoreagrawdata")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppAgRawData(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_tm_id = json.optString("param_workgroup", "");
			String param_empid = ((json.optString("param_empid", "")).equals("") ? "0" :  json.optString("param_empid", "0"));
			
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppAgRawData(param_view, param_freqno, param_yearno, param_empid);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscoreviewverbatim")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppVerbatim(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_serialno = json.optString("param_serialno", "");
		

			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppVerbatim(param_serialno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	@Path("/sppcmscore")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppCmOverall(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppCmOverall(param_view, param_freqno, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscorecmtimebucket")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppCmTimeBuckets(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppCmTimeBuckets(param_view, param_freqno, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	@Path("/sppcmwgscore")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppCmWgOverall(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_prodfam = json.optString("param_prodfam", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppCmWgOverall(param_view, param_prodfam, param_freqno, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	
	
	@Path("/sppscorecmwgtimebucket")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response CtrViewSppCmWgTimeBuckets(String DATA) {
		boolean success = false;
		try {
			Response rb = null;
                        
			JSONObject json = new JSONObject(DATA);
			String param_view = json.optString("param_view", "");
			String param_prodfam = json.optString("param_prodfam", "");
			String param_freqno_= ((json.optString("param_freqno", "")).equals("") ? "0" :  json.optString("param_freqno", "0"));
			Integer param_freqno = Integer.parseInt(param_freqno_);
			String param_yearno_= ((json.optString("param_yearno", "")).equals("") ? "0" :  json.optString("param_yearno", "0"));
			Integer param_yearno = Integer.parseInt(param_yearno_);
			
			sppBeans sppBean = new sppBeans();
			JSONArray JSONreturn = sppBean.ViewSppCmWgTimeBuckets(param_view, param_prodfam, param_freqno, param_yearno);
			
			rb = Response.ok(JSONreturn.toString()).build();

			return rb;

		} catch (NullPointerException h) {

			return Response.status(400).entity("You have empty parameter").build();

		} catch (Exception e) {
			Response.ok("{\"error\":\"" + e.getMessage() + "\"}").build();
		} finally {
			success = false;
		}

		return Response.status(500)
				.entity("{\"error\":\"There was an error on the code kindly contact marangelo.delatorre@thomsonreuters.com\"}")
				.build();

	}
	


}
