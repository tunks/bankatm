<%-- 
    Document   : login
    Created on : Jul 13, 2014, 5:57:05 AM
    Author     : ebrima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link href="vendor/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="vendor/jquery/realperson/jquery.realperson.css">
        
        <script src="vendor/jquery/jquery-1.11.1.min.js"></script>
        <script src="vendor/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery/realperson/jquery.plugin.js"></script> 
        <script type="text/javascript" src="vendor/jquery/realperson/jquery.realperson.js"></script>
        <script type="text/javascript" src="javascripts/webapp.js"></script>
         <title>Bank ATM Login page</title>
    </head>
    <body>
        <h1 class="center-block" style="text-align: center;margin-bottom: 20px;">Welcome to Farask Bank</h1>
        <div>
            <div style="width:300px;" class="center-block">
                <%
                    
                     String errorMsg = (String)request.getAttribute("errorMsg");

                      if (errorMsg != null) {       
                     
                 %>
                       <div>
                           <span style="color:red"><%= errorMsg %></span>
                       </div>
                 <%
                            
                       }
                 %>
                 <div>
                     <%
                      String reference = (String)request.getAttribute("reference");
                      if(reference != null && reference.equals("atm")){
                    %>
                    <%@include file= "atm_login.jsp" %>
                    <%
                      }
                      else  if(reference != null && reference.equals("bank")){
                    %>
                    <%@include file= "bank_login.jsp" %>
                    <% } %>
                 </div>
            </div>
        </div>
    </body>
</html>
