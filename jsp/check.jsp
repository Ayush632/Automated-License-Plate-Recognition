<%@page import ="full1.Msqj,java.sql.*"%>
<html>
<head>
<title>Insert title here</title>
</head>
<style>
    .login{
        margin: auto;
        margin-top: 100px;
        height: 250px;
        width: 80%;
        background-color: #ffffff;
        padding: 20px;
    }

    body{
        background-color: #595959;
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
        background-color: #454545;
        margin: 35px 0px;
        color: #ffffff;
    }

    .signin{
        text-align: center;
        font-size: 20px;
    }

    table {
        width:60%;
        margin:auto;
    }
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    table#t01 tr:nth-child(even) {
        background-color: #eee;
    }
    table#t01 tr:nth-child(odd) {
        background-color: #fff;
    }
    table#t01 th {
        background-color: black;
        color: white;
    }
</style>
<body>
<%! Msqj m1 = new Msqj(); 
	String s11 = "";
%>
<% s11= m1.shCars(); %>
<div class="login">
<p class ="signin">Parking Lot Entries</p>
<%=s11 %>
</div>
</body>
</html>