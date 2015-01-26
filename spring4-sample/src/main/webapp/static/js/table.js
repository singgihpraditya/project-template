$(document).ready(function() {
	$("#mytable #checkall").click(function() {
		if ($("#mytable #checkall").is(':checked')) {
			$("#mytable input[type=checkbox]").each(function() {
				$(this).prop("checked", true);
			});

		} else {
			$("#mytable input[type=checkbox]").each(function() {
				$(this).prop("checked", false);
			});
		}
	});

	$("[data-toggle=tooltip]").tooltip();

	$('body').on('click', '.ajax-submit', function() {
		var formId = $(this).attr('form-binding');
		var dataContent = $(this).attr('data-content');
		$.ajax({
			type : "POST",
			url : $("#" + formId).attr('action'),
			data : $("#" + formId).serialize(),
			success : function(data) {
				$("#" + dataContent).html(data);
			}
		});
		return false;
	});
	
	$('body').on('click', '.ajax-reset', function() {
		var formId = $(this).attr('form-binding');
		$('#'+formId).find("input[type=text], input[type=email], input[type=password], textarea").val("");
		$('#'+formId).find("select").prop('selectedIndex',0);
		return false;
	});
	
	
	$('body').on('click', '.ajax-close', function() {
		var url = $(this).attr('reload-url');
		var dataContent = $(this).attr('data-content');
		$.ajax({
			type : "GET",
			url : url,
			success : function(data) {
				$("#" + dataContent).html(data);
			}
		});
		return false;
	});

	$('body').on('click', '.ajax-link', function() {
		var url = $(this).attr('href');
		var dataContent = $(this).attr('data-content');
		$.ajax({
			type : "GET",
			url : url,
			success : function(data) {
				$("#" + dataContent).html(data);
			}
		});
		return false;
	});
});
