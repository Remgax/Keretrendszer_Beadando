<%--
  Created by IntelliJ IDEA.
  User: korma
  Date: 25/01/2021
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>${diak.nev}</title>
</head>
<body>
<table>
    <tr><td>Név:</td><td>${diak.nev}</td></tr>
    <tr><td>Születési Dátum:</td><td>${diak.szuletesiDatum}</td></tr>
    <tr><td>Osztály:</td><td>${diak.osztaly}</td></tr>
    <tr><td>Átlag:</td><td>${diak.atlag}</td></tr>
</table>
<form action="${pageContext.servletContext.contextPath}/">
    <input type="submit" value="Vissza a főoldalra.">
</form>
</body>
</html>
