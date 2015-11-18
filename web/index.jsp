<%-- 
    Document   : index
    Created on : Oct 25, 2015, 8:09:28 PM
    Author     : Demian
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="com.apcb.utils.entities.Message"%>
<%@page import="com.apcb.utils.entities.Response"%>
<%@page import="com.apcb.interfaceWeb.services.APCBInterfaceWebServices"%>
<%@page import="com.apcb.utils.entities.Request"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


  <%
   APCBInterfaceWebServices service = new APCBInterfaceWebServices();
   Request request2 = new Request();
   request2.setMessage(new Message("0","index"));
   Response response2 = new Response();
   response2  = new Gson().fromJson(service.test(new Gson().toJson(request2)),Response.class);
   out.write(response2.getMessage().getMsgDesc());
  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
