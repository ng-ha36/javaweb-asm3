<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <title>Form Sign In</title>
</head>

<body>
    <div class="container">
        <div class="left">
            <form action="login" method = "post">
                <h1 class="sign">Sign in</h1>
				<p> ${mess}</p>
                <input type="email" name="user" class="form-control" placeholder="Email" />

                <input type="password" name="pass" class="form-control" placeholder="Password" /><br>

                <a href="#" class="pass"><span class="center">Forgot your password?</span></a><br>

                <button type="submit">LOGIN</button>
                
            </form>
        </div>
        <div class="right">
            <h1>Welcome Back!</h1>
            <p>To keep connected with us<br>
                please login with your personal<br>
                info</p>
        </div>
    </div>
</body>

</html>