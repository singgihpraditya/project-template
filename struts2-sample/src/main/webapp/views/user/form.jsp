<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
	<h1>Struts 2 Hello World Example</h1>
	<s:form action="save">
		<s:textfield name="user.name" label="username" />
		<s:textfield name="user.role.name" label="rolename" />
		<s:textfield name="user.groups[0].name" label="groupname1" />
		<s:textfield name="user.groups[1].name" label="groupname2" />
		<s:submit />
	</s:form>
</body>
</html>