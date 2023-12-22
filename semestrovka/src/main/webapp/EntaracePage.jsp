<%--
  Created by IntelliJ IDEA.
  User: rusla
  Date: 18.11.2023
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gresentation</title>
    <meta charset="UTF-8">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap');

        body {
            margin: 0;
            padding: 0;
            background-color: black;
            color: white;
            font-family: 'Montserrat', sans-serif;
        }

        .navbar {
            background-color: #333;
            color: #fff;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-radius: 10px;
        }

        .navbar h1 {
            margin: 0;
            padding: 0;
            font-size: 24px;
            margin-right: 20px;
        }

        .navbar .btn {
            background-color: #444;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
        }

        .navbar .btn:hover {
            background-color: #666;
        }

        .content {
            margin: 20px;
            border-radius: 10px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.2);
        }

        .animated-text {
            overflow: hidden;
            white-space: nowrap;
            border-right: 0.15em solid white;
            animation: typing 3s steps(40, end), blink-caret 0.75s step-end infinite;
        }

        @keyframes typing {
            from { width: 0 }
            to { width: 100% }
        }

        @keyframes blink-caret {
            from, to { border-color: transparent }
            50% { border-color: white }
        }
    </style>
</head>
<body>
<div class="navbar">
    <h1>Gresentation</h1>
    <div>
        <a href="semestrovka/SignIn" class="btn">Sign In</a>
        <a href="semestrovka/SignUp" class="btn">Sign Up</a>
    </div>
</div>

<div class="content">
    <h2 class="animated-text">Важность создания презентации через наш продукт</h2>
    <p>Создание презентации является важным инструментом для передачи информации и убеждения аудитории. Наш продукт, Gresentation, предоставляет удобные и мощные инструменты для создания презентаций, которые помогут вам выделиться и произвести впечатление на вашу аудиторию. Благодаря нашему продукту вы сможете создавать красивые и профессиональные презентации, которые помогут вам достичь ваших целей и донести ваше сообщение до аудитории.</p>
</div>

<script>
    const animatedText = document.querySelector('.animated-text');
    const text = animatedText.textContent;
    animatedText.textContent = '';

    for (let i = 0; i < text.length; i++) {
        const span = document.createElement('span');
        span.textContent = text[i];
        span.style.animationDelay = `${i * 0.1}s`;
        animatedText.appendChild(span);
    }
</script>
</body>
</html>