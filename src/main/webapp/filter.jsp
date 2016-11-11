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
        <h2>Фильтр</h2>

        <div class="row" >
            <div class="col-md-6 col-md-offset-2">
        <form class="form" class="form-inline" action="/filter" method="get">
           <br>

            <table class="table">
                <tr>
                    <td>Количество комнат</td>
                    <td>
                        <div class="form-group ${roomsErr}">
                            <input class="form-control" type="text" value="${rooms}" name="rooms">
                        </div>
                    </td>
                    <td>
                        <select class="form-control" name="r_option">
                            <option selected value="all">Все</option>
                            <option value="=">=</option>
                            <option value=">">></option>
                            <option value="<"><</option>
                            <option value=">=">>=</option>
                            <option value="<="><=</option>
                        </select>
                    </td>
                <tr>
                    <td>Площадь квартиры</td>
                    <td>
                        <div class="form-group ${areaErr}">
                        <input class="form-control" type="text" name="area" value="${area}">
                        </div>
                    </td>
                    <td>
                        <select class="form-control" name="a_option">
                            <option selected value="all">Все</option>
                            <option value="=">=</option>
                            <option value=">">></option>
                            <option value="<"><</option>
                            <option value=">=">>=</option>
                            <option value="<="><=</option>
                        </select>
                    </td>

                </tr>
                <tr>
                    <td>Цена</td>
                    <td>
                        <div class="form-group ${priceErr}">
                        <input class="form-control" type="text" name="price" value="${price}">
                        </div>
                    </td>
                    <td>
                        <select class="form-control" name="p_option">
                            <option selected value="all">Все</option>
                            <option value="=">=</option>
                            <option value=">">></option>
                            <option value="<"><</option>
                            <option value=">=">>=</option>
                            <option value="<="><=</option>
                        </select>
                    </td>



            </table>

            <input class="btn btn-primary" type="submit" value="Запрос">
            <a class="btn btn-primary" href="\">На главную</a>
        </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
