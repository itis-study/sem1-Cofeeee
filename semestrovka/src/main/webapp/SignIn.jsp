<%--
  Created by IntelliJ IDEA.
  User: rusla
  Date: 18.11.2023
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login</title>
    <style>
        body {
            background-color: #222;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background-color: #333;
            border-radius: 10px;
            padding: 20px;
            width: 400px;
            text-align: center;
        }

        .login-container h2 {
            margin-bottom: 20px;
            color: #fff;
        }

        .login-container input {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            background-color: #444;
            color: #fff;
        }

        .login-container button {
            padding: 10px 20px;
            background-color: #555;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .login-container button:hover {
            background-color: #777;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <form th:action="/Login" method="post">
        <div>
            <input type="text" th:field="login" placeholder="Login" required>
        </div>
        <div>
            <input type="password" th:field="password" placeholder="Password" required>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </form>
</div>
</body>
</html>