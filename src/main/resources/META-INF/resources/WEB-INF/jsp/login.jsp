<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap-grid.min.css" rel="stylesheet">
		<title>login page title</title>
	</head>
	<body>
		<div class="container">
			Welcome page body
			<pre>${errormessage}</pre>
			<form method="post">
				Name:<input type="text" name="name">
				Password:<input type="password" name="password">
				<input type="submit">
			</form>
		</div>	
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="resources/webjars/jquery/3.5.1/jquery.min.js"></script>
	</body>
</html>