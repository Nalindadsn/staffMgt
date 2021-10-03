<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<style type="text/css">
body {
margin:0;
padding:0;
  font-family: "Rubik", sans-serif;
  background-color: #240046;
  margin-left: 20px;
  margin-right: 20px;
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


</style>
</head>
<body>

	<header>
<nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a href="<%=request.getContextPath()%>/list" class="navbar-brand">Staff Management System</a>
    <form class="d-flex" method="get" action="<%=request.getContextPath()%>/attendance?date=">
      <input class="form-control me-2" type="date" placeholder="Search" aria-label="Search" name="date">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New 
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Employee Id</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>


				<fieldset class="form-group">
					<label>Date<span class="badge bg-primary">${user.attendedDate}</span> </label>
						
						
						
				<c:if test="${user != null}"> <input type="date"
						value="<c:out value='${user.attendedDate}' />" class="form-control"
						name="attendedDate" required>

				</c:if>
				<c:if test="${user == null}"> <input type="date"
						value="<c:out  value="<%=new java.util.Date()%>"  />" class="form-control"
						name="attendedDate" required>

				</c:if>
						
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Note</label> <input type="text"
						value="<c:out value='${user.note}' />" class="form-control"
						name="note">
				</fieldset>
				
<hr>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>