<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div>Welcome ${name}</div>
	<div>Your Todos</div>
	<table class="table ">
		<thead>
			<tr>
				<th>Course</th>
				<th>Target Date</th>
				<th>Status</th>
				<th></th>
			</tr>
		</thead>
	 <tbody>
			<c:forEach items="${todo}" var="todo">
				<tr>
					<td>${todo.discription }</td>
					<td>${todo.localdate }</td>
					<td>${todo.done }</td>
					<td><a href="update-Todo?id=${todo.id}" class="btn btn-success">UPDATE </td>
					<td><a href="delete-Todo?id=${todo.id}" class="btn btn-warning">DELETE </td>
				</tr>
			</c:forEach>
				</tbody> 
			</table>  
			<a href ="add-todos" class="btn btn-success">Add ToDo</a>
		</div>
		<%@ include file="common/footer.jspf" %>
	</body>
</html>