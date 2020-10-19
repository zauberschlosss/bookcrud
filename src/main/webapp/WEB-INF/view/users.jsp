<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create Users Form</title>
</head>
<body>
<h3>Create New User</h3>
<div style="border:1px solid olivedrab; width:400px; padding:10px;">

    <form:form action="/users/createnewuser" modelAttribute="user" method="POST">
        User Name: <form:input path="username"/>
        <br>
        <br>
        Password: <form:password path="password"/>
        <br>
        <br>
        E-mail: <form:input path="email"/>
        <br>
        <br>
        Date of Birth: <form:input type="date" path="dob"/>
        <br>
        <hr>
        <input type="submit" value="Submit">
    </form:form>
</div>

</body>
</html>