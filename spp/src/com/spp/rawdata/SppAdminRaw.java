package com.spp.rawdata;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.spp.dao.ConnectionDAO;

import java.util.logging.Level;
import java.util.logging.Logger;

import jxl.*;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;



public class SppAdminRaw extends HttpServlet {
       private static final long serialVersionUID = 1L;

       public SppAdminRaw() {
             super();
             // TODO Auto-generated constructor stub
       }

       protected void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
    	   
    	   	String param_view = request.getParameter("param_view");
    	   	String param_fxngroup = request.getParameter("param_fxngroup");
    	   	
    	   	String param_freqno_ = request.getParameter("param_freqno");
    	   	Integer param_freqno = Integer.parseInt(param_freqno_);
   			
    	   	String param_yearno_ = request.getParameter("param_yearno");
   			Integer param_yearno = Integer.parseInt(param_yearno_);
   			
             WritableCell cell = null;
             WritableCellFormat cf = null;
             java.sql.Connection conn = null;

             try {
            	 	conn = ConnectionDAO.spp_mysql().getConnection();
        			String sql = "call spp.spp_rawdata_download(?,?,?,?)";
        			java.sql.CallableStatement query = conn.prepareCall(sql);
	        			query.setString(1, param_view);
	        			query.setString(2, param_fxngroup);
	        			query.setInt(3, param_freqno);
	        			query.setInt(4, param_yearno);
                    java.sql.ResultSet sppraw = query.executeQuery();
       

                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition","attachment; filename=SppRaw_"+ param_view +"_"+ param_freqno +"_"+ param_yearno +".xls");
                    WritableWorkbook w = Workbook.createWorkbook(response.getOutputStream());
                    WritableSheet s = w.createSheet("SppRaw", 0);
                    WritableCellFormat cellFormat = new jxl.write.WritableCellFormat(new jxl.write.DateFormat("dd/MM/yyyy"));

                    int counter = 1;
                    s.addCell(new Label(0, 0,"Serial Number"));
                    s.addCell(new Label(1, 0,"Account"));
                    s.addCell(new Label(2, 0,"First Name"));
                    s.addCell(new Label(3, 0,"Last Name"));
                    s.addCell(new Label(4, 0,"Product"));
                    s.addCell(new Label(5, 0,"Email"));
                    s.addCell(new Label(6, 0,"Case Number"));
                    s.addCell(new Label(7, 0,"Contact Channel"));
                    s.addCell(new Label(8, 0,"Case Flag"));
                    s.addCell(new Label(9, 0,"Q1 1"));
                    s.addCell(new Label(10, 0,"Q1 2"));
                    s.addCell(new Label(11, 0,"Q1 3"));
                    s.addCell(new Label(12, 0,"Q1 4"));
                    s.addCell(new Label(13, 0,"Q1 5"));
                    s.addCell(new Label(14, 0,"Q1 6"));
                    s.addCell(new Label(15, 0,"Q1 7"));
                    s.addCell(new Label(16, 0,"Q1 8"));
                    s.addCell(new Label(17, 0,"Q1 9"));
                    s.addCell(new Label(18, 0,"Q1 10"));
                    s.addCell(new Label(19, 0,"Q1 11"));
                    s.addCell(new Label(20, 0,"Q1 12"));
                    s.addCell(new Label(21, 0,"Q1 13"));
                    s.addCell(new Label(22, 0,"Q2"));
                    s.addCell(new Label(23, 0,"Q3"));
                    s.addCell(new Label(24, 0,"Q5 Level Involvement"));
                    s.addCell(new Label(25, 0,"Q5 End User"));
                    s.addCell(new Label(26, 0,"Q4"));
                    s.addCell(new Label(27, 0,"Q4A"));
                    s.addCell(new Label(28, 0,"Alerts"));
                    s.addCell(new Label(29, 0,"Case Subject"));
                    s.addCell(new Label(30, 0,"Description"));
                    s.addCell(new Label(31, 0,"Case Origin"));
                    s.addCell(new Label(32, 0,"Case Symptom"));
                    s.addCell(new Label(33, 0,"Diagnosis"));
                    s.addCell(new Label(34, 0,"Issue Type"));
                    s.addCell(new Label(35, 0,"Content Set"));
                    s.addCell(new Label(36, 0,"Severity"));
                    s.addCell(new Label(37, 0,"Cause"));
                    s.addCell(new Label(38, 0,"Resolution Comment"));
                    s.addCell(new Label(39, 0,"Closure Code"));
                    s.addCell(new Label(40, 0,"Case Record Type"));
                    s.addCell(new Label(41, 0,"Case Record Subtype"));
                    s.addCell(new Label(42, 0,"Vip Cases Indicator"));
                    s.addCell(new Label(43, 0,"Outcome (Campaign Member)"));
                    s.addCell(new Label(44, 0,"Status (Campaign)"));
                    s.addCell(new Label(45, 0,"No Client Contact Flag"));
                    s.addCell(new Label(46, 0,"Date Time Opened"));
                    s.addCell(new Label(47, 0,"Date Time Closed"));
                    s.addCell(new Label(48, 0,"Time To 1St Call Back"));
                    s.addCell(new Label(49, 0,"Closed In 30 Minutes"));
                    s.addCell(new Label(50, 0,"Time To Close In Hrs Inc Oh"));
                    s.addCell(new Label(51, 0,"Time To Close In Hrs Exc Oh"));
                    s.addCell(new Label(52, 0,"Closure Time Buckets"));
                    s.addCell(new Label(53, 0,"Resolved In 30 Minutes"));
                    s.addCell(new Label(54, 0,"Time To Resolve In Hrs Inc Oh"));
                    s.addCell(new Label(55, 0,"Time To Resolve In Hrs Exc Oh"));
                    s.addCell(new Label(56, 0,"Resolution Time Buckets"));
                    s.addCell(new Label(57, 0,"Estimated Resolution Time Changes"));
                    s.addCell(new Label(58, 0,"Resolved in Frontline"));
                    s.addCell(new Label(59, 0,"Created By "));
                    s.addCell(new Label(60, 0,"Created By Group"));
                    s.addCell(new Label(61, 0,"Case Owner"));
                    s.addCell(new Label(62, 0,"Case Owner Emp No"));
                    s.addCell(new Label(63, 0,"Case Owner Role"));
                    s.addCell(new Label(64, 0,"Frontline Team Support"));
                    s.addCell(new Label(65, 0,"Service Restored By"));
                    s.addCell(new Label(66, 0,"Service Restored By Group"));
                    s.addCell(new Label(67, 0,"Fixed By"));
                    s.addCell(new Label(68, 0,"Fixed By Group"));
                    s.addCell(new Label(69, 0,"Centerproduct Family"));
                    s.addCell(new Label(70, 0,"Team Type"));
                    s.addCell(new Label(71, 0,"Function New Class"));
                    s.addCell(new Label(72, 0,"Directtransfer"));
                    s.addCell(new Label(73, 0,"Tsg Touched"));
                    s.addCell(new Label(74, 0,"Visit Flag"));
                    s.addCell(new Label(75, 0,"Remote Support Flag"));
                    s.addCell(new Label(76, 0,"Cst Touched"));
                    s.addCell(new Label(77, 0,"All Content touched"));
                    s.addCell(new Label(78, 0,"Primary Product"));
                    s.addCell(new Label(79, 0,"Case Product"));
                    s.addCell(new Label(80, 0,"Product Capability"));
                    s.addCell(new Label(81, 0,"Product Version"));
                    s.addCell(new Label(82, 0,"Trading"));
                    s.addCell(new Label(83, 0,"Investors"));
                    s.addCell(new Label(84, 0,"Marketplaces"));
                    s.addCell(new Label(85, 0,"Media"));
                    s.addCell(new Label(86, 0,"Segment"));
                    s.addCell(new Label(87, 0,"Sector"));
                    s.addCell(new Label(88, 0,"Business Channel"));
                    s.addCell(new Label(89, 0,"Ggo Country"));
                    s.addCell(new Label(90, 0,"Ultimate Parent Account"));
                    s.addCell(new Label(91, 0,"Account Site"));
                    s.addCell(new Label(92, 0,"Account Class"));
                    s.addCell(new Label(93, 0,"Relationship Model"));
                    s.addCell(new Label(94, 0,"Excess Flag"));
                    s.addCell(new Label(95, 0,"Region Sample"));
                    s.addCell(new Label(96, 0,"SUB REGION (SAMPLE)"));
                    s.addCell(new Label(97, 0,"Region Geographical"));
                    s.addCell(new Label(98, 0,"Country"));
                    s.addCell(new Label(99, 0,"Siebel Support Language"));
                    s.addCell(new Label(100, 0,"Assigned Interview Language"));
                    s.addCell(new Label(101, 0,"Final Interview Language"));
                    s.addCell(new Label(102, 0,"Date Of Interview"));
                    s.addCell(new Label(103, 0,"Week"));




                    while (sppraw.next()) {
                    	s.addCell(new Label(0, counter, sppraw.getString("serial_number")));
                    	s.addCell(new Label(1, counter, sppraw.getString("account")));
                    	s.addCell(new Label(2, counter, sppraw.getString("first_name")));
                    	s.addCell(new Label(3, counter, sppraw.getString("last_name")));
                    	s.addCell(new Label(4, counter, sppraw.getString("product")));
                    	s.addCell(new Label(5, counter, sppraw.getString("email")));
                    	s.addCell(new Label(6, counter, sppraw.getString("case_number")));
                    	s.addCell(new Label(7, counter, sppraw.getString("contact_channel")));
                    	s.addCell(new Label(8, counter, sppraw.getString("case_flag")));
                    	s.addCell(new Label(9, counter, sppraw.getString("q1_1")));
                    	s.addCell(new Label(10, counter, sppraw.getString("q1_2")));
                    	s.addCell(new Label(11, counter, sppraw.getString("q1_3")));
                    	s.addCell(new Label(12, counter, sppraw.getString("q1_4")));
                    	s.addCell(new Label(13, counter, sppraw.getString("q1_5")));
                    	s.addCell(new Label(14, counter, sppraw.getString("q1_6")));
                    	s.addCell(new Label(15, counter, sppraw.getString("q1_7")));
                    	s.addCell(new Label(16, counter, sppraw.getString("q1_8")));
                    	s.addCell(new Label(17, counter, sppraw.getString("q1_9")));
                    	s.addCell(new Label(18, counter, sppraw.getString("q1_10")));
                    	s.addCell(new Label(19, counter, sppraw.getString("q1_11")));
                    	s.addCell(new Label(20, counter, sppraw.getString("q1_12")));
                    	s.addCell(new Label(21, counter, sppraw.getString("q1_13")));
                    	s.addCell(new Label(22, counter, sppraw.getString("q2")));
                    	s.addCell(new Label(23, counter, sppraw.getString("q3")));
                    	s.addCell(new Label(24, counter, sppraw.getString("q5_level_involvement")));
                    	s.addCell(new Label(25, counter, sppraw.getString("q5_end_user")));
                    	s.addCell(new Label(26, counter, sppraw.getString("q4")));
                    	s.addCell(new Label(27, counter, sppraw.getString("q4a")));
                    	s.addCell(new Label(28, counter, sppraw.getString("alerts")));
                    	s.addCell(new Label(29, counter, sppraw.getString("case_subject")));
                    	s.addCell(new Label(30, counter, sppraw.getString("description")));
                    	s.addCell(new Label(31, counter, sppraw.getString("case_origin")));
                    	s.addCell(new Label(32, counter, sppraw.getString("case_symptom")));
                    	s.addCell(new Label(33, counter, sppraw.getString("diagnosis")));
                    	s.addCell(new Label(34, counter, sppraw.getString("issue_type")));
                    	s.addCell(new Label(35, counter, sppraw.getString("content_set")));
                    	s.addCell(new Label(36, counter, sppraw.getString("severity")));
                    	s.addCell(new Label(37, counter, sppraw.getString("cause")));
                    	s.addCell(new Label(38, counter, sppraw.getString("resolution_comment")));
                    	s.addCell(new Label(39, counter, sppraw.getString("closure_code")));
                    	s.addCell(new Label(40, counter, sppraw.getString("case_record_type")));
                    	s.addCell(new Label(41, counter, sppraw.getString("case_record_subtype")));
                    	s.addCell(new Label(42, counter, sppraw.getString("vip_cases_indicator")));
                    	s.addCell(new Label(43, counter, sppraw.getString("outcome")));
                    	s.addCell(new Label(44, counter, sppraw.getString("status")));
                    	s.addCell(new Label(45, counter, sppraw.getString("no_client_contact_flag")));
                    	s.addCell(new Label(46, counter, sppraw.getString("date_time_opened")));
                    	s.addCell(new Label(47, counter, sppraw.getString("date_time_closed")));
                    	s.addCell(new Label(48, counter, sppraw.getString("time_to_1st_call_back")));
                    	s.addCell(new Label(49, counter, sppraw.getString("closed_in_30_minutes")));
                    	s.addCell(new Label(50, counter, sppraw.getString("time_to_close_in_hrs_inc_oh")));
                    	s.addCell(new Label(51, counter, sppraw.getString("time_to_close_in_hrs_exc_oh")));
                    	s.addCell(new Label(52, counter, sppraw.getString("closure_time_buckets")));
                    	s.addCell(new Label(53, counter, sppraw.getString("resolved_in_30_minutes")));
                    	s.addCell(new Label(54, counter, sppraw.getString("time_to_resolve_in_hrs_inc_oh")));
                    	s.addCell(new Label(55, counter, sppraw.getString("time_to_resolve_in_hrs_exc_oh")));
                    	s.addCell(new Label(56, counter, sppraw.getString("resolution_time_buckets")));
                    	s.addCell(new Label(57, counter, sppraw.getString("estimated_resolution_time_changes")));
                    	s.addCell(new Label(58, counter, sppraw.getString("resolved_frontline")));
                    	s.addCell(new Label(59, counter, sppraw.getString("created_by_")));
                    	s.addCell(new Label(60, counter, sppraw.getString("created_by_group")));
                    	s.addCell(new Label(61, counter, sppraw.getString("case_owner")));
                    	s.addCell(new Label(62, counter, sppraw.getString("case_owner_emp_no")));
                    	s.addCell(new Label(63, counter, sppraw.getString("case_owner_role")));
                    	s.addCell(new Label(64, counter, sppraw.getString("frontline_team_support")));
                    	s.addCell(new Label(65, counter, sppraw.getString("service_restored_by")));
                    	s.addCell(new Label(66, counter, sppraw.getString("service_restored_by_group")));
                    	s.addCell(new Label(67, counter, sppraw.getString("fixed_by")));
                    	s.addCell(new Label(68, counter, sppraw.getString("fixed_by_group")));
                    	s.addCell(new Label(69, counter, sppraw.getString("centerproduct_family")));
                    	s.addCell(new Label(70, counter, sppraw.getString("team_type")));
                    	s.addCell(new Label(71, counter, sppraw.getString("function_new_class")));
                    	s.addCell(new Label(72, counter, sppraw.getString("directtransfer")));
                    	s.addCell(new Label(73, counter, sppraw.getString("tsg_touched")));
                    	s.addCell(new Label(74, counter, sppraw.getString("visit_flag")));
                    	s.addCell(new Label(75, counter, sppraw.getString("remote_support_flag")));
                    	s.addCell(new Label(76, counter, sppraw.getString("cst_touched")));
                    	s.addCell(new Label(77, counter, sppraw.getString("all_content_touched")));
                    	s.addCell(new Label(78, counter, sppraw.getString("primary_product")));
                    	s.addCell(new Label(79, counter, sppraw.getString("case_product")));
                    	s.addCell(new Label(80, counter, sppraw.getString("product_capability")));
                    	s.addCell(new Label(81, counter, sppraw.getString("product_version")));
                    	s.addCell(new Label(82, counter, sppraw.getString("trading")));
                    	s.addCell(new Label(83, counter, sppraw.getString("investors")));
                    	s.addCell(new Label(84, counter, sppraw.getString("marketplaces")));
                    	s.addCell(new Label(85, counter, sppraw.getString("media")));
                    	s.addCell(new Label(86, counter, sppraw.getString("segment")));
                    	s.addCell(new Label(87, counter, sppraw.getString("sector")));
                    	s.addCell(new Label(88, counter, sppraw.getString("business_channel")));
                    	s.addCell(new Label(89, counter, sppraw.getString("ggo_country")));
                    	s.addCell(new Label(90, counter, sppraw.getString("ultimate_parent_account")));
                    	s.addCell(new Label(91, counter, sppraw.getString("account_site")));
                    	s.addCell(new Label(92, counter, sppraw.getString("account_class")));
                    	s.addCell(new Label(93, counter, sppraw.getString("relationship_model")));
                    	s.addCell(new Label(94, counter, sppraw.getString("excess_flag")));
                    	s.addCell(new Label(95, counter, sppraw.getString("region_sample")));
                    	s.addCell(new Label(96, counter, sppraw.getString("sub_region_sample")));
                    	s.addCell(new Label(97, counter, sppraw.getString("region_geographical")));
                    	s.addCell(new Label(98, counter, sppraw.getString("country")));
                    	s.addCell(new Label(99, counter, sppraw.getString("siebel_support_language")));
                    	s.addCell(new Label(100, counter, sppraw.getString("assigned_interview_language")));
                    	s.addCell(new Label(101, counter, sppraw.getString("final_interview_language")));
                    	s.addCell(new Label(102, counter, sppraw.getString("date_of_interview")));
                    	s.addCell(new Label(103, counter, sppraw.getString("week")));


                           
                           counter++;
                    }

                    w.write();
                    w.close();
             } catch (NullPointerException g) {

             } catch (WriteException ex) {
                    Logger.getLogger(SppAdminRaw.class.getName()).log(Level.SEVERE,
                                 null, ex);
             } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
             } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
                    try {
                           if (conn != null) {
                                 conn.close();
                           }
                    } catch (SQLException ex) {
                           Logger.getLogger(SppAdminRaw.class.getName()).log(
                                        Level.SEVERE, null, ex);
                    }
             }
       }

}

