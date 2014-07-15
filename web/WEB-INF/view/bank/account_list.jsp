<%-- 
    Document   : account_list
    Created on : Jul 15, 2014, 4:15:22 PM
    Author     : ebrima
--%>

<%@page import="model.classes.Customer"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <% List customers = (List)request.getAttribute("customers"); %>
<div>
    <table><tr><th>Acc No.</th><th>Customer Name</th></tr>
     <%for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
       Customer customer = (Customer) iterator.next();  
       %>
        <tr>
            <td> <%=customer.getFirstName()%> </td>
            <td></td>
        </tr>
      <% } %>
                       
    
    </table>
</div>