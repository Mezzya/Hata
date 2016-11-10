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
    <h2>Hello World!</h2>

    <form class="" action="/all" method="post">
        <input type="radio" name="pr" value="1">
        Cписок всех квартир
        <br>
        <input type="radio" name="pr" value="2">
        Список однокомнатных квартир
        <br>
        <input class="btn btn-primary" type="submit" value="Запрос">
    </form>


    </div>
</div>
</body>
</html>
