<%@page import="java.util.List"%>
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
</head>
<body>

<%ManagerServices managerServices=new ManagerServices(); %>
<%List <Customer> customers=managerServices.fetchAllCustomer();  %>

<table border="2px">

<tr >
<th>CUSTOMER ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>ACCOUNT NO</th>
<th>ACCOUNT TYPE</th>
<th>ACCOUNT STATUS</th>
<th>BALANCE</th>


</tr>

<%
for(Customer c: customers){%>
<tr>
<td><%=c.getId() %></td>
<td><%= c.getName() %></td>
<td><%= c.getEmail() %></td> <td><%= c.getAcc_no() %></td>
<td><%= c.getAcc_type() %></td>
<td><%= c.getStatus() %></td>
<td><%= c.getBalance() %></td>


</tr>

<%} %>
</table>

</body>
</html>