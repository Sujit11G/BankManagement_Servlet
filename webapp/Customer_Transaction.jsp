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

<form>
 <input type="button" name="debit_Amount" value="Withdraw Amount" onclick="showForm('withdrawForm')">
 <input type="button" name="credit_Amount" value="Credit Amount" onclick="showForm('creditForm')">
 <input type="button" name="transfer_Amount" value="Transfer Amount" onclick="showForm('transferForm')">
</form>

<div class="form-container" id="withdrawForm">
   
    <form action="withdrawAmount" method="post">
 <label for="CustomerID">ID: </label>
 <input type="number" name="CustomerID" value="<%=request.getParameter("customer_Id")%>">
 <label for="withdrawAmount">Withdraw Amount:</label>
 <input type="number" id="withdrawAmount" name="withdrawAmount" required>
 <input type="submit" value="Withdraw">
    </form>
</div>

<div class="form-container" id="creditForm" >
    
    <form action="creditAmount" method="post">
 <label for="CustomerID">ID: </label>
 <input type="number" name="CustomerID" value="<%=request.getParameter("customer_Id")%>">
 <label for="creditAmount">Credit Amount:</label>
 <input type="number" id="creditAmount" name="creditAmount" required>
 <input type="submit" value="Credit">
    </form>
</div>

<div class="form-container" id="transferForm">
  
    <form action="transfer_Amount" method="post">
 <label for="CustomerID">Your ID: </label>
 <input type="number" name="CustomerID" value="<%=request.getParameter("customer_Id")%>">
 <label for="transferId">Enter Receiver ID:</label>
 <input type="text" id="transferId" name="transferId" required>
 <label for="transferAmount">Transfer Amount:</label>
 <input type="number" id="transferAmount" name="transferAmount" required>
 <input type="submit" value="Transfer">
    </form>
</div>



</body>
</html>