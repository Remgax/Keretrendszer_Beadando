<%--
  Created by IntelliJ IDEA.
  User: korma
  Date: 25/01/2021
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Diák hozzáadása</title>
</head>
<body>
<form:form method="post" action="addDiak" modelAttribute="diak">
    <form:label path="nev">Név</form:label>
    <form:input path="nev"/>
    <form:label path="szuletesiDatum">Születési Dátum</form:label>
    <form:input type="date" path="szuletesiDatum"/>
    <form:label path="atlag">Átlag</form:label>
    <form:input path="atlag"/>
    <form:label path="osztaly">Osztály</form:label>
    <form:select path="osztaly">
        <form:options items="${osztalyok}"/>
    </form:select>
    <input type="submit" value="Küldés">

</form:form>
</body>
</html>
