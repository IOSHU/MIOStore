<%-- 
    Document   : header
    Created on : Jun 14, 2020, 7:17:35 AM
    Author     : hieule
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    img {
        max-width: 100%;
        height: auto;
    }
    
    body {margin: 0;}

    ul.topnav { 
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: #333;
    }

    ul.topnav li {float: left;}

    ul.topnav li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    ul.topnav li a:hover:not(.active) {background-color: #111;}

    ul.topnav li a.active {background-color: #0066ff;}

    ul.topnav li.right {float: right;}

    @media screen and (max-width: 600px) {
        ul.topnav li.right, 
        ul.topnav li {float: none;}
    }
    ul.topnav li.toplink {
        cursor: pointer;
    }

/*    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        overflow: hidden;
        background-color: #333;
    }

    li {
        float: left;
    }
    li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px; 
        text-decoration: none;
    }
    li a:hover:not(.active) {
        background-color: #111;
    }

    .active {
        background-color: #4CAF50;
    }*/

</style>
<header>
    <img src="imgs/head.png" alt="Cinque Terre" width="2000" height="300">
    <ul class="topnav">
      <li><a class="toplink active" href="home.jsp">Home</a></li>
      <li><a class="toplink" href="item-management.jsp">Add new item</a></li>
      <li><a class="toplink" href="news.asp">News</a></li>
      <li><a class="toplink" href="contact.asp">Contact</a></li>
      <li style="float:right"><a class="toplink" href="about.asp">About</a></li>
    </ul> 
    <script>
        // Add active class to the current button (highlight it)
        var header = document.getElementsByClassName("topnav").getElementsByTagName("li");
        var btns = header.getElementsByClassName("toplink");
        for (var i = 0; i < btns.length; i++) {
            btns[i].addEventListener("click", function() {
            var current = document.getElementsByClassName("active");
            current[0].className = current[0].className.replace(" active", "");
            this.className += " active";
            });
        }
    </script>
</header>

