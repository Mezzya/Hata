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

        <table class="table table-striped table-hover table-condensed">
            <thead>
            <th class="col-xs-1">#</th>
            <th  class="col-xs-2">Район</th>
            <th >Адрес</th>
            <th class="col-xs-1">Комнат</th>
            <th  class="col-xs-1">Площадь</th>
            <th  class="col-xs-1">Цена</th>

            <th class="col-xs-1"></th>
            <th class="col-xs-1"></th>
            </thead>
            <c:forEach var="hata" items="${list}">
                <tr>
                    <td>${hata.id}</td>
                    <td>${hata.rayon}</td>
                    <td>${hata.adress}</td>
                    <td>${hata.rooms}</td>
                    <td>${hata.area}</td>
                    <td>${hata.price}</td>

                    <td><a class="btn btn-default btn-md" href="">Изменить</a></td>
                        <td><a class="btn btn-default btn-md" href="/del?id=${hata.id}">Удалить</a> </td>

                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <form class="form" action="/add" method="post">
                    <td><input class="form-control" type="text" name="rayon" value=""></td>
                    <td><input class="form-control" type="text" name="adress" value=""></td>
                    <td><input class="form-control" type="text" name="rooms" value=""></td>
                    <td><input class="form-control" type="text" name="area" value=""></td>
                    <td><input class="form-control" type="text" name="price" value=""></td>
                    <td><input class="btn btn-primary btn-md" type="submit" value="Добавить"></td>
                    <td></td>

                </form>

            </tr>

        </table>
        <a class="btn btn-primary" href="\">На главную</a>
       

    </div>
</div>
</body>
</html>
