<%-- 
    Document   : item-management
    Created on : Jun 14, 2020, 12:11:06 PM
    Author     : hieule
--%>

<%@page import="model.product.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item management Page</title>
        <script src="libs/jquery-3.5.1.min.js"></script>
        <!--<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.js"></script>-->
        <style>
            form {
                margin: auto;
                text-align: left;
                font-family: arial;
                width: 40%;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <h1 style="margin: auto; width: 40%">Item management</h1>
        <%
            try{
                int index = Integer.parseInt(request.getParameter("index"));
                Item[] items = (Item[]) session.getAttribute("items");
                session.setAttribute("item", items[index]);
                request.setAttribute("action", "update");
                System.out.println(items[index].toString());
            } catch (Exception e) {
                request.setAttribute("action", "add");
                session.setAttribute("item", null);
            }
        %>
        <div>
            <form action="${requestScope.action}" method="POST" enctype="multipart/form-data">
                <input type="hidden" id="item-id" name="item-id" value="${sessionScope.item.id}" >
                <table>
                    <tr>
                        <td>Name:</td>
                        <td>
                            <input type="text" id="item-name" name="item-name" value="${sessionScope.item.name}" >
                        </td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td>
                            <input type="text" id="item-price" name="item-price" value="${sessionScope.item.price}" >
                        </td>
                    </tr>

                    <tr>
                        <td>Quantity:</td>
                        <td>
                            <input type="text" id="item-quantity" name="item-quantity" value="${sessionScope.item.quantity}" >
                        </td>
                    </tr>

                    <tr>
                        <td>Choose item image:</td>
                        <td>
                            <input type="file" id="item-image" name="item-image" >

                        </td>
                    </tr>
                    <script type="text/javascript">
                        function readURL(input) {
                            if (input.files && input.files[0]) {
                                var reader = new FileReader();

                                reader.onload = function (e) {
                                    $('#item-img').attr('src', e.target.result);
                                };

                                reader.readAsDataURL(input.files[0]);
                            }
                        }

                        $("#item-image").change(function(){
                            readURL(this);
                        });
                    </script>
                    <tr>
                        <td colspan="2">
                            <img id="item-img" name="item-img" src="${sessionScope.item.imagePath}" height="300px" width="300px">
                        </td>
                    </tr>

                    <tr>
                        <td>Description:</td>
                        <td>
                            <input type="text" id="item-description" name="item-description" value="${sessionScope.item.description}" >
                        </td>
                    </tr>
                </table>

                <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

                <c:choose>
                    <c:when test="${requestScope.action=='add'}">
                        <input type="submit" value="Add" name="add" id="add" >
                    </c:when>    
                    <c:otherwise>
                        <input type="submit" value="Update" name="act" id="update" >
                        <input type="submit" value="Delete" name="act" id="delete" >
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
