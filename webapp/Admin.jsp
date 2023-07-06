<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    /* CSS code */
    .my-element {
      border: 1px solid black;
      padding: 10px;
     
    }
  </style>
</head>
<body>

<div class="my-element">
<form action="admin" method="post">
<h3>Admin Page</h3>

<input type="submit" name="register" value="SignUp"><br><br>

<input type="submit" name="login" value="Login"> <br><br>

<input type="submit" name="customer" value="All Customer"> <br><br>

<input type="submit" name="manager" value="All Manager"> <br><br>



</form>

</div>
</body>
</html>


