<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Settings</title>
<link rel="stylesheet" href="style.css"/>
</head>
<body>

    <nav id="navbar">
        <a href="home.jsp">Home Page</a>
        <a href="/Capstone4Testing/ItemListServlet">Added Items</a>
        <a href="settings.jsp">Settings</a>
        <a href="/Capstone4Testing/LogoutServlet">Sign Out</a>
    </nav>

<form method="post" action="SettingsServlet">
    Username: <input name="usernameField" type="text"/><br>
    Current Password: <input name="currentPasswordField" type="password"/><br>
    New Password: <input name="newPasswordField" type="password"/><br>
    Confirm New Password: <input name="confirmNewPasswordField" type="password"/><br>
    <input type="submit" value="Save Changes"/>
</form>

</body>
</html>
