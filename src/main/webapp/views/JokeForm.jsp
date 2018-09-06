<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Enter the following to receive a joke!</h1>
	<form method="POST" action="/joke_post">
		First name: <input type="text" name="firstName"><br>
		Last name: <input type="text" name="lastName"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>