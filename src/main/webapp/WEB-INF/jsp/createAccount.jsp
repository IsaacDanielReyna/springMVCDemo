<!-- %@ page contentType="text/html;charset=UTF-8" language="java" % -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create an account</title>
</head>
<body>
    <h1>Enter Account Details</h1>
    <form:form modelAttribute ="aNewAccount">
        <table>
            <tr><td>First Name: <form:input path="firstName" type="text" name="firstName"/></td></tr>
            <tr><td>Last Name: <form:input path="lastName" type="text" name="lastName"/></td></tr>
            <tr><td>Age: <form:input path="age" type="text" name="age"/></td></tr>
            <tr><td>Address: <form:input path="address" type="text" name="address"/></td></tr>
            <tr><td>Email: <form:input path="email" type="text" name="email"/></td></tr>
            <tr><td><input type="submit" value="Create"/></td></tr>
        </table>
    </form:form>
</body>
</html>
