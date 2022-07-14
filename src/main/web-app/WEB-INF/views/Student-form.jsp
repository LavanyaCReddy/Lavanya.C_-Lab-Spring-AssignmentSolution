<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">


<title>Save Student</title>
</head>
<body>
<div style="text-align:center;">
<h1>Student Directory</h1>
<form action="/CollegeFest/students/save" method="post">

<input type="hidden"   id="id"  name="id" value="${Student.id }"/>
<br/>

<label for="firstname">Firstname</label>
<input type="text"   id="firstname"  name="firstname" value="${Student.firstname }"/>
<br/>

<label for="lastname">Lastname</label>
<input type="text"   id="Lastname"  name="lastname" value="${Student.lastname }"/>
<br/>

<label for="course">Course</label>
<input type="text"   id="course"  name="course" value="${Student.Course }"/>
<br/>

<label for="country">Country</label>
<input type="text"   id="country"  name="country" value="${Student.Country}"/>
<br/>

<input> type="submit" name="s" value="Save">

</form>
<hr/>
<p>
<a href="/CollegeFest/students/list">Show Book List</a>
</p>
</div>
</body>
</html>