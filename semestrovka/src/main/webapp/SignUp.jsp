<%--
  Created by IntelliJ IDEA.
  User: rusla
  Date: 11.11.2023
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Registration</title>
    <style>
        body {
            background-color: #222;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .registration-container {
            background-color: #333;
            border-radius: 10px;
            padding: 20px;
            width: 400px;
            text-align: center;
        }

        .registration-container h2 {
            margin-bottom: 20px;
            color: #fff;
        }

        .registration-container input {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            background-color: #444;
            color: #fff;
        }

        .registration-container button {
            padding: 10px 20px;
            background-color: #555;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .registration-container button:hover {
            background-color: #777;
        }
    </style>
</head>
<body>
<div class="registration-container">
    <h2>Registration</h2>
    <form th:action="/SignUp"  method="post">
        <div>
            <input type="text" th:field="name" placeholder="Name" required>
        </div>
        <div>
            <input type="text" th:field="login" placeholder="Login" required>
        </div>
        <div>
            <input type="password" th:field="password" placeholder="Password" required>
        </div>
        <div>
            <input type="email" th:field="email" placeholder="Email" required>
        </div>
        <div>
            <button type="submit">Register</button>
        </div>
    </form>
</div>
</body>
</html>