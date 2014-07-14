<%-- 
    Document   : atm
    Created on : Jul 13, 2014, 11:34:08 PM
    Author     : ebrima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="vendor/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet" media="screen">      
        <script src="vendor/jquery/jquery-1.11.1.min.js"></script>
        <script src="vendor/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="javascripts/webapp.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
       <div>
            <h1>Welcome to the ATM page</h1>
            <div>
               <form action="logout" method="post" role="form">
                 <button type="submit" class="btn btn-primary">Logout</button>
               </form>
            </div>
        </div>
    </body>
</html>
