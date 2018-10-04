<%-- 
    Document   : register
    Created on : 4-Oct-2018, 12:06:26 PM
    Author     : 763198
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            <form method="post" action="ShoppingList">
                Username: <br>
                <input type="text" name="name">
                <input type="submit" name="action" value="register">
                <br>${message}
            </form>
        </div>
    </body>
</html>
