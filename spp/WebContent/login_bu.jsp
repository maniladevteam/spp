<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>iPerform</title>
<link rel="stylesheet" type="text/css" href="css/jquery.ui.all.css"/>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<script src="js/jquery-1.10.2.min.js" ></script>		
<script src="js/jquery-1.9.1.js"></script>
<script src="ui/jquery.ui.core.js"></script>
<script src="ui/jquery.ui.widget.js"></script>
<script src="ui/jquery.ui.mouse.js"></script>
<script src="ui/jquery.ui.button.js"></script>
<script src="ui/jquery.ui.draggable.js"></script>
<script src="ui/jquery.ui.position.js"></script>
<script src="ui/jquery.ui.resizable.js"></script>
<script src="ui/jquery.ui.dialog.js"></script>
<script src="ui/jquery.ui.effect.js"></script>

<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
<script type="text/javascript"src="js/jquery.tablesorter.widgets.js"></script>


</head>
<body>

<form method="post" action="j_security_check">
    <table>
    <tr><td>Username: </td><td><input type="text" name="j_username" /></td><td><i>Your Employee Number</i></td></tr>
    <tr><td>Password: </td><td><input type="password" name="j_password" /></td><td><i>default password is : hdpr</i></td></tr>
    <tr><td><input type="submit" value="Login" /></td></tr>
    </table>
</form>
</body>
</html>