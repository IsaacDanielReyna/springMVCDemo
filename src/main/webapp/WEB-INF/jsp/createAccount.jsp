<!-- %@ page contentType="text/html;charset=UTF-8" language="java" % -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Create an account</title>
    <style>
        .error{
            color:red;
            font-size:15px;
        }
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Enter Account Details</h1>
    <form:form modelAttribute="aNewAccount" method="post" action="doCreate" class="form-group" >
        <table>
            <tr><td>
                First Name: <form:input path="firstName" type="text" name="firstName" class="form-control"/>
                <form:errors path="firstName" cssClass="error"/>
            </td></tr>

            <tr><td>
                Last Name: <form:input path="lastName" type="text" name="lastName" class="form-control"/>
                <form:errors path="lastName" cssClass="error"/>
            </td></tr>

            <tr><td>
                Age: <form:input path="age" type="text" name="age" class="form-control"/>
                <form:errors path="age" cssClass="error"/>
            </td></tr>

            <tr><td>
                Address: <form:input path="address" type="text" name="address" class="form-control"/>
                <form:errors path="address" cssClass="error"/>
            </td></tr>

            <tr><td>
                Email: <form:input path="email" type="text" name="email" class="form-control"/>
                <form:errors path="email" cssClass="error"/>
            </td></tr>

            <tr><td>
                <input type="submit" value="Create" class="btn btn-primary"/>
            </td></tr>

        </table>
    </form:form>
</div>
</body>
</html>
