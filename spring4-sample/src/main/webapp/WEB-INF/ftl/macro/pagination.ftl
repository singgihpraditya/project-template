<#import "/spring.ftl" as spring />
<#macro pagination>
	<div class="clearfix"></div>
  	<ul class="pagination pull-right">
    	<li class="disabled"><a class="ajax-link" data-content="tableContent" href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
        <li class="active"><a class="ajax-link" data-content="tableContent" href="<@spring.url '/user/ajax/list/1'/>">1</a></li>
        <li><a class="ajax-link" data-content="tableContent" href="<@spring.url '/user/ajax/list/2'/>">2</a></li>
        <li><a class="ajax-link" data-content="tableContent" href="#">3</a></li>
        <li><a class="ajax-link" data-content="tableContent" href="#">4</a></li>
        <li><a class="ajax-link" data-content="tableContent" href="#">5</a></li>
        <li><a class="ajax-link" data-content="tableContent" href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
	</ul>  	
</#macro>