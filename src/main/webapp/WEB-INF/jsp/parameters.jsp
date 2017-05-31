<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Мониторинг</title>
    <script type='text/javascript'>
        var period = null;
        period = ${update};
        function updatePage() {
            location.reload();
        }
        if (period > 0 && period != null)
            setInterval("updatePage()", period);
    </script>
</head>
<body>
<h2>
    ${module}
</h2>
<br>
<table border="2">
    <tr>
        <th>Вкл./Выкл.</th>
        <th>Параметр</th>
        <th>Значение</th>
        <th>Статус опроса</th>
        <th>Период опроса</th>
        <th>Изменить период опроса</th>
        <th>Изменить параметр</th>
        <td>Конфигурация</td>
        <td>Изменить конфигурацию</td>
    </tr>
    <c:forEach var="parameter" items="${parameters}">
        <tr>
            <td>
                <form action="switch" method="get">
                    <input type="hidden" name="parameter" value="${parameter.name}">
                    <input type="submit"
                           value="<c:choose><c:when test="${parameter.requestStatus}">Выключить</c:when><c:when test="${!parameter.requestStatus}">Включить</c:when></c:choose>"/>
                </form>
            </td>
            <td>${parameter.name}</td>
            <td>${parameter.value}</td>
            <td>
                <c:if test="${parameter.requestStatus}">Включено</c:if>
                <c:if test="${!parameter.requestStatus}">Выключено</c:if>
            </td>
            <td>${parameter.requestPeriod}</td>
            <td>
                <form action="change_period" method="get">
                    <input type="hidden" name="parameter" value="${parameter.name}">
                    <input type="number" name="period">
                    <input type="submit" value="Задать">
                </form>
            </td>
            <td>
                <form action="change_parameter" method="get">
                    <input type="hidden" name="parameter" value="${parameter.name}">
                    <input type="text" name="value">
                    <input type="submit" value="Задать">
                </form>
            </td>
            <td>${parameter.configuration}</td>
            <td>
                <form action="change_configuration" method="get">
                    <input type="hidden" name="configuration" value="${parameter.name}">
                    <input type="text" name="value">
                    <input type="submit" value="Задать">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="plugins">Выбрать плагин</a>
</body>
</html>
