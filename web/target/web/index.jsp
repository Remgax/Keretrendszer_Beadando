<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.servletContext.contextPath}/diakok">
    <input type="submit" value="Diakok">
</form>
<form action="${pageContext.servletContext.contextPath}/addDiak">
    <input type="submit" value="Diákhozzáadása">
</form>

</body>
</html>
