<%-- 
    Document   : index
    Created on : 21.11.2014, 18:13:15
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Server Main Page</title>
    </head>
    <body>
        
         <%!
  int a;
  private int getCount(){
//increment cnt and return the value
    a=10;
return a;
  }
   %>
        <h1>Hello!</h1>
        <b>There is a server for Testing project. Here the server is making a lot of changes and recieves client messages</b>
        <p><%=getCount()%></p>
    </body>
</html>
