<#import "/macro/form-element.ftl" as form/>	
<#import "/spring.ftl" as spring />
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	        <h4 class="modal-title">Compose Message</h4>
	    </div>
	    <div class="modal-body">
	        <form action="<@spring.url '/user/ajax/form'/>" id="user-form" method="post" role="form" class="form-horizontal ajax-form">
	     		<@form.text placeholder="User Name For Login" id="userName" name="userName" label="label.user.name"/>
	     		<@form.text placeholder="First Name" id="firstName" name="firstName" label="label.first.name"/>
	     		<@form.text placeholder="Last Name" id="lastName" name="lastName" label="label.last.name"/>
	     		<@form.select id="sex" name="gender" label="Gender"/>
	  		</form>
	    </div>
	    <div class="modal-footer">
	    	<@form.button_submit label="Save" formbinding="user-form" datacontent="processing-modal" class="ajax-submit"/>
	        <@form.button_clear label="Clear" formbinding="user-form" class="ajax-reset" />
	        <@form.button_close label="Close" datacontent="tableContent" reloadurl="/user/ajax/list/0" class="ajax-close" />
	    </div>
	</div>
</div>