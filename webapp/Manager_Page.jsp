<%@page import="java.util.List"%>
<%@page import="com.jsp.dto.Manager"%>
<%@page import="com.jsp.services.ManagerServices"%>
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

<%ManagerServices managerServices=new ManagerServices(); %>

<%List<Customer> customers=managerServices.fetchAllCustomer();%>

        <% String ManagerID=request.getParameter("managerId");%>
        
        <% int id=Integer.parseInt(ManagerID); %>
		
		<%Manager manager=managerServices.fetchManagerDetails(id); %>
			

<table border="2px">

<tr >
<th>SID</th>
<th>NAME</th>
<th>Email</th>
<th>Status</th>
<th>Account No</th>
<th>Account Type</th>
<th>IFSC</th>


</tr>

<%
for(Customer c: customers){%>
<tr>
<td><%=c.getId() %></td>
<td><%=c.getName() %></td>
<td><%=c.getEmail() %></td>
<td><%=c.getStatus() %></td>
<td><%=c.getAcc_no() %></td>
<td><%=c.getAcc_type() %></td>
<td><%=c.getIfsc() %></td>
 <td>
  <form action="blockCustomer" method="post">
      <input type="hidden" name="manager_ID" value="<%=request.getParameter("managerId")%>">
      <input type="hidden" name="customerId" value="<%=c.getId() %>">
      <button type="submit">Block</button>
  </form> 
  </td>
  <td>
  <form action="approveCustomer" method="post">
      <input type="hidden" name="manager_ID" value="<%=request.getParameter("managerId")%>">
      <input type="hidden" name="customerId" value="<%=c.getId() %>">
      <button type="submit">Approve</button>
  </form> 
  </td>


</tr>

<%} %>
</table><br>

<form>
 <input type="button" name="activate_account" value="Activate Customer Account" onclick="showForm('setCustomerAccount')">
 <input type="button" name="update_manager" value="Update" onclick="showForm('UpdateManager')">

</form>

<div class="form-container" id="setCustomerAccount">

 <form action="setAccountDetails" method="post">
         <label for="managerID">Manager ID:</label>
        <input type="text" id="managerID" name="managerID"  value="<%=request.getParameter("managerId") %>" required><br><br>
        
 
        <label for="customerId">Customer ID:</label>
        <input type="text" id="customerId" name="customerId" required><br><br>
        
        <label for="accountType">Account Type:</label>
        <input type="text" id="accountType" name="accountType" required><br><br>
        
        <label for="accountStatus">Account Status:</label>
        <input type="text" id="accountStatus" name="accountStatus" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
    
    </div>
   
    
  <div class="form-container" id="UpdateManager"> 
   <%if(manager!=null){ %>
<form action="UpdateManager" method="post" id="updateForManager">

<label for="manager_Id" >Manager ID :</label>
 <input type="number" name="manager_Id" 
value="<%=request.getParameter("managerId")%>"><br><br>

<label for="manageremail">Email: </label>
<input type="email" name="manageremail" value="<%=manager.getEmail() %>" ><br><br>

<label for="managerpassword">Password: </label>
<input type="password" name="managerpassword" value="<%=manager.getPassword()%>"><br><br>

<input type="submit" >
</form>
<%} %>

</div> 



</body>
</html>