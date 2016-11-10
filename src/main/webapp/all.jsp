<%@ page import="servlets.HataWrapper" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=utf-8" %>

<html>
<head>
    <title>Квартирный менеджер</title>
    <meta charset="utf-8"  />
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="my_body">
        <h2>Result</h2>

        <table class="table table-striped">
            <thead>
            <th>#</th>
            <th>Кол. комнат</th>
            <th>Площадь</th>
            <th>Адрес</th>
            <th>Цена</th>
            <th>Раен</th>
            </thead>
            <c:forEach var="hata" items="${list}">
                <tr>
                    <td>${hata.id}</td>
                    <td>${hata.rooms}</td>
                    <td>${hata.area}</td>
                    <td>${hata.adress}</td>
                    <td>${hata.price}</td>
                    <td>${hata.rayon}</td>
                </tr>
            </c:forEach>

        </table>
        <a class="btn btn-primary" href="\">На главную</a>
       

    </div>
</div>
</body>
</html>
