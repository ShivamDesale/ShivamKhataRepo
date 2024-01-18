<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
	<div class="container">
		<h1>Welcome to Add Khata page</h1>
		<hr>
		<h1>Enter khata details</h1>
		<form method="post" modelAttribute="khata">
			Name : <input type="text" name="name" value="predefine">
			<input type="submit" class="btn btn-success">
		</form>
	</div>
<%@ include file="common/footer.jspf"%>

