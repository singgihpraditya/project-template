<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head></head>
<body>
	<h1>Struts 2 Hello World Example</h1>
	<s:form action="/upload/save">
		<s:file name="uploadedFile" label="Select a File to upload" size="40" />
		<s:submit />
	</s:form>
</body>
</html>