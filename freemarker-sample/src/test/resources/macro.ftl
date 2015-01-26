<#macro test foo bar baaz>
  Test text, and the params: ${foo}, ${bar}, ${baaz}
</#macro>

<#macro paginate pagination>
  	<#assign pageSize=$pagination.pageSize>
  	<#assign totalRecord=$pagination.totalRecord>
  	<#assign currentPage=$pagination.currentPage>
	<#assign totalPage=$pagination.totalPage>
	<#assign url=$pagination.url>
	
	<ul class="pagination pull-right">
        <li class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
        <li class="active"><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
    </ul>
</#macro>
