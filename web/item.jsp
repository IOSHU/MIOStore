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
        <style>
            div.inline { float:left; }
            .clearBoth { clear:both; }
            .card {
              border: 1px solid black;
              background-color: #f4f4f4;
              box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
              max-width: 300px;
              height: 550px;
              max-height: 600px;
              margin: auto;
              text-align: center;
              font-family: arial;
            }

            .price {
              color: grey;
              font-size: 22px;
            }

            .card button {
              border: none;
              outline: 0;
              padding: 12px;
              color: white;
              background-color: #000;
              text-align: center;
              cursor: pointer;
              width: 100%;
              font-size: 18px;
            }

            .card button:hover {
              opacity: 0.7;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <p>${sessionScope.employee.fullName.firstName}</p>

        <div>
            <form method="POST" action="search">
                <table>
                    <input type="text" name="txt-search" id="txt-search" value="${sessionScope.search}"/>
                    <input type="submit" name="btn-search" id="btn-search" value="search" />
                </table>         
            </form>
        </div>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



        <div>
            <c:forEach items="${sessionScope.items}" var="item" varStatus="loop">
                <div class="inline" style="margin-right: 40px; margin-top: 40px;">
                    <div class="card">
                        <a href="item-management.jsp?index=${loop.index}">
                            <img src="${item.imagePath}" alt="${item.name}" width="250" height="250" >
                        </a>

                        <h1>${item.name}</h1>
                        <p class="price">$${item.price}</p>
                        <p>Quantity: ${item.quantity}</p>
                        <p>${item.description}</p>

                    </div>
                </div>
            </c:forEach>
        </div>
        <br class="clearBoth" />
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

