<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="Customer_SignUp" method="post">
<label for="username">NAME: </label><br>
<input type="text" name="username" placeholder="Enter Your Name" ><br>

<label for="useremail">EMAIL: </label><br>
<input type="email" name="useremail" placeholder="Enter Your Email" ><br>

<label for="userpan">PAN NO: </label><br>
<input type="text" name="userpan" pattern="[A-Z]{5}[0-9]{4}[A-Z]{1}" placeholder="Enter Your Pan No" ><br>

<label for="userpassword">PASSWORD: </label><br>
<input type="password" name="userpassword"><br>

<label for="useramount">Amount: </label><br>
<input type="number" name="useramount"><br>

<input type="submit" value="SIGN IN">


</form>

</body>
</html>