<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>New User</title>
        <script src="jsSHA-2.3.1/src/sha.js" type = "text/javascript"></script>
        <script>	
                function hashPass()
                {
                    var userName = document.getElementById ("uname").value;
                    var password = document.getElementById ("pass").value;

                    var shaObj = new jsSHA("SHA-256", "TEXT");
                    shaObj.update(password);
                    var hash = shaObj.getHash("HEX");

                    document.getElementById("pass").value = hash;

                    return ok
                }
                
                function login ()
                {
                    var userName =  document.getElementById ("uname").value;
                    //hash it then pass it
                    hashPass();
                    var password = document.getElementById ("pass").value;
                    
                    var loginInfo = {
                        action: "newUser"
                        user: userName,
                        pass: password
                    };
                    
                    socket.send(JSON.stringify(loginInfo));
                
                    document.cookie = "username=" + userName;
                    
                    document.getElementById('redirect').innerHTML = "<a href=\"${pageContext.request.contextPath}/pages/MainPage.jsp\" ><h3>Login Successful. Click to continue</h3></a>";
                }
        </script>
        <style>
            body {background-color: #60d145;}
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
                background-color: #c97208;
            }
        
    </style>
    </head>
    <body>
            <div class="container">
                <h1>Please enter your username and password to create an account</h1>
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" id = "uname" required>
                <br/>
                <br/>
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="pass" id="pass" required>
                <br/>
                <br/>
                <input id = "submitButton" type="button" value="Submit" onclick="login()">
                <br/>
            </div>
            <div id ="redirect">
                
                
            </div>
    </body>
</html>
