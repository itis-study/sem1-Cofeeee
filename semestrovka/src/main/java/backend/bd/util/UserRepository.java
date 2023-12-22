package backend.bd.util;

import backend.bd.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {

    public static void create(User user) throws SQLException {
        String query = "INSERT INTO users (id, name, description, login, password, mail, registration_date, picture_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = ConnectionContainer.getConnection().prepareStatement(query)) {
            statement.setObject(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getDescription());
            statement.setString(4, user.getLogin());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getMail());
            statement.setString(7, user.getRegistrationDate());
            statement.setObject(8, user.getPictureId());
            statement.executeUpdate();
        }
    }

    public User read(UUID id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = ConnectionContainer.getConnection().prepareStatement(query)) {
            statement.setObject(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapUser(resultSet);
                }
            }
        }
        return null;
    }

    public void update(User user) throws SQLException {
        String query = "UPDATE users SET name = ?, description = ?, login = ?, password = ?, mail = ?, " +
                "registration_date = ?, picture_id = ? WHERE id = ?";
        try (PreparedStatement statement = ConnectionContainer.getConnection().prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getDescription());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getMail());
            statement.setString(6, user.getRegistrationDate());
            statement.setObject(7, user.getPictureId());
            statement.setObject(8, user.getId());
            statement.executeUpdate();
        }
    }

    public void delete(UUID id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = ConnectionContainer.getConnection().prepareStatement(query)) {
            statement.setObject(1, id);
            statement.executeUpdate();
        }
    }

    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Statement statement = ConnectionContainer.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                userList.add(mapUser(resultSet));
            }
        }
        return userList;
    }

    private User mapUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId((UUID) resultSet.getObject("id"));
        user.setName(resultSet.getString("name"));
        user.setDescription(resultSet.getString("description"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setMail(resultSet.getString("mail"));
        user.setRegistrationDate(resultSet.getString("registration_date"));
        user.setPictureId((UUID) resultSet.getObject("picture_id"));
        return user;
    }
}