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
        <th>item</th>
        <td>type</td>
        <td>qty</td>
        <th>status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${applicationScope.tools}" var="tool">
        <tr>
<td>${tool.id}</td>
<td>${tool.name}</td>
<td>${tool.type}</td>
<td>${tool.qty}</td>
            <c:choose>
                <c:when test = "${tool.isAvailable}">
                    <td style="background-color: green"></td>
                </c:when>
                <c:otherwise>
                    <td style ="background-color: red"></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
