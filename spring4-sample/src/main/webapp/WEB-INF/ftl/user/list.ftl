<html>
<head>
<title>Blank Page</title>
</head>
<body>
  	<div id="tableContent"/>
	<script type="text/javascript">
		$(document).ready(function() {
			var url = "/user/ajax/list/0"
			$.get(url, function(data) {		
				$('#tableContent').html(data)						
			});
			$('body').on('click', '.button-dialog', function(){
				$.get($(this).attr('href'), function(data) {		
					$('#processing-modal').html(data)
					$('#processing-modal').modal('show');
					
				});						
				return false;
			});
		});
	</script>
</body>
</html>