<%--
  Created by IntelliJ IDEA.
  User: isaac.d.reyna
  Date: 2/3/2020
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyForm</title>
</head>
<body>
    <h1>myForm</h1>
    <form method="post" action="handleForm" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit"/>
    </form>

</body>
</html>
