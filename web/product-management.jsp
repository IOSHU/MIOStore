<%-- 
    Document   : product-manger
    Created on : Jun 13, 2020, 9:57:32 PM
    Author     : hieule
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product management Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <h1>Hello World this is product management page!</h1>
        <p>${sessionScope.employee.fullName.firstName}</p>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
