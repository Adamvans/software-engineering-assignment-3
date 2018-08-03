<%-- 
    Document   : LoginForm
    Created on : Jul 30, 2018, 8:52:51 PM
    Author     : dexte
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Login</title>
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
        </script>
    </head>
    <body>
        <form onsubmit="hashPass()"action="/login.php" method = "post">
	
            <div class="container">
                <h1>Please enter your username and password to login</h1>
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" id = "uname" required>
                <br/>
                <br/>
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="pass" id="pass" required>
                <br/>
                <br/>
                <button type="submit">Login</button>
            </div>
	</form>
    </body>
</html>
