<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="<c:url value='static/css/table.css'/>" />

<title>Hello World</title>

</head>
<body>
	<table id="table-design">
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Address</th>
			<th>Website</th>
		</thead>
		<tbody>
			<tr>
				<td>John</td>
				<td>Smith</td>
				<td>johnsmith@example.com</td>
				<td>http://www.example.com</td>
			</tr>
			<tr>
				<td>Peter</td>
				<td>James</td>
				<td>peterjames@example.com</td>
				<td>http://www.example.com</td>
			</tr>
			<tr>
				<td>Ronald</td>
				<td>Weeley</td>
				<td>ronweeley@example.com</td>
				<td>http://www.example.com</td>
			</tr>
		</tbody>
	</table>
</body>
</html>