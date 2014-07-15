<%-- 
    Document   : bank
    Created on : Jul 13, 2014, 7:23:18 PM
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
        <title>Bank Account Page</title>
    </head>
    <body>
        <h1>Welcome to the Bank Account page</h1>

        <div>
            <a href="bank/createcustomer" >Add Customer</a>
        </div>
        <div>
            <a href="bank/deposit" >Deposit</a>            
        </div>
        <div>
            <form action="logout" method="post" role="form">
                <button type="submit" class="btn btn-primary">Logout</button><br>
            </form>
        </div>
    </body>
</html>
