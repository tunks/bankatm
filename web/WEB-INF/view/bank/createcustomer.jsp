<%-- 
    Document   : createcustomer
    Created on : Jul 14, 2014, 2:15:54 PM
    Author     : fara1_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="vendor/bootstrap-3.1.1/dist/css/bootstrap.min.css" rel="stylesheet" media="screen">      
        <script src="vendor/jquery/jquery-1.11.1.min.js"></script>
        <script src="vendor/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="javascripts/webapp.js"></script>
        <title>Create New Account</title>
    </head>
    <body>
        <div>
            <form action="bank/createcustomer" method="post" role="form" id="createCustomer"><br>
                First name: <input type="text" name="firstname" /><br>
                Last name: <input type="text" name="lastname" /><br>
                Address:<input type="text" name="address" /><br>
                Email: <input type="text" name="email" /><br>
                Phone: <input type="text" name="phone" /><br>
                Account Number: <input type="text" name="accountno" /><br>
                Initial Amount:<input type="text" name="iniamount" /><br>
                <button type="submit" class="btn btn-primary">Save</button>
                <button type="button" class="btn btn-primary" id="closeCustomerForm">Cancel</button>
            </form>
        </div>
    </body>
</html>
