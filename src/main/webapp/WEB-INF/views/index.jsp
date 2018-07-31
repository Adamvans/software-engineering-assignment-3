<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SE_A2</title>
    <meta name="description" content="" />
    <script>
        var socket = new WebSocket("ws://localhost:8080/SE_A3/server");
        
        function start() 
        {
           socket.send("page");
        }
    </script>
  </head>
  <body class="">
    <h1>Congratulations! SE_A2 is ALIVE!</h1>
    <h2>You just created a Java Spring web application.</h2>
    <button onclick="test())">test</button>
  </body>
</html>
