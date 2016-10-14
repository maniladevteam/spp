

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.spp.helper.SSO_Validation" %>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Date" %>

<%

SSO_Validation validator = new SSO_Validation();

 

String digest = request.getParameter("digest");

String time = request.getParameter("time");

String uid = request.getParameter("uid");


if (digest == null || session == null) {


%>

<script type="text/javascript">



    window.location.href="https://safe.thomson.com/login/sso/SSOService?app=servicePulsePortal";

</script>


<%

}
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"

   "http://www.w3.org/TR/html4/loose.dtd">

<%

    // Validate SAFE


    if (digest != null && time != null && uid != null && !validator.verify(uid, time, digest, "VHjk5sVB83ke4LGR")) {

%>

<html>

    <head>

    <title>Login Page</title>

    </head>

    <body>

        <h1>Invalid Authentication</h1>

        Somebody may be attempting access without SAFE authentication.

    </body>

</html>

<%

    }

    else {

%>

<html>

<head>

    <title>Login Page</title>

</head>

<body>

    <form id="loginForm" method="POST" action="j_security_check">

        <input type="hidden" size="15" maxlength="25" name="j_username" value="<%=request.getParameter("uid")%>"><br><br>

        <input type="hidden" size="15" maxlength="25" name="j_password" value="hdpr"><br><br>

        <script type="text/javascript">document.getElementById('loginForm').submit();</script>

    </form>

</body>

</html>

<%

    }

%>