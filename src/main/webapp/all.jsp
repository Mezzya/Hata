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
        <h2>Список квартир</h2>
        <h6 style="color: red">${error}</h6>

        <table class="table table-striped table-condensed">
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

                    <c:choose>
                        <c:when test="${hata.id eq edit}">

                            <tr class="danger">
                            <form class="form" action="/add" method="get">
                                <td>${hata.id}</td>
                                <td><input class="form-control" type="text" name="rayon" value="${hata.rayon}"></td>
                                <td><input class="form-control" type="text" name="adress" value="${hata.adress}"></td>
                                <td><input class="form-control" type="text" name="rooms" value="${hata.rooms}"></td>
                                <td><input class="form-control" type="text" name="area" value="${hata.area}"></td>
                                <td><input class="form-control" type="text" name="price" value="${hata.price}"></td>
                                <td>
                                    <input type="hidden" name="edit_id" value="${hata.id}">
                                    <input class="btn btn-primary btn-md" type="submit" value="Записать"></td>
                                <td><a class="btn btn-default btn-md" href="/all">Отмена</a></td>
                                </form>
                        </c:when>
                        <c:otherwise>
                            <tr>
                            <td>${hata.id}</td>
                            <td>${hata.rayon}</td>
                            <td>${hata.adress}</td>
                            <td>${hata.rooms}</td>
                            <td>${hata.area}</td>
                            <td>${hata.price}</td>
                            <td><a class="btn btn-default btn-md" href="/all?edit=${hata.id}">Изменить</a></td>
                            <td><a class="btn btn-default btn-md" href="/del?id=${hata.id}">Удалить</a> </td>

                        </c:otherwise>
                    </c:choose>


                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <form class="form" action="/add" method="get">
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
        <a class="btn btn-primary" href="\filter.jsp">Фильтр</a>
       

    </div>
</div>
</body>
</html>
