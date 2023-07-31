</html>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Added Items</title>
    <link rel="stylesheet" href="style.css"/>


    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {background-color:#f5f5f5;}
    </style>
</head>
<body>

    <nav id="navbar">
        <a href="home.jsp">Home Page</a>
        <a href="/Capstone4Testing/userItems">Added Items</a>
        <a href="settings.jsp">Settings</a>
        <a href="/Capstone4Testing/LogoutServlet">Sign Out</a>
    </nav>
    
    <%@ page import="com.grocie.beans.GroceryItem" %>
	<%@ page import="java.util.List" %>
    <h1>Added Items</h1>

    <table>
        <thead>
            <tr>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Category</th>
                <th>End Date</th>
            </tr>
        </thead>
        <tbody>
            <% List<GroceryItem> items = (List<GroceryItem>) request.getAttribute("items"); %>
            <% for (GroceryItem item : items) { %>
                <tr>
                    <td><%= item.getItemName() %></td>
                    <td><%= item.getItemQuantity() %></td>
                    <td><%= item.getItemCategory() %></td>
                    <td><%= item.getEndDate() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
