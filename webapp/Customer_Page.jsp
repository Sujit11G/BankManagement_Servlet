<%@page import="com.jsp.dto.Customer"%>
<%@page import="com.jsp.services.CustomerServices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .form-container {
        display: none;
    }
</style>
<script>
    function showForm(formId) {
        // Hide all form containers
        var formContainers = document.querySelectorAll('.form-container');
        formContainers.forEach(function(container) {
            container.style.display = 'none';
        });
        
        // Show the selected form container
        var selectedForm = document.getElementById(formId);
        if (selectedForm) {
            selectedForm.style.display = 'block';
        }
    }
</script>

</head>
<body>

<%CustomerServices customerServices=new CustomerServices(); %>
<%String ID=request.getParameter("customerId"); %>
<%int id=Integer.parseInt(ID); %>
<%Customer customer=customerServices.getCustomerByID(id); %>

<%if(customer!=null){ %>
<table border="2px">
<tr>
      <th>Name</th>
      <th>Status</th>
      <th>Balance</th>
      <th>Account No</th>
      <th>Account Type</th>
      <th>IFSC</th>
      
</tr>

<tr>

      <td><%=customer.getName() %></td>
      <td><%=customer.getStatus() %></td>
      <td><%=customer.getBalance() %></td>
      <td><%=customer.getAcc_no() %></td>
      <td><%=customer.getAcc_type() %></td>
      <td><%=customer.getIfsc() %></td>

</tr>

</table><br><br>

<form>
 <input type="button" name="update_customer" value="UPDATE" onclick="showForm('UpdateCustomer')">
</form>

<%} %>
<br><br>

<div class="form-container" id="UpdateCustomer">

<%if(customer!=null){ %>
<form action="UpdateCustomer" method="post" id="updateForCustomer">

<label for="customer_Id" >Customer ID :</label>
 <input type="number" name="customer_Id" 
value="<%=request.getParameter("customerId")%>"><br><br>

<label for="customeremail">Email: </label>
<input type="email" name="customeremail" ><br><br>

<label for="customerpassword">Password: </label>
<input type="password" name="customerpassword" ><br><br>

<input type="submit" >
</form>
<%} %>

</div>
<br><br>



<a href="Customer_Transaction.jsp?customer_Id=<%=customer.getId()%>">Transaction</a>





</body>
</html>