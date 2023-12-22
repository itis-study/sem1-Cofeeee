package frontend.servlet;

import backend.bd.model.User;
import backend.bd.util.UserRepository;
import backend.util.HashPasswordMD5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/SignUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("SignUp.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Получаем данные из запроса
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String mail = request.getParameter("mail");

        // Генерируем UUID для пользователя
        UUID id = UUID.randomUUID();

        // Хэшируем пароль по алгоритму MD5
        String hashedPassword = HashPasswordMD5.hashPassword(password);

        // Создаем нового пользователя
        User user = new User();
        user.setId(id);
        user.setName(name);
//        user.setDescription(description);
        user.setLogin(login);
        user.setPassword(hashedPassword);
        user.setMail(mail);

        // Добавляем пользователя в базу данных или выполняем другие необходимые действия
        UserRepository userRepository = new UserRepository();

        // Отправляем ответ клиенту
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("User registered successfully");
    }


}
