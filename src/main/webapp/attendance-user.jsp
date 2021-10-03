<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
body {
margin:0;
padding:0;
  font-family: "Rubik", sans-serif;
  text-align: center;
  background-color: #240046;
  margin-left: 20px;
  margin-right: 20px;
  color: #fff;
}
table {
  width: 100%;
  min-width: 400px;
  margin: 30px auto 0 auto;
}

h3 {
  margin: 5px;
}

img {
  border-radius: 50%;
  width: 50px;
  margin: 5px 0 0 0;
  border: 3px solid #ff9e00;
}

img:hover {
  border: 3px solid #ff6d00;
}

h1 {
  color: white;
  margin-bottom: 15px;
}

p {
  margin: 0;
}

th {
  border: none;
  color: white;
  text-transform: uppercase;
  padding: 10px;
  
  background-color: rgba(0,0,0,.8);
}

tr,
td {
  border: none;
  background-color: rgba(0,0,0,.2);
  color:#fff
}

thead{

  background-color: rgba(0,0,0,.5);
}
a{
text-decoration:none;
color:#fff;
}
a:hover{

color:orange;
}
</style>

</head>
<body>
	<header>
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a  href="<%=request.getContextPath()%>/list"  class="navbar-brand">Staff Management System</a>
    <form class="d-flex" method="get" action="<%=request.getContextPath()%>/attendance?date=">
      <input class="form-control me-2" type="date" placeholder="Search" aria-label="Search" name="date">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>
	</header>
	<br>
<div class="container">
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<div class="">
				<h5 class="float-start">Member Id: <a class="btn btn-primary"><c:out value="${param['uid']}"></c:out></a> </h5><br><br>
				<h5 class="float-start">No of staff members: ${listUser2.size()}</h5><br><br>
			<h3 class="float-start">Attendance</h3>
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success float-end">Add
					New </a>
			</div>

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Attened date</th>
						<th>Created at</th>
						<th>Note</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listUser2}">
					

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.attendedDate}" /></td>
							<td><c:out value="${user.created_at}" /></td>
							<td><c:out value="${user.note}" /></td>
							<td><a href="edit?id=<c:out value='${user.id}' />"><i class="fa fa-edit text-warning"></i> Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${user.id}' />"><i class="fa fa-trash text-danger"></i> Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</div>

</body>
</html>