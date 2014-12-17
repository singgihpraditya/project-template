<%@ include file="taglibs.jsp"%>
<c:if test="${not empty errors}">
		<div class="alert alert-error">
			<button type="button" class="close" data-dismiss="alert">×</button> 
				<c:forEach var="message" items="${messages}">
					<strong><c:out value="${message}"/></strong> 
				</c:forEach>
			</div>
		<c:remove var="errors" scope="session"/>
	</c:if>
	<c:if test="${not empty messages}">
		<div class="alert alert-success">
			 <button type="button" class="close" data-dismiss="alert">×</button> 
			<c:forEach var="message" items="${messages}">
				<strong><c:out value="${message}"/></strong>
			</c:forEach>
		</div>
		<c:remove var="messages" scope="session" />
	</c:if>