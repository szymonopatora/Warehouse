<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Warehouse</h2>
<style> td, th {
    border: 1px solid black;
} </style>
<!-- ustawienie czarnego obramowania tabeli w CSS -->
<table>
    <thead>
    <tr>
        <td>ID</td>
        <th>Name</th>
        <td>Tool type</td>
        <td>qty</td>
        <td>Availability</td>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${applicationScope.tools}" var="tool">
        <tr>
            <td>${tool.id}</td>
            <td>${tool.name}</td>
            <td>${tool.toolType}</td>
            <td>${tool.qty}</td>
            <c:choose>
                <c:when test="${tool.isAvailable}">
                    <td style="background-color: green"></td>
                    <td>
                        <form>
                            <input type="hidden" name="action" value="take">
                            <input type="hidden" name="id" value="${tool.id}">
                            <input type="submit" value="Take">
                        </form>
                    </td>
                </c:when>
                <c:otherwise>
                    <td style="background-color: red"></td>
                    <td>
                        <form>
                            <input type="hidden" name="action" value="return">
                            <input type="hidden" name="id" value="${tool.id}">
                            <input type="submit" value="Return">
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
