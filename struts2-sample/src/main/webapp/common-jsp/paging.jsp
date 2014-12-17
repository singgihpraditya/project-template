<%@ include file="taglibs.jsp"%>
<div class="pagination">
	<c:if test="${paging.pageCount > 0}">
		<ul>
			<c:if test="${not empty elementId}">
				<c:set var="box">boxId="#${elementId}"</c:set>
			</c:if>
			<c:if test="${(paging.selPage-1)>=0}">
				<c:url value="${baseLink}" var="backPage">
					<c:param name="page${sufix}" value="${paging.selPage-1}"/>
				</c:url>
				<c:url value="${baseLink}" var="firstPage">
					<c:param name="page${sufix}" value="0"/>
				</c:url>			
				<li><a ${box} href="<c:out value="${backPage}"/>&<c:out value="${tailLink}"/>" >&laquo;&nbsp;prev</a></li>
			</c:if>
			
			<c:forEach begin="${paging.lowerLimit}" end="${paging.upperLimit}" var="pg" varStatus="st">
				<c:if test="${pg eq  paging.selPage}">
					<li><a class="current pagingLink" ${box} href="<c:url value='${baseLink}'/>"><strong><c:out value="${pg+1}"/></strong></a><c:if test="${not st.last}"></c:if></li>
				</c:if>
				<c:if test="${pg ne paging.selPage}">
				<c:url value="${baseLink}" var="goPage">
					<c:param name="page${sufix}" value="${pg}"/>
				</c:url>			
					<li><a ${box} href='<c:out value="${goPage}"/>&<c:out value="${tailLink}"/>'><c:out value="${pg+1}"/></a><c:if test="${not st.last}"></c:if></li>
				</c:if>
			</c:forEach>
		
			<c:if test="${paging.pageCount>1 and paging.selPage!=(paging.pageCount-1)}">
				<c:url value="${baseLink}" var="nextPage">
					<c:param name="page${sufix}" value="${paging.selPage+1}"/>
				</c:url>
				<c:url value="${baseLink}" var="lastPage">
					<c:param name="page${sufix}" value="${paging.pageCount-1}"/>
				</c:url>
				<li><a ${box} href="<c:out value="${nextPage}&${tailLink}"/>" >next&nbsp;&raquo;</a></li>
			</c:if>
		</ul>
	</c:if>
</div>