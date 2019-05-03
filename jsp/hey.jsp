<%@page import ="java.sql.*"%>
<%@page import ="full1.Msqj"%>

<html>
<body>

<style>
	.login{
		margin: auto;
		margin-top: 100px;
		overflow: auto;
		height: 400px;
		width: 25%;
		background-color: #e6e6e6;
		padding: 20px;
	}

	body{
		background-color: #595959;
        overflow: auto;
	}

	.login-text{
		width: 100%;
		height: 25px;
		margin: 10px 0px;
		padding-left: 5px;
	}

	.login-btn{
		width: 100%;
		height: 30px;
		background-color: #ff9823;
		margin: 35px 0px;
		color: #ffffff;
	}

	.signin{
		text-align: center;
		font-size: 20px;
	}
</style>

<div class="login">

<%! Msqj m1 = new Msqj();%>
<%
	String s1 =request.getParameter("usr");
	String s2 = request.getParameter("psw");
	String s="",cp="<p class=\"signin\">Successful Login<br>Welcome "+s1+"</p>",wp="<p class=\"signin\">Incorrect Password. Click to go back to Login Page</p>";
	%>

	<% if(m1.chkUser(s1,s2)){
					 s = cp+"<br><a href=\"check.jsp\"><button class=\"login-btn\">GO</button></a>";
				}
				 else
					 s = wp+"<a href=\"NewFile.html\"><button class=\"login-btn\">GO</button></a>";
		s+="";
	%>
	<%= s %>
</div>
</body>
</html>



