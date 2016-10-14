package com.spp.roleinfo;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * Servlet implementation class OpenbookServlet
 */

public class GlobalHdprServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GlobalHdprServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		java.sql.Connection conn = null;

		String uid = request.getRemoteUser();
		
		GlobalHdprDAO GlobalHdprDAO = new GlobalHdprDAO();
		
		try {
			HttpSession session = request.getSession();

			GlobalHdprBean userinfo = new GlobalHdprBean();
			userinfo = GlobalHdprDAO.userinfo(userinfo, uid);
 
			request.setAttribute("userinfo", userinfo);

			userinfo.setUid(uid);
			session.setAttribute("groupname", userinfo.getGroupname());
			
			String role = userinfo.getGroupname();

			if (role.equals("admin")) {
				request.getRequestDispatcher("admin.jsp").forward(request,
						response);
			} else if (role.equals("team_manager")) {
				request.getRequestDispatcher("workgroup.jsp").forward(request,
						response);
			} else if (role.equals("admin_content")) {
				request.getRequestDispatcher("content.jsp").forward(request,
						response);
			} else if (role.equals("admin_risk")) {
				request.getRequestDispatcher("risk.jsp").forward(request,
						response);
			}else if (role.equals("team_managerrisk")) { 
				request.getRequestDispatcher("workgrouprisk.jsp").forward(request,
						response);
			}else if (role.equals("specialist")) { 
				request.getRequestDispatcher("agent.jsp").forward(request,
						response);
			}
			

		} catch (SQLException | NamingException | NullPointerException e) {
			throw new ServletException("Cannot retrieve areas" + uid, e);
		}finally {
			if (conn == null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
