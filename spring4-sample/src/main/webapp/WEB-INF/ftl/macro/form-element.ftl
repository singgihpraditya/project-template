<#import "/spring.ftl" as spring />

<#macro email name="" id="" placeholder="" class="" value="" label="">
	<div class="form-group">
		<label class="col-sm-3" for="inputBody">${label}</label>
		<div class="col-sm-9"><input class="form-control" id="${id}" name="${name}" value="${value}" placeholder="${placeholder}" type="email"></div>
	</div>
</#macro>

<#macro text name="" id="" placeholder="" class="" value="" label="">

	<div class="form-group">
		<label class="col-sm-3" for="inputBody"><@spring.message label/></label>
		<div class="col-sm-9"><input class="form-control" id="${id}" name="${name}" value="${value}" placeholder="${placeholder}" type="text"></div>
	</div>
</#macro>

<#macro select name="" id="" class="" value="" label="" list="">
	<div class="form-group">
		<label class="col-sm-3" for="inputBody">${label}</label>
		<div class="col-sm-9">
		<select class="form-control" id="${id}" name="${name}" value="${value}">
			<option>-- Please Select --</option>
			<option>Foo</option>
			<option>Bar</option>
			
		</select></div>
	</div>
</#macro>

<#macro textarea name="" id="" placeholder="" class="" value="" label="" row="3">
	<div class="form-group">
		<label class="col-sm-12" for="inputBody">${label}</label>
		<div class="col-sm-12"><textarea name="${name}" value="${value}"  class="form-control $class" id="$id" rows="$row"></textarea></div>
	</div>
</#macro>

<#macro button_submit label="" formbinding="" class="" datacontent="">
	<button type="button" form-binding="${formbinding}" data-content="${datacontent}" class="btn btn-primary pull-left ${class}">${label}</button> 
</#macro>

<#macro button_clear label="" formbinding="" class="">
	<button type="button" form-binding="${formbinding}" class="btn btn-warning pull-left ${class}">${label}</button> 
</#macro>

<#macro button_close label="" class="" reloadurl="" datacontent="">
	<#if reloadurl!="">
		<#assign reloadurl><@spring.url reloadurl/></#assign>
	</#if>
	<button type="button" data-dismiss="modal" reload-url="${reloadurl}" data-content="${datacontent}" class="btn btn-default ${class}">${label}</button> 
</#macro>