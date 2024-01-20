<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<core:forEach var="result" items="${sessionScope.data.data}">
    <tr>
        <td>${result.x}</td>
        <td>${result.y}</td>
        <td>${result.r}</td>
        <td>${result.result ? "Попадание" : "Непопадание"}</td>
        <td>${result.time}</td>
    </tr>
</core:forEach>