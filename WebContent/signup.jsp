<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>

<link rel="stylesheet" href="style.css"/>

</head>
<body>
    <form action="/Capstone4Testing/SignupServlet" method="post" class="formElement">
        <label for="fname">First Name:</label><br>
        <input type="text" id="fname" name="fname"><br>
        <label for="lname">Last Name:</label><br>
        <input type="text" id="lname" name="lname"><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email"><br>
        <label for="username">Username:</label><br>
        <input type="text" id="username" name="username"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Submit">
        </form>
</body>
</html>