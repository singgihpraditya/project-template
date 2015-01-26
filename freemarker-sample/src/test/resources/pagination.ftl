<#-- call include: -->

<#import "/macro.ftl" as form>

FreeMarker Template example: ${message}  
<#list countries as i>
	${i}
</#list>  

<#list 1..size as index>
<#if index==3>
	${index} itu tiga
<#elseif index==9>
	${index} itu sembilan
<#break>
<#else>
	${index} apa ja lah	
</#if>
</#list>  	
<#switch size>
  <#case 1>
    1
  <#case 2>
    2
  <#default>
    d
</#switch> 
<#function avg x y>
	<#return (x + y) / 2>
</#function>
${avg(10, 20)}
<#-- call the macro: -->
<@form.test foo="a" bar="b" baaz=5*5-2/>