<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выбор плагина</title>
</head>
<body>
<form action="remove">
    <c:forEach var="plugin" items="${plugins}">
        <input type="checkbox" name="remove" value="${plugin}">
        <a href="select?name=${plugin}">${plugin}</a>
        <br>
    </c:forEach>
    <br>
    <c:if test="${fn:length(plugins) > 0}">
        <input type="submit" value="Удалить">
    </c:if>
</form>
Добавить плагин
<form action="plugins" method="post">
    <input type="text" name="name">Имя
    <br>
    <input type="text" name="file">Путь к файлу
    <br>
    <input type="submit" value="Добавить">
</form>
</body>
</html>
