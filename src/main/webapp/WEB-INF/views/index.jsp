<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SE_A3</title>
    <meta name="description" content="" />
    
    <script>
        var socket = new WebSocket("ws://localhost:8080/SE_A3/server");
        
        socket.onmessage = function (event)  
        {
            document.getElementById("answer").value += "</br>" + event;
        }
        
        function test() 
        {
           document.getElementById("answer").value = "sending";
           socket.send("page");
        }
        
        
    </script>
     <style>
        body {background-color: #60d145}
        a:link, a:visited {
            background-color: lightgrey;
            color: black;
            padding: 2px 5px;
            text-align: center; 
            text-decoration: none;
            display: inline-block;
            border-style: solid;
            border-width: 2px;
        }

        a:hover, a:active {
            background-color: grey;
        }
        
    </style>
  </head>
  <body class="">
    <h1>Welcome to the Stock Tracker</h1>
    <h2>Please select if you are a new or returning user</h2>
    <a href="${pageContext.request.contextPath}/pages/NewUser.jsp" >New User</a>
    <a href="${pageContext.request.contextPath}/pages/LoginForm.jsp" >Returning User</a>
    <button onclick="test())">test</button>
    <h2><span id = "answer"></span></h2>
  </body>
</html>
