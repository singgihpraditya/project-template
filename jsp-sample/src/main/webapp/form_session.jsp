<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>Hello World</title>
</head>
<body>
	<h1>Set Session</h1>
	<form method="post" action="/session">
		Message : <input type="text" name="message"/>
		<input type="submit" value="send"/>
	</form>
</body>
</html>