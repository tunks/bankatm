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
        <h1>Welcome to the Bank Home page</h1>
        <div>
            <form action="logout" method="post" role="form">
                <button type="submit" class="btn btn-primary">Logout</button>
            </form>
        </div>
        <div>
            <form action="creatcustomer" method="post" role="form"><br>
                First name: <input type="text" name="firstname"><br>
                Last name: <input type="text" name="lastname"><br>
                Address:<input type="text" name="address"><br>
                Email: <input type="text" name="email"><br>
                Phone: <input type="text" name="phone"><br>
                Account Number: <input type="text" name="accountno"><br>
                Initial Amount:<input type="text" name="iniamount"><br>
                <button type="submit" class="btn btn-primary">Create Accoutnt</button>
            </form>
            <form action="deposit" method="post" role="form"><br>
                Account Number: <input type="text" name="accountno"><br>     
                Amount to Deposit: <input type="text" name="amount"><br>   
                <button type="submit" class="btn btn-primary">Deposit</button>
            </form>
        </div>
    </body>
</html>
