<%-- 
    Document   : newjspshoppinglist
    Created on : 4-Oct-2018, 12:06:34 PM
    Author     : 763198
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>
            Hello ${username}!
            <br>
            <a href="ShoppingList?action=logout">Logout</a>
        </div>
        <h2>List</h2>
        <div>
            <span>${message}</span>
            <form action="ShoppingList" method="post">
                Add item: <input name="newItem" type="text">
                <input type="submit" value="add" name="action">
                
                <ul>
                    <c:forEach var="item" items="${list}" varStatus="status">
                        <li><input type="radio" value="${status.index}" name="itemIndex"><c:out value="${item}"></c:out></li>
                    </c:forEach>
                </ul>
                <input type="submit" value="delete" name="action">
            </form>
        </div>
    </body>
</html>
