<%-- 
    Document   : AtmWithdraw
    Created on : Jul 14, 2014, 3:13:44 PM
    Author     : tune
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ATM Transaction</title>
       
        <link rel="stylesheet" href="css/ATM_style.css" media="screen" type="text/css" /> 
        <script type="text/javascript" src="javascripts/atm_javascript.js"></script>

    </head>
    <body>
        
        <form id="Withdraw" action="atm_withdraw_confirm" method="post">
            <input type="hidden" id="WAmount" name="WAmount" value="0">
        </form>
        
        <table class="center">
            <col width="100px" />
            <col width="250px" />
            <col width="250px" />
            <col width="100px" />
            <tr>
                <td colspan="4">
                    <div class="fontStyle-header">
                        welcome to the Programmers Bank
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="4" height="120">
                    <div class="fontStyle-menu">
                        Sorry
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <a href="#" class="button">></a>
                    </div>
                </td>
                <td colspan="2">
                    <div class="fontStyle-center">
                        You Can not withdraw the money more that 1000$ per day
                    </div>
                </td>
                <td>
                    <div>
                        <a href="#" class="button"><</a>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <a href="#" class="button">></a>
                    </div>
                </td>
                <td>
                    <div class="fontStyle-left">
                        
                    </div>
                </td>
                <td>
                    <div class="fontStyle-right">
                        
                    </div>
                </td>
                <td>
                    <div>
                        <a href="#" class="button"><</a>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div>
                        <a href="atm_transaction" class="button">></a>
                    </div>
                </td>
                <td>
                    <div class="fontStyle-left">
                        menu
                    </div>
                </td>
                <td>
                    <div class="fontStyle-right">
                        log out
                    </div>
                </td>
                <td>
                    <div>
                        <a href="atm_logout" class="button"><</a>
                    </div>
                </td>
            </tr>
            
        </table>

        
        
    </body>
</html>
