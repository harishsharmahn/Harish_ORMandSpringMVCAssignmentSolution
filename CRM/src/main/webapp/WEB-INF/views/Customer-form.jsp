<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer</title>
</head>

<body>

	<div class="container">

		<h3>Book Directory</h3>
		<hr>

		<p class="h4 mb-4">Customer</p>

		<form action="/CRM/customer/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${customer.id}" />

			<div class="form-inline">
				<input type="text" name="firstname" value="${CustDetail.firstname}"
					class="form-control mb-4 col-4" placeholder="First Name">



			</div>
			
			<div class="form-inline">
				<input type="text" name="lastname" value="${CustDetail.lastname}"
					class="form-control mb-4 col-4" placeholder="Last Name">



			</div>

			<div class="form-inline">

				<input type="text" name="email" value="${CustDetail.email}"
					class="form-control mb-4 col-4" placeholder="Category">



			</div>
<!-->
			<div class="form-inline">

				<input type="text" name="author" value="${Book.author}"
					class="form-control mb-4 col-4" placeholder="Author">



			</div>--!> 
			<!--->

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/CRM/customer/list">Back to Customers List</a>

	</div>
</body>

</html>










