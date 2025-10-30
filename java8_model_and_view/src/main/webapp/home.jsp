<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    Hello JSP
    <form action="add" method="post">
        <label for="num1">Enter 1st number:</label>
        <input type="number" name="num1" id="">
        <br>
        <label for="num1">Enter 2nd number:</label>
        <input type="number" name="num2" id="">
        <br>
        <input type="submit">
    </form>

    <%= session.getAttribute("result") %>
    <h1>Result: ${result}</h1>
</body>
</html>


