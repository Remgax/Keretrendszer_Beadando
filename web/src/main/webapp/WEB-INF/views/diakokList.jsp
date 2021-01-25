<%--
  Created by IntelliJ IDEA.
  User: korma
  Date: 25/01/2021
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Diákok</title>
</head>
<body>
<c:if test="${!empty diakok}">
    <table frame="border" rules="all">
        <tr><th>Azonosító</th><th>Név</th><th>Születési Dátum</th><th>Átlag</th><th>Osztály</th></tr>
        <c:forEach items="${diakok}" var="diak">
            <tr><th><a href="${pageContext.servletContext.contextPath}/diak/${diak.id}"/>${diak.id}</th><th>${diak.nev}</th><th>${diak.szuletesiDatum}</th><th>${diak.atlag}</th><th>${diak.osztaly}</th></tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty diakok}">
    <c:out value="Nincs Diák az adatbázisban!"/>
</c:if>
<form action="${pageContext.servletContext.contextPath}/addDiak">
    <input type="submit" value="Diák Hozzáadása">
</form>
</body>
</html>
