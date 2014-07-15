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
         <link  rel="stylesheet" href="stylesheets/webapp.css" />
        <script type="text/javascript" src="vendor/jquery/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap-3.1.1/dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/bootstrap-3.1.1/js/tab.js"></script>
        <script type="text/javascript" src="javascripts/webapp.js"></script>
        <title>Bank Account Page</title>
    </head>
    <body>    
        <div style=" margin: auto; width: 80%;">
         <div class="jumbotron" style="width: 80%; margin: 20px auto auto;padding-bottom: 10px;padding-top: 10px;">
            <h3>Welcome to the Bank Account page</h3>
                    <div>
                        <ul class="nav nav-pills">
                            <li>
                                  <a href="bank/createcustomer" id="addCustomer">Add Customer</a>
                            </li>
                            <li>
                                 <a href="bank/deposit" >Deposit</a>       
                            </li>
                            <li>                           
                              <form action="logout" method="post" role="form">
                                 <button type="submit" class="btn btn-primary">Logout</button><br>
                              </form>
                            </li>
                         </ul>
                    </div>
              </div>
        <div style="width: 80%; margin: 20px auto auto;">
             <ul class="nav nav-tabs nav-justified" role="tablist">
                             <li class="active"><a href="#bank" role="tab" data-toggle="tab">Accounts</a></li>
                              <li><a href="#atm" role="tab" data-toggle="tab">Transactions</a></li>
                          </ul>
                          <div class="tab-content">
                                <div class="tab-pane active" id="bankAccountsBank">
                                    <%@include file="account_list.jsp" %>
                                </div>
                              <div class="tab-pane" id="transactions">
                                   Transactions
                              </div>
                            </div> 
        </div>
        </div>
    </body>
</html>
