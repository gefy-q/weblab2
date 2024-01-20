<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="styles.css">
        <script src="script.js"></script>
        <title>Лабораторная работа 2</title>
    </head>
    <body>
        <header id="page-header">
            <h1>Андриянова Софья, P3230, 7639</h1>
        </header>
        <main id="page-content">
            <form id="main-form" onsubmit="return validateForm()">
                <label for="inputX">X:</label>
                <select id="inputX" name="x">
                    <option value="-5">-5</option>
                    <option value="-4">-4</option>
                    <option value="-3">-3</option>
                    <option value="-2">-2</option>
                    <option value="-1">-1</option>
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>
                <label for="inputY">Y:</label>
                <input type="text" id="inputY" name="y" value="0" required>
                <label for="inputR">R:</label>
                <input type="text" id="inputR" name="r" value="2" required>
                <input type="submit" value="Отправить">
            </form>
            <div id="image-block">
                <img src="areas.png" onclick="imageCheck(event)">
            </div>
            <table id="data-table">
                <thead>
                    <tr>
                        <th>Координата X</th>
                        <th>Координата Y</th>
                        <th>Радиус R</th>
                        <th>Результат</th>
                        <th>Время запроса</th>
                    </tr>
                </thead>
                <tbody id="results-body">
                    <jsp:include page="table.jsp"/>
                </tbody>
            </table>
        </main>
    </body>
</html>