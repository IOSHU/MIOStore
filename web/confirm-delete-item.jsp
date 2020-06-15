<%-- 
    Document   : confirm-delete-item
    Created on : Jun 14, 2020, 4:43:27 PM
    Author     : hieule
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <h1>Confirm delete item</h1>
        <form action="delete" method="POST">
            <input type="hidden" name="item-id" value="${item.id}" name="item-id" >
            <table>
                <tr>
                    <td>Name: ${item.name}</td>
                </tr>
                <tr>
                    <td>Price: ${item.price}</td>
                </tr>
                <tr>
                    <td>Quantity: ${item.quantity}</td>
                </tr>
                <tr>
                    <td>Image path: ${item.imagePath}</td>
                </tr>
                <tr>
                    <td>Description ${item.description}</td>
                </tr>
            </table>
            <input type="submit" name="delete" value="Delete" >
        </form>
       
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
