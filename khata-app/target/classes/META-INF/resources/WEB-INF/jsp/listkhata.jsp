<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
	<div class="container">
	<h1>Welcome khata app</h1>
	<hr>
	<h1>Your List</h1>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th></th>
				<th><a href="add-khata" class="btn btn-success">Add Todo</a></th>
				<th></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${khatas}" var="khata">
				<tr>
					<td>${khata.id}</td>
					<td>${khata.name}</td>
					<th></th>
					<td><a href="del-khata?id=${khata.id}" class="btn btn-warning">Delete</a></td>
					<th></th>
					<td><a href="update-khata?id=${khata.id}" class="btn btn-success">Update</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
<%@ include file="common/footer.jspf"%>