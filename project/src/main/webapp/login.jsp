<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Log In Test</title>
</head>
   
<body onload="load()">
  <p id="log"></p> 
  
  <% if (session.getAttribute("userID") != null) { %>
  <p> <%= session.getAttribute("userID") %> </p>
  <% } %>

  <script>
    function load() {
      var xhttp = new XMLHttpRequest();
      xhttp.open("GET", "/Auth", true);
      xhttp.onreadystatechange = function() {
        document.getElementById("log").innerHTML = this.responseText;
      }
      xhttp.send();
    }
  </script>

</body>
</html>