<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styletwo.css">
</head>
<body>
    <nav id="navbar">
        <a href="home.jsp">Home Page</a>
        <a href="/Capstone4Testing/ItemListServlet">Added Items</a>
        <a href="settings.jsp">Settings</a>
        <a href="/Capstone4Testing/LogoutServlet">Sign Out</a>
    </nav>
    <main>
        <h1>Grocery List</h1>
        <div id="grocery-list">
            <form action="addItem" method="post">
                <input type="date" id="end-date" name="end-date">
                <input type="text" id="item-name" name="item-name" placeholder="Item name">
                <input type="number" id="item-quantity" name="item-quantity" placeholder="Quantity">
                <input type="text" id="item-category" name="item-category" placeholder="Category">
                <button type="submit">Add Item</button>
            </form>
        </div>
    </main>
</body>
</html>
