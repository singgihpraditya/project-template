<#import "/macro/pagination.ftl" as page/>
<#import "/spring.ftl" as spring />

<a href="<@spring.url '/user/ajax/form'/>" class="btn btn-primary btn-s pull-right button-dialog"><b>+</b> Add new categories</a>
<div class="clearfix"></div>
<table id="mytable" class="table table-striped custab">
	<thead>
		<tr>
			<th width="10"><input type="checkbox" id="checkall" /></th>
			<th>ID</th>
			<th>Title</th>
			<th>Parent ID</th>
			<th width="200" class="text-center">Action</th>
		</tr>
	</thead>
	<tr>
		<td><input type="checkbox" class="checkthis" /></td>
		<td>1</td>
		<td>News</td>
		<td>News Cate</td>
		<td class="text-center"><a class='btn btn-info btn-xs  button-dialog' href="<@spring.url '/user/ajax/form'/>"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Delete</a></td>
	</tr>
	<tr>
		<td><input type="checkbox" class="checkthis" /></td>
		<td>2</td>
		<td>Products</td>
		<td>Main Products</td>
		<td class="text-center"><a class='btn btn-info btn-xs  button-dialog' href="<@spring.url '/user/ajax/form'/>"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Delete</a></td>
	</tr>
	<tr>
		<td><input type="checkbox" class="checkthis" /></td>
		<td>3</td>
		<td>Blogs</td>
		<td>Parent Blogs</td>
		<td class="text-center"><a class='btn btn-info btn-xs  button-dialog' href="<@spring.url '/user/ajax/form'/>"><span class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Delete</a></td>
	</tr>
</table>
<@page.pagination/>
</div>